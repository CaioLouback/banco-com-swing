import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class TesteCadastro {
    private TelaCadastroTest cadastroTest;

    @BeforeEach
    void setUp() {
        cadastroTest = new TelaCadastroTest();
    }

    @Test
    void testValidarNome_Valido() {
        assertTrue(cadastroTest.validarNome("James Hetfield"));
    }

    @Test
    void testValidarNome_Invalido() {
        assertFalse(cadastroTest.validarNome(" "));
    }

    @Test
    void testValidarCPF_Valido() {
        assertTrue(cadastroTest.validarCPF("123.456.789-09"));
    }

    @Test
    void testValidarCPF_Invalido() {
        assertFalse(cadastroTest.validarCPF("123.456.789-00"));
    }

    @Test
    void testValidarSenha_Valida() {
        assertTrue(cadastroTest.validarSenhas("LoubackBank", "LoubackBank"));
    }

    @Test
    void testValidarSenha_Invalida() {
        assertFalse(cadastroTest.validarSenhas("LoubackBank","Louback"));
    }
    
}

