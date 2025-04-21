package Reserva_Vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehiculo {
    /**
     * Atributos del objeto Vehículo.
     */
    public String matricula;
    public String numeroBastidor;
    public String anioMatriculacion;
    public String modelo;
    private List<Mantenimiento> mantenimientos = new ArrayList<>();
    private List<Vehiculo_Accesorio> vehiculoAccesorios = new ArrayList<>();

    /**
     * The constant catalogo (catálogo podrá ser utilizado en el main).
     */
    public static List<Vehiculo> catalogo = new ArrayList<>();

    /**
     * Añadir un accesorio al vehículo.
     *
     * @param va
     */
    public void addVehiculoAccesorio(Vehiculo_Accesorio va) {
        vehiculoAccesorios.add(va);
    }

    /**
     * Gets vehiculo accesorios.
     *
     * @return devuelve vehiculo accesorios
     */
    public List<Vehiculo_Accesorio> getVehiculoAccesorios() {
        return vehiculoAccesorios;
    }

    /**
     * Constructor
     * Instancia un nuevo objeto de tipo Vehículo.
     *
     * @param matricula         matrícula
     * @param numeroBastidor    número bastidor
     * @param anioMatriculacion año matriculación
     * @param modelo            modelo
     */
    public Vehiculo(String matricula, String numeroBastidor, String anioMatriculacion, String modelo) {
        this.matricula = matricula;
        this.numeroBastidor = numeroBastidor;
        this.anioMatriculacion = anioMatriculacion;
        this.modelo = modelo;

        // Añadir un vehículo al catálogo cada vez se cree un nuevo vehículo
        catalogo.add(this);
    }

    //Vehículos ya en el catálogo.
    static {
        new Vehiculo("7896SLV", "66600", "2025", "Kawasaki de Salva");
        new Vehiculo("7639BKL", "23410", "2022", "Vespa azulita");
        new Vehiculo("7452HOE", "383800", "2025", "Volkswagen Tayron");
        new Vehiculo("2605RYE", "20180", "2018", "Alfa Romeo");
        new Vehiculo("9873MLS", "52342", "2023", "Seat Ibiza");
    }

    /**
     * Obtiene la matrícula.
     *
     * @return devuelve la matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula.
     *
     * @param matricula matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el número de  bastidor.
     *
     * @return devuelve el número de bastidor
     */
    public String getNumeroBastidor() {
        return numeroBastidor;
    }

    /**
     * Establece el número de bastidor.
     *
     * @param numeroBastidor número de bastidor
     */
    public void setNumeroBastidor(String numeroBastidor) {
        this.numeroBastidor = numeroBastidor;
    }

    /**
     * Obtiene el año de matriculación.
     *
     * @return devuelve el año de matriculación.
     */
    public String getAnioMatriculacion() {
        return anioMatriculacion;
    }

    /**
     * Establece el año de matriculación.
     *
     * @param anioMatriculacion año de matriculación.
     */
    public void setAñoMatriculacion(String anioMatriculacion) {
        this.anioMatriculacion = anioMatriculacion;
    }

    /**
     * Obtiene el modelo.
     *
     * @return devuelve el modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo.
     *
     * @param modelo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Datos del vehículo: " +
                "\n\tMatrícula: " + matricula + "(" + anioMatriculacion + ")"+
                "\n\tModelo: " + modelo;
    }

    /**
     * Método para ver el catálogo de vehículos.
     */
    public static void verCatalogo(){
        for(Vehiculo vehiculo:catalogo){
            System.out.println(vehiculo.toString());
        }
    }

    /**
     * Método para crear un nuevo mantenimiento (objeto del tipo Mantenimiento).
     *
     * @param m m
     */
    public void addMantenimiento(Mantenimiento m) {
        mantenimientos.add(m);
        System.out.println("Mantenimiento " + m.getId_Mantenimiento() + " asociado al vehículo " + matricula);
    }

    /**
     * Método para agregar un vehículo nuevo al catálogo.
     */
    public static void agregarVehiculo(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introducir matrícula.");
            String matricula = sc.nextLine().toUpperCase();
            if (!matricula.matches("\\d{4}[A-Z]{3}")) {
                throw new IllegalArgumentException("Formato de matrícula inválido. Debe tener 4 números y 3 letras.");
            }
            System.out.println("Introducir número de bastidor.");
            String numeroBastidor = sc.nextLine();
            if (!numeroBastidor.matches("\\d{5}")) {
                throw new IllegalArgumentException("Número de bastidor inválido. Debe contener exactamente 5 números.");
            }
            System.out.println("Introducir año de matriculación.");
            String anioMatriculacion = sc.nextLine();
            int anio = Integer.parseInt(anioMatriculacion);
            if (anio < 2020 || anio > 2025) {
                throw new IllegalArgumentException("Año de matriculación inválido. Debe estar entre 2020 y 2025.");
            }
            System.out.println("Introducir modelo.");
            String modelo = sc.nextLine();

            Vehiculo nuevoVehiculo = new Vehiculo(matricula, numeroBastidor, anioMatriculacion, modelo);
            Vehiculo.catalogo.add(nuevoVehiculo);
            System.out.println("Vehículo agregado al catálogo correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    /**
     * Obtiene los mantenimientos.
     *
     * @return devuelve los mantenimientos
     */
    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }
}