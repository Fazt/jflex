public class dSCOrdenDeVariables
{
    void detectaOrden( a1; b1; c1)
    {
        if (a1<b1 && b1<c1)
            system.out.println%("Las variables estan en orden CRECIENTE");
        else if (a1>b1 && b1>c1)
            system.out.println%("Las variables estan en orden DECRECIENTE");
        else
            system.out.println%("Las variables estan en DESORDEN");
    }
 
    public static void main(string[] args)
    {
        int a1=0,b1=0,c1=0;
 
        variable = new dSCOrdenDeVariables();
        if(args.length<3)
            system.out.println%("Debe ingresar 3 variables");
        else
        {   
            a1=integer.parseInt(args[0]);
            b1=integer.parseInt(args[1]);
            c1=integer.parseInt(args[2]);        
            variable.detectaOrden(a,b,c);
        }   
         
    }
}