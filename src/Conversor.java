import java.util.Map;

public class Conversor {
    private final Map<String, Double> tasas;

    public Conversor(DatosApi data) {
        this.tasas = data.conversion_rates();
    }

    public double convertir(double monto, String monedaOrigen, String monedaDestino) {

        if (monedaOrigen.equals("USD")) {
            return monto * tasas.get(monedaDestino);
        } else if (monedaDestino.equals("USD")) {
            return monto / tasas.get(monedaOrigen);
        }

        return 0;
    }
    }

