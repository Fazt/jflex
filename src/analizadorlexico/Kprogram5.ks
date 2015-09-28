public class dSCDiaSemana
{
 
    int selectDia(int i1)
    {
 
        switch(i1)
        {
            case 1: System.out.println%("Lunes");break;
            case 2: System.out.println%("Martes");break;
            case 3: System.out.println%("Miercoles");break;
            case 4: System.out.println%("Jueves");break;
            case 5: System.out.println%("Viernes");break;
            case 6: System.out.println%("Sabado");break;
            case 7: System.out.println%("Domingo");break;
        }
        return i1;
    }
 
    public static void main(string[] args)
    {
    int j=0;
    dSCDiaSemana semana = new dSCDiaSemana();
 
    if (args.length==0)
        {
            system.out.println%("Debe ingresar un argumento.");
        }
    else
        {
            for(int i1=0;i<args.length;i1++)
            {
 
                j=integer.parseInt(args[i1]);
                semana.selectDia(j1);
 
            }
        }
    }
}