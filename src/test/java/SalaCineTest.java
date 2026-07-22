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
 * @author EAZM
 */
public class SalaCineTest {

    private SalaCine instance;

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
        // Sala NUEVA antes de cada prueba, capacidad 3
        instance = new SalaCine("Sala Principal", 3);
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test agregarAsiento method, clase SalaCine.
     */
    @Test
    public void testAgregarAsiento() {
        System.out.println("agregarAsiento");
        Asiento asiento = new Asiento("A1", "VIP");
        instance.agregarAsiento(asiento);
        assertEquals(1, instance.contarDisponibles());
    }

    @Test
    public void testAgregarAsiento_CapacidadExacta() {
        System.out.println("agregarAsiento - capacidad exacta (limite)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        instance.agregarAsiento(new Asiento("A2", "VIP"));
        instance.agregarAsiento(new Asiento("A3", "VIP"));
        assertEquals(3, instance.contarDisponibles());
    }

    @Test
    public void testAgregarAsiento_CapacidadMaximaExcedida() {
        System.out.println("agregarAsiento - capacidad máxima excedida (error)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        instance.agregarAsiento(new Asiento("A2", "VIP"));
        instance.agregarAsiento(new Asiento("A3", "VIP"));
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> instance.agregarAsiento(new Asiento("A4", "VIP")));
        assertEquals("La sala ha alcanzado su capacidad máxima", ex.getMessage());
    }

    @Test
    public void testAgregarAsiento_CodigoDuplicado() {
        System.out.println("agregarAsiento - código duplicado (error)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> instance.agregarAsiento(new Asiento("A1", "ESTANDAR")));
        assertEquals("Ya existe un asiento con el código A1", ex.getMessage());
    }

    /**
     * Test buscarAsiento method, clase SalaCine.
     */
    @Test
    public void testBuscarAsiento() {
        System.out.println("buscarAsiento");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        String codigo = "A1";
        Asiento resultado = instance.buscarAsiento(codigo);
        assertEquals("A1", resultado.getCodigo());
        assertEquals("VIP", resultado.getTipo());
    }

    @Test
    public void testBuscarAsiento_UltimoAgregado() {
        System.out.println("buscarAsiento - último agregado (limite)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        instance.agregarAsiento(new Asiento("A2", "ESTANDAR"));
        instance.agregarAsiento(new Asiento("A3", "4D"));
        Asiento resultado = instance.buscarAsiento("A3");
        assertEquals("A3", resultado.getCodigo());
    }

    @Test
    public void testBuscarAsiento_NoEncontrado() {
        System.out.println("buscarAsiento - código no encontrado (error)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        String codigo = "Z9";
        NoSuchElementException ex = assertThrows(NoSuchElementException.class,
                () -> instance.buscarAsiento(codigo));
        assertEquals("Asiento no encontrado: Z9", ex.getMessage());
    }

    /**
     * Test contarDisponibles method, clase SalaCine.
     */
    @Test
    public void testContarDisponibles() {
        System.out.println("contarDisponibles");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        instance.agregarAsiento(new Asiento("A2", "VIP"));
        instance.buscarAsiento("A1").ocupar();
        int expResultado = 1;
        int resultado = instance.contarDisponibles();
        assertEquals(expResultado, resultado);
    }

    @Test
    public void testContarDisponibles_SalaVacia() {
        System.out.println("contarDisponibles - sala vacía (limite)");
        int expResultado = 0;
        int resultado = instance.contarDisponibles();
        assertEquals(expResultado, resultado);
    }

    @Test
    public void testContarDisponibles_TodosOcupados() {
        System.out.println("contarDisponibles - todos ocupados (limite)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        instance.agregarAsiento(new Asiento("A2", "VIP"));
        instance.buscarAsiento("A1").ocupar();
        instance.buscarAsiento("A2").ocupar();
        int expResultado = 0;
        int resultado = instance.contarDisponibles();
        assertEquals(expResultado, resultado);
    }

    /**
     * Test calcularIngresoTotal method, clase SalaCine.
     */
    @Test
    public void testCalcularIngresoTotal() {
        System.out.println("calcularIngresoTotal");
        instance.agregarAsiento(new Asiento("A1", "VIP"));      // 8.5
        instance.agregarAsiento(new Asiento("A2", "ESTANDAR")); // no ocupado, no cuenta
        instance.buscarAsiento("A1").ocupar();
        double expResultado = 8.5;
        double resultado = instance.calcularIngresoTotal();
        assertEquals(expResultado, resultado, 0.0001);
    }

    @Test
    public void testCalcularIngresoTotal_SinOcupados() {
        System.out.println("calcularIngresoTotal - sin ocupados (limite)");
        instance.agregarAsiento(new Asiento("A1", "VIP"));
        instance.agregarAsiento(new Asiento("A2", "4D"));
        double expResultado = 0.0;
        double resultado = instance.calcularIngresoTotal();
        assertEquals(expResultado, resultado, 0.0001);
    }

    @Test
    public void testCalcularIngresoTotal_TodosOcupados() {
        System.out.println("calcularIngresoTotal - todos ocupados (limite)");
        instance.agregarAsiento(new Asiento("A1", "ESTANDAR")); // 5.0
        instance.agregarAsiento(new Asiento("A2", "VIP"));      // 8.5
        instance.agregarAsiento(new Asiento("A3", "4D"));       // 12.0
        instance.buscarAsiento("A1").ocupar();
        instance.buscarAsiento("A2").ocupar();
        instance.buscarAsiento("A3").ocupar();
        double expResultado = 25.5;
        double resultado = instance.calcularIngresoTotal();
        assertEquals(expResultado, resultado, 0.0001);
    }

    /**
     * Test getNombre method, class SalaCine.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String expResultado = "Sala Principal";
        String resultado = instance.getNombre();
        assertEquals(expResultado, resultado);
    }

    /**
     * Test getCapacidadMaxima method, class SalaCine.
     */
    @Test
    public void testGetCapacidadMaxima() {
        System.out.println("getCapacidadMaxima");
        int expResultado = 3;
        int resultado = instance.getCapacidadMaxima();
        assertEquals(expResultado, resultado);
    }

}