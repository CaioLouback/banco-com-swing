package usuario;


public abstract class Usuario {
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
    
    
}
