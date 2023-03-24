import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class SimuladorHipoteca {

    interface Callback {
        void error (String error);
        void cuota (Double cuota);
    }

    public static double calcularCuota(double capital, double plazo, Callback callback) {
        // if (capital <= 0) error: capital no valido
        // if (plazo <= 0) error: plazo no valido
        if (capital <= 0){
            callback.error("CAPITAL NO VÁLIDO");
        } else if (plazo <= 0){
            callback.error("PLAZO NO VALIDO");
        }

        double interes = 0;

        try {
            // obtener 'interes' del banco...
            interes = Double.parseDouble(HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                    .uri(URI.create("https://fakebank-tan.vercel.app/api/get-interest"))
                    .GET().build(), HttpResponse.BodyHandlers.ofString()).body());
        } catch (Exception e) {
            // error obteniendo interes
            System.out.println("ERROR OBTENIENDO INTERESES");
        }

        return capital*interes/12/(1-Math.pow(1+(interes/12),-plazo*12));
    }
}

public class Main {
    public static void main(String[] args) {
        double cuota = SimuladorHipoteca.calcularCuota(2000, 2, new SimuladorHipoteca.Callback() {
            @Override
            public void error(String error) {
                System.out.println("ERROR: " + error);
            }

            @Override
            public void cuota(Double cuota) {
                System.out.println(cuota);
            }
        });

        System.out.println(cuota);
    }
}