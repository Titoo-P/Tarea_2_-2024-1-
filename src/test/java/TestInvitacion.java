import org.example.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;
import java.util.Date;

class TestInvitacion {

    Empleado empleado;
    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    String sala;
    Reunion reunion;
    Departamento departamento;
    Invitacion invitacion;
    Instant hora;

    @BeforeEach
    void setUp(){

        empleado = new Empleado("1", "Prat", "Arturo", "Aprat@example.com");
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(2);
        sala = "1";
        hora = horaPrevista;

        reunion = new ReunionVirtual(empleado, tipoReunion.MARKETING, fecha, horaPrevista, duracionPrevista,  sala);
        departamento = new Departamento("Microsoft");
        invitacion = new Invitacion(reunion, departamento);
    }

    @Test
    void TestGetHora(){
        assertEquals(reunion.getHoraPrevista(), invitacion.getHora());
    }

    @Test
    void TestGetInvitado(){
        assertEquals(departamento, invitacion.getInvitado());
    }

    @Test
    void TestGetReunion(){
        assertEquals(reunion, invitacion.getReunion());
    }

    @Test
    void TestToString(){
        assertEquals("Invitacion{" + "hora=" + hora + '}', invitacion.toString());
    }
}
