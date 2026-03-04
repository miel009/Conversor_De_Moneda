import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ConsultaApi conexion = new ConsultaApi();
        DatosApi data = conexion.Conexion();

        if (data == null) {
            System.out.println("No se pudo obtener datos :(");
            return;
        }

        Conversor conversor = new Conversor(data);
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 7) {

            ExibirMenu.mostrar();
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {

                System.out.print("Ingrese el monto: ");
                double monto = scanner.nextDouble();

                switch (opcion) {

                    case 1 -> System.out.println(
                            "Resultado: " +
                                    conversor.convertir(monto, "USD", "ARS") +
                                    " ARS");

                    case 2 -> System.out.println(
                            "Resultado: " +
                                    conversor.convertir(monto, "ARS", "USD") +
                                    " USD");

                    case 3 -> System.out.println(
                            "Resultado: " +
                                    conversor.convertir(monto, "USD", "BRL") +
                                    " BRL");

                    case 4 -> System.out.println(
                            "Resultado: " +
                                    conversor.convertir(monto, "BRL", "USD") +
                                    " USD");

                    case 5 -> System.out.println(
                            "Resultado: " +
                                    conversor.convertir(monto, "USD", "COP") +
                                    " COP");

                    case 6 -> System.out.println(
                            "Resultado: " +
                                    conversor.convertir(monto, "COP", "USD") +
                                    " USD");
                }

            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor!!!");
            } else {
                System.out.println("Opción inválida.");
            }
        }

    }

}
