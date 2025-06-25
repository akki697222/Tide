lexer grammar TideLexer;

@header {

}

FUNCTION : 'fun';
VAR      : 'var';
VAL      : 'val';
VARARG   : 'vararg';
IF       : 'if';
ELSEIF   : 'elseif';
ELSE     : 'else';
FOR      : 'for';
LOCAL    : 'local';
META     : 'meta';
RET      : 'ret';
NULL     : 'null';
FINAL    : 'final';

LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI   : ';';
COMMA  : ',';
DOT    : '.';

ASSIGN       : '=';
GT           : '>';
LT           : '<';
BANG         : '!';
TILDE        : '~';
QUESTION     : '?';
COLON        : ':';
EQ           : '==';
LE           : '<=';
GE           : '>=';
NE           : '!=';
ADD_ASSIGN   : '+=';
SUB_ASSIGN   : '-=';
MUL_ASSIGN   : '*=';
DIV_ASSIGN   : '/=';
MOD_ASSIGN   : '%=';
BAND_ASSIGN  : '&=';
BXOR_ASSIGN  : '^=';
BOR_ASSIGN   : '|=';
LSH_ASSIGN   : '<<=';
RSH_ASSIGN   : '>>=';
AND          : '&&';
OR           : '||';
INCL         : '++';
DECL         : '--';
ADD          : '+';
SUB          : '-';
MUL          : '*';
DIV          : '/';
MOD          : '%';
ARROW        : '->';
COLON_DOUBLE : '::';
FOR_INC      : '..=';
FOR_EXC      : '..';
LSH          : '<<';
RSH          : '>>';
BAND         : '&';
BXOR         : '^';
BOR          : '|';

INT         : DIGITS ;
FLOAT       : DIGITS '.' DIGITS? EXPONENT?
            | '.' DIGITS EXPONENT? ;
HEX         : '0' [xX] HEX_LETTER+;
STRING      : '"' (ESC | ~["\\])* '"' ;
BOOLEAN     : 'true' | 'false' ;
IDENTIFIER  : [a-zA-Z_] [a-zA-Z0-9_]*;

fragment DIGITS   : [0-9]+ ;
fragment EXPONENT : [eE] [+-]? DIGITS ;
fragment LETTER   : [a-zA-Z_] ;
fragment ESC      : '\\' (["\\nrtbf] | UNICODE) ;
fragment UNICODE  : 'u' HEX_LETTER HEX_LETTER HEX_LETTER HEX_LETTER ;
fragment HEX_LETTER      : [0-9a-fA-F] ;

WS: [ \t\r\n\u000C]+ -> skip;

COMMENT: '#[' .*? ']' -> skip;

LINE_COMMENT: '#' ~[\r\n]* -> skip;