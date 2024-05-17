package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
/**
 * La clase ReunionVirtual representa una reunión que se llevará a cabo de forma virtual utilizando un enlace en línea.
 * Extiende la clase Reunion y agrega información sobre el enlace de la reunión virtual.
 */
public class ReunionVirtual extends Reunion{


    private String enlace;
    /**
     * Constructor que inicializa una reunión virtual con los parámetros especificados.
     *
     * @param empleado          El organizador de la reunión.
     * @param tipo              El tipo de reunión.
     * @param fecha             La fecha de la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param enlace            El enlace en línea para unirse a la reunión virtual.
     */
    public ReunionVirtual(Empleado empleado, tipoReunion tipo, Date fecha, Instant horaPrevista,Duration duracionPrevista, String enlace){
        super(empleado, tipo, fecha, horaPrevista, duracionPrevista,enlace);
        this.enlace = enlace;
    }
    /**
     * Devuelve el enlace en línea para unirse a la reunión virtual.
     *
     * @return El enlace de la reunión virtual.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Devuelve una representación en formato de cadena de la reunión virtual,
     * incluyendo el tipo de reunión y el enlace para unirse.
     *
     * @return Una cadena que representa la reunión virtual.
     */
    @Override
    public String toString(){
        return super.toString() + "de tipo Virtual";
    }
}
