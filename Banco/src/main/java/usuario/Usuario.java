package usuario;


public class Usuario {
    protected String nome;
    protected String cpf;
    protected String senha;
    protected String tipo; // "Cliente", "Caixa", "Gerente"
    
    public Usuario(String nome, String cpf, String senha, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSenha() {
        return senha;
    }
    
    
}
