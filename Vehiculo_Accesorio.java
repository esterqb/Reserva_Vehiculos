package Reserva_Vehiculos;


public class Vehiculo_Accesorio {
    private Vehiculo vehiculo;
    private Accesorio accesorio;
    private boolean tieneAccesorio;

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
