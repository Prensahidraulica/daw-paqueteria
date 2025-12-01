package endes;
import daw.Paqueteria;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaqueteriaTest {
    @Test 
    public void testCalcularTarizaZonaA() {
        int resultado = Paqueteria.calcularTarifaEnvio(3, "A");
        assertEquals(10, resultado, "La tarifa para zona A y peso 3 debería ser 10.");
    }

    @Test 
    public void testCalcularTarifaZonaBConSuplemento() {
        int resultado = Paqueteria.calcularTarifaEnvio(6, "B");
        assertEquals(20, resultado, "La tarifa para zona B y peso 6 debería ser 20.");
    }

    @Test 
    public void testCalcularTarifaPesoInvalido() {
        int resultado = Paqueteria.calcularTarifaEnvio(-5, "A");
        assertEquals(-1, resultado, "El peso no debe ser negativo.");
    }

    @Test 
    public void testValidarIdentificadorCorrecto() {
        boolean resultado = Paqueteria.validarIdentificador("1234");
        assertTrue(resultado, "El identificador debería ser válido.");
    }

    @Test 
    public void testValidarIdentificadorIncorrectoLongitud() {
        boolean resultado = Paqueteria.validarIdentificador("123");
        assertFalse(resultado, "El identificador debe tener exactamente 4 dígitos.");
    }

    @Test 
    public void testValidarIdentificadorIncorrectoLetra() {
        boolean resultado = Paqueteria.validarIdentificador("12A4");
        assertFalse(resultado, "El identificador debe contener solo dígitos entre 1 y 9.");
    }

    @Test 
    public void testRepartirCargaCorrecta() {
        int resultado = Paqueteria.repartirCarga(10, 2);
        assertEquals(5, resultado, "Cada camión debería llevar 5 paquetes.");
    }

    @Test 
    public void testRepartirCargaConResto() {
        int resultado = Paqueteria.repartirCarga(10, 3);
        assertEquals(3, resultado, "Cada camión debería llevar 3 paquetes.");
    }

    @Test 
    public void testRepartirCargaErrorCero() {
        int resultado = Paqueteria.repartirCarga(50, 0);
        assertEquals(0, resultado, "El resultado debería ser 0 cuando el número de camiones es cero.");
    }

}