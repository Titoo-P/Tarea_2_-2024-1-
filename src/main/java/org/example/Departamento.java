package org.example;

import org.example.Excepciones.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.*;

/**
 * La clase Departamento representa un departamento de una organización.
 * Implementa la interfaz Invitable para permitir la invitación a reuniones.
 */
public class Departamento implements Invitable {

    private ArrayList<Empleado> empleados;
    private int numEmpleados;
    private String nombreOrganizacion;

    /**
     * Constructor que inicializa un departamento con un número de empleados y un nombre.
     *
     * @param name El nombre de la organización a la que pertenece el departamento.
     */
    public Departamento(String name) {
        empleados = new ArrayList<>();
        nombreOrganizacion = name;
    }

    /**
     * Devuelve la cantidad de empleados en el departamento.
     * Además, imprime la información de cada empleado en la consola.
     *
     * @return La cantidad de empleados en el departamento.
     */
    public int ObtenerCantEmpleados() {
        //for (Empleado empleado : empleados) {
        //    System.out.println(empleado.toString());
        //}
        return empleados.size();
    }

    /**
     * Agrega un empleado al departamento.
     * Si el empleado ya existe en el departamento, no lo agrega.
     *
     * @param empleado El empleado que se desea agregar.
     * @return true si el empleado se agregó exitosamente, false si ya existe.
     */
    public boolean AgregarEmpleado(Empleado empleado) throws EmpleadoYaExisteException, EmpleadoNullException{
        if (empleado == null) {
            throw new EmpleadoNullException("EmpleadoNullException: El empleado no puede ser null.");
        } else if (empleados.contains(empleado)) {
            throw new EmpleadoYaExisteException("EmpleadoYaExisteException: El empleado ya existe en el departamento.");
        } else {
            empleados.add(empleado);
            return true;
        }
    }

    /**
     * Invita a todo el departamento a una reunión.
     *
     * @param reunion La reunión a la que se invita al departamento.
     */
    public void invitar(Reunion reunion) {
        reunion.AgregarInvitado(new Invitacion(reunion, this)); // crear en Reunion
    }

    /**
     * Devuelve el empleado solicitado de la lista de empleados como organizador de la reunión.
     * Si no hay empleados, devuelve null.
     *
     * @return El empleado organizador de la reunión, o null si no hay empleados.
     */
    public Empleado OrganizadorReu(int cual_empleado) {
        if (cual_empleado >= 0 && cual_empleado < empleados.size()) {
            return empleados.get(cual_empleado);
        } else {
            // Manejar el caso en el que el índice es inválido
            return null;
        }
    }

    /**
     * Devuelve la lista de empleados del departamento.
     *
     * @return Una lista de empleados en el departamento.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }
}