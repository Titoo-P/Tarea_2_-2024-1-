package org.example;

import java.time.Instant;

/**
 * La clase Invitacion representa una invitación a una reunión para un invitado específico.
 */
public class Invitacion {
    private final Instant hora;
    private final Invitable invitado;
    private final Reunion reunion;

    /**
     * Constructor que inicializa una invitación para una reunión y un invitado específicos.
     *
     * @param reunion  La reunión a la que se invita.
     * @param invitado El objeto que implementa la interfaz Invitable y que representa al invitado.
     */
    public Invitacion(Reunion reunion, Invitable invitado) {
        this.reunion = reunion;
        this.invitado = invitado;
        this.hora = reunion.getHoraPrevista();
    }

    /**
     * Devuelve la hora de la invitación.
     *
     * @return La hora de la invitación.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Devuelve el invitado de la invitación.
     *
     * @return El objeto que implementa la interfaz Invitable y que representa al invitado.
     */
    public Invitable getInvitado() {
        return invitado;
    }

    /**
     * Devuelve la reunión a la que se refiere la invitación.
     *
     * @return La reunión a la que se refiere la invitación.
     */
    public Reunion getReunion() {
        return reunion;
    }

    /**
     * Devuelve una representación en formato de cadena de la invitación,
     * incluyendo la hora de la invitación.
     *
     * @return Una cadena que representa la invitación.
     */
    @Override
    public String toString() {
        return "Invitacion{" +
                "hora=" + hora +
                '}';
    }
}

