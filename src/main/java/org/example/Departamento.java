package org.example;

import java.time.Instant;
import java.util.*;

public class Departamento implements Invitable {

    private ArrayList<Empleado> empleados;
    private int numEmpleados;
    private String nombreOrganizacion;

    public int ObtenerCantEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
        return numEmpleados;
    }

    public boolean AgregarEmpleado(Empleado empleado) {
        if (empleados.contains(empleado)) {
            return false;
        } else {
            empleados.add(empleado);
            numEmpleados++;
            return true;
        }
    }

    public void invitar(Reunion reunion) {
        reunion.AgregarInvitado(new Invitacion(reunion,this)); // crear en Reunion
    }

    public Empleado OrganizadorReu() {
        if (!empleados.isEmpty()) {
            return empleados.get(0);
        } else {
            // Manejar el caso en el que no hay empleados en el departamento
            return null;
        }
    }

    public List<Empleado> getEmpleados(){
        return empleados;
    }

    public Departamento(int num, String name) {
        numEmpleados = num;
        empleados = new ArrayList<>();
        nombreOrganizacion = name;
    }
}