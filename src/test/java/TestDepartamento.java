import org.example.*;

import org.example.Excepciones.EmpleadoNullException;
import org.example.Excepciones.EmpleadoYaExisteException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TestDepartamento {

    Departamento departamento;
    Empleado empleado1;
    Empleado empleado2;
    Date fecha;
    Duration duracionPrevista;
    Instant horaPrevista;
    String sala;
    Instant hora;

    @BeforeEach
    void setUp() {
    departamento = new Departamento("Microsoft");
    empleado1 = new Empleado("1","Gonzalez","Martin","martin@example.com");
    empleado2 = new Empleado("2", "Cruz", "Roberto", "Roberto@example.com");
    fecha = new Date();
    horaPrevista = Instant.now();
    duracionPrevista = Duration.ofHours(2);
    sala = "1";
    hora = horaPrevista;
    }

    @Test
    void TestAgregarEmpleado() throws EmpleadoYaExisteException, EmpleadoNullException {
        // Prueba agregar un empleado normal
        assertTrue(departamento.AgregarEmpleado(empleado1));

        // Prueba agregar un empleado que ya existe
        assertThrows(EmpleadoYaExisteException.class, () -> {
            departamento.AgregarEmpleado(empleado1);
        });

        // Prueba agregar un empleado null
        assertThrows(EmpleadoNullException.class, () -> {
            departamento.AgregarEmpleado(null);
        });
    }

    @Test
    void testObtenerCantEmpleados() throws EmpleadoYaExisteException, EmpleadoNullException {
        // Verificar que la cantidad de empleados es 0 al inicio
        assertEquals(0, departamento.ObtenerCantEmpleados());

        // Agregar un empleado y verificar que la cantidad de empleados es 1
        departamento.AgregarEmpleado(empleado1);
        assertEquals(1, departamento.ObtenerCantEmpleados());

        // Agregar otro empleado y verificar que la cantidad de empleados es 2
        departamento.AgregarEmpleado(empleado2);
        assertEquals(2, departamento.ObtenerCantEmpleados());
    }

    @Test
    void testInvitar() {
        // Crear una nueva reunión
        Reunion reunion = new Reunion(empleado1, tipoReunion.MARKETING, fecha, horaPrevista, duracionPrevista);

        // Invitar al empleado2 a la reunión
        departamento.invitar(reunion);

        // Verificar que el empleado1 ha sido invitado a la reunión
        assertEquals(departamento, reunion.getInvitaciones().get(0).getInvitado());
    }

    @Test
    void testOrganizadorReu() throws EmpleadoYaExisteException, EmpleadoNullException {
        // Agregar empleados al departamento
        departamento.AgregarEmpleado(empleado1);
        departamento.AgregarEmpleado(empleado2);

        // Prueba obtener el primer empleado
        assertEquals(empleado1, departamento.OrganizadorReu(0));

        // Prueba obtener el segundo empleado
        assertEquals(empleado2, departamento.OrganizadorReu(1));

        // Prueba obtener un empleado con un índice inválido
        assertNull(departamento.OrganizadorReu(10));
    }
}
