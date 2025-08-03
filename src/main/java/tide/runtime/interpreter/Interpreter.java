package tide.runtime.interpreter;

import tide.ast.Node;
import tide.ast.UnaryOperator;
import tide.ast.expression.*;
import tide.ast.statements.*;
import tide.core.*;
import tide.runtime.AbstractRuntime;
import tide.runtime.RuntimeFrame;
import tide.runtime.error.*;
import tide.runtime.error.internal.Break;
import tide.runtime.error.internal.Return;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@code Interpreter} is a concrete implementation of the {@link AbstractRuntime}
 * that executes Tide programs represented as abstract syntax trees (AST).
 * It performs interpretation by recursively evaluating AST nodes such as expressions,
 * statements, function calls, and control flow.
 * <p>
 * This interpreter supports variable declarations, function definitions, arithmetic and
 * logical operations, conditional branches, return statements, and both native and user-defined functions.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *     <li>Interpret and evaluate {@link Node} instances</li>
 *     <li>Manage scope, stack frames, and runtime environment</li>
 *     <li>Provide custom stack trace output with {@link #printStackTrace(Throwable)}</li>
 *     <li>Invoke both user-defined and native Java functions</li>
 * </ul>
 *
 * <p>Used internally as the core execution engine of the Tide runtime.</p>
 *
 * @author akki697222
 * @since V1
 */
public class Interpreter extends AbstractRuntime {
    private Node current;

    @Override
    public void printStackTrace(Throwable e)  {
        if (System.getProperty("runtime.javaStackTrace") == null) {
            System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage() + " (line " + current.nodeInfo.line() + " column " + current.nodeInfo.column() + ")");
            if (e instanceof JavaRuntimeError) {
                e.printStackTrace();
            } else {
                for (RuntimeFrame frame : callStack) {
                    System.err.println(" ".repeat(4) + "at " + frame.program.getSourceType() + " " + frame.program.getSource() + " (line " + frame.program.line() + ")");
                }
            }
        } else {
            e.printStackTrace();
        }
    }

    @Override
    protected TideObject doInvoke(RuntimeFrame frame, boolean throwReturn) {
        if (frame.program instanceof TideASTProgram astProgram) {
            try {
                for (Node node : astProgram.program.body) {
                    current = node;
                    if (node instanceof Statement statement) {
                        evaluate(statement);
                    } else if (node instanceof Expression expression) {
                        evaluate(expression);
                    }
                }
            } catch (Return ret) {
                if (throwReturn) {
                    throw ret;
                } else {
                    logDebug("[RET] " + ret.result);
                    return ret.result;
                }
            }
        } else {
            throw new RuntimeError("Interpreter cannot execute bytecode.");
        }
        return TideObject.NULL;
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
                        invoke(new TideASTProgram(ifStmt.body), new HashMap<>(), true, true);
                        return;
                    } else {
                        if (!ifStmt.elseIfs.isEmpty()) {
                            for (IfStmt.ElseIf elseIf : ifStmt.elseIfs) {
                                TideObject elseIfResult = evaluate(elseIf.expression);
                                if (elseIfResult instanceof TideBool _bool) {
                                    if (_bool.getValue()) {
                                        invoke(new TideASTProgram(elseIf.body), new HashMap<>(), true, true);
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
                    invoke(new TideASTProgram(ifStmt.ifElse.body), new HashMap<>(), true, true);
                }
            }
            case VarDecl varDecl -> {
                TideObject init = evaluate(varDecl.initializer);
                if (init.getType().getTypeName().equals(varDecl.type) || varDecl.type.equals("object")) {
                    env().set(varDecl.name, new TideObjectHolder(init, varDecl.modifiers));
                } else {
                    if (init instanceof TideArray array) {
                        if (array.length() == 0) {
                            env().set(varDecl.name, new TideObjectHolder(new TideArray(varDecl.type.substring(0, varDecl.type.length() - 2), 0), varDecl.modifiers));
                            return;
                        }
                    }
                    throw new TypeError("Expected " + varDecl.type + ", got " + init.getType().getTypeName());
                }
            }
            case WhileStmt whileStmt -> {
                while (true) {
                    TideObject evaluated = evaluate(whileStmt.expression);
                    if (evaluated instanceof TideBool bool) {
                        if (bool.getValue()) {
                            try {
                                invoke(new TideASTProgram(whileStmt.block), new HashMap<>(), true, true);
                            } catch (Break ignored) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        throw new TypeError("The while expression must return a boolean value.");
                    }
                }
            }
            case ClassDecl classDecl -> {
                TideClass clazz = new TideClass(
                        classDecl.name,
                        new TideASTProgram(classDecl.body),
                        classDecl.modifiers,
                        classDecl.inherits
                );
                initializeClassStatic(clazz);
                env().set(classDecl.name, clazz);
            }
            case ForIterate forIterate -> {

            }
            case ForNumerical forNumerical -> {
                TideObject left = evaluate(forNumerical.left);
                TideObject right = evaluate(forNumerical.right);
                TideObject variable = left.copy();
                while (true) {
                    if (forNumerical.exclusive) {
                        if (variable.lt(right).equals(TideBool.FALSE)) {
                            break;
                        }
                    } else {
                        if (variable.le(right).equals(TideBool.FALSE)) {
                            break;
                        }
                    }
                    invoke(new TideASTProgram(forNumerical.body), Map.of(forNumerical.varName, variable));
                    variable = variable.incl();
                }
            }
            case ReturnStmt returnStmt -> {
                TideObject result = evaluate(returnStmt.expression);
                logDebug("[RET(STMT)] " + result);
                throw new Return(result);
            }
            case BreakStmt ignored -> throw new Break();
            default -> throw new UnsupportedOperationException(statement.getClass().getSimpleName());
        }
    }

    private TideObject evaluate(Expression expression) {
        logDebug("[EVAL] Processing Expr: " + expression);
        switch (expression) {
            case BinaryOperationExpr binaryOperationExpr -> {
                TideObject left = evaluate(binaryOperationExpr.left);
                TideObject right = evaluate(binaryOperationExpr.right);
                logDebug("[EVAL] BinOp: " + left + " (" + binaryOperationExpr.left + ") " + binaryOperationExpr.operator.getSymbol() + " " + right + " (" + binaryOperationExpr.right + ") ");
                if (left == null || right == null) {
                    throw new ReferenceError("null");
                }
                TideObject result = switch (binaryOperationExpr.operator) {
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
                    case POW -> left.pow(right);
                    case ASSIGN,
                         ADD_ASSIGN,
                         SUB_ASSIGN,
                         MUL_ASSIGN,
                         DIV_ASSIGN,
                         MOD_ASSIGN,
                         POW_ASSIGN,
                         LSH_ASSIGN,
                         RSH_ASSIGN,
                         BAND_ASSIGN,
                         BOR_ASSIGN ,
                         BXOR_ASSIGN -> {
                        TideScope env = env();
                        String target;
                        if (binaryOperationExpr.left instanceof ArrayReferenceExpr arrayReferenceExpr) {
                            TideObject mayBeArray = env.get(arrayReferenceExpr.identifier);
                            if (mayBeArray instanceof TideArray array) {
                                array.set((TideInteger) evaluate(arrayReferenceExpr.arrayAccess), right);
                                yield right;
                            } else {
                                throw new ReferenceError("Array access must be integer");
                            }
                        } else if (binaryOperationExpr.left instanceof ReferenceExpr referenceExpr) {
                            target = referenceExpr.identifier;
                        } else {
                            throw new RuntimeError("Attempt to assign a value to a non-variable");
                        }
                        TideObject assigned;
                        TideObject targetObj = env.get(target);
                        switch (binaryOperationExpr.operator) {
                            case ASSIGN -> assigned = right;
                            case ADD_ASSIGN -> assigned = targetObj.add(right);
                            case SUB_ASSIGN -> assigned = targetObj.sub(right);
                            case MUL_ASSIGN -> assigned = targetObj.mul(right);
                            case DIV_ASSIGN -> assigned = targetObj.div(right);
                            case POW_ASSIGN -> assigned = targetObj.pow(right);
                            case MOD_ASSIGN -> assigned = targetObj.mod(right);
                            case LSH_ASSIGN -> assigned = targetObj.lsh(right);
                            case RSH_ASSIGN -> assigned = targetObj.rsh(right);
                            case BAND_ASSIGN -> assigned = targetObj.band(right);
                            case BOR_ASSIGN -> assigned = targetObj.bor(right);
                            case BXOR_ASSIGN -> assigned = targetObj.bxor(right);
                            default -> throw new IllegalStateException("An unexpected error has occurred");
                        }
                        env.replace(target, assigned);
                        yield assigned;
                    }
                };
                logDebug("[EVAL] BinOp Result: " + result);
                return result;
            }
            case UnaryOperationExpr unaryOperationExpr -> {
                TideObject operand = evaluate(unaryOperationExpr.operand);
                UnaryOperator operator = unaryOperationExpr.operator;
                if (operand == null) {
                    throw new ReferenceError("null");
                }
                if (operator.isPostfix()) {
                    TideObject result = operand.copy();
                    if (operator == UnaryOperator.POST_INC) {
                        operand.incl();
                    } else if (operator == UnaryOperator.POST_DEC) {
                        operand.decl();
                    } else {
                        throw new UnsupportedOperationException("Unsupported POST operator in unary expression");
                    }
                    return result;
                }
                return switch (operator) {
                    case TILDE -> operand.binvert();
                    case BANG -> operand.invert();
                    case PLUS -> operand.abs();
                    case MINUS -> operand.neg();
                    case PRE_INC -> operand.incl();
                    case PRE_DEC -> operand.decl();
                    default -> throw new UnsupportedOperationException("Unsupported unary operator: " + operator);
                };
            }
            case ArrayReferenceExpr arrayReferenceExpr -> {
                TideObject mayBeArray = env().get(arrayReferenceExpr.identifier);
                if (mayBeArray instanceof TideArray array) {
                    return array.get(evaluate(arrayReferenceExpr.arrayAccess));
                } else {
                    throw new ReferenceError("Array access must be integer");
                }
            }
            case ChainExpr chainExpr -> {
                TideObject left = evaluate(chainExpr.left);
                if (chainExpr.right instanceof ReferenceExpr referenceExpr) {
                    return left.getField(referenceExpr.identifier);
                } else if (chainExpr.right instanceof FunCall funCall) {
                    return invokeFunction(funCall, left.getField(funCall.identifier));
                } else {
                    throw new UnsupportedOperationException("");
                }
            }
            case LambdaExpr lambdaExpr -> {
                return new TideFunction(
                        lambdaExpr.parameters,
                        new TideASTProgram(lambdaExpr.program)
                );
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
            case FloatingLiteral floatingLiteral -> {
                return new TideDouble(floatingLiteral.value);
            }
            case BooleanLiteral booleanLiteral -> {
                return booleanLiteral.value ? TideBool.TRUE : TideBool.FALSE;
            }
            case FunCall funCall -> {
                logDebug("[FCALL]");
                return invokeFunction(funCall, env().get(funCall.identifier));
            }
            case ArrayLiteral arrayLiteral -> {
                if (arrayLiteral.elements.isEmpty()) {
                    return new TideArray("object", 0);
                }
                TideObject firstElem = evaluate(arrayLiteral.elements.getFirst());
                TideArray array = new TideArray(firstElem.getType().getTypeName(), arrayLiteral.elements.size());
                array.set(0, firstElem);
                for (int i = 1; i < arrayLiteral.elements.size(); i++) {
                    TideObject elem = evaluate(arrayLiteral.elements.get(i));
                    array.set(i, elem);
                }
                return array;
            }
            case null -> {
                return TideObject.NULL;
            }
            default -> throw new UnsupportedOperationException(expression.toString());
        }
    }

    private TideObject invokeFunction(FunCall funCall, TideObject mayBeFun) {
        if (mayBeFun instanceof TideFunction function) {
            if (function.getSignature().size() != funCall.args.size()) {
                throw new FunctionSignatureMismatchError("Expected " + function.getSignature().size() + ", got " + funCall.args.size());
            }
            Map<String, TideObject> args = new HashMap<>();
            AtomicInteger i = new AtomicInteger(0);
            function.getSignature().forEach((name, type) -> {
                TideObject arg = evaluate(funCall.args.get(i.get()));
                if (arg.getType().getTypeName().equals(type) || type.equals("object")) {
                    args.put(name, arg);
                } else {
                    throw new TypeError("Expected " + type + ", got " + arg.getType().getTypeName());
                }
                i.incrementAndGet();
            });
            TideScope scope = new TideScope();
            scope.parent = globalScope;
            logDebug("[INVF] Arguments: " + args);
            pushFrame(new RuntimeFrame(function.getProgram(), scope, null, args, funCall.nodeInfo.line()));
            return invoke(function.getProgram(), args, false);
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
        } else if (mayBeFun instanceof TideClass tideClass) {
            TideClass instance = tideClass.instantiate();
            try {
                invokeFunction(funCall, instance.getField("<init>"));
            } catch (TypeError ignored) {

            }
            return instance;
        } else {
            throw new TypeError("Attempt to try to invoke non-function value");
        }
    }

    private void initializeClassStatic(TideClass clazz) {
        for (Node node : ((TideASTProgram) clazz.getBody()).program.body) {
            switch (node) {
                case FunDecl funDecl -> {
                    TideFunction function = new TideFunction(
                            funDecl.signature,
                            new TideASTProgram(funDecl.body),
                            funDecl.name
                    );
                    if (funDecl.modifiers.contains(Modifier.STATIC)) {
                        clazz.setField(funDecl.name, function);
                    } else {
                        clazz.setInstanceField(funDecl.name, function);
                    }
                }
                case VarDecl varDecl -> {
                    TideObject init = evaluate(varDecl.initializer);
                    if (init.getType().getTypeName().equals(varDecl.type) || varDecl.type.equals("object")) {
                        if (varDecl.modifiers.contains(Modifier.STATIC)) {
                            clazz.setField(varDecl.name, new TideObjectHolder(init, varDecl.modifiers));
                        } else {
                            clazz.setInstanceField(varDecl.name, new TideObjectHolder(init, varDecl.modifiers));
                        }
                    } else {
                        if (init instanceof TideArray array) {
                            if (array.length() == 0) {
                                String varTypeTrimmed = varDecl.type.substring(0, varDecl.type.length() - 2);
                                if (varDecl.modifiers.contains(Modifier.STATIC)) {
                                    clazz.setField(varDecl.name, new TideObjectHolder(new TideArray(varTypeTrimmed, 0), varDecl.modifiers));
                                } else {
                                    clazz.setInstanceField(varDecl.name, new TideObjectHolder(new TideArray(varTypeTrimmed, 0), varDecl.modifiers));
                                }
                                return;
                            }
                        }
                        throw new TypeError("Expected " + varDecl.type + ", got " + init.getType().getTypeName());
                    }

                }
                default -> throw new UnsupportedOperationException("");
            }
        }
    }

    @Override
    public String getVersion() {
        return "Tide Interpreter v1.0.0-dev";
    }
}
