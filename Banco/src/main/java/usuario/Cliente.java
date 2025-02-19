package usuario;


public class Cliente extends Usuario{
    private double saldo;
    
    public Cliente(String nome, String cpf, String senha, double saldo) {
        super(nome, cpf, senha, "Cliente");
        this.saldo = saldo;
    }
}
