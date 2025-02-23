package usuario;

//import com.google.gson.annotations.Expose;


public class Cliente extends Usuario{
    //@Expose
    //private final double saldo;
    
    public Cliente(String nome, String cpf, String senha, double saldo) {
        super(nome, cpf, senha, "Cliente");
        this.saldo = saldo;
    }
    
    @Override
    public double getSaldo() {
        return saldo;
    }
    
    
}
