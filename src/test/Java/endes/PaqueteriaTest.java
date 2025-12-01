package endes;

import daw.Paqueteria;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaqueteriaTest {
    @Test
    public void testCalcularTarifaZonaA() {
        assertEquals(10, Paqueteria.calcularTarifaEnvio(3, 'A'));
    }

    @Test
    public void testCalcularTarifaZonaBConSuplemento() {
        assertEquals(20, Paqueteria.calcularTarifaEnvio(6, 'B'));
    }

    @Test
    public void testCalcularTarifaPesoInvalido() {
        assertEquals(-1, Paqueteria.calcularTarifaEnvio(-5, 'A'));
    }

    @Test
    public void testValidarIdentificadorCorrecto() {
        assertTrue(Paqueteria.validarIdentificador("1234"));
    }

    @Test
    public void testValidarIdentificadorIncorrectoLongitud() {
        assertFalse(Paqueteria.validarIdentificador("123"));
    }

    @Test
    public void testValidarIdentificadorIncorrectoLetra() {
        assertFalse(Paqueteria.validarIdentificador("12A4"));
    }

    @Test
    public void testRepartirCargaCorrecta() {
        assertEquals(5, Paqueteria.repartirCarga(10, 2));
    }

    @Test
    public void testRepartirCargaConResto() {
        assertEquals(3, Paqueteria.repartirCarga(10, 3));
    }

    @Test
    public void testRepartirCargaErrorCero() {
        assertEquals(0, Paqueteria.repartirCarga(50, 0));
    }

}