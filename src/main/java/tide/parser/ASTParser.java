package tide.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import tide.ast.expression.*;
import tide.ast.statements.*;
import tide.ast.*;
import tide.compiler.TideParser;
import tide.compiler.TideParserBaseVisitor;

import java.util.*;

public class ASTParser extends TideParserBaseVisitor<Node> {
    private NodeInfo getNodeInfo(ParserRuleContext ctx) {
        return new NodeInfo(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Node visitRoot(TideParser.RootContext ctx) {
        Program program = new Program(NodeInfo.ZERO);

        for (TideParser.StatementsContext statementsContext : ctx.statements()) {
            System.out.println(statementsContext.getChild(0));
            program.body.add(visit(statementsContext.getChild(0)));
        }

        return program;
    }

    @Override
    public Node visitBlock(TideParser.BlockContext ctx) {
        Program program = new Program(getNodeInfo(ctx));
        for (ParseTree statement : ctx.statements()) {
            program.body.add(visit(statement.getChild(0)));
        }
        return program;
    }

    @Override
    public Node visitFunDecl(TideParser.FunDeclContext ctx) {
        return new FunDecl(
                getNodeInfo(ctx),
                (Program) visitBlock(ctx.block()),
                ctx.identifier().value,
                ctx.funModifier().isEmpty() ? new HashSet<>(List.of(Modifier.GLOBAL)) : ctx.funModifier().getFirst().modifiers,
                parseFunArg(ctx.funArg())
        );
    }

    @Override
    public Node visitReturnStmt(TideParser.ReturnStmtContext ctx) {
        return new ReturnStmt(
                getNodeInfo(ctx),
                (Expression) visitExpr(ctx.expr())
        );
    }

    private Map<String, String> parseFunArg(List<TideParser.FunArgContext> funArgContexts) {
        if (funArgContexts == null) {
            return new HashMap<>();
        }
        Map<String, String> result = new HashMap<>();

        for (TideParser.FunArgContext funArgContext : funArgContexts) {
            result.put(funArgContext.identifier().value, funArgContext.typeLiteral() != null ? funArgContext.typeLiteral().getText() : "object");
        }

        return result;
    }

    @Override
    public Node visitIfStmt(TideParser.IfStmtContext ctx) {
        return new IfStmt(
                getNodeInfo(ctx),
                (Expression) visitExpr(ctx.expr()),
                (Program) visitBlock(ctx.block()),
                ctx.elseIf().stream().map(elseIfCtx -> (IfStmt.ElseIf) visitElseIf(elseIfCtx)).toList(),
                (IfStmt.Else) visitElse(ctx.else_())
        );
    }

    @Override
    public Node visitElseIf(TideParser.ElseIfContext ctx) {
        return new IfStmt.ElseIf(
                getNodeInfo(ctx),
                (Expression) visitExpr(ctx.expr()),
                (Program) visitBlock(ctx.block())
        );
    }

    @Override
    public Node visitElse(TideParser.ElseContext ctx) {
        if (ctx == null) {
            return null;
        }
        return new IfStmt.Else(
                getNodeInfo(ctx),
                (Program) visitBlock(ctx.block())
        );
    }

    @Override
    public Node visitExpr(TideParser.ExprContext ctx) {
        return visit(ctx.logicalOr());
    }

    //logicalOr
    @Override
    public Node visitLogicalOrBase(TideParser.LogicalOrBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitLogicalOrExpr(TideParser.LogicalOrExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //logicalAnd
    @Override
    public Node visitLogicalAndBase(TideParser.LogicalAndBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitLogicalAndExpr(TideParser.LogicalAndExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //bitwiseOr
    @Override
    public Node visitBitwiseOrBase(TideParser.BitwiseOrBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitBitwiseOrExpr(TideParser.BitwiseOrExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //bitwiseXor
    @Override
    public Node visitBitwiseXorBase(TideParser.BitwiseXorBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitBitwiseXorExpr(TideParser.BitwiseXorExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //bitwiseAnd
    @Override
    public Node visitBitwiseAndBase(TideParser.BitwiseAndBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitBitwiseAndExpr(TideParser.BitwiseAndExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //equality
    @Override
    public Node visitEqualityBase(TideParser.EqualityBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitEqualityExpr(TideParser.EqualityExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //relational
    @Override
    public Node visitRelationalBase(TideParser.RelationalBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitRelationalExpr(TideParser.RelationalExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //shift
    @Override
    public Node visitShiftBase(TideParser.ShiftBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitShiftExpr(TideParser.ShiftExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //additive
    @Override
    public Node visitAdditiveBase(TideParser.AdditiveBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitAdditiveExpr(TideParser.AdditiveExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //multiplicative
    @Override
    public Node visitMultiplicativeBase(TideParser.MultiplicativeBaseContext ctx) {
        return visit(ctx.left);
    }

    @Override
    public Node visitMultiplicativeExpr(TideParser.MultiplicativeExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        BinaryOperator operator = BinaryOperator.fromSymbol(ctx.op.getText());
        return new BinaryOperationExpr(getNodeInfo(ctx), operator, left, right);
    }

    //unary
    @Override
    public Node visitUnaryBase(TideParser.UnaryBaseContext ctx) {
        return visit(ctx.cast());
    }

    @Override
    public Node visitUnaryExpr(TideParser.UnaryExprContext ctx) {
        Expression operand = (Expression) visit(ctx.right);
        UnaryOperator operator = UnaryOperator.fromPrefixSymbol(ctx.op.getText());
        return new UnaryOperationExpr(getNodeInfo(ctx), operator, operand);
    }

    //cast
    @Override
    public Node visitCastBase(TideParser.CastBaseContext ctx) {
        return visit(ctx.postfix());
    }

    @Override
    public Node visitCastExpr(TideParser.CastExprContext ctx) {
        return new CastExpr(getNodeInfo(ctx), ctx.typeLiteral().getText(), (Expression) visit(ctx.right));
    }

    //postfix
    @Override
    public Node visitPostfixBase(TideParser.PostfixBaseContext ctx) {
        return visit(ctx.primary());
    }

    @Override
    public Node visitPostfixExpr(TideParser.PostfixExprContext ctx) {
        Expression operand = (Expression) visit(ctx.primary());
        UnaryOperator operator = UnaryOperator.fromPostfixSymbol(ctx.op.getText());
        return new UnaryOperationExpr(getNodeInfo(ctx), operator, operand);
    }

    //primary
    @Override
    public Node visitFunCallExpr(TideParser.FunCallExprContext ctx) {
        return visit(ctx.funCall());
    }

    @Override
    public Node visitRefExpr(TideParser.RefExprContext ctx) {
        return visit(ctx.ref());
    }

    @Override
    public Node visitLiteralExpr(TideParser.LiteralExprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public Node visitChainExpr(TideParser.ChainExprContext ctx) {
        Expression left = (Expression) visit(ctx.left);
        Expression right = (Expression) visit(ctx.right);
        return new ChainExpr(getNodeInfo(ctx), left, right);
    }

    @Override
    public Node visitParenExpr(TideParser.ParenExprContext ctx) {
        return visitExpr(ctx.expr());
    }

    //ref
    @Override
    public Node visitArrayReference(TideParser.ArrayReferenceContext ctx) {
        return new ArrayReferenceExpr(getNodeInfo(ctx), ctx.identifier().value, (Expression) visitExpr(ctx.expr()));
    }

    @Override
    public Node visitReference(TideParser.ReferenceContext ctx) {
        return new ReferenceExpr(getNodeInfo(ctx), ctx.identifier().value);
    }

    //funCall
    @Override
    public Node visitFunctionCall(TideParser.FunctionCallContext ctx) {
        return new FunCall(
                getNodeInfo(ctx),
                ctx.identifier().value,
                ctx.expr().stream().map(exprCtx -> (Expression) visitExpr(exprCtx)).toList()
        );
    }

    //literal
    @Override
    public Node visitIntegerLiteral(TideParser.IntegerLiteralContext ctx) {
        return new IntegerLiteral(getNodeInfo(ctx), ctx.integer().value);
    }

    @Override
    public Node visitFloatingLiteral(TideParser.FloatingLiteralContext ctx) {
        return new FloatingLiteral(getNodeInfo(ctx), ctx.floats().value);
    }

    @Override
    public Node visitStringLiteral(TideParser.StringLiteralContext ctx) {
        return new StringLiteral(getNodeInfo(ctx), ctx.string().value);
    }

    @Override
    public Node visitBooleanLiteral(TideParser.BooleanLiteralContext ctx) {
        return new BooleanLiteral(getNodeInfo(ctx), ctx.boolean_().value);
    }

    @Override
    public Node visitNullLiteral(TideParser.NullLiteralContext ctx) {
        return new NullLiteral(getNodeInfo(ctx));
    }
}
