import org.example.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAsistencia{

    @Test
    void testGetEmpleado(){
        Empleado empleado = new Empleado("1", "Guzman", "Pedro", "PeGuz@example.com");
        Asistencia asistencia = new Asistencia(empleado);

        assertEquals(empleado, asistencia.getEmpleado());
    }
}
