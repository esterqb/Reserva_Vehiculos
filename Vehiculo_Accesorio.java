package Reserva_Vehiculos;


import java.util.Scanner;

public class Vehiculo_Accesorio {
    private Vehiculo vehiculo;
    private Accesorio accesorio;
    private static boolean tieneAccesorio;

    /**
     * Constructor
     * Instancia un nuevo Vehiculo accesorio.
     *
     * @param vehiculo  vehiculo
     * @param accesorio accesorio
     */
    public Vehiculo_Accesorio(Vehiculo vehiculo, Accesorio accesorio) {
        this.vehiculo = vehiculo;
        this.accesorio = accesorio;
    }

    public static boolean tieneAccesorio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Seleccionar accesorio(s)? (S/N)");
        String resp=sc.nextLine();
        if(resp.equals("S"))
            tieneAccesorio=true;
        return true;
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
