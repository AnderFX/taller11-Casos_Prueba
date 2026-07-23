/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anai
 */
public class ReservasServiceTest {
    SalaCine sala;
    ReservasService reservasService;

    public ReservasServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        //Creacion de la sala y los asientos que utilizarán todos los tests
        sala = new SalaCine("Sala 1", 10);

        sala.agregarAsiento(new Asiento("A1", "ESTANDAR"));
        sala.agregarAsiento(new Asiento("A2", "ESTANDAR"));
        sala.agregarAsiento(new Asiento("A3", "VIP"));
        sala.agregarAsiento(new Asiento("A4", "VIP"));
        sala.agregarAsiento(new Asiento("A5", "4D"));
        sala.agregarAsiento(new Asiento("A6", "4D"));

        reservasService = new ReservasService(sala);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
    * Test del método reservarAsientos.
    * Caso normal: verifica que se puedan reservar dos asientos disponibles,
    * que el total calculado sea el esperado y que los asientos queden ocupados.
    */
    @Test
    @DisplayName("Caso normal: reservar dos asientos disponibles")
    public void testReservarAsientosCasoNormal() {

        List<String> asientos = List.of("A1", "A2");

        double total = reservasService.reservarAsientos(asientos);

        assertEquals(9.5, total, 0.001);

        assertTrue(sala.buscarAsiento("A1").isOcupado());
        assertTrue(sala.buscarAsiento("A2").isOcupado());

        assertFalse(sala.buscarAsiento("A3").isOcupado());
        //Resultado esperado: Reserva exitosa y descuento del 5%
    }
    
    /**
    * Test del método reservarAsientos.
    * Caso límite: verifica que sea posible reservar exactamente el número
    * máximo permitido de asientos (6) y que el descuento aplicado sea correcto.
    */
    @Test
    @DisplayName("Caso límite: reservar exactamente seis asientos")
    public void testReservarAsientosCasoLimite() {

        List<String> asientos = List.of("A1","A2","A3","A4","A5","A6");

        double total = reservasService.reservarAsientos(asientos);

        assertEquals(43.35, total, 0.001);

        assertEquals(0, sala.contarDisponibles());

        assertTrue(sala.buscarAsiento("A6").isOcupado());
        //Resultado esperado: Reserva exitosa con descuento del 15%
    }

    /**
    * Test del método reservarAsientos.
    * Caso de error: verifica que se lance una excepción al intentar
    * reservar más de seis asientos en una sola compra.
    */
    @Test
    @DisplayName("Caso error: reservar más de seis asientos")
    public void testReservarAsientosCasoError() {

        sala.agregarAsiento(new Asiento("A7", "ESTANDAR"));

        List<String> asientos = List.of("A1","A2","A3","A4","A5","A6","A7");

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> reservasService.reservarAsientos(asientos));
        assertEquals("No se pueden reservar más de 6 asientos por compra", ex.getMessage());
        //Resultado esperado:IllegalArgumentException
    }
}
