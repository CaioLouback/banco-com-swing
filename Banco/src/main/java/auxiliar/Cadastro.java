package auxiliar;

import usuario.Caixa;
import usuario.Cliente;
import usuario.Gerente;


public class Cadastro {
    private static ArquivoJson j = new ArquivoJson();
    
    public void cadastrarCliente(String nome, String cpf, String senha){
        Cliente cliente = new Cliente(nome, cpf, senha, 100.0);
        j.salvarUsuario(cliente);
    }
    
    public void cadastrarCaixa(String nome, String cpf, String senha){
        Caixa caixa = new Caixa(nome, cpf, senha);
        j.salvarUsuario(caixa);
    }
    
    public void cadastrarGerente(String nome, String cpf, String senha){
        Gerente gerente = new Gerente(nome, cpf, senha);
       j.salvarUsuario(gerente);
    }
     
}
