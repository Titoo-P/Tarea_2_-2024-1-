import org.example.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestTipoReunion {

    @Test
    public void TestTipoReuEnum() {
        assertEquals(tipoReunion.MARKETING.tipo, "Marketing");
        assertEquals(tipoReunion.TECNICA.tipo, "Tecnica");
        assertEquals(tipoReunion.OTRO.tipo, "Otro");
    }
}
