import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import usuario.Usuario;

public class TesteLogin {
    private final LoginTest loginService = new LoginTest();

    @Test
    void testLoginComCredenciaisCorretas() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jonas", "12345678900", "metallica", "Cliente"));

        boolean resultado = loginService.autenticar("12345678900", "metallica", usuarios);
        assertTrue(resultado);
    }

    @Test
    void testLoginComSenhaIncorreta() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jonas", "12345678900", "metallica", "Cliente"));

        boolean resultado = loginService.autenticar("12345678900", "ledzeppelin", usuarios);
        assertFalse(resultado);
    }

    @Test
    void testLoginComCpfIncorreto() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jonas","12345678900", "senha123", "Cliente"));

        boolean resultado = loginService.autenticar("00000000000", "mastodon", usuarios);
        assertFalse(resultado);
    }

    @Test
    void testLoginComCamposVazios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jonas","12345678900", "metallica", "Cliente"));

        boolean resultado = loginService.autenticar("", "", usuarios);
        assertFalse(resultado);
    }

    @Test
    void testLoginComListaVazia() {
        List<Usuario> usuarios = new ArrayList<>();

        boolean resultado = loginService.autenticar("12345678900", "senha123", usuarios);
        assertFalse(resultado);
    }
   
}
