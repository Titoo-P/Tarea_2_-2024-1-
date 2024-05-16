package org.example;

import java.time.Instant;

public class Invitacion {
    private final Instant hora;
    private final Invitable invitado;
    private final Reunion reunion;


    public Invitacion(Reunion reunion, Invitable invitado) {
        this.reunion = reunion;
        this.invitado = invitado;
        this.hora = reunion.getHoraPrevista();
    }

    // Getter y Setter
    public Instant getHora() {
        return hora;
    }

    public Invitable getInvitado(){
        return invitado;
    }

    public Reunion getReunion(){
        return reunion;
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                "hora=" + hora +
                '}';
    }
}
