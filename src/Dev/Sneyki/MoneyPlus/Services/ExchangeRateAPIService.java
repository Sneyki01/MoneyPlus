package Dev.Sneyki.MoneyPlus.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPIService {
    //Constructor de URL en base a decisiones de Usuario
    public static String construirURL (String monedaBase, String monedaCotizada) {
        return "https://v6.exchangerate-api.com/v6/f7c11aa90887c6c18210a5ae/pair/"
                + monedaBase + "/" + monedaCotizada;
    }

    //Consulta de API usando URL construida previamente
    public static String consultarURL (String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
