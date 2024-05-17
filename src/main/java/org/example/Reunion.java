package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reunion {

    private final Date fecha;
    private final Instant horaPrevista;
    private final Duration duracionPrevista;
    private Instant HorarioInicio;
    private Instant HorarioFinal;
    private List<Invitacion> invitaciones;
    private List<Nota> notas = null;
    private final Empleado organizador;
    private final tipoReunion tipo;
    private List<Asistencia> asistencias;


    //constructor con los atributos de la clase

    public Reunion(Empleado organizador, tipoReunion tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
        this.invitaciones = new ArrayList<Invitacion>(); //lista para guardar invitaciones
        this.notas = new ArrayList<Nota>(); //lista para guardar las notas
    }

    public void AgregarInvitado(Invitacion invitacion){
        invitaciones.add(invitacion);
    }

    public void iniciar(List<Asistencia> asistencia){
        this.HorarioInicio = Instant.now();
        this.asistencias = asistencia;
    }

    public void terminar(){
        this.HorarioFinal = Instant.now();
    }

    public void AgregarAtrasados(Empleado empleado){
        Asistencia retraso = new Retraso(empleado, Instant.now());
        asistencias.add(retraso);
    }

    public List<Asistencia> obtenerAsist(){
        return asistencias;
    }

    public List<Empleado> obtenerAusencias(){
        List<Empleado> ausente = new ArrayList<Empleado>();
        List<Empleado> invitadosAUX = new ArrayList<Empleado>();

        for (Invitacion invitacion : invitaciones){
            if (invitacion.getInvitado() instanceof Departamento){    //crear get invitado en clase invitacion
                invitadosAUX.addAll(((Departamento) invitacion.getInvitado()).getEmpleados());
            }
            else{
                invitadosAUX.add((Empleado) invitacion.getInvitado());
            }
        }

        List<Empleado> AsistenciasAUX = new ArrayList<Empleado>(); //lista de asistentes

        for(Asistencia x : asistencias){
            AsistenciasAUX.add(x.getEmpleado());
        }
        for(Empleado empleado : invitadosAUX){
           if (!AsistenciasAUX.contains((Empleado) empleado)){
               ausente.add(empleado);
           }
        }
        return ausente;
    }

    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos = new ArrayList<Asistencia>();
        for(Asistencia asistencia : asistencias){
            if(asistencia instanceof Retraso){
                retrasos.add(asistencia);
            }
        }
        return retrasos;
    }

    public int AsistenciaTotal(){
        return obtenerAsist().size();
    }

    public float tiempoReal(){
        return Duration.between(this.HorarioInicio, this.HorarioFinal).toSeconds();
    }

    public float AsistenciaPorcentaje(){
        return ((float) AsistenciaTotal() / (AsistenciaTotal() + obtenerAusencias().size())) * 100;
    }

    public void AgregarNota(Nota nota){
        notas.add(nota);
    }

    @Override
    public String toString(){
        return "'Reunion' una reunion de la empresa";
    }

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public Instant getHorarioInicio(){
        return HorarioInicio;
    }

    public Instant getHorarioFinal() {
        return HorarioFinal;
    }

    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }

    public List<Nota> getNotas(){
        return notas;
    }

    public Empleado getOrganizador(){
        return organizador;
    }

    public tipoReunion getTipo(){
        return tipo;
    }

    public List<Invitacion> getInvitaciones(){
        return invitaciones;
    }
}
