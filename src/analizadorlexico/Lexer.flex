package analizadorlexico;
import static analizadorlexico.Token.*;
%%
%class Lexer
%type Token
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
{WHITE} {/*Ignore*/}
else {return ELSE;}
if {return IF;}
int {return INT;}
void {return VOID;}
return {return RETURN;}
{w}{h}{i}{l}{e} {return WHILE;}
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
"::=" {return ASIGN;}
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
[a-z]([A-Za-z0-9]*[_]?)[A-Za-z0-9]+ {lexeme=yytext(); return ID;}
([1-9][0-9]+)|[0-9] {lexeme=yytext(); return NUM;}
. {return ERROR;}