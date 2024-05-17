import org.example.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;

class TestAsistencia {

    @Test
    void testGetEmpleado() {

        Empleado empleado = new Empleado("1", "Guzman", "Pedro", "PeGuz@example.com");
        Asistencia asistencia = new Asistencia(empleado, Instant.now());

        assertEquals(empleado, asistencia.getEmpleado());
    }
}
