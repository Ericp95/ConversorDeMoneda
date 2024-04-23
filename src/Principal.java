import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {

        static HashMap<Integer, String[]> calculoConversiones = new CalculoConversionMoneda().getConversiones();
        static ConsultaApi consulta = new ConsultaApi(); //Establece la conexión HTTP y devuelve un JSON
        static String[] valores; //Valores de conversión: [1] es para moneda a convertir, [2] para la conversión
        static String monedaACambiar = "";
        static String cambioDeMoneda = "";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opc = 0; //Elección del usuario
            double valorCambio = 0; //Valor a convertir ingresado por el usuario
            System.out.println("***********************************");
            System.out.println("Sea bienvenido al conversor de monedas =]");
            while (true) {
                try {
                    menu(false);
                    opc = scanner.nextInt();
                    if (opc < 1 || opc >=9) {
                        break;
                    }

                    valores = calculoConversiones.get(opc);
                    monedaACambiar = valores[0];
                    cambioDeMoneda = valores[1];

                    var json = new ConsultaApi().buscaMoneda(monedaACambiar);
                    Moneda moneda = new Moneda(json);
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    valorCambio = scanner.nextDouble();
                    moneda.realizaConversion(cambioDeMoneda,valorCambio);
                    System.out.println(moneda);
                } catch (Exception e) {
                    System.out.println("Error: Ingresa una opción válida");
                    scanner.nextLine();
                }
            }
            menu(true);
        }

        public static void menu(boolean isFinished){
            if (isFinished){
                System.out.print("Gracias por utilizar la aplicación =]");
            }else{
                System.out.print(
                        """
                                1) Dólar =>> Peso Argentino
                                2) Peso Argentino =>> Dolar
                                3) Dolar =>> Real Brasileño
                                4) Real Brasileño =>> Dólar
                                5) Dolar =>> Peso Colombiano
                                6) Peso Colombiano =>> Dolar
                                7) Dolar =>> Peso Mexicano
                                8) Peso Mexicano =>> Dolar
                                9) Salir
                                Elige una opción válida: 
          
                                """
                );
                System.out.println("***********************************");
            }
        }
}
