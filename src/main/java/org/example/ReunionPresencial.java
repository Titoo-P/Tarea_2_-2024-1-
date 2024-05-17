package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;

public class ReunionPresencial extends Reunion{

    private String sala;

    /**
     * Constructor que inicializa una reunión presencial con los parámetros especificados.
     *
     * @param empleado          El organizador de la reunión.
     * @param tipo              El tipo de reunión.
     * @param fecha             La fecha de la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param sala              El nombre de la sala donde se llevará a cabo la reunión.
     */
    public ReunionPresencial(Empleado empleado, tipoReunion tipo, Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(empleado, tipo, fecha, horaPrevista, duracionPrevista, sala);
        this.sala = sala;
    }

    /**
     * Devuelve el nombre de la sala donde se llevará a cabo la reunión presencial.
     *
     * @return El nombre de la sala.
     */
    public String getSala(){
        return sala;
    }

    /**
     * Devuelve una representación en formato de cadena de la reunión presencial,
     * incluyendo el tipo de reunión y la sala donde se llevará a cabo.
     *
     * @return Una cadena que representa la reunión presencial.
     */
    @Override

    public String toString(){
        return  super.toString() + " de tipo Presencial";
    }
}
