package codigoGerado;

import java_cup.runtime.*;

%%

%class AnalisadorLexico
%public
%column
%line
%cup

%{
	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
   	
	private Symbol symbol(int type, Object val) {
		return new Symbol(type, yyline, yycolumn, val);
	}

	private void mensagemErro() {
		throw new RuntimeException("Erro Léxico na linha " + yyline + " e coluna " + yycolumn + " . Não existe padrão para o lexema: " + yytext());
	}
%}

numero = [0-9]+
letra = [a-zA-Z]
inteiro = [+-]?{numero}

%%

"/*"([ -~] | [^\n\r] | [\t\f\n\r])*"*/"	{ 											}
"--"([ -~])*							{ 											}
"--"([^\n\r])*([-~])*[\n\r]				{ 											}
"(" 									{ return symbol(sym.LPAREN); 				}
")"			 							{ return symbol(sym.RPAREN); 				}
"{"			 							{ return symbol(sym.LBRACKET); 				}
"}"			 							{ return symbol(sym.RBRACKET); 				}
"xor" 									{ return symbol(sym.XOR); 					}
"or"		 							{ return symbol(sym.OR); 					}
"and"		 							{ return symbol(sym.AND); 					}
"implies"								{ return symbol(sym.IMPLIES); 				}
"not"		 							{ return symbol(sym.NOT); 					}
"="			 							{ return symbol(sym.EQ); 					}
">"			 							{ return symbol(sym.GT);					}
"<"			 							{ return symbol(sym.LT); 					}
">="		 							{ return symbol(sym.GE); 					}
"<="		 							{ return symbol(sym.LE); 					}
"<>"		 							{ return symbol(sym.NE); 					}
"+"			 							{ return symbol(sym.PLUS); 					}
"-" 									{ return symbol(sym.MINUS); 				}
"*" 									{ return symbol(sym.TIMES); 				}
"/"			 							{ return symbol(sym.DIV); 					}
"collection"		 					{ return symbol(sym.COLLECTION);			} 
"inv"		 							{ return symbol(sym.INV); 					}
"if"		 							{ return symbol(sym.IF); 					}
"then"		 							{ return symbol(sym.THEN); 					}
"else"		 							{ return symbol(sym.ELSE);					}
"endif"			 						{ return symbol(sym.ENDIF); 				}
":"						    			{ return symbol(sym.COLON); 				}
"."			 							{ return symbol(sym.DOT);					}
","			 							{ return symbol(sym.COMMA); 				}
"|"			 							{ return symbol(sym.PIPE); 					}
"->"		 							{ return symbol(sym.ARROW); 				}
"context" 								{ return symbol(sym.CONTEXT);				}
"True"              					{ return symbol(sym.TRUE);                  }
"False"			             			{ return symbol(sym.FALSE);                	}
"self"									{ return symbol(sym.SELF);					}
{inteiro}								{ return symbol(sym.INTEGER, yytext());		}
{inteiro}\.{numero}([eE][+-]?{numero})?	{ return symbol(sym.DOUBLE, yytext());		}
({letra} | _)({letra} | {numero} | _)*	{ return symbol(sym.NAME, yytext()); 		}
"'"([ -&(-~]  | \\')*"'"            	{ return symbol(sym.STRING, yytext());		}
[ \r\n\t\f] 							{ 											}
<<EOF>> 								{ return symbol(sym.EOF); 					}
.|\n 									{ mensagemErro();							}