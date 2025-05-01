package Reserva_Vehiculos;

import static Reserva_Vehiculos.Main.scanner;

public class Usuario {
    /**
     * Atributos de la clase Usuario
     */
    public String dni;
    public String nombre;
    public String apellido;
    public String tlfno;


    /**
     * Obtiene el dni.
     *
     * @return devuelve dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece dni.
     *
     * @param dni  dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre.
     *
     * @return devuelve el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     *
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido.
     *
     * @return devuelve el apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido.
     *
     * @param apellido apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el teléfono.
     *
     * @return devuelve el teléfono
     */
    public String getTlfno() {
        return tlfno;
    }

    /**
     * Establece el teléfono.
     *
     * @param tlfno tlfno
     */
    public void setTlfno(String tlfno) {
        this.tlfno = tlfno;
    }

    /**
     * Instancia un nuevo Usuario.
     *
     * @param dni      dni
     * @param nombre   nombre
     * @param apellido apellido
     * @param tlfno    tlfno
     */
    public Usuario(String dni, String nombre, String apellido, String tlfno) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tlfno = tlfno;
    }

    /**
     * Método para introducir (crear) un nuevo objeto de tipo Usuario.
     *
     * @param dni      dni
     * @param nombre   nombre
     * @param apellido apellido
     * @param tlfno
     * @throws ReservaException reserva exception
     */
    public void entrada(String dni, String nombre, String apellido, String tlfno) throws ReservaException{
        if (dni == null || dni.length() != 9) {
            throw new ReservaException("El DNI introducido es incorrecto.", dni);
        }
        if (!dni.matches("\\d{8}[A-Za-z]")) {
            throw new ReservaException("El formato del DNI no es válido.", dni);
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new ReservaException("Introduzca un nombre.", dni);
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new ReservaException("Introduzca un apellido.", dni);
        }
        if (!tlfno.matches("\\d{9}")) {
            throw new ReservaException("El número de teléfono debe contener exactamente 9 dígitos numéricos.", dni);
        }
    }

    /**
     * Método para introducir (crear) un usuario.
     */
    public static Usuario introducirUsuario() {
        boolean correcto = false;
        Usuario usuario = null;

        try {
            System.out.println("Introduzca el DNI del usuario: ");
            String dni = scanner.nextLine();
            System.out.println("Introduzca el nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.println("Introduzca el apellido del usuario: ");
            String apellido = scanner.nextLine();
            System.out.println("Introduzca el número de teléfono: ");
            String tlfn = scanner.nextLine();

            usuario = new Usuario(dni, nombre, apellido, tlfn);
            usuario.entrada(dni, nombre, apellido, tlfn);
            correcto = true;

        } catch (ReservaException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            System.out.println("No se realizó correctamente la entrada de datos del usuario con DNI " + ex.getDni() + " en el sistema.");
        }

        if (!correcto) {
            System.out.println("Se produjo un error.");
            return null;
        }

        return usuario;
    }

}
