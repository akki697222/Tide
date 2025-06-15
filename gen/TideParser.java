// Generated from D:/Projects(New)/Tide/src/main/antlr4/tide/compiler/TideParser.g4 by ANTLR 4.13.2

import java.util.*;
import tide.core.parser.Modifier;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TideParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=1, VAR=2, VAL=3, VARARG=4, IF=5, ELSEIF=6, ELSE=7, FOR=8, LOCAL=9, 
		META=10, RET=11, NULL=12, LPAREN=13, RPAREN=14, LBRACE=15, RBRACE=16, 
		LBRACK=17, RBRACK=18, SEMI=19, COMMA=20, DOT=21, ASSIGN=22, GT=23, LT=24, 
		BANG=25, TILDE=26, QUESTION=27, COLON=28, EQ=29, LE=30, GE=31, NE=32, 
		ADD_ASSIGN=33, SUB_ASSIGN=34, MUL_ASSIGN=35, DIV_ASSIGN=36, MOD_ASSIGN=37, 
		BAND_ASSIGN=38, BXOR_ASSIGN=39, BOR_ASSIGN=40, LSH_ASSIGN=41, RSH_ASSIGN=42, 
		AND=43, OR=44, INCL=45, DECL=46, ADD=47, SUB=48, MUL=49, DIV=50, MOD=51, 
		ARROW=52, COLON_DOUBLE=53, FOR_INC=54, FOR_EXC=55, LSH=56, RSH=57, BAND=58, 
		BXOR=59, BOR=60, INT=61, FLOAT=62, HEX=63, STRING=64, BOOLEAN=65, IDENTIFIER=66, 
		WS=67, COMMENT=68, LINE_COMMENT=69;
	public static final int
		RULE_root = 0, RULE_statements = 1, RULE_returnStmt = 2, RULE_ifStmt = 3, 
		RULE_elseIf = 4, RULE_else = 5, RULE_expr = 6, RULE_block = 7, RULE_funCall = 8, 
		RULE_funDecl = 9, RULE_funArg = 10, RULE_funModifier = 11, RULE_literal = 12, 
		RULE_typeLiteral = 13, RULE_identifier = 14, RULE_boolean = 15, RULE_string = 16, 
		RULE_integer = 17, RULE_floats = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "statements", "returnStmt", "ifStmt", "elseIf", "else", "expr", 
			"block", "funCall", "funDecl", "funArg", "funModifier", "literal", "typeLiteral", 
			"identifier", "boolean", "string", "integer", "floats"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fun'", "'var'", "'val'", "'vararg'", "'if'", "'elseif'", "'else'", 
			"'for'", "'local'", "'meta'", "'ret'", "'null'", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", 
			"'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'&='", "'^='", "'|='", "'<<='", "'>>='", "'&&'", 
			"'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'->'", "'::'", 
			"'..='", "'..'", "'<<'", "'>>'", "'&'", "'^'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNCTION", "VAR", "VAL", "VARARG", "IF", "ELSEIF", "ELSE", "FOR", 
			"LOCAL", "META", "RET", "NULL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
			"TILDE", "QUESTION", "COLON", "EQ", "LE", "GE", "NE", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "BAND_ASSIGN", "BXOR_ASSIGN", 
			"BOR_ASSIGN", "LSH_ASSIGN", "RSH_ASSIGN", "AND", "OR", "INCL", "DECL", 
			"ADD", "SUB", "MUL", "DIV", "MOD", "ARROW", "COLON_DOUBLE", "FOR_INC", 
			"FOR_EXC", "LSH", "RSH", "BAND", "BXOR", "BOR", "INT", "FLOAT", "HEX", 
			"STRING", "BOOLEAN", "IDENTIFIER", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TideParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TideParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6918056793323093538L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0)) {
				{
				{
				setState(38);
				statements();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public FunDeclContext funDecl() {
			return getRuleContext(FunDeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TideParser.SEMI, 0); }
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
			case LOCAL:
			case META:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				funDecl();
				}
				break;
			case NULL:
			case LPAREN:
			case BANG:
			case TILDE:
			case INCL:
			case DECL:
			case ADD:
			case SUB:
			case INT:
			case FLOAT:
			case STRING:
			case BOOLEAN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				expr(0);
				setState(46);
				match(SEMI);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				ifStmt();
				}
				break;
			case RET:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				returnStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RET() { return getToken(TideParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TideParser.SEMI, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(RET);
			setState(53);
			expr(0);
			setState(54);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TideParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(TideParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TideParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ElseIfContext> elseIf() {
			return getRuleContexts(ElseIfContext.class);
		}
		public ElseIfContext elseIf(int i) {
			return getRuleContext(ElseIfContext.class,i);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(IF);
			setState(57);
			match(LPAREN);
			setState(58);
			expr(0);
			setState(59);
			match(RPAREN);
			setState(60);
			block();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(61);
				elseIf();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(67);
				else_();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(TideParser.ELSEIF, 0); }
		public TerminalNode LPAREN() { return getToken(TideParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TideParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterElseIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitElseIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitElseIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfContext elseIf() throws RecognitionException {
		ElseIfContext _localctx = new ElseIfContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elseIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(ELSEIF);
			setState(71);
			match(LPAREN);
			setState(72);
			expr(0);
			setState(73);
			match(RPAREN);
			setState(74);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(TideParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ELSE);
			setState(77);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext left;
		public ExprContext cond;
		public ExprContext right;
		public Token op;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(TideParser.LPAREN, 0); }
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TideParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TILDE() { return getToken(TideParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(TideParser.BANG, 0); }
		public TerminalNode ADD() { return getToken(TideParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(TideParser.SUB, 0); }
		public TerminalNode INCL() { return getToken(TideParser.INCL, 0); }
		public TerminalNode DECL() { return getToken(TideParser.DECL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(TideParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(TideParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(TideParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(TideParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(TideParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(TideParser.MOD_ASSIGN, 0); }
		public TerminalNode BAND_ASSIGN() { return getToken(TideParser.BAND_ASSIGN, 0); }
		public TerminalNode BXOR_ASSIGN() { return getToken(TideParser.BXOR_ASSIGN, 0); }
		public TerminalNode BOR_ASSIGN() { return getToken(TideParser.BOR_ASSIGN, 0); }
		public TerminalNode LSH_ASSIGN() { return getToken(TideParser.LSH_ASSIGN, 0); }
		public TerminalNode RSH_ASSIGN() { return getToken(TideParser.RSH_ASSIGN, 0); }
		public TerminalNode QUESTION() { return getToken(TideParser.QUESTION, 0); }
		public TerminalNode COLON() { return getToken(TideParser.COLON, 0); }
		public TerminalNode OR() { return getToken(TideParser.OR, 0); }
		public TerminalNode AND() { return getToken(TideParser.AND, 0); }
		public TerminalNode BOR() { return getToken(TideParser.BOR, 0); }
		public TerminalNode BXOR() { return getToken(TideParser.BXOR, 0); }
		public TerminalNode BAND() { return getToken(TideParser.BAND, 0); }
		public TerminalNode EQ() { return getToken(TideParser.EQ, 0); }
		public TerminalNode NE() { return getToken(TideParser.NE, 0); }
		public TerminalNode LSH() { return getToken(TideParser.LSH, 0); }
		public TerminalNode RSH() { return getToken(TideParser.RSH, 0); }
		public TerminalNode MUL() { return getToken(TideParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(TideParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(TideParser.MOD, 0); }
		public TerminalNode DOT() { return getToken(TideParser.DOT, 0); }
		public TerminalNode LT() { return getToken(TideParser.LT, 0); }
		public TerminalNode LE() { return getToken(TideParser.LE, 0); }
		public TerminalNode GT() { return getToken(TideParser.GT, 0); }
		public TerminalNode GE() { return getToken(TideParser.GE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(80);
				literal();
				}
				break;
			case 2:
				{
				setState(81);
				match(LPAREN);
				setState(82);
				typeLiteral();
				setState(83);
				match(RPAREN);
				setState(84);
				((ExprContext)_localctx).right = expr(9);
				}
				break;
			case 3:
				{
				setState(86);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==TILDE) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				((ExprContext)_localctx).right = expr(8);
				}
				break;
			case 4:
				{
				setState(88);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				((ExprContext)_localctx).right = expr(7);
				}
				break;
			case 5:
				{
				setState(90);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCL || _la==DECL) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(91);
				((ExprContext)_localctx).right = expr(6);
				}
				break;
			case 6:
				{
				setState(92);
				identifier();
				}
				break;
			case 7:
				{
				setState(93);
				funCall();
				}
				break;
			case 8:
				{
				setState(94);
				match(LPAREN);
				setState(95);
				expr(0);
				setState(96);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(143);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(101);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8787507281920L) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						((ExprContext)_localctx).right = expr(22);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(104);
						match(QUESTION);
						setState(105);
						((ExprContext)_localctx).left = expr(0);
						setState(106);
						match(COLON);
						setState(107);
						((ExprContext)_localctx).right = expr(21);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(110);
						((ExprContext)_localctx).op = match(OR);
						setState(111);
						((ExprContext)_localctx).right = expr(20);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(113);
						((ExprContext)_localctx).op = match(AND);
						setState(114);
						((ExprContext)_localctx).right = expr(19);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(116);
						((ExprContext)_localctx).op = match(BOR);
						setState(117);
						((ExprContext)_localctx).right = expr(18);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(119);
						((ExprContext)_localctx).op = match(BXOR);
						setState(120);
						((ExprContext)_localctx).right = expr(17);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(122);
						((ExprContext)_localctx).op = match(BAND);
						setState(123);
						((ExprContext)_localctx).right = expr(16);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(125);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(126);
						((ExprContext)_localctx).right = expr(15);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(128);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LSH || _la==RSH) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						((ExprContext)_localctx).right = expr(13);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(131);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						((ExprContext)_localctx).right = expr(12);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(134);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(135);
						((ExprContext)_localctx).right = expr(11);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(137);
						((ExprContext)_localctx).op = match(DOT);
						setState(138);
						((ExprContext)_localctx).right = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(140);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3246391296L) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(141);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(142);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INCL || _la==DECL) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(TideParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TideParser.RBRACE, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(LBRACE);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6918056793323093538L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0)) {
				{
				{
				setState(149);
				statements();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(TideParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TideParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterFunCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitFunCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunCallContext funCall() throws RecognitionException {
		FunCallContext _localctx = new FunCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			identifier();
			setState(158);
			match(LPAREN);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 33214176100900867L) != 0)) {
				{
				{
				setState(159);
				expr(0);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunDeclContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(TideParser.FUNCTION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(TideParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TideParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FunModifierContext> funModifier() {
			return getRuleContexts(FunModifierContext.class);
		}
		public FunModifierContext funModifier(int i) {
			return getRuleContext(FunModifierContext.class,i);
		}
		public List<FunArgContext> funArg() {
			return getRuleContexts(FunArgContext.class);
		}
		public FunArgContext funArg(int i) {
			return getRuleContext(FunArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TideParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TideParser.COMMA, i);
		}
		public FunDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterFunDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitFunDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitFunDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDeclContext funDecl() throws RecognitionException {
		FunDeclContext _localctx = new FunDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOCAL || _la==META) {
				{
				{
				setState(167);
				funModifier();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(FUNCTION);
			setState(174);
			identifier();
			setState(175);
			match(LPAREN);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(176);
				funArg();
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(177);
					match(COMMA);
					setState(178);
					funArg();
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(186);
			match(RPAREN);
			setState(187);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunArgContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeLiteralContext typeLiteral() {
			return getRuleContext(TypeLiteralContext.class,0);
		}
		public FunArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterFunArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitFunArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitFunArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunArgContext funArg() throws RecognitionException {
		FunArgContext _localctx = new FunArgContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(189);
				typeLiteral();
				}
				break;
			}
			setState(192);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunModifierContext extends ParserRuleContext {
		public Set<Modifier> modifiers;
		public TerminalNode LOCAL() { return getToken(TideParser.LOCAL, 0); }
		public TerminalNode META() { return getToken(TideParser.META, 0); }
		public FunModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterFunModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitFunModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitFunModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunModifierContext funModifier() throws RecognitionException {
		FunModifierContext _localctx = new FunModifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funModifier);
		 ((FunModifierContext)_localctx).modifiers =  new HashSet<>(List.of(Modifier.GLOBAL)); 
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOCAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(LOCAL);

				        if (_localctx.modifiers.contains(Modifier.GLOBAL)) _localctx.modifiers.remove(Modifier.GLOBAL);
				        if (!_localctx.modifiers.add(Modifier.LOCAL)) throw new RuntimeException("Duplicate modifier: meta");
				    
				}
				break;
			case META:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(META);
				 if (!_localctx.modifiers.add(Modifier.META)) throw new RuntimeException("Duplicate modifier: meta"); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public FloatsContext floats() {
			return getRuleContext(FloatsContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public TerminalNode NULL() { return getToken(TideParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				floats();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				string();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				boolean_();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeLiteralContext extends ParserRuleContext {
		public TypeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLiteral; }
	 
		public TypeLiteralContext() { }
		public void copyFrom(TypeLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends TypeLiteralContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(TideParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(TideParser.RBRACK, 0); }
		public ArrayTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultTypeContext extends TypeLiteralContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DefaultTypeContext(TypeLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterDefaultType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitDefaultType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitDefaultType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLiteralContext typeLiteral() throws RecognitionException {
		TypeLiteralContext _localctx = new TypeLiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeLiteral);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new DefaultTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				identifier();
				}
				break;
			case 2:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				identifier();
				setState(209);
				match(LBRACK);
				setState(210);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public String value;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(TideParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			((IdentifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 ((IdentifierContext)_localctx).value =  (((IdentifierContext)_localctx).IDENTIFIER!=null?((IdentifierContext)_localctx).IDENTIFIER.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public Boolean value;
		public Token BOOLEAN;
		public TerminalNode BOOLEAN() { return getToken(TideParser.BOOLEAN, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolean);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			((BooleanContext)_localctx).BOOLEAN = match(BOOLEAN);
			 ((BooleanContext)_localctx).value =  Boolean.getBoolean((((BooleanContext)_localctx).BOOLEAN!=null?((BooleanContext)_localctx).BOOLEAN.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public String value;
		public Token STRING;
		public TerminalNode STRING() { return getToken(TideParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((StringContext)_localctx).STRING = match(STRING);
			 ((StringContext)_localctx).value =  (((StringContext)_localctx).STRING!=null?((StringContext)_localctx).STRING.getText():null).substring(1, (((StringContext)_localctx).STRING!=null?((StringContext)_localctx).STRING.getText():null).length() - 1); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public Integer value;
		public Token INT;
		public TerminalNode INT() { return getToken(TideParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			((IntegerContext)_localctx).INT = match(INT);
			 ((IntegerContext)_localctx).value =  Integer.parseInt((((IntegerContext)_localctx).INT!=null?((IntegerContext)_localctx).INT.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FloatsContext extends ParserRuleContext {
		public Double value;
		public Token FLOAT;
		public TerminalNode FLOAT() { return getToken(TideParser.FLOAT, 0); }
		public FloatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).enterFloats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TideParserListener ) ((TideParserListener)listener).exitFloats(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TideParserVisitor ) return ((TideParserVisitor<? extends T>)visitor).visitFloats(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatsContext floats() throws RecognitionException {
		FloatsContext _localctx = new FloatsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_floats);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			((FloatsContext)_localctx).FLOAT = match(FLOAT);
			 ((FloatsContext)_localctx).value =  Double.parseDouble((((FloatsContext)_localctx).FLOAT!=null?((FloatsContext)_localctx).FLOAT.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 21);
		case 1:
			return precpred(_ctx, 20);
		case 2:
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 14);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		case 10:
			return precpred(_ctx, 10);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001E\u00e6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"3\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"?\b\u0003\n\u0003\f\u0003B\t\u0003\u0001\u0003\u0003\u0003E\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006c\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u0090\b\u0006\n\u0006\f\u0006\u0093\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u0097\b\u0007\n\u0007\f\u0007\u009a\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00a1\b\b\n\b\f\b\u00a4"+
		"\t\b\u0001\b\u0001\b\u0001\t\u0005\t\u00a9\b\t\n\t\f\t\u00ac\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00b4\b\t\n\t\f\t\u00b7"+
		"\t\t\u0003\t\u00b9\b\t\u0001\t\u0001\t\u0001\t\u0001\n\u0003\n\u00bf\b"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00c7\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00ce"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d5\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0001\f\u0013\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$\u0000\b\u0001\u0000\u0019\u001a\u0001\u0000/0\u0001\u0000-.\u0002\u0000"+
		"\u0016\u0016!*\u0002\u0000\u001d\u001d  \u0001\u000089\u0001\u000013\u0002"+
		"\u0000\u0017\u0018\u001e\u001f\u00f9\u0000)\u0001\u0000\u0000\u0000\u0002"+
		"2\u0001\u0000\u0000\u0000\u00044\u0001\u0000\u0000\u0000\u00068\u0001"+
		"\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nL\u0001\u0000\u0000\u0000"+
		"\fb\u0001\u0000\u0000\u0000\u000e\u0094\u0001\u0000\u0000\u0000\u0010"+
		"\u009d\u0001\u0000\u0000\u0000\u0012\u00aa\u0001\u0000\u0000\u0000\u0014"+
		"\u00be\u0001\u0000\u0000\u0000\u0016\u00c6\u0001\u0000\u0000\u0000\u0018"+
		"\u00cd\u0001\u0000\u0000\u0000\u001a\u00d4\u0001\u0000\u0000\u0000\u001c"+
		"\u00d6\u0001\u0000\u0000\u0000\u001e\u00d9\u0001\u0000\u0000\u0000 \u00dc"+
		"\u0001\u0000\u0000\u0000\"\u00df\u0001\u0000\u0000\u0000$\u00e2\u0001"+
		"\u0000\u0000\u0000&(\u0003\u0002\u0001\u0000\'&\u0001\u0000\u0000\u0000"+
		"(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*\u0001\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,3\u0003"+
		"\u0012\t\u0000-.\u0003\f\u0006\u0000./\u0005\u0013\u0000\u0000/3\u0001"+
		"\u0000\u0000\u000003\u0003\u0006\u0003\u000013\u0003\u0004\u0002\u0000"+
		"2,\u0001\u0000\u0000\u00002-\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000021\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000\u000045\u0005"+
		"\u000b\u0000\u000056\u0003\f\u0006\u000067\u0005\u0013\u0000\u00007\u0005"+
		"\u0001\u0000\u0000\u000089\u0005\u0005\u0000\u00009:\u0005\r\u0000\u0000"+
		":;\u0003\f\u0006\u0000;<\u0005\u000e\u0000\u0000<@\u0003\u000e\u0007\u0000"+
		"=?\u0003\b\u0004\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000CE\u0003\n\u0005\u0000DC\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000E\u0007\u0001\u0000\u0000\u0000FG\u0005"+
		"\u0006\u0000\u0000GH\u0005\r\u0000\u0000HI\u0003\f\u0006\u0000IJ\u0005"+
		"\u000e\u0000\u0000JK\u0003\u000e\u0007\u0000K\t\u0001\u0000\u0000\u0000"+
		"LM\u0005\u0007\u0000\u0000MN\u0003\u000e\u0007\u0000N\u000b\u0001\u0000"+
		"\u0000\u0000OP\u0006\u0006\uffff\uffff\u0000Pc\u0003\u0018\f\u0000QR\u0005"+
		"\r\u0000\u0000RS\u0003\u001a\r\u0000ST\u0005\u000e\u0000\u0000TU\u0003"+
		"\f\u0006\tUc\u0001\u0000\u0000\u0000VW\u0007\u0000\u0000\u0000Wc\u0003"+
		"\f\u0006\bXY\u0007\u0001\u0000\u0000Yc\u0003\f\u0006\u0007Z[\u0007\u0002"+
		"\u0000\u0000[c\u0003\f\u0006\u0006\\c\u0003\u001c\u000e\u0000]c\u0003"+
		"\u0010\b\u0000^_\u0005\r\u0000\u0000_`\u0003\f\u0006\u0000`a\u0005\u000e"+
		"\u0000\u0000ac\u0001\u0000\u0000\u0000bO\u0001\u0000\u0000\u0000bQ\u0001"+
		"\u0000\u0000\u0000bV\u0001\u0000\u0000\u0000bX\u0001\u0000\u0000\u0000"+
		"bZ\u0001\u0000\u0000\u0000b\\\u0001\u0000\u0000\u0000b]\u0001\u0000\u0000"+
		"\u0000b^\u0001\u0000\u0000\u0000c\u0091\u0001\u0000\u0000\u0000de\n\u0015"+
		"\u0000\u0000ef\u0007\u0003\u0000\u0000f\u0090\u0003\f\u0006\u0016gh\n"+
		"\u0014\u0000\u0000hi\u0005\u001b\u0000\u0000ij\u0003\f\u0006\u0000jk\u0005"+
		"\u001c\u0000\u0000kl\u0003\f\u0006\u0015l\u0090\u0001\u0000\u0000\u0000"+
		"mn\n\u0013\u0000\u0000no\u0005,\u0000\u0000o\u0090\u0003\f\u0006\u0014"+
		"pq\n\u0012\u0000\u0000qr\u0005+\u0000\u0000r\u0090\u0003\f\u0006\u0013"+
		"st\n\u0011\u0000\u0000tu\u0005<\u0000\u0000u\u0090\u0003\f\u0006\u0012"+
		"vw\n\u0010\u0000\u0000wx\u0005;\u0000\u0000x\u0090\u0003\f\u0006\u0011"+
		"yz\n\u000f\u0000\u0000z{\u0005:\u0000\u0000{\u0090\u0003\f\u0006\u0010"+
		"|}\n\u000e\u0000\u0000}~\u0007\u0004\u0000\u0000~\u0090\u0003\f\u0006"+
		"\u000f\u007f\u0080\n\f\u0000\u0000\u0080\u0081\u0007\u0005\u0000\u0000"+
		"\u0081\u0090\u0003\f\u0006\r\u0082\u0083\n\u000b\u0000\u0000\u0083\u0084"+
		"\u0007\u0001\u0000\u0000\u0084\u0090\u0003\f\u0006\f\u0085\u0086\n\n\u0000"+
		"\u0000\u0086\u0087\u0007\u0006\u0000\u0000\u0087\u0090\u0003\f\u0006\u000b"+
		"\u0088\u0089\n\u0004\u0000\u0000\u0089\u008a\u0005\u0015\u0000\u0000\u008a"+
		"\u0090\u0003\f\u0006\u0005\u008b\u008c\n\r\u0000\u0000\u008c\u0090\u0007"+
		"\u0007\u0000\u0000\u008d\u008e\n\u0005\u0000\u0000\u008e\u0090\u0007\u0002"+
		"\u0000\u0000\u008fd\u0001\u0000\u0000\u0000\u008fg\u0001\u0000\u0000\u0000"+
		"\u008fm\u0001\u0000\u0000\u0000\u008fp\u0001\u0000\u0000\u0000\u008fs"+
		"\u0001\u0000\u0000\u0000\u008fv\u0001\u0000\u0000\u0000\u008fy\u0001\u0000"+
		"\u0000\u0000\u008f|\u0001\u0000\u0000\u0000\u008f\u007f\u0001\u0000\u0000"+
		"\u0000\u008f\u0082\u0001\u0000\u0000\u0000\u008f\u0085\u0001\u0000\u0000"+
		"\u0000\u008f\u0088\u0001\u0000\u0000\u0000\u008f\u008b\u0001\u0000\u0000"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\r\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0094\u0098\u0005\u000f\u0000\u0000\u0095\u0097\u0003\u0002\u0001\u0000"+
		"\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0005\u0010\u0000\u0000\u009c\u000f\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0003\u001c\u000e\u0000\u009e\u00a2\u0005\r\u0000\u0000\u009f"+
		"\u00a1\u0003\f\u0006\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u000e\u0000\u0000\u00a6\u0011"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a9\u0003\u0016\u000b\u0000\u00a8\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0001\u0000\u0000\u00ae\u00af\u0003\u001c\u000e\u0000\u00af\u00b8"+
		"\u0005\r\u0000\u0000\u00b0\u00b5\u0003\u0014\n\u0000\u00b1\u00b2\u0005"+
		"\u0014\u0000\u0000\u00b2\u00b4\u0003\u0014\n\u0000\u00b3\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005\u000e\u0000\u0000\u00bb\u00bc\u0003\u000e"+
		"\u0007\u0000\u00bc\u0013\u0001\u0000\u0000\u0000\u00bd\u00bf\u0003\u001a"+
		"\r\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0003\u001c\u000e"+
		"\u0000\u00c1\u0015\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\t\u0000\u0000"+
		"\u00c3\u00c7\u0006\u000b\uffff\uffff\u0000\u00c4\u00c5\u0005\n\u0000\u0000"+
		"\u00c5\u00c7\u0006\u000b\uffff\uffff\u0000\u00c6\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u0017\u0001\u0000\u0000"+
		"\u0000\u00c8\u00ce\u0003\"\u0011\u0000\u00c9\u00ce\u0003$\u0012\u0000"+
		"\u00ca\u00ce\u0003 \u0010\u0000\u00cb\u00ce\u0003\u001e\u000f\u0000\u00cc"+
		"\u00ce\u0005\f\u0000\u0000\u00cd\u00c8\u0001\u0000\u0000\u0000\u00cd\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00cd\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u0019"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d5\u0003\u001c\u000e\u0000\u00d0\u00d1"+
		"\u0003\u001c\u000e\u0000\u00d1\u00d2\u0005\u0011\u0000\u0000\u00d2\u00d3"+
		"\u0005\u0012\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d0\u0001\u0000\u0000\u0000\u00d5\u001b"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005B\u0000\u0000\u00d7\u00d8\u0006"+
		"\u000e\uffff\uffff\u0000\u00d8\u001d\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005A\u0000\u0000\u00da\u00db\u0006\u000f\uffff\uffff\u0000\u00db\u001f"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005@\u0000\u0000\u00dd\u00de\u0006"+
		"\u0010\uffff\uffff\u0000\u00de!\u0001\u0000\u0000\u0000\u00df\u00e0\u0005"+
		"=\u0000\u0000\u00e0\u00e1\u0006\u0011\uffff\uffff\u0000\u00e1#\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0005>\u0000\u0000\u00e3\u00e4\u0006\u0012\uffff"+
		"\uffff\u0000\u00e4%\u0001\u0000\u0000\u0000\u0010)2@Db\u008f\u0091\u0098"+
		"\u00a2\u00aa\u00b5\u00b8\u00be\u00c6\u00cd\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}