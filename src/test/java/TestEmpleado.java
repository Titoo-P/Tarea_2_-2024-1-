import org.example.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;
import java.util.Date;

class TestEmpleado {
    Empleado empleado;

    @BeforeEach
    void setUp(){
        empleado = new Empleado("1", "Prat","Arturo", "Aprat@example.com");
    }

    @Test
    void TestGetId(){
        assertEquals("1", empleado.getId());
    }

    @Test
    void TestGetNombre(){
        assertEquals("Arturo", empleado.getNombre());
    }

    @Test
    void TestGetApellido(){
        assertEquals("Prat", empleado.getApellidos());
    }

    @Test
    void TestGetCorreo(){
        assertEquals("Aprat@example.com", empleado.getCorreo());
    }
}
