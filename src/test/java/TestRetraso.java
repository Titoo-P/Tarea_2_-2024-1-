import org.example.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.*;

class TestRetraso {

    Retraso retraso;
    Empleado empleado;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("1","Bros","Mario","Mariogalaxy@example.com");
        retraso = new Retraso(empleado, Instant.now());
    }

    @Test
    void testGetHora() {
        Instant hora = Instant.now();
        retraso.setHora(hora);
        assertEquals(hora, retraso.getHora());
    }

    @Test
    void testSetHora() {
        Instant hora = Instant.now();
        retraso.setHora(hora);
        assertEquals(hora, retraso.getHora());
    }

    @Test
    void testToString() {
        String expected = "Retraso{hora=" + retraso.getHora() + "}";
        assertEquals(expected, retraso.toString());
    }
}