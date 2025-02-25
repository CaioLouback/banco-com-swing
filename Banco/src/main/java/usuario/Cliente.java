package usuario;

public class Cliente extends Usuario{
    
    
    public Cliente(String nome, String cpf, String senha, double saldo) {
        super(nome, cpf, senha, "Cliente");
        this.saldo = saldo;
    }
    
    @Override
    public double getSaldo() {
        return saldo;
    }
    @Override
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    
}
