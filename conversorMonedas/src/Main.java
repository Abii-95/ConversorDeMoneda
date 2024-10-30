import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Por favor ingrese la opción deseada");

        Conversor conversor = new Conversor();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Conversor de Monedas, seleccione la moneda actual a convertir:");
            System.out.println("1 = ARS - Peso argentino");
            System.out.println("2 = BOB - Boliviano boliviano");
            System.out.println("3 = BRL - Real brasileño");
            System.out.println("4 = CLP - Peso chileno");
            System.out.println("5 = COP - Peso colombiano");
            System.out.println("6 = USD - Dólar estadounidense");
            System.out.println("7 = CRC - Colón Costarricense");
            System.out.println("8 = Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.next();


            switch (opcion)
            {
                case "1":
                    conversor.LlenarMonedas("ARS");
                    break;
                case "2":
                    conversor.LlenarMonedas("BOB");
                    break;
                case "3":
                    conversor.LlenarMonedas("BRL");
                    break;
                case "4":
                    conversor.LlenarMonedas("CLP");
                    break;
                case "5":
                    conversor.LlenarMonedas("COP");
                    break;
                case "6":
                    conversor.LlenarMonedas("USD");
                    break;
                case "7":
                    conversor.LlenarMonedas("CRC");
                    break;
                case "8":
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

            if (salir == false) {
                System.out.println("Ingrese el monto a convertir");

                double monto = scanner.nextDouble();
                System.out.println("Conversor de Monedas, seleccione el tipo de moneda a convertir:");
                System.out.println("1 = ARS - Peso argentino");
                System.out.println("2 = BOB - Boliviano boliviano");
                System.out.println("3 = BRL - Real brasileño");
                System.out.println("4 = CLP - Peso chileno");
                System.out.println("5 = COP - Peso colombiano");
                System.out.println("6 = USD - Dólar estadounidense");
                System.out.println("7 = CRC - Colón Costarricense");
                System.out.println("8 = Salir");
                System.out.print("Seleccione una opción: ");
                String opcion2 = scanner.next();

                double resultado;
                switch (opcion2)
                {
                    case "1":
                        resultado = conversor.ConvertirMoneda(monto , "ARS");
                        System.out.println(resultado);
                        break;
                    case "2":
                        resultado = conversor.ConvertirMoneda(monto,"BOB");
                        System.out.println(resultado);
                        break;
                    case "3":
                        resultado = conversor.ConvertirMoneda(monto , "BRL");
                        System.out.println(resultado);
                        break;
                    case "4":
                        resultado = conversor.ConvertirMoneda(monto , "CLP");
                        System.out.println(resultado);
                        break;
                    case "5":
                        resultado = conversor.ConvertirMoneda(monto , "COP");
                        System.out.println(resultado);

                        break;
                    case "6":
                        resultado = conversor.ConvertirMoneda(monto ,"USD");
                        System.out.println(resultado);
                        break;
                    case "7":
                        resultado = conversor.ConvertirMoneda(monto ,"CRC");
                        System.out.println(resultado);
                        break;
                    case "8":
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }


        }
        scanner.close();
    } // fin main

} // fin de la clase Main
