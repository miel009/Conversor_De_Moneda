public class Principal {

    public static void main(String[] args) {

        ConsultaApi consulta = new ConsultaApi();
        DatosApi datos = consulta.Conexion();

        if (datos != null) {
            System.out.println("Conexión exitosa");
            System.out.println("Moneda base: " + datos.base_code());
        } else {
            System.out.println("Error conexión");
        }

    }

}
