package Reserva_Vehiculos;

public class ReservaException extends Exception {
    private String mensaje;
    private String dni;

    public ReservaException(String mensaje, String dni) {
        super(mensaje);
        this.mensaje = mensaje;
        this.dni = dni;
    }
    public String getDni() {
        return dni;
    }
    public String getMessage() {
        return mensaje;
    }
}
