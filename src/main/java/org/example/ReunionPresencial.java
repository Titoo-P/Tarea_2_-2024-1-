package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;

public class ReunionPresencial extends Reunion{

    private String sala;

    public ReunionPresencial(Empleado empleado, tipoReunion tipo, Date fecha, Duration duracionPrevista, String sala, Instant horaPrevista){
        super(empleado, tipo, fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }

    public String getSala(){
        return sala;
    }

    @Override
    public String toString(){
        return  super.toString() + "en la sala";
    }
}
