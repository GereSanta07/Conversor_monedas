import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaMoneda {

    Scanner lectura=new Scanner(System.in);

    public Moneda ConsultaMoneda(String peso1,String peso2,double peso) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/16c84de311b4df3fe0d8d0bf/pair/" + peso1 + "/"+peso2+"/"+peso+"/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        Gson gson=new Gson();
        return gson.fromJson(response.body(),Moneda.class);
    }

    public String Menu(){
        return "*******************\n" +
                "Sea bienvenido/a al Conversor de Moneda =\n\n" +
                "1) Dólar => Peso argentino\n" +
                "2) Peso argentino => Dólar\n" +
                "3) Dólar => Real brasileño\n" +
                "4) Real brasileño => Dólar\n" +
                "5) Dólar => Peso colombiano\n" +
                "6)Peso colombiano => Dólar\n" +
                "7) Salir\n" +
                "Elija una opcion válida:\n" +
                "*******************";

    }

    public double IngresarValorAConvertir(){
        System.out.println("Ingrese el valor que deseas convertir: ");
        double monedas=lectura.nextDouble();
        return monedas;
    }

}
