package analizadorlexico;
import static analizadorlexico.Token.*;
%%
%class Lexer
%type Token
L = [a-zA-Z]
D = [0-9]
WHITE=[ \t\r\n]
COMENT1= \%.*[\r\n]
COMENT2= \/\#([^\#]|[\r\n]|(\#+([^\#\/]|[\r\n])))*\#+\/
IDENT= [a-z]([L|D]*[_]?)[L|D]+
NUMERO= ([1-9][0-9]+)|[0-9]
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
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}
else {return ELSE;}
if {return IF;}
int {return INT;}
void {return VOID;}
return {return RETURN;}
while {return WHILE;}
for {return FOR;}
"+" {return SUMA;}
"-" {return RESTA;}
"*" {return MULT;}
"/" {return DIV;}
"^" {return EXP1;}
"**" {return EXP2;}
"<" {return LT;}
"<=" {return LEQ;}
">" {return GT;}
">=" {return GEQ;}
"=" {return EQ;}
"!=" {return NEQ;}
":=" {return ASIGN;}
"(" {return PRI;}
")" {return PRD;}
"[" {return PCI;}
"]" {return PCD;}
"{" {return LLI;}
"}" {return LLD;}
";" {return PCOMMA;}
"." {return POINT;}
{COMENT1} {/*Ignore*/}
{COMENT2} {/*Ignore*/}
{IDENT} {lexeme=yytext(); return ID;}
{NUMERO} {lexeme=yytext(); return NUM;}
. {return ERROR;}