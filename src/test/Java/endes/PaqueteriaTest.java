package endes;

import java.daw.Paqueteria;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaqueteriaTest {
    @Test
    public void testCalcularTarizaZonaA() {
        boolean resultado = false;
        if (Paqueteria.calcularTarifaEnvio(3, "A") == 10) {
            resultado = true;
        }
        assertTrue(resultado, "La tarifa para zona A y peso 3 debería ser 10.");
    }

    @Test
    public void testCalcularTarifaZonaBConSuplemento() {
        boolean resultado = false;
        if (Paqueteria.calcularTarifaEnvio(6, "B") == 20) {
            resultado = true;
        }
        assertTrue(resultado, "La tarifa para zona B y peso 6 debería ser 20.");
    }

    @Test
    public void testCalcularTarifaPesoInvalido() {
        boolean resultado = false;
        if (Paqueteria.calcularTarifaEnvio(-5, "A") == -1) {
            resultado = true;
        }
        assertTrue(resultado, "El peso no debe ser negativo.");
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
        boolean resultado = false;
        if (Paqueteria.repartirCarga(10, 2) == 5) {
            resultado = true;

        }
        assertTrue(resultado, "Cada camión debería llevar 5 paquetes.");
    }

    @Test
    public void testRepartirCargaConResto() {
        boolean resultado = false;
        if (Paqueteria.repartirCarga(10, 3) == 3) {
            resultado = true;
        }
        assertTrue(resultado, "Cada camión debería llevar 3 paquetes.");
    }

    @Test
    public void testRepartirCargaErrorCero() {
        boolean resultado = false;
        if (Paqueteria.repartirCarga(50, 0) == 0) {
            resultado = true;
        }
        assertTrue(resultado, "El resultado debería ser 0 cuando el número de camiones es cero.");
    }

}