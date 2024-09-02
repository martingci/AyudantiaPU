import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class GestionTest {

    String [][] entradas;

    @BeforeEach
    void setUp() {
        entradas = new String[][] {
                {"Martin", "20", "VIP", "5", "False"},
                {"Sabrina", "21", "General", "0", "False"},
                {"Emilio", "16", "False", "0", "False"},
                {"David", "30", "General", "0", "True"},
                {"Gustavo", "40", "False", "0", "False"},
                {"Pilar", "12", "General", "0", "False"},
                {"Andres", "30", "General", "0", "True"},
                {"Ema", "36", "False", "0", "False"},
                {"Ignacia", "28", "VIP", "2", "False"},
                {"Antonia", "32", "General", "0", "False"}
        };
    }
    @AfterEach
    void tearDown() {
        entradas = null;
    }

    @Test
    void verificarEdad() {
        assertTrue(Gestion.verificarEdad(entradas,1));
        assertTrue(Gestion.verificarEdad(entradas,2));
        assertFalse(Gestion.verificarEdad(entradas,3));
        assertTrue(Gestion.verificarEdad(entradas,4));
        assertTrue(Gestion.verificarEdad(entradas,5));
        assertFalse(Gestion.verificarEdad(entradas,6));
        assertTrue(Gestion.verificarEdad(entradas,7));
        assertTrue(Gestion.verificarEdad(entradas,8));
        assertTrue(Gestion.verificarEdad(entradas,9));
        assertTrue(Gestion.verificarEdad(entradas,10));
    }

    @Test
    void verificarBoleto() {
        assertEquals("VIP", Gestion.verificarBoleto(entradas,1));
        assertEquals("General", Gestion.verificarBoleto(entradas,2));
        assertEquals("False", Gestion.verificarBoleto(entradas,3));
        assertEquals("General", Gestion.verificarBoleto(entradas,4));
        assertEquals("False", Gestion.verificarBoleto(entradas,5));
        assertEquals("General", Gestion.verificarBoleto(entradas,6));
        assertEquals("General", Gestion.verificarBoleto(entradas,7));
        assertEquals("False", Gestion.verificarBoleto(entradas,8));
        assertEquals("VIP", Gestion.verificarBoleto(entradas,9));
        assertEquals("General", Gestion.verificarBoleto(entradas,10));
    }

    @Test
    void validarInvitados() {
        // el metodo es solamente para entradas VIP.
        assertFalse(Gestion.validarInvitados(entradas,1));
        assertTrue(Gestion.validarInvitados(entradas,9));
    }

    @Test
    void aforoDisponible() { /* Al tener a Martin como ingresado desde el inicio, lo cuenta
    para el aforo. En un caso real se inicializa a todos como false*/
        assertEquals(3, Gestion.aforoDisponible(entradas, "General"));
        assertEquals(10, Gestion.aforoDisponible(entradas, "VIP"));
    }

    @Test
    void ingresarPersona() { // Se cambian solamente los datos que cumplen con los requerimientos.
        assertTrue(Boolean.parseBoolean(Gestion.ingresarPersona(entradas,2)[1][4]));
        assertTrue(Boolean.parseBoolean(Gestion.ingresarPersona(entradas,10)[9][4]));
    }

    @Test
    void permitirEntrada() {
        assertFalse(Gestion.permitirEntrada(entradas,1));
        assertTrue(Gestion.permitirEntrada(entradas,2));
        assertFalse(Gestion.permitirEntrada(entradas,3));
        assertTrue(Gestion.permitirEntrada(entradas,4));
        assertFalse(Gestion.permitirEntrada(entradas,5));
        assertFalse(Gestion.permitirEntrada(entradas,6));
        assertTrue(Gestion.permitirEntrada(entradas,7));
        assertFalse(Gestion.permitirEntrada(entradas,8));
        assertTrue(Gestion.permitirEntrada(entradas,9));
        assertTrue(Gestion.permitirEntrada(entradas,10));
    }

    @Test
    void removerPersona() { // Prueba a cambiar a todas las personas true
        assertFalse(Boolean.parseBoolean(Gestion.removerPersona(entradas,3)[2][4]));
        assertFalse(Boolean.parseBoolean(Gestion.removerPersona(entradas,4)[3][4]));
        assertFalse(Boolean.parseBoolean(Gestion.removerPersona(entradas,5)[4][4]));
        assertFalse(Boolean.parseBoolean(Gestion.removerPersona(entradas,6)[5][4]));
        assertFalse(Boolean.parseBoolean(Gestion.removerPersona(entradas,8)[7][4]));
        assertFalse(Boolean.parseBoolean(Gestion.removerPersona(entradas,10)[9][4]));
    }
}