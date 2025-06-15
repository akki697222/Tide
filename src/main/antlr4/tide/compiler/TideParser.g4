parser grammar TideParser;

@header {
import java.util.*;
import tide.parser.Modifier;
}

options {
    tokenVocab = TideLexer;
}

root
    : statements* EOF
    ;

statements
    : funDecl
    | ifStmt
    | returnStmt
    | expr SEMI
    ;

returnStmt
    : RET expr SEMI
    ;

ifStmt
    : IF expr block elseIf* else?
    ;

elseIf
    : ELSEIF expr block
    ;

else
    : ELSE block
    ;

expr
    : logicalOr
    ;

logicalOr
    : left=logicalAnd                                    #LogicalOrBase
    | left=logicalOr op=OR right=logicalAnd             #LogicalOrExpr
    ;

logicalAnd
    : left=bitwiseOr                                     #LogicalAndBase
    | left=logicalAnd op=AND right=bitwiseOr            #LogicalAndExpr
    ;

bitwiseOr
    : left=bitwiseXor                                    #BitwiseOrBase
    | left=bitwiseOr op=BOR right=bitwiseXor            #BitwiseOrExpr
    ;

bitwiseXor
    : left=bitwiseAnd                                    #BitwiseXorBase
    | left=bitwiseXor op=BXOR right=bitwiseAnd          #BitwiseXorExpr
    ;

bitwiseAnd
    : left=equality                                      #BitwiseAndBase
    | left=bitwiseAnd op=BAND right=equality            #BitwiseAndExpr
    ;

equality
    : left=relational                                    #EqualityBase
    | left=equality op=(EQ | NE) right=relational       #EqualityExpr
    ;

relational
    : left=shift                                         #RelationalBase
    | left=relational op=(LT | LE | GT | GE) right=shift #RelationalExpr
    ;

shift
    : left=additive                                      #ShiftBase
    | left=shift op=(LSH | RSH) right=additive          #ShiftExpr
    ;

additive
    : left=multiplicative                                #AdditiveBase
    | left=additive op=(ADD | SUB) right=multiplicative #AdditiveExpr
    ;

multiplicative
    : left=unary                                         #MultiplicativeBase
    | left=multiplicative op=(MUL | DIV | MOD) right=unary #MultiplicativeExpr
    ;

unary
    : op=(TILDE | BANG | ADD | SUB | INCL | DECL) right=unary #UnaryExpr
    | cast                                               #UnaryBase
    ;

cast
    : LPAREN typeLiteral RPAREN right=unary             #CastExpr
    | postfix                                           #CastBase
    ;

postfix
    : primary op=(INCL | DECL)                          #PostfixExpr
    | primary                                           #PostfixBase
    ;

primary
    : funCall                                           #FunCallExpr
    | ref                                              #RefExpr
    | literal                                          #LiteralExpr
    | left=primary DOT right=primary                   #ChainExpr
    | LPAREN expr RPAREN                               #ParenExpr
    ;

funCall
    : identifier LPAREN (expr (COMMA expr)*)? RPAREN #FunctionCall
    ;

ref
    : identifier LBRACK expr RBRACK #ArrayReference
    | identifier #Reference
    ;

block
    : LBRACE statements* RBRACE
    ;

funDecl
    : funModifier* FUNCTION identifier LPAREN (funArg (COMMA funArg)*)? RPAREN block
    ;

funArg
    : typeLiteral? identifier
    ;

funModifier returns [Set<Modifier> modifiers]
    @init { $modifiers = new HashSet<>(List.of(Modifier.GLOBAL)); }
    : LOCAL {
        if ($modifiers.contains(Modifier.GLOBAL)) $modifiers.remove(Modifier.GLOBAL);
        if (!$modifiers.add(Modifier.LOCAL)) throw new RuntimeException("Duplicate modifier: meta");
    }
    | META  { if (!$modifiers.add(Modifier.META)) throw new RuntimeException("Duplicate modifier: meta"); }
    ;

literal
    : integer #IntegerLiteral
    | floats #FloatingLiteral
    | string #StringLiteral
    | boolean #BooleanLiteral
    | NULL #NullLiteral
    ;

typeLiteral
    : identifier #DefaultType
    | identifier LBRACK RBRACK #ArrayType
    ;

identifier returns [String value]
    : IDENTIFIER
    { $value = $IDENTIFIER.text; }
    ;

boolean returns [Boolean value]
    : BOOLEAN
    { $value = Boolean.getBoolean($BOOLEAN.text); }
    ;

string returns [String value]
    : STRING
    { $value = $STRING.text.substring(1, $STRING.text.length() - 1); }
    ;

integer returns [Integer value]
    : INT
    { $value = Integer.parseInt($INT.text); }
    ;

floats returns [Double value]
    : FLOAT
    { $value = Double.parseDouble($FLOAT.text); }
    ;