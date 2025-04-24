package auxiliar;

import static dao.ArquivoJson.attSaldo;
import static dao.ArquivoJson.buscarUsuarioPorCPF;
import static dao.ArquivoJson.registrarMovimentacao;
import user.Usuario;


public class MovimentacoesBancarias {
    
    public static void transferenciaBancaria(Usuario origem, Usuario destino, double valor){
        
        double saldoUserLogado = origem.getSaldo();
        saldoUserLogado -= valor;
       
        double saldoUserDestino = destino.getSaldo();
        saldoUserDestino += valor;
        
        //Registro das movimentações no extrato de ambos os clientes
        registrarMovimentacao(origem.getCpf(), "Transferência (-)", valor);
        registrarMovimentacao(destino.getCpf(), "Transferência (+)", valor);
        
        //Atualiza salto de ambos. Tanto quem transferiu quanto quem recebeu
        attSaldo(origem.getCpf(), saldoUserLogado);
        attSaldo(destino.getCpf(), saldoUserDestino);
    }
    
    public static void emprestimo(String cpf, double valor){
        Usuario usuario = buscarUsuarioPorCPF(cpf);
        double saldo = usuario.getSaldo();
        saldo += valor;
        //Atualiza saldo no JSON
        attSaldo(usuario.getCpf(), saldo);
        
        registrarMovimentacao(usuario.getCpf(), "Empréstimo (+)", valor);
    }
    
    public static void deposito(Usuario usuario, double valor){
        double saldo = usuario.getSaldo();
        saldo += valor;
        
        attSaldo(usuario.getCpf(), saldo);
        registrarMovimentacao(usuario.getCpf(), "Depósito (+)", valor);
    }
    
    public static void saque(Usuario usuario, double valor){
        double saldo = usuario.getSaldo();
        saldo -= valor;
        
        attSaldo(usuario.getCpf(), saldo);
        registrarMovimentacao(usuario.getCpf(), "Saque (-)", valor);
    }
}
