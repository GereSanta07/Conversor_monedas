import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta=new ConsultaMoneda();
        Scanner lectura=new Scanner(System.in);
        Moneda moneda =null;
        int opcion;
        do{
            System.out.println(consulta.Menu());
            opcion=lectura.nextInt();
            double peso;
            if(opcion==7){
                break;
            }
            peso=consulta.IngresarValorAConvertir();
            switch(opcion){
                case 1:

                    moneda=consulta.ConsultaMoneda("USD","ARS",peso);
                    break;
                case 2:

                    moneda=consulta.ConsultaMoneda("ARS","USD",peso);
                    break;
                case 3:

                    moneda=consulta.ConsultaMoneda("USD","BRL",peso);
                    break;
                case 4:

                    moneda=consulta.ConsultaMoneda("BRL","USD",peso);
                    break;
                case 5:

                    moneda=consulta.ConsultaMoneda("USD","COP",peso);
                    break;
                case 6:

                    moneda=consulta.ConsultaMoneda("COP","USD",peso);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            if (moneda!=null){
                System.out.println("El valor"+peso+" ["+moneda.base_code()+"] corresponde al valor final de =>>> "+moneda.conversion_result()+" ["+moneda.target_code()+"]");
            }

        }while(opcion!=7);
    }
}
