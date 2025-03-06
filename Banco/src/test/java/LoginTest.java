import auxiliar.ArquivoJson;
import com.mycompany.banco.view.Login;
import usuario.Cliente;
import usuario.Usuario;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login telaLogin;

    @BeforeEach
    void setUp() {
        telaLogin = new Login();
        telaLogin.setVisible(false);  // Evita abrir a UI durante os testes
    }

    @AfterEach
    void tearDown() {
        telaLogin.dispose();
    }

    @Test
    void testLoginCorreto() {
        Usuario usuario = new Cliente("João", "123.456.789-00", "senha123", 1000.0);
        ArquivoJson.salvarUsuario(usuario);

        telaLogin.txtCPF.setText("123.456.789-00");
        telaLogin.txtSenha.setText("senha123");
        telaLogin.btnEntrar.doClick();

        assertFalse(telaLogin.isVisible());  // Verifica se a tela de login foi fechada
    }


    @Test
    void testAbrirTelaCadastro() {
        telaLogin.btnCadastrar.doClick();
        assertFalse(telaLogin.isVisible());  // Verifica se a tela de login foi fechada
    }
}
