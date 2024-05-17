package org.example;
import org.example.Excepciones.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static int contadorReuniones = 1;

    public static void main(String[] args) {

        Departamento Informatica = new Departamento("Informatica");
        Departamento Marketing = new Departamento("Marketing");
        Departamento Finanzas = new Departamento("Finanzas");

        Empleado Organizador = new Empleado("001", "Pato", "Piñera", "pato.pta@empresa.com");
        Empleado empleado2 = new Empleado("002", "Lucas", "Rus", "lucas.rus @empresa.com");
        Empleado empleado3 = new Empleado("003", "Aldo", "Deep", "aldo.deep@empresa.com");
        Empleado empleado4 = new Empleado("004", "Noah", "Balls", "noah.balls@empresa.com");

        agregarEmpleadosDepartamento(Informatica, empleado2,empleado3,empleado4, Organizador);

        //***************************************************//
        // *****  Ejemplo Crear Reunion presencial ******   //
        ReunionPresencial reunion1 = crearReunionPresencial(Informatica, tipoReunion.TECNICA, Organizador, "Sala 01",empleado2, empleado3, empleado4);
        // Crear lista de asistencias e iniciar la reunión
        List<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(new Asistencia(Organizador, Instant.now()));
        asistencias.add(new Asistencia(empleado2, Instant.now()));
        reunion1.iniciar(asistencias);
        // Simular el tiempo
        Tiempo.esperarSegundos(2);
        // Agregar empleados atrasados
        reunion1.AgregarAtrasados(empleado3);
        // Notas tomadas por la reunion
        Nota nota = new Nota("Pepito debe ser despedido.");
        reunion1.AgregarNota(nota);
        //simula que paso un poco de tiempo para tomar nota
        Tiempo.esperarSegundos(2);
        // Finalizar la reunión
        reunion1.terminar();
        guardarInformeReunion(reunion1);
        //****************************************************//


        //***************************************************//
        // *****  Ejemplo Crear Reunion Virtual ******   //
        ReunionVirtual reunion2 = crearReunionVirtual(Informatica, tipoReunion.TECNICA, Organizador, "https//televisio.cl",empleado2, empleado3, empleado4);
        // Crear lista de asistencias e iniciar la reunión
        asistencias = new ArrayList<>();
        asistencias.add(new Asistencia(Organizador, Instant.now()));
        asistencias.add(new Asistencia(empleado2, Instant.now()));
        reunion2.iniciar(asistencias);
        // Simular el tiempo
        Tiempo.esperarSegundos(2);
        // Agregar empleados atrasados
        reunion1.AgregarAtrasados(empleado3);
        // Notas tomadas por la reunion
        nota = new Nota("Pepito debe ser despedido.");
        reunion2.AgregarNota(nota);
        //simula que paso un poco de tiempo para tomar nota
        Tiempo.esperarSegundos(2);
        // Finalizar la reunión
        reunion2.terminar();
        guardarInformeReunion(reunion2);
        //****************************************************//

    }




    private static ReunionPresencial crearReunionPresencial(Departamento departamento,tipoReunion tipodeReunion, Empleado organizador,String sala, Empleado... invitados) {
        Date fechaReunion = new Date();
        Instant horaPrevista = Instant.now().plus(Duration.ofHours(2));
        Duration duracionPrevista = Duration.ofHours(1);
        ReunionPresencial reunion = new ReunionPresencial(organizador, tipodeReunion, fechaReunion, horaPrevista, duracionPrevista, sala);

        // Agregar invitados a la reunión
        for (Empleado invitado : invitados) {
            if (invitado != null) {
                reunion.AgregarInvitado(new Invitacion(reunion, invitado));
            }
        }

        return reunion;
    }
    private static ReunionVirtual crearReunionVirtual(Departamento departamento,tipoReunion tipodeReunion, Empleado organizador,String enlace, Empleado... invitados) {
        Date fechaReunion = new Date();
        Instant horaPrevista = Instant.now().plus(Duration.ofHours(2));
        Duration duracionPrevista = Duration.ofHours(1);
        ReunionVirtual reunion = new ReunionVirtual(organizador, tipodeReunion, fechaReunion, horaPrevista, duracionPrevista, enlace);

        // Agregar invitados a la reunión
        for (Empleado invitado : invitados) {
            if (invitado != null) {
                reunion.AgregarInvitado(new Invitacion(reunion, invitado));
            }
        }

        return reunion;
    }


    private static void agregarEmpleadosDepartamento(Departamento departamento, Empleado... empleados) {
        try {
            for (Empleado empleado : empleados) {
                if (empleado != null) {
                    departamento.AgregarEmpleado(empleado);
                }
            }
        } catch (EmpleadoYaExisteException | EmpleadoNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void guardarInformeReunion(Reunion reunion) {
        String nombreArchivo = "informe_reunion" + contadorReuniones + ".txt";
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Organizador de la reunión: " + reunion.getOrganizador().getNombre() + "\n");
            writer.write("Hora de inicio: " + reunion.getHorarioInicio() + "\n");
            writer.write("Hora de finalización: " + reunion.getHorarioFinal() + "\n");
            writer.write("Direccion de Reunion: " + reunion.getDireccion() + "\n");
            writer.write("Duración real: " + reunion.tiempoReal() + " segundos\n");
            writer.write("Asistencias totales: " + reunion.AsistenciaTotal() + "\n");
            writer.write("Porcentaje de asistencia: " + reunion.AsistenciaPorcentaje() + "%\n");
            writer.write("Notas de la reunión: \n");
            for (Nota n : reunion.getNotas()) {
                writer.write("- " + n.getContenido() + "\n");
            }
            writer.write("Empleados ausentes: \n");
            for (Empleado e : reunion.obtenerAusencias()) {
                writer.write("- " + e.getNombre() + "\n");
            }
            writer.write("Empleados atrasados: \n");
            for (Asistencia a : reunion.obtenerRetrasos()) {
                writer.write("- " + a.getEmpleado().getNombre() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        contadorReuniones++;
    }

    public class Tiempo {
        public static void esperarSegundos(int segundos) {
            Instant start = Instant.now();
            while (Duration.between(start, Instant.now()).getSeconds() < segundos) {
                // Busy-wait loop to simulate a delay
            }
        }
    }
}