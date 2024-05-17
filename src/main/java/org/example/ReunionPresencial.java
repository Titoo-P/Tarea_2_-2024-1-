package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;

public class ReunionPresencial extends Reunion{

    private String sala;

    public ReunionPresencial(Empleado empleado, tipoReunion tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(empleado, tipo, fecha, horaPrevista, duracionPrevista, sala);
        this.sala = sala;
    }

    public String getSala(){
        return sala;
    }

    @Override
    public String toString(){
        return  super.toString() + "de tipo Presencial";
    }
}
