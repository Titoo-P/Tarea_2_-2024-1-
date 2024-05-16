package org.example;

import java.time.Instant;

public class Invitacion {
    private Instant hora;

    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    // Getter y Setter
    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                "hora=" + hora +
                '}';
    }
}
