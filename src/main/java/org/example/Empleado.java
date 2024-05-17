package org.example;

/**
 * La clase Empleado representa un empleado con un ID, apellidos, nombre y correo electrónico.
 */
public class Empleado implements Invitable {

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * Constructor que inicializa un empleado con el ID, apellidos, nombre y correo electrónico.
     *
     * @param id        El ID del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre    El nombre del empleado.
     * @param correo    El correo electrónico del empleado.
     */
    public Empleado(String id, String nombre, String apellidos, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Devuelve el ID del empleado.
     *
     * @return El ID del empleado.
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve los apellidos del empleado.
     *
     * @return Los apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el correo electrónico del empleado.
     *
     * @return El correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id El nuevo ID del empleado.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos Los nuevos apellidos del empleado.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo El nuevo correo electrónico del empleado.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve una representación en formato de cadena del empleado,
     * incluyendo su ID, apellidos, nombre y correo electrónico.
     *
     * @return Una cadena que representa al empleado.
     */

    public void invitar(Reunion reunion) {
        System.out.println(nombre + "Has sido invitado a una reunión el " + reunion.getFecha() + " a las " + reunion.getHoraPrevista() + ".");
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}


