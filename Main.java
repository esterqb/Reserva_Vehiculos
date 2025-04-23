package Reserva_Vehiculos;

import java.time.LocalDate;
import java.util.Scanner;

import static Reserva_Vehiculos.Accesorio.seleccionAccesorio;
import static Reserva_Vehiculos.Usuario_vehiculo.alquilarVehiculo;
import static Reserva_Vehiculos.Vehiculo_Accesorio.tieneAccesorio;

public class Main {
    /**
     * Declaración de la variable estática Usuario para usarlo en cualquier parte del Main.
     */
    static Usuario usuario;
    /**
     * La variable opcion permite elegir al usuario qué función realizar.
     */
    static int opcion;
    /**
     * Variable estática para usar Scanner en el Main.
     */
    static Scanner scanner = new Scanner(System.in);


    /**
     * Menu del programa.
     */
    public static void menu() {
        System.out.println("ALQUILER DE VEHÍCULOS.");
        System.out.println("Seleccione una opción.");
        System.out.println("1. Ver catálogo.");
        System.out.println("2. Registrar otro vehiculo.");
        System.out.println("3. Registrar mantenimiento.");
        System.out.println("4. Asociar mantenimiento al vehículo.");
        System.out.println("5. Registrar usuario.");
        System.out.println("6. Alquiler de vehículo.");
        System.out.println("7. Seleccionar accesorio.");
        System.out.println("8. Elegir accesorio.");
        System.out.println("9. Finalizar el sistema.");

        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            opcion = 0;
        }
    }


    public static void main(String[] args) {
        do {
            menu();
            accion();
        } while (opcion !=7);
    }

    /**
     * Método para realizar las acciones introducidas por el usuario en el menú según el método asociado aquí al case seleccionado.
     */
    public static void accion() {
        switch (opcion) {
            case 1 -> Vehiculo.verCatalogo();
            case 2 -> Vehiculo.agregarVehiculo();
            case 3 -> Mantenimiento.addMantenimiento();
            case 4 -> Mantenimiento.asociarMantenimiento();
            case 5 -> introducirUsuario();
            case 6 -> alquilarVehiculo();
            case 7 -> tieneAccesorio();
            case 8 -> seleccionAccesorio();
            case 9 -> System.out.println("Fin del programa\n\n");
            default -> System.out.println("Error en la opción\n\n");
        }
    }

    /**
     * Método para introducir (crear) un usuario.
     */
    public static void introducirUsuario() {
        boolean correcto = false;
        try {
            System.out.println("Introduzca el DNI del usuario: ");
            String dni = scanner.nextLine();
            System.out.println("Introduzca el nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.println("Introduzca el apellido del usuario: ");
            String apellido = scanner.nextLine();

            Usuario verUsuario = new Usuario(dni, nombre, apellido, 0);
            verUsuario.entrada(dni, nombre, apellido);

            usuario = verUsuario;
            correcto = true;

        } catch (ReservaException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            System.out.println("No se realizó correctamente la entrada de datos del usuario con DNI " + ex.getDni() + " en el sistema.");
        }
        if (!correcto) {
            System.out.println("Se produjo un error.");
        }
    }
}
