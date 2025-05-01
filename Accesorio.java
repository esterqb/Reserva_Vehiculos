package Reserva_Vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Reserva_Vehiculos.Vehiculo_Accesorio.tieneAccesorio;

/**
 * Tipo Accesorio.
 */
public class Accesorio {
    /**
     * Nombre.
     */
    public String nombre;
    /**
     * Id.
     */
    public int id;
    private static List<Accesorio> accesoriosDisponibles = new ArrayList<>();

    /**
     * Intancia un nuevo Accesorio.
     *
     * @param nombre the nombre
     * @param id     the id
     */
    public Accesorio(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        accesoriosDisponibles.add(this);
    }

    /**
     * Obtiene el nombre.
     *
     * @return - devuelve el nombre
     */
    public String getNombre() {return nombre;}

    /**
     * Establece el nombre.
     *
     * @param nombre el parámetro es nombre
     */
    public void setNombre(String nombre) {this.nombre = nombre;}

    /**
     * Obtiene la id.
     *
     * @return devuelve la id
     */
    public int getId() {return id;}

    /**
     * Establece la id.
     *
     * @param id el parámetro es id
     */
    public void setId(int id) {this.id = id;}

    /**
     * Obtiene accesorios disponibles.
     *
     * @return Devuelve los accesorios disponibles
     */
    public static List<Accesorio> getAccesoriosDisponibles() {
        return accesoriosDisponibles;
    }

    /**
     * Método para seleccionar el o los accesorios que se quieran de la lista de accesorios disponibles.
     * En el caso de la Kawasaki de Salva o la Vespa azulita, no se pueden seleccionar accesorios salvo el casco.
     * Plantear meter tipo de vehículo: coche o moto para así cubrir eso (if tipo = "moto" no accesorios excepto casco).
     * En el caso del GPS, Baca Remolque, solo se puede seleccionar 1, y las sillitas de bebé, 2 como mucho.
     */
    public static List<Accesorio> seleccionAccesorio(String tipoVehiculo) {
        List<Accesorio> seleccionados = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        if (tipoVehiculo.equalsIgnoreCase("moto")) {
            System.out.println("Para la moto solo se puede seleccionar el casco.");
            for (Accesorio accesorio : accesoriosDisponibles) {
                if (accesorio.getNombre().equalsIgnoreCase("Casco")) {
                    seleccionados.add(accesorio);
                    System.out.println("Casco seleccionado.");
                    return seleccionados;
                }
            }
            System.out.println("No se encotró el accesorio 'Casco'.");
            return seleccionados;
        }

        System.out.println("Accesorios disponibles:");
        for (Accesorio accesorio : accesoriosDisponibles) {
            System.out.println(accesorio.getId() + " - " + accesorio.getNombre());
        }

        boolean seguir = true;
        int sillitasSeleccionadas = 0;
        boolean otroAccesorio = false;

        // Nueva validación para el tipo "coche"
        boolean cocheLimiteAlcanzado = false;

        while (seguir) {
            if (cocheLimiteAlcanzado) {
                System.out.println("Has alcanzado el límite de accesorios para este coche. No puedes seleccionar más.");
                break; // Termina la selección de accesorios si el límite es alcanzado.
            }

            System.out.print("Introduzca el ID del accesorio deseado (si desea salir introduzca '-1'): ");
            int opcion = entrada.nextInt();

            if (opcion == -1) {
                System.out.println("Ha seleccionado la opción de salir sin seleccionar accesorios.");
                seguir = false;
            } else {
                Accesorio accesorioEncontrado = null;
                for (Accesorio a : accesoriosDisponibles) {
                    if (a.getId() == opcion) {
                        accesorioEncontrado = a;
                        break;
                    }
                }
                if (accesorioEncontrado != null) {
                    int id = accesorioEncontrado.getId();

                    switch (id) {
                        case 1:
                        case 3:
                        case 4:
                            if (otroAccesorio) {
                                System.out.println("Ya has seleccionado GPS, Baca o Remolque y solo puede seleccionar uno de estos.");
                            } else {
                                seleccionados.add(accesorioEncontrado);
                                otroAccesorio = true;
                                System.out.println(accesorioEncontrado.getNombre() + " añadido correctamente!");
                            }
                            break;
                        case 2:
                            if (sillitasSeleccionadas < 2) {
                                seleccionados.add(accesorioEncontrado);
                                sillitasSeleccionadas++;
                                System.out.println("Sillita añadida correctamente");
                            } else {
                                System.out.println("Ya ha añadido un máximo de 2 sillitas");
                            }
                            break;
                        default:
                            seleccionados.add(accesorioEncontrado);
                            System.out.println(accesorioEncontrado.getNombre() + " añadido correctamente:");
                    }

                    // Si se alcanzan los límites para los coches, se desactiva la opción de seguir seleccionando
                    if (tipoVehiculo.equalsIgnoreCase("coche") && sillitasSeleccionadas >= 2 && otroAccesorio) {
                        cocheLimiteAlcanzado = true;
                    }
                } else {
                    System.out.println("ID no válido. Por favor, introduzca un ID válido.");
                }
            }
        }

        return seleccionados;
    }

    /*Accesorios predefinidos. Gracias al constructor, ya están registrados en el array list.*/
    static {
        new Accesorio("GPS", 1);
        new Accesorio("Sillita de bebé", 2);
        new Accesorio("Remolque", 3);
        new Accesorio("Baca", 4);
        new Accesorio("Casco", 5);
    }
}