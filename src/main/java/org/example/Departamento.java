package org.example;

import org.example.Reunion.*;
import java.util.*;

public class Departamento implements Invitable {

    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Reunion> EmpReuniones; // Lista de reuniones a las que asisten los empleados del departamento
    private int numEmpleados;
    private String organizacion;

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

    public void invitar(Reunion reunion, Empleado empleado) {

        reunion.AgregarInvitado(empleado); // crear en Reunion
    }

    public void OrganizadorReu() {
        organizador = empleado.getFirst();
    }

    public Departamento(int num) {
        numEmpleados = num;
        empleados = new ArrayList<>();
        EmpReuniones = new ArrayList<>();
    }
}
