package usuario;


public class Gerente extends Usuario{
    
    public Gerente(String nome, String cpf, String senha) {
        super(nome, cpf, senha, "Gerente");
    }
}
