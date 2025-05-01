package Reserva_Vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario_vehiculo {
    private static Usuario usuario;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    // Lista para guardar todas las relaciones entre vehiculos y usuarios (alquiler)
    public static List<Usuario_vehiculo> alquileres = new ArrayList<>();


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


    /**
     * Alquilar vehiculo. Se le pasan los métodos introducir usuario de la clase Usuario, mostrar catálogo de la clase Vehículo, método tiene accesorio de la clase vehiculo_accesorio y seleccion_accesorio de la clase Accesorio.
     * Primero se identifica el usuario que va a realizar el alquiler, a continuación se muestran los vehículos disponibles.
     * Se pide la fecha de recogida del vehículo y la de entrega del mismo, comprobando que la de entrega sea posterior a la de recogida.
     * Preguntan si quieres seleccionar accesorios y si responde que si, muestra todos los accesorios disponibles, teniendo en cuenta las limitaciones presentadas en el método seleccion_accesorio de la clase Accesorio.
     * Finalmente muestra un mensaje de alquiler realizado correctamente.
     */
    public static void alquilarVehiculo(){
        Scanner sc = new Scanner(System.in);

        // Identificación del usuario
        Usuario usuario = Usuario.introducirUsuario();
        if (usuario == null) {
            System.out.println("No se pudo crear el usuario. Cancelando el alquiler.");
            return;
        }

        // Mostramos el catálogo de vehículos
        System.out.println("Seleccione el vehículo que quiera alquilar: ");
        for (int i = 0; i < Vehiculo.catalogo.size(); i++) {
            System.out.println(i + " - " + Vehiculo.catalogo.get(i));
        }

        System.out.print("Introduce el número del vehículo que quieres alquilar: ");
        try {
            int opcion = sc.nextInt();
            if (opcion >= 0 && opcion < Vehiculo.catalogo.size()) {
                Vehiculo seleccionado = Vehiculo.catalogo.get(opcion);
                System.out.println("Has seleccionado: " + seleccionado);

                System.out.print("Introduce el día de recogida (DD): ");
                int dia = sc.nextInt();
                System.out.print("Introduce el mes (MM): ");
                int mes = sc.nextInt();
                System.out.print("Introduce el año (AAAA): ");
                int anio = sc.nextInt();
                LocalDate fechaInicio = LocalDate.of(anio, mes, dia);

                LocalDate fechaEntrega = null;
                boolean fechaValida = false;
                while (!fechaValida) {
                    System.out.print("Introduce el día de entrega (DD): ");
                    int diaE = sc.nextInt();
                    System.out.print("Introduce el mes de entrega (MM): ");
                    int mesE = sc.nextInt();
                    System.out.print("Introduce el año de entrega (AAAA): ");
                    int anioE = sc.nextInt();
                    fechaEntrega = LocalDate.of(anioE, mesE, diaE);

                    // Comprobar que la fecha de entrega no sea antes de la de recogida
                    if (fechaEntrega.isBefore(fechaInicio)) {
                        System.out.println("¡Error! La fecha de entrega no puede ser antes de la fecha de recogida. Por favor, introduzca nuevamente la fecha de entrega.");
                    } else {
                        fechaValida = true; // Fecha de entrega válida
                    }
                }


                // Crear el alquiler
                Usuario_vehiculo alquiler = new Usuario_vehiculo(usuario, seleccionado, fechaInicio, fechaEntrega);

                // Guardarlo en la lista
                alquileres.add(alquiler);

                // Eliminar el vehículo del catálogo
                Vehiculo.catalogo.remove(seleccionado);

                // Pegunta si quiere seleccionar algun accesorio y en caso afirmativo se muestran los accesorios que puede seleccionar
                if (Vehiculo_Accesorio.tieneAccesorio()){
                    List<Accesorio> accesoriosSeleccionados = Accesorio.seleccionAccesorio(seleccionado.getTipo());

                    // Se muestran los accesorios seleccionados
                    if (!accesoriosSeleccionados.isEmpty()){
                        System.out.println("*** Accesorios seleccionados ***");
                        for (Accesorio accesorio : accesoriosSeleccionados){
                            System.out.println("- " + accesorio.getNombre());
                        }
                    } else {
                        System.out.println("No se han seleccionado accesorios.");
                    }
                }

                System.out.println("¡Vehículo alquilado correctamente!");
            } else {
                System.out.println("Índice fuera de rango.");
            }
        } catch (Exception e) {
            System.out.println("Error: Debes introducir un número válido.");
        }
    }

    /**
     * Mostrar alquileres. Método para mostrar todos los alquileres realizados.
     * Muestra el nombre y DNI del usuario que ha realizado el alquilere, con el vehiculo y la fecha de recogida y entrega del vehiculo.
     */
    public static void mostrarAlquileres(){
        if (alquileres.isEmpty()){
            System.out.println("No hay alquileres realizados");
        } else {
            System.out.println("*** Listado de alquileres realizados ***");
            for (Usuario_vehiculo alquiler : alquileres){
                System.out.println("Usuario: " + alquiler.getUsuario().getNombre() + " " + alquiler.getUsuario().getApellido());
                System.out.println("DNI: " + alquiler.getUsuario().getDni());
                System.out.println("Vehículo: " + alquiler.getVehiculo().getModelo() + " - Matrícula: " + alquiler.getVehiculo().getMatricula());
                System.out.println("Fecha de recogida de vehículo: " + alquiler.getFechaInicio());
                System.out.println("Fecha estimada de entrega: " + alquiler.getFechaEntrega());
                System.out.println("-----------------------------");
            }
        }
    }

    /**
     * Obtiene la lista alquileres.
     *
     * @return the alquileres
     */
    public static List<Usuario_vehiculo> getAlquileres() {
        return alquileres;
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

