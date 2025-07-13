package Dev.Sneyki.MoneyPlus;

import Dev.Sneyki.MoneyPlus.Models.ExchangeRateResponse;
import Dev.Sneyki.MoneyPlus.Services.ExchangeRateAPIService;
import Dev.Sneyki.MoneyPlus.Utils.JsonParserUtil;
import Dev.Sneyki.MoneyPlus.Utils.XchangeRateSave;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        bienvenida();
        List<String> historialConversiones = new ArrayList<>();

        while (true) {
            String fromCurrency = seleccionarMoneda("La moneda BASE");
            String toCurrency = seleccionarMoneda("La moneda COTIZADA");
            int montoUsuario = montoAConvertir();

            //HTTP request and response
            String buildRequest = ExchangeRateAPIService.construirURL(fromCurrency, toCurrency);
            String respuestaExchange = ExchangeRateAPIService.consultarURL(buildRequest);
            ExchangeRateResponse exchangeResponse = JsonParserUtil.parseRate(respuestaExchange);

            //Devuelve la informacion al usuario sobre moneda base y moneda cotizada
            infoParseada(exchangeResponse);

            //muestra el resultado usando el monto y moneda elegidos por Usuario
            mostrarResultadoConversion(exchangeResponse, montoUsuario);

            //Se guarda la informacion en ArrayList
            String resumen = String.format("%.2f %s => %.2f %s (Tasa: %.4f)",
                    (double) montoUsuario,
                    exchangeResponse.base_code(),
                    montoUsuario * exchangeResponse.conversion_rate(),
                    exchangeResponse.target_code(),
                    exchangeResponse.conversion_rate());
            historialConversiones.add(resumen);

            //Pregunta al Usuario continuar con busquedas
            String respuestaWhile = preguntaBucle();
            if (respuestaWhile.equals("no")) {
                break;
            }
        }
        preguntarYGuardarArchivo(historialConversiones);
        despedida();
    }


    //Bienvenida del programa
    private static void bienvenida() {
        System.out.println("***********************************************");
        System.out.println("Hola! Bienvenido a MoneyPlus!");
        System.out.println("Tu conversor de monedas de confianza!");
        System.out.println("Iniciemos con las divisas a convertir");
        System.out.println("***********************************************");
    }

    //Metodo para solicitar a Usuario tipo de moneda tanto base como cotizada
    private static String seleccionarMoneda(String tipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("selecciona " + tipo + ":");
        System.out.println("""
                        1) USD - Dólar estadounidense
                        2) EUR - Euro
                        3) GBP - Libra esterlina
                        4) JPY - Yen japonés
                        5) CHF - Franco suizo
                        6) CAD - Dólar canadiense
                        7) AUD - Dólar australiano
                        8) NZD - Dólar neozelandés
                        9) CNY - Yuan chino
                        10) MXN - Peso mexicano
                        11) BRL - Real brasileño
                        12) ARS - Peso argentino
                """);
        int monedaBaseOpcionUsuario = scanner.nextInt();
        String monedaBase;
        switch (monedaBaseOpcionUsuario) {
            case 1:
                monedaBase = "USD";
                break;
            case 2:
                monedaBase = "EUR";
                break;
            case 3:
                monedaBase = "GBP";
                break;
            case 4:
                monedaBase = "JPY";
                break;
            case 5:
                monedaBase = "CHF";
                break;
            case 6:
                monedaBase = "CAD";
                break;
            case 7:
                monedaBase = "AUD";
                break;
            case 8:
                monedaBase = "NZD";
                break;
            case 9:
                monedaBase = "CNY";
                break;
            case 10:
                monedaBase = "MXN";
                break;
            case 11:
                monedaBase = "BRL";
                break;
            case 12:
                monedaBase = "ARS";
                break;
            default:
                System.out.println("opcion no valida, intente de nuevo");
                return seleccionarMoneda(tipo);
        }
        return monedaBase;
    }

    //Solicita monto a convertir
    private static int montoAConvertir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto que deseas convertir");
        int monto = scanner.nextInt();
        return monto;
    }

    //Mostrar informacion ya parseada
    private static void infoParseada(ExchangeRateResponse info) {
        System.out.printf("Actualmente, el tipo de cambio de la moneda %s para %s es de: %.2f\n",
                info.base_code(),
                info.target_code(),
                info.conversion_rate()
        );
    }

    //Mostrar resultado de la conversion
    private static void mostrarResultadoConversion(ExchangeRateResponse info, int monto) {
        double resultado = monto * info.conversion_rate();
        System.out.printf("\nPor lo tanto, %.2f %s equivale a %.2f %s\n",
                (double) monto,
                info.base_code(),
                resultado,
                info.target_code()
        );
    }

    //Pregunta al usuario continuar buscando
    private static String preguntaBucle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea hacer otra busqueda? Si/No");
        String respuestaUsuario = scanner.nextLine().toLowerCase(Locale.ROOT);
        return respuestaUsuario;
    }

    //Pregunta al Usuario para crear archivo TXT con historial de busqueda
    private static void preguntarYGuardarArchivo(List<String> historial) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea guardar el historial de conversiones? Si/No");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("si")) {
            XchangeRateSave.guardarHistorial(historial);
        } else {
            System.out.println("No se guardo ningun archivo.");
        }
    }

    private static void despedida(){
        System.out.println("***********************************");
        System.out.println("Gracias por usar MoneyPlus!");
        System.out.println("***********************************");
    }
}