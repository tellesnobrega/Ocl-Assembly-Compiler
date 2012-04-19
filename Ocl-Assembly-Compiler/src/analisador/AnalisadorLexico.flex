package codigoGerado;

import java_cup.runtime.*;

%%

%class AnalisadorLexico
%public
%column
%line
%cup

%{
	private Symbol symbol(int type, Object val) {
		return new Symbol(type, yyline, yycolumn, val);
	}

	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
   	
	private void mensagemErro() {
		throw new RuntimeException("Ocorreu de erro léxico na linha " + yyline + " e coluna " + yycolumn + " . Lexema não casou com padrão: " + yytext());
	}
%}

number = [0-9]+
letter = [a-zA-Z]
integer = [+-]?{number}

%%

"/*"([ -~] | [^\n\r] | [\t\f\n\r])*"*/"	{ 											}
"--"([ -~])*							{ 											}
"--"([^\n\r])*([-~])*[\n\r]				{ 											}
"="			 							{ return symbol(sym.EQ); 					}
">"			 							{ return symbol(sym.GT);					}
"<"			 							{ return symbol(sym.LT); 					}
">="		 							{ return symbol(sym.GE); 					}
"<="		 							{ return symbol(sym.LE); 					}
"<>"		 							{ return symbol(sym.NE); 					}
"+"			 							{ return symbol(sym.PLUS); 					}
"-" 									{ return symbol(sym.MINUS); 				}
"*" 									{ return symbol(sym.TIMES); 				}
"(" 									{ return symbol(sym.LPAREN); 				}
")"			 							{ return symbol(sym.RPAREN); 				}
"{"			 							{ return symbol(sym.LBRACKET); 				}
"}"			 							{ return symbol(sym.RBRACKET); 				}
"/"			 							{ return symbol(sym.DIV); 					}
"collection"		 					{ return symbol(sym.COLLECTION);			} 
"pre" 				{ return symbol(sym.PRE);					}
"post" 				{ return symbol(sym.POST); 					}
"if"		 							{ return symbol(sym.IF); 					}
"then"		 							{ return symbol(sym.THEN); 					}
"else"		 							{ return symbol(sym.ELSE);					}
"endif"			 						{ return symbol(sym.ENDIF); 				}
"::" 									{ return symbol(sym.DOUBLECOLON); 				}
":"						    			{ return symbol(sym.COLON); 				}
"."			 							{ return symbol(sym.DOT);					}
","			 							{ return symbol(sym.COMMA); 				}
"|"			 							{ return symbol(sym.PIPE); 					}
"->"		 							{ return symbol(sym.ARROW); 				}
"xor" 									{ return symbol(sym.XOR); 					}
"or"		 							{ return symbol(sym.OR); 					}
"and"		 							{ return symbol(sym.AND); 					}
"implies"								{ return symbol(sym.IMPLIES); 				}
"not"		 							{ return symbol(sym.NOT); 					}
"context" 								{ return symbol(sym.CONTEXT);				}
"True"              					{ return symbol(sym.TRUE);                  }
"False"			             			{ return symbol(sym.FALSE);                	}
"@" 									{ return symbol(sym.AT);					}
{number}		 						{ return symbol(sym.NUMBER, Integer.parseInt(yytext())); 	}
{integer}\.{number}([eE][+-]?{number})?	{ return symbol(sym.DOUBLE, yytext());		}			
({letter} | _)({letter} | {number} | _)*	{ return symbol(sym.NAME, yytext()); 		}
"'"([ -&(-~]  | \\')*"'"            	{ return symbol(sym.STRING, yytext());		}
[ \r\n\t\f] 							{ 											}
<<EOF>> 								{ return symbol(sym.EOF); 					}
.|\n 									{ mensagemErro();							}