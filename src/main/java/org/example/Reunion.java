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
    private String direccion;
    private Instant HorarioInicio;
    private Instant HorarioFinal;
    private List<Invitacion> invitaciones;
    private List<Nota> notas = null;
    private final Empleado organizador;
    private final tipoReunion tipo;
    private List<Asistencia> asistencias;
    /**
     * Constructor que inicializa una reunión con los detalles proporcionados.
     *
     * @param organizador      El empleado que organiza la reunión.
     * @param tipo             El tipo de reunión.
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora prevista para la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param direccion        La dirección de la reunión.
     */

    //constructor con los atributos de la clase

    public Reunion(Empleado organizador, tipoReunion tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, String direccion){
        this.organizador = organizador;
        this.direccion = direccion;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;
        this.invitaciones = new ArrayList<Invitacion>(); //lista para guardar invitaciones
        this.notas = new ArrayList<Nota>(); //lista para guardar las notas
    }
    /**
     * Agrega una invitación a la lista de invitaciones para esta reunión.
     *
     * @param invitacion La invitación a agregar.
     */
    public void AgregarInvitado(Invitacion invitacion){
        invitaciones.add(invitacion);
    }
    /**
     * Inicia la reunión y registra la lista de asistencias.
     *
     * @param asistencia La lista de asistencias para la reunión.
     */
    public void iniciar(List<Asistencia> asistencia){
        this.HorarioInicio = Instant.now();
        this.asistencias = asistencia;
    }
    /**
     * Finaliza la reunión y registra la hora de finalización.
     */
    public void terminar(){
        this.HorarioFinal = Instant.now();
    }
    /**
     * Agrega un empleado que llegó tarde a la reunión.
     *
     * @param empleado El empleado que llegó tarde.
     */
    public void AgregarAtrasados(Empleado empleado){
        Asistencia retraso = new Retraso(empleado, Instant.now());
        asistencias.add(retraso);
    }
    /**
     * Obtiene la lista de asistencias para esta reunión.
     *
     * @return La lista de asistencias.
     */
    public List<Asistencia> obtenerAsist(){
        return asistencias;
    }
    /**
     * Obtiene la lista de empleados que estuvieron ausentes en la reunión.
     *
     * @return La lista de empleados ausentes.
     */
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
    /**
     * Obtiene la lista de asistencias con retraso para esta reunión.
     *
     * @return La lista de asistencias con retraso.
     */
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos = new ArrayList<Asistencia>();
        for(Asistencia asistencia : asistencias){
            if(asistencia instanceof Retraso){
                retrasos.add(asistencia);
            }
        }
        return retrasos;
    }
    /**
     * Calcula el total de asistentes en la reunión.
     *
     * @return El número total de asistentes.
     */
    public int AsistenciaTotal(){
        return obtenerAsist().size();
    }
    /**
     * Calcula la duración real de la reunión en segundos.
     *
     * @return La duración real de la reunión en segundos.
     */
    public float tiempoReal(){
        return Duration.between(this.HorarioInicio, this.HorarioFinal).toSeconds();
    }
    /**
     * Calcula el porcentaje de asistencia a la reunión.
     *
     * @return El porcentaje de asistencia.
     */
    public float AsistenciaPorcentaje(){
        return ((float) AsistenciaTotal() / (AsistenciaTotal() + obtenerAusencias().size())) * 100;
    }
    /**
     * Agrega una nota a la reunión.
     *
     * @param nota La nota a agregar.
     */
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

    public String getDireccion() {
        return direccion;
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
