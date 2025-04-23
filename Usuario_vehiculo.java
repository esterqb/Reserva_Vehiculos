package Reserva_Vehiculos;

import java.time.LocalDate;

public class Usuario_vehiculo {
    private Usuario usuario;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;

    /**
     * Instancia un nuevo objeto Usuario_vehiculo.
     *
     * @param usuario      usuario
     * @param vehiculo     vehiculo
     * @param fechaInicio  fecha inicio
     * @param fechaEntrega fecha entrega
     */
    public Usuario_vehiculo(Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaEntrega) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
    }

    public static void alquilarVehiculo(){
        System.out.println("Alquilando vehiculo (tengo que desarrollarlo -en mantenimiento xd-)");
    }

    /**
     * Obtiene  el usuario.
     *
     * @return devuelve el usuario
     */
    public Usuario getUsuario() { return usuario; }

    /**
     * Establece el usuario.
     *
     * @param usuario usuario
     */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    /**
     * Obtiene el vehículo.
     *
     * @return devuelve el vehículo.
     */
    public Vehiculo getVehiculo() { return vehiculo; }

    /**
     * Establece el vehículo.
     *
     * @param vehiculo vehículo
     */
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    /**
     * Obtiene la fecha de inicio.
     *
     * @return devuelve la fecha de inicio
     */
    public LocalDate getFechaInicio() { return fechaInicio; }

    /**
     * Establece la fecha de inicio.
     *
     * @param fechaInicio fecha inicio
     */
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    /**
     * Obtiene la fecha de entrega.
     *
     * @return devuelve la fecha de entrega
     */
    public LocalDate getFechaEntrega() { return fechaEntrega; }

    /**
     * Establece la fecha de entrega.
     *
     * @param fechaEntrega fecha entrega
     */
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }
}

