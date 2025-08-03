parser grammar TideParser;

@header {
import java.util.*;
import tide.core.Modifier;
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
    | varDecl
    | returnStmt
    | whileStmt
    | breakStmt
    | forStmt
    | classDecl
    | interfaceDecl
    | expr SEMI
    ;

returnStmt
    : RET expr? SEMI
    ;

forStmt
    : FOR (forNumerical | forIterate)
    ;

forNumerical
    : identifier IN expr (FOR_INC | FOR_EXC) expr block
    ;

forIterate
    : identifier IN expr block
    ;

interfaceDecl
    : modifier* INTERFACE identifier classInherit? LBRACE interfaceMethodDecl* RBRACE
    ;

interfaceMethodDecl
    : FUNCTION identifier LPAREN (funArg (COMMA funArg)*)? RPAREN SEMI
    ;

classDecl
    : modifier* CLASS identifier classInherit? classBlock
    ;

classInherit
    : COLON identifier (COMMA identifier)*
    ;

classBlock
    : LBRACE classStatements* RBRACE
    ;

classStatements
    : funDecl
    | varDecl
    | classConstructor
    ;

classConstructor
    : (PUBLIC | PRIVATE) CONSTRUCTOR LPAREN (funArg (COMMA funArg)*)? RPAREN block
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

/*
while true {
    #do something
}
*/
whileStmt
    : WHILE expr block
    ;

breakStmt
    : BREAK SEMI
    ;

expr
    : assignment
    ;

assignment
    : left=logicalOr #AssignmentBase
    | ref op=(ASSIGN
             | ADD_ASSIGN
             | SUB_ASSIGN
             | MUL_ASSIGN
             | DIV_ASSIGN
             | MOD_ASSIGN
             | POW_ASSIGN
             | BAND_ASSIGN
             | BXOR_ASSIGN
             | BOR_ASSIGN
             | LSH_ASSIGN
             | RSH_ASSIGN)
    assignment #AssignmentExpr
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
    | left=multiplicative op=(MUL | DIV | MOD | POW) right=unary #MultiplicativeExpr
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
    : funCall                         #FunCallExpr
    | left=primary DOT right=primary #ChainExpr
    | left=(THIS | SUPER) DOT right=primary #ClassAccessorExpr
    | SUPER LPAREN (expr (COMMA expr)*)? RPAREN #SuperClassConstructorCallerExpr
    | ref                            #RefExpr
    | lambda #LambdaExpr
    | literal                        #LiteralExpr
    | LPAREN expr RPAREN             #ParenExpr
    ;

lambda
    : lambdaParam ARROW (block | expr)
    ;

lambdaParam
    : LPAREN (funArg (COMMA funArg)*)? RPAREN
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
    : modifier* FUNCTION identifier LPAREN (funArg (COMMA funArg)*)? RPAREN (block | SEMI)
    ;

funArg
    : typeLiteral? identifier
    ;

varDecl
    : modifier* typeLiteral identifier (ASSIGN expr)? SEMI
    ;

modifier
    : PRIVATE
    | PUBLIC
    | ABSTRACT
    | FINAL
    | STATIC //static(class method,variable only)
    ;

literal
    : integer #IntegerLiteral
    | floats #FloatingLiteral
    | string #StringLiteral
    | boolean #BooleanLiteral
    | NULL #NullLiteral
    | LBRACK (expr (COMMA expr)*)? RBRACK #ArrayLiteral
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
    { $value = Boolean.parseBoolean($BOOLEAN.text); }
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