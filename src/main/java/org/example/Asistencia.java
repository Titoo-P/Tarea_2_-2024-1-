package org.example;

public class Asistencia {
    private final Empleado empleado;

    public Asistencia(Empleado empleado) {
        this.empleado = empleado;
    } // Constructor que inicializa al empleado que asiste a la reunion

    public Empleado getEmpleado() {
        return empleado;
    } // Metodo que devuelve el empleado que asiste a la reunion

    @Override
    public String toString() {
        return "Asistencia{" + "empleado=" + empleado + '}';
    } // Metodo que devuelve el empleado que asiste a la reunion
}
