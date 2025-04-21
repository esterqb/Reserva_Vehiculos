package Reserva_Vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Reserva_Vehiculos.Main.scanner;

public class Mantenimiento {
    private int id_Mantenimiento;
    private LocalDate fecha;
    private static List<Mantenimiento> historial = new ArrayList<>();

    /**
     * Instancia un nuevo objeto Mantenimiento.
     *
     * @param id_Mantenimiento id mantenimiento
     * @param fecha            fecha
     */
    public Mantenimiento(int id_Mantenimiento, LocalDate fecha) {
        this.id_Mantenimiento = id_Mantenimiento;
        this.fecha = fecha;
    }

    /**
     * Obtiene el id mantenimiento.
     *
     * @return devuelve el id mantenimiento
     */
    public int getId_Mantenimiento() {
        return id_Mantenimiento;
    }

    /**
     * Establece el id mantenimiento.
     *
     * @param id_Mantenimiento el parámetro es el id mantenimiento
     */
    public void setId_Mantenimiento(int id_Mantenimiento) {
        this.id_Mantenimiento = id_Mantenimiento;
    }

    /**
     * Obtiene la fecha.
     *
     * @return devuelve la fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha.
     *
     * @param fecha parámetro: fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para registrar y guardar mantenimiento en el historial.
     *
     * @param id    id
     * @param fecha fecha
     * @return devuelve el mantenimiento
     */
    public static Mantenimiento registrarMantenimiento(int id, LocalDate fecha) {
        Mantenimiento nuevo = new Mantenimiento(id, fecha);
        historial.add(nuevo);
        System.out.println("Mantenimiento registrado: " + id + "(" + fecha + ")" );
        return nuevo;
    }

    /**
     * Obtiene el historial de mantenimiento recogido en el array list.
     *
     * @return devuelve el historial
     */
    public static List<Mantenimiento> getHistorial() {
        return historial;
    }

    @Override
    public String toString() {
        return "Mantenimiento " + id_Mantenimiento + "(" + fecha + ")";
    }

    /**
     * Método para añadir un nuevo objeto de la clase Mantenimiento.
     */
    public static void addMantenimiento() {
        System.out.println("Ingrese el ID del mantenimiento:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la fecha (formato AAAA-MM-DD):");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        Mantenimiento.registrarMantenimiento(id, fecha);
    }

    /**
     * Método para asociar un mantenimiento (objeto de ese tipo) a un objeto de la clase Vehículo.
     */
    public static void asociarMantenimiento() {
        System.out.println("\nSeleccione vehículo por matrícula:");

        for (Vehiculo v : Vehiculo.catalogo) {
            System.out.println("- " + v.getMatricula());
        }

        String matricula = scanner.nextLine();

        Vehiculo vehiculoSeleccionado = null;
        for (Vehiculo v : Vehiculo.catalogo) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculoSeleccionado = v;
                break;
            }
        }

        if (vehiculoSeleccionado == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        System.out.println("Seleccione ID de mantenimiento:");
        for (Mantenimiento m : Mantenimiento.getHistorial()) {
            System.out.println("- ID: " + m.getId_Mantenimiento() + " | Fecha: " + m.getFecha());
        }

        int id = Integer.parseInt(scanner.nextLine());
        Mantenimiento mantenimientoSeleccionado = null;

        for (Mantenimiento m : Mantenimiento.getHistorial()) {
            if (m.getId_Mantenimiento() == id) {
                mantenimientoSeleccionado = m;
                break;
            }
        }

        if (mantenimientoSeleccionado == null) {
            System.out.println("Mantenimiento no encontrado.");
            return;
        }

        vehiculoSeleccionado.addMantenimiento(mantenimientoSeleccionado);
    }
}
