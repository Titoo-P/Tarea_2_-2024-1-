package org.example;

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
     * @param num  El número inicial de empleados en el departamento.
     * @param name El nombre de la organización a la que pertenece el departamento.
     */
    public Departamento(int num, String name) {
        numEmpleados = num;
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
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
        return numEmpleados;
    }

    /**
     * Agrega un empleado al departamento.
     * Si el empleado ya existe en el departamento, no lo agrega.
     *
     * @param empleado El empleado que se desea agregar.
     * @return true si el empleado se agregó exitosamente, false si ya existe.
     */
    public boolean AgregarEmpleado(Empleado empleado) {
        if (empleados.contains(empleado)) {
            return false;
        } else {
            empleados.add(empleado);
            numEmpleados++;
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
     * Devuelve el primer empleado de la lista de empleados como organizador de la reunión.
     * Si no hay empleados, devuelve null.
     *
     * @return El empleado organizador de la reunión, o null si no hay empleados.
     */
    public Empleado OrganizadorReu() {
        if (!empleados.isEmpty()) {
            return empleados.get(0);
        } else {
            // Manejar el caso en el que no hay empleados en el departamento
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