/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author CltControl
 */
public class SalaCineTest {
    
    public SalaCineTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarAsiento method, of class SalaCine.
     */
    @Test
    public void testAgregarAsiento() {
        System.out.println("agregarAsiento");
        Asiento asiento = null;
        SalaCine instance = null;
        instance.agregarAsiento(asiento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAsiento method, of class SalaCine.
     */
    @Test
    public void testBuscarAsiento() {
        System.out.println("buscarAsiento");
        String codigo = "";
        SalaCine instance = null;
        Asiento expResult = null;
        Asiento result = instance.buscarAsiento(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contarDisponibles method, of class SalaCine.
     */
    @Test
    public void testContarDisponibles() {
        System.out.println("contarDisponibles");
        SalaCine instance = null;
        int expResult = 0;
        int result = instance.contarDisponibles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularIngresoTotal method, of class SalaCine.
     */
    @Test
    public void testCalcularIngresoTotal() {
        System.out.println("calcularIngresoTotal");
        SalaCine instance = null;
        double expResult = 0.0;
        double result = instance.calcularIngresoTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class SalaCine.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        SalaCine instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacidadMaxima method, of class SalaCine.
     */
    @Test
    public void testGetCapacidadMaxima() {
        System.out.println("getCapacidadMaxima");
        SalaCine instance = null;
        int expResult = 0;
        int result = instance.getCapacidadMaxima();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
