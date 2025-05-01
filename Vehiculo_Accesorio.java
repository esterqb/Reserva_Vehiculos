package Reserva_Vehiculos;


import java.util.Scanner;

public class Vehiculo_Accesorio {
    private Vehiculo vehiculo;
    private Accesorio accesorio;
    private static boolean tieneAccesorio;


    /**
     * Pregunta si quiere seleccionar accesorios. Ignora las diferentes formas de introducir el valor true.
     *
     * @return the boolean
     */
    public static boolean tieneAccesorio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Seleccionar accesorio(s)? (S/N)");
        String resp = sc.nextLine().trim().toUpperCase();
        return resp.equals("s") || resp.equals("si") || resp.equals("S") || resp.equals("SI");
    }


    /**
     * Obtiene el vehículo.
     *
     * @return devuelve el vehículo.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo.
     *
     * @param vehiculo vehículo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene el accesorio.
     *
     * @return devuelve el accesorio
     */
    public Accesorio getAccesorio() {
        return accesorio;
    }

    /**
     * Establece el accesorio.
     *
     * @param accesorio accesorio
     */
    public void setAccesorio(Accesorio accesorio) {
        this.accesorio = accesorio;
    }

}
