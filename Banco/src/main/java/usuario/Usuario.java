package usuario;

import com.google.gson.annotations.Expose;


public class Usuario {
    @Expose
    protected String nome;
    @Expose
    protected String cpf;
    @Expose
    protected String senha;
    @Expose
    protected String tipo; // "Cliente", "Caixa", "Gerente"
    @Expose
    protected double saldo;
    
    public Usuario(String nome, String cpf, String senha, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.tipo = tipo;
        this.saldo = 0;
    }
    
    public Usuario() {
        
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
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
}
