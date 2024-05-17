package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Departamento Informatica = new Departamento("Informatica");
        Departamento Marketing = new Departamento("Marketing");
        Departamento Finanzas = new Departamento("Finanzas");

        Empleado empleado1 = new Empleado("001", "Pato", "Pta", "pato.pta@empresa.com");
        Empleado empleado2 = new Empleado("002", "Lucas", "Rus", "lucas.rus @empresa.com");
        Empleado empleado3 = new Empleado("003", "Aldo", "Deep", "aldo.deep@empresa.com");
        Empleado empleado4 = new Empleado("004", "Noah", "Balls", "noah.balls@empresa.com");
        Empleado empleado5 = new Empleado("005", "Spawn", "Lol", "spawn.lol@empresa.com");
        Empleado empleado6 = new Empleado("006", "Pepito", "Elsa", "pepito.elsa@empresa.com");
        Empleado empleado7 = new Empleado("007", "Juanito", "Sapato", "juanito.sapato@empresa.com");
        
        Informatica.AgregarEmpleado(empleado1);
        Informatica.AgregarEmpleado(empleado2);
        Informatica.AgregarEmpleado(empleado3);
        System.out.println(Informatica.getEmpleados());
        System.out.println(Informatica.ObtenerCantEmpleados());
        System.out.println("Organizador: "+Informatica.OrganizadorReu(1));


        // Imprimir los detalles del empleado
        //System.out.println(empleado1);

    }
}