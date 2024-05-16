package org.example;

/**
 * La clase Asistencia representa la asistencia de un empleado a una reunión.
 * Contiene la información del empleado que asiste.
 */
public class Asistencia {
    private final Empleado empleado;

    /**
     * Constructor que inicializa al empleado que asiste a la reunión.
     *
     * @param empleado El empleado que asiste a la reunión.
     */
    public Asistencia(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Devuelve el empleado que asiste a la reunión.
     *
     * @return El empleado que asiste a la reunión.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Devuelve una representación en formato de cadena de la asistencia,
     * incluyendo la información del empleado.
     *
     * @return Una cadena que representa la asistencia.
     */
    @Override
    public String toString() {
        return "Asistencia{" + "empleado=" + empleado + '}';
    }
}