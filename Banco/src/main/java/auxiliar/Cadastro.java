package auxiliar;

import usuario.Caixa;
import usuario.Cliente;
import usuario.Gerente;

public class Cadastro {
        
    public void cadastrarCliente(String nome, String cpf, String senha){
        Cliente cliente = new Cliente(nome, cpf, senha, 0.0);
    }
    
    public void cadastrarCaixa(String nome, String cpf, String senha){
        Caixa caixa = new Caixa(nome, cpf, senha);
    }
    
    public void cadastrarGerente(String nome, String cpf, String senha){
        Gerente gerente = new Gerente(nome, cpf, senha);
    }
     
}
