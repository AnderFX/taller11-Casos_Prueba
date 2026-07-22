import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {
    Asiento asiento;

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    void setUp(){
        asiento=new Asiento("A1","VIP");
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Constructor crea asiento válido")
    void constructorValido(){
        assertFalse(asiento.isOcupado());
        assertEquals("A1",asiento.getCodigo());
    }

    // TODO: Traducir los demás casos de su tabla a métodos @Test.

    /**
     * Test of calcularPrecioBase method, of class Asiento.
     */
    @Test
    public void testCalcularPrecioBase() {
        System.out.println("calcularPrecioBase");
        Asiento instance = null;
        double expResult = 0.0;
        double result = instance.calcularPrecioBase();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ocupar method, of class Asiento.
     */
    @Test
    public void testOcupar() {
        System.out.println("ocupar");
        Asiento instance = null;
        instance.ocupar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of liberar method, of class Asiento.
     */
    @Test
    public void testLiberar() {
        System.out.println("liberar");
        Asiento instance = null;
        instance.liberar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOcupado method, of class Asiento.
     */
    @Test
    public void testIsOcupado() {
        System.out.println("isOcupado");
        Asiento instance = null;
        boolean expResult = false;
        boolean result = instance.isOcupado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigo method, of class Asiento.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Asiento instance = null;
        String expResult = "";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Asiento.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Asiento instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
