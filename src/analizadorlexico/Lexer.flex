package analizadorlexico;

import Tablas.sym;
import java_cup.runtime.Symbol;
%%
%class Scanner
%line
%public
%column
%unicode
%cup
%caseless
%ignorecase
%eofval{
  return new java_cup.runtime.Symbol(sym.EOF);
%eofval}
%eofclose
%{

/**
 * Retorna un nuevo Symbol con su identificador de Token y la línea y columna actual.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}
/**
 * Retorna un nuevo Symbol con su identificador de Token, la línea y columna actual,
 * además se incluye el valor del tokensken. El valor es utilizado para tokens como 
 * identificadores y números.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}
%}
ID=[a-z]([A-Za-z0-9]*[_]?)[A-Za-z0-9]+
NUM=([1-9][0-9]+)|[0-9] 
WHITE=[ \t\r\n]
COMENT1= \%.*[\r\n]
COMENT2= \/\#([^\#]|[\r\n]|(\#+([^\#\/]|[\r\n])))*\#+\/
f=f|F
w=w|W
h=h|H
l=l|L
e=e|E
n=n|N
t=t|T
v=v|V
o=o|O
d=d|D
s=s|S
r=r|R
u=u|U
i=i|I
%{
public String lexeme;
%}
%%
<YYINITIAL>{
{e}{l}{s}{e} {return newSym( sym.ELSE);}
{i}{f} {return newSym( sym.IF);}
{i}{n}{t} {return newSym( sym.INT);}
{v}{o}{i}{d} {return newSym( sym.VOID);}
{r}{e}{t}{u}{r}{n} {return newSym( sym.RETURN);}
{w}{h}{i}{l}{e} {return newSym( sym.WHILE);}
{f}{o}{r} {return newSym( sym.FOR);}
"+" {return newSym( sym.SUMA);}
"-" {return newSym(sym.RESTA);}
"*" {return newSym( sym.MULT);}
"/" {return newSym( sym.DIV);}
"^" {return newSym( sym.EXP1);}
"**" {return newSym( sym.EXP2);}
"LT" {return newSym( sym.LT);}
"LEQ" {return newSym( sym.LEQ);}
"GT" {return newSym( sym.GT);}
"GEQ" {return newSym( sym.GEQ);}
"EQ" {return newSym( sym.EQ);}
"NEQ" {return newSym( sym.NEQ);}
"::=" {return newSym( sym.ASIGN);}
"(" {return newSym( sym.PRI);}
")" {return newSym( sym.PRD);}
"[" {return newSym( sym.PCI);}
"]" {return newSym( sym.PCD);}
"{" {return newSym( sym.LLI);}
"}" {return newSym( sym.LLD);}
";" {return newSym( sym.PCOMMA);}
"," {return newSym( sym.COMMA);}
{ID} {return new Symbol( sym.ID, yyline,yycolumn,yytext());}
{NUM} {return new Symbol( sym.NUM,yyline,yycolumn, new Integer(yytext()));}
{COMENT1} {/*Ignore*/}
{COMENT2} {/*Ignore*/}
{WHITE} {/*Ignore*/}
}
. {throw new Error( "Caracter ilegal <"+yytext()+">");}