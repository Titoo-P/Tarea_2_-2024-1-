package org.example;
import java.time.Instant;
/**
 * La clase Retraso representa el registro de un empleado que llega tarde a una reunión.
 * Extiende la clase Asistencia y agrega la hora en que el empleado llegó tarde.
 */
public class Retraso extends Asistencia {
    private Instant hora;
    /**
     * Constructor que inicializa un objeto Retraso con el empleado y la hora especificados.
     *
     * @param empleado El empleado que llegó tarde.
     * @param hora     La hora en que el empleado llegó tarde.
     */
    public Retraso(Empleado empleado,Instant hora) {
        super(empleado, hora);
        this.hora = hora;
    }
    /**
     * Devuelve la hora en que el empleado llegó tarde.
     *
     * @return La hora del retraso.
     */
    public Instant getHora() {
        return hora;
    }
    /**
     * Establece la hora en que el empleado llegó tarde.
     *
     * @param hora La nueva hora del retraso.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }
    /**
     * Devuelve una representación en formato de cadena del objeto Retraso,
     * incluyendo la hora del retraso.
     *
     * @return Una cadena que representa el retraso.
     */
    @Override
    public String toString() {
        return "Retraso{" +
                "hora=" + hora +
                '}';
    }
}
