import auxiliar.Ajudante;
import auxiliar.Cadastro;


class TelaCadastroTest {
    public boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
    
    public boolean validarCPF(String cpf) {
        Ajudante ajudante = new Ajudante(cpf);
        return ajudante.isCPF();
    }
    
    public boolean validarSenhas(String senha, String confirmarSenha) {
        return senha != null && confirmarSenha != null && senha.equals(confirmarSenha);
    }
    
    public boolean cadastrarUsuario(String nome, String cpf, String senha, String tipoUsuario) {
        if (!validarNome(nome) || !validarCPF(cpf) || senha == null || senha.isEmpty()) {
            return false;
        }
        Cadastro cadastro = new Cadastro();
        switch (tipoUsuario) {
            case "Cliente":
                cadastro.cadastrarCliente(nome, cpf, senha);
                break;
            case "Caixa":
                cadastro.cadastrarCaixa(nome, cpf, senha);
                break;
            case "Gerente":
                cadastro.cadastrarGerente(nome, cpf, senha);
                break;
            default:
                return false;
        }
        return true;
    }
}

