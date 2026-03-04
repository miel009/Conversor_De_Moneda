import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaApi {

        private static final String API_KEY = "7c4a48afaae64edb330639f4";

        public DatosApi Conexion() {

                URI url = URI.create("https://v6.exchangerate-api.com/v6/"
                        + API_KEY + "/latest/USD");

                HttpClient cliente = HttpClient.newHttpClient();

                HttpRequest solicitud = HttpRequest.newBuilder()
                        .uri(url)
                        .GET()
                        .build();

                try {
                        HttpResponse<String> respuesta = cliente.send(
                                solicitud,
                                HttpResponse.BodyHandlers.ofString()
                        );
                        System.out.println(respuesta.body());
                        return new Gson().fromJson(respuesta.body(), DatosApi.class);

                } catch (IOException | InterruptedException e) {
                        throw new RuntimeException("Error al conectar con la API", e);
                }
        }
}
