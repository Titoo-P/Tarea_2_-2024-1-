package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;

public class ReunionVirtual extends Reunion{

    private String enlace;

    public ReunionVirtual(Empleado empleado, tipoReunion tipo, Date fecha, Instant horaPrevista,Duration duracionPrevista, String enlace){
        super(empleado, tipo, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    @Override
    public String toString(){
        return super.toString() + "de tipo Virtual";
    }
}
