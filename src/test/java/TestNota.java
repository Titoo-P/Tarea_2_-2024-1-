import org.example.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;
import java.util.Date;

class TestNota {
    String contenido;
    Nota nota;

    @BeforeEach
    void setUp(){
        contenido = "Nota 1 example";
        nota = new Nota(contenido);
    }

    @Test
    void TestGetContenido(){
        assertEquals(contenido, nota.getContenido());
    }

    @Test
    void TestToString(){
        assertEquals("Nota{" + "contenido='" + contenido + '\'' + '}', nota.toString());
    }

}
