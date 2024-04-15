import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String nombre= "Tony Estark";
        String tipoDeCuenta= "Corriente";
        double saldo= 1599.99;
        int opcion=0;

        System.out.println("***************************");
        System.out.println("se bienvenido/a al conversor de moneda =) ");

        String menu= """
                
                1- Dolar =>> Peso Argentino
                2- Peso Argentino =>> Dolar
                3- Dolar =>> Real Brasilero
                4- Real Brasilero =>> Dolar
                5- Dolar =>> Peso Colombiano
                6- Peso Colombiano =>> Dolar
                7- Salir del menu
                
                *** Elija una opcion valida ***
                """;

        System.out.println("**************************");
        Scanner teclado= new Scanner(System.in);
        while(opcion !=7){
            System.out.println(menu);
            opcion= teclado.nextInt();

            switch (opcion){

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;
                case 4:

                    break;
                case 6:

                    break;


                case 7:
                    System.out.println("saliendo del programa, gracias por utilizar nuestros servicios :) ");
                    break;

                default:
                    System.out.println("opcion no valida! ingrese opcion correcta");


            }
        }




    }
}
