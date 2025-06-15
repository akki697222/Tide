package tide.runtime.interpreter;

import tide.ast.Node;
import tide.ast.expression.*;
import tide.ast.statements.FunDecl;
import tide.ast.statements.IfStmt;
import tide.ast.statements.ReturnStmt;
import tide.ast.statements.Statement;
import tide.core.*;
import tide.runtime.AbstractRuntime;
import tide.runtime.RuntimeFrame;
import tide.runtime.error.FunctionSignatureMismatchError;
import tide.runtime.error.ReferenceError;
import tide.runtime.error.RuntimeError;
import tide.runtime.error.TypeError;
import tide.runtime.error.internal.Return;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Interpreter extends AbstractRuntime {
    @Override
    protected TideObject doInvoke(RuntimeFrame frame) {
        if (frame.program instanceof TideASTProgram astProgram) {
            frame.args.forEach((name, obj) -> {
                env().set(name, obj);
            });
            for (Node node : astProgram.program.body) {
                if (node instanceof Statement statement) {
                    try {
                        evaluate(statement);
                    } catch (Return ret) {
                        return ret.result;
                    }
                } else if (node instanceof Expression expression){
                    evaluate(expression);
                }
            }
        } else {
            throw new RuntimeError("Interpreter cannot execute bytecode.");
        }
        return null;
    }

    private void evaluate(Statement statement) {
        switch (statement) {
            case FunDecl funDecl -> env().set(funDecl.name, new TideFunction(
                    funDecl.signature,
                    new TideASTProgram(funDecl.body),
                    funDecl.name
            ));
            case IfStmt ifStmt -> {
                boolean isElse = false;
                TideObject ifResult = evaluate(ifStmt.expression);
                if (ifResult instanceof TideBool bool) {
                    if (bool.getValue()) {
                        invoke(new TideASTProgram(ifStmt.body));
                        return;
                    } else {
                        if (!ifStmt.elseIfs.isEmpty()) {
                            for (IfStmt.ElseIf elseIf : ifStmt.elseIfs) {
                                TideObject elseIfResult = evaluate(elseIf.expression);
                                if (elseIfResult instanceof TideBool _bool) {
                                    if (_bool.getValue()) {
                                        invoke(new TideASTProgram(elseIf.body));
                                        return;
                                    }
                                } else {
                                    throw new TypeError("The if expression must return a boolean value.");
                                }
                            }
                        } else {
                            isElse = true;
                        }
                    }
                } else {
                    throw new TypeError("The if expression must return a boolean value.");
                }
                if (isElse && ifStmt.ifElse != null) {
                    invoke(new TideASTProgram(ifStmt.ifElse.body));
                }
            }
            case ReturnStmt returnStmt -> throw new Return(evaluate(returnStmt.expression));
            default -> throw new UnsupportedOperationException(statement.getClass().getSimpleName());
        }
    }

    private TideObject evaluate(Expression expression) {
        switch (expression) {
            case BinaryOperationExpr binaryOperationExpr -> {
                TideObject left = evaluate(binaryOperationExpr.left);
                TideObject right = evaluate(binaryOperationExpr.right);
                if (left == null || right == null) {
                    throw new ReferenceError("null");
                }
                return switch (binaryOperationExpr.operator) {
                    case OR -> left.or(right);
                    case AND -> left.and(right);
                    case BOR -> left.bor(right);
                    case BXOR -> left.bxor(right);
                    case BAND -> left.band(right);
                    case EQ -> left.eq(right);
                    case NE -> left.ne(right);
                    case LT -> left.lt(right);
                    case LE -> left.le(right);
                    case GT -> left.gt(right);
                    case GE -> left.ge(right);
                    case LSH -> left.lsh(right);
                    case RSH -> left.rsh(right);
                    case ADD -> left.add(right);
                    case SUB -> left.sub(right);
                    case MUL -> left.mul(right);
                    case DIV -> left.div(right);
                    case MOD -> left.mod(right);
                    case ASSIGN,
                    ADD_ASSIGN,
                    SUB_ASSIGN,
                    MUL_ASSIGN,
                    DIV_ASSIGN,
                    MOD_ASSIGN,
                    LSH_ASSIGN,
                    RSH_ASSIGN,
                    BAND_ASSIGN,
                    BOR_ASSIGN ,
                    BXOR_ASSIGN -> {
                        String target;
                        if (left instanceof TideString string) {
                            target = string.toString();
                        } else {
                            throw new RuntimeError("Attempt to assign a value to a non-variable");
                        }
                        TideObject assigned = null;
                        switch (binaryOperationExpr.operator) {
                            case ASSIGN -> env().replace(target, right);
                            case ADD_ASSIGN -> assigned = env().get(target).add(right);
                            case SUB_ASSIGN -> assigned = env().get(target).sub(right);
                            case MUL_ASSIGN -> assigned = env().get(target).mul(right);
                            case DIV_ASSIGN -> assigned = env().get(target).div(right);
                            case MOD_ASSIGN -> assigned = env().get(target).mod(right);
                            case LSH_ASSIGN -> assigned = env().get(target).lsh(right);
                            case RSH_ASSIGN -> assigned = env().get(target).rsh(right);
                            case BAND_ASSIGN -> assigned = env().get(target).band(right);
                            case BOR_ASSIGN -> assigned = env().get(target).bor(right);
                            case BXOR_ASSIGN -> assigned = env().get(target).bxor(right);
                             default -> throw new IllegalStateException("An unexpected error has occurred");
                        }
                        env().replace(target, assigned);
                        yield assigned;
                    }
                };
            }
            case ReferenceExpr referenceExpr -> {
                return env().get(referenceExpr.identifier);
            }
            case IntegerLiteral integerLiteral -> {
                return TideInteger.newInstance(integerLiteral.value);
            }
            case StringLiteral stringLiteral -> {
                return new TideString(stringLiteral.value);
            }
            case FunCall funCall -> {
                TideObject mayBeFun = env().get(funCall.identifier);
                if (mayBeFun instanceof TideFunction function) {
                    if (function.getSignature().size() != funCall.args.size()) {
                        throw new FunctionSignatureMismatchError("Expected " + function.getSignature().size() + ", got " + funCall.args.size());
                    }
                    Map<String, TideObject> args = new HashMap<>();
                    List<TideObject> evaluatedArgs = funCall.args.stream().map(this::evaluate).toList();
                    AtomicInteger i = new AtomicInteger(0);
                    function.getSignature().forEach((name, type) -> {
                        TideObject arg = evaluatedArgs.get(i.get());
                        if (arg.getType().getTypeName().equals(type) || type.equals("object")) {
                            args.put(name, arg);
                        } else {
                            throw new TypeError("Expected " + type + ", got " + arg.getType().getTypeName());
                        }
                        i.incrementAndGet();
                    });
                    return invoke(function.getProgram(), args);
                } else if (mayBeFun instanceof JavaFunction function) {
                    if (function.getSignature().size() != funCall.args.size()) {
                        throw new FunctionSignatureMismatchError("Expected " + function.getSignature().size() + ", got " + funCall.args.size());
                    }
                    Map<String, TideObject> args = new HashMap<>();
                    List<TideObject> evaluatedArgs = funCall.args.stream().map(this::evaluate).toList();
                    AtomicInteger i = new AtomicInteger(0);
                    function.getSignature().forEach((name, type) -> {
                        TideObject arg = evaluatedArgs.get(i.get());
                        if (arg.getType().getTypeName().equals(type) || type.equals("object")) {
                            args.put(name, arg);
                        } else {
                            throw new TypeError("Expected " + type + ", got " + arg.getType().getTypeName());
                        }
                        i.incrementAndGet();
                    });
                    return function.invoke(args);
                } else {
                    throw new TypeError("Attempt to invoke non-function value");
                }
            }
            default -> throw new UnsupportedOperationException(expression.toString());
        }
    }
}
