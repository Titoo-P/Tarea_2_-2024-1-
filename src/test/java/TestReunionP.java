import org.example.*;

import org.example.ReunionPresencial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestReunionP {

    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    Empleado organizador;
    String sala;
    ReunionPresencial reunion;

    @BeforeEach
    void setUp(){
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(2);
        organizador = new Empleado("1", "Pedro", "Pascal", "Pascall@example.com");
        sala = "2";

        reunion = new ReunionPresencial(organizador, tipoReunion.MARKETING, fecha, horaPrevista, duracionPrevista, sala);
    }

    @Test
    void TestAgregarInvitado(){
        organizador.invitar(reunion);
        boolean x = false;
        for (Invitacion invitado : reunion.getInvitaciones()){
            if(invitado.getInvitado().equals(organizador)){
                x = true;
                break;
            }
        }
        Assertions.assertTrue(x); // ver si esta invitado a la reunion

        Empleado empleadoAUX = new Empleado("2", "Juanito","Broos", "Jbroos@example.com");

        x = false;

        for (Invitacion invitado : reunion.getInvitaciones()){
            if(invitado.getInvitado().equals(empleadoAUX)){
                x = true;
                break;
            }
        }
        Assertions.assertTrue(x); //ver si esta invitado a la reunion
    }

    @Test
    void TestGetSala(){
        Assertions.assertEquals(sala, reunion.getSala());
    }

    @Test
    void TestToString(){
        Assertions.assertEquals("'Reunion' una reunion de la empresa de tipo Presencial", reunion.toString());
    }

    //Test clase Reunion

    @Test
    void TestGetOrganizador(){
        assertEquals(organizador, reunion.getOrganizador());
    }

    @Test
    void TestGetTipo(){
        assertEquals(tipoReunion.MARKETING, reunion.getTipo());
    }

    @Test
    void TestGetFecha(){
        assertEquals(fecha, reunion.getFecha());
    }

    @Test
    void TestHorarios(){
        assertEquals(horaPrevista, reunion.getHoraPrevista());
        assertEquals(duracionPrevista, reunion.getDuracionPrevista());
    }

    @Test
    void TestAddNota(){
        Nota nota1 = new Nota("Nota example");
        reunion.AgregarNota(nota1);
        assertEquals(1, reunion.getNotas().size());
    }

    @Test
    void TestGetNota(){
        Nota nota1 = new Nota("Nota example");
        reunion.AgregarNota(nota1);
        assertEquals(nota1, reunion.getNotas().get(0));
    }

    @Test
    void TestTiempoReal(){
        reunion.iniciar(null);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        reunion.terminar();
        assertEquals(1, reunion.tiempoReal());
    }
}