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
    public static void seleccionAccesorio() {
        if (tieneAccesorio()){
            seleccionAccesorio();
        }

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