// Generated from D:/Projects(New)/Tide/src/main/antlr4/tide/compiler/TideParser.g4 by ANTLR 4.13.2

import java.util.*;
import tide.core.parser.Modifier;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TideParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TideParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TideParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(TideParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(TideParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(TideParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(TideParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#elseIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(TideParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(TideParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TideParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TideParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#funCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(TideParser.FunCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#funDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecl(TideParser.FunDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#funArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunArg(TideParser.FunArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#funModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunModifier(TideParser.FunModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(TideParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefaultType}
	 * labeled alternative in {@link TideParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultType(TideParser.DefaultTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link TideParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(TideParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(TideParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(TideParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(TideParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(TideParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link TideParser#floats}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloats(TideParser.FloatsContext ctx);
}