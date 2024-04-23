import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public MonedaResponse buscaMoneda(String tipoDeMoneda){

        URI direccion=URI.create("https://v6.exchangerate-api.com/v6/878b1f25279902fa96c5e05d/latest/"+ tipoDeMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), MonedaResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("no encontre esa monedaa");
        }
    }
}
