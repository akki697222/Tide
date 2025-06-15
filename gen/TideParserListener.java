// Generated from D:/Projects(New)/Tide/src/main/antlr4/tide/compiler/TideParser.g4 by ANTLR 4.13.2

import java.util.*;
import tide.core.parser.Modifier;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TideParser}.
 */
public interface TideParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TideParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(TideParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(TideParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(TideParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(TideParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(TideParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(TideParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TideParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TideParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#elseIf}.
	 * @param ctx the parse tree
	 */
	void enterElseIf(TideParser.ElseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#elseIf}.
	 * @param ctx the parse tree
	 */
	void exitElseIf(TideParser.ElseIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(TideParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(TideParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TideParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TideParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(TideParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(TideParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#funCall}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(TideParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#funCall}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(TideParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunDecl(TideParser.FunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunDecl(TideParser.FunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#funArg}.
	 * @param ctx the parse tree
	 */
	void enterFunArg(TideParser.FunArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#funArg}.
	 * @param ctx the parse tree
	 */
	void exitFunArg(TideParser.FunArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#funModifier}.
	 * @param ctx the parse tree
	 */
	void enterFunModifier(TideParser.FunModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#funModifier}.
	 * @param ctx the parse tree
	 */
	void exitFunModifier(TideParser.FunModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(TideParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(TideParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefaultType}
	 * labeled alternative in {@link TideParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDefaultType(TideParser.DefaultTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefaultType}
	 * labeled alternative in {@link TideParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDefaultType(TideParser.DefaultTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link TideParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(TideParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link TideParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(TideParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(TideParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(TideParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(TideParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(TideParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(TideParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(TideParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(TideParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(TideParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link TideParser#floats}.
	 * @param ctx the parse tree
	 */
	void enterFloats(TideParser.FloatsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TideParser#floats}.
	 * @param ctx the parse tree
	 */
	void exitFloats(TideParser.FloatsContext ctx);
}