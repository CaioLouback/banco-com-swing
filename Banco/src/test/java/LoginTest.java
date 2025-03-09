
import java.util.List;
import usuario.Usuario;

/**
 *
 * @author caiol
 */
public class LoginTest {
    
   public boolean autenticar(String cpf, String senha, List<Usuario> usuarios) {
        if (cpf == null || cpf.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            return false;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
