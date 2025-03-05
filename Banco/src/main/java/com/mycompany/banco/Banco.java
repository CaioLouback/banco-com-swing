package com.mycompany.banco;

import auxiliar.ArquivoJson;
import com.mycompany.banco.view.MenuCaixa;
import com.mycompany.banco.view.MenuCliente;
import com.mycompany.banco.view.MenuGerente;
import java.util.List;
import usuario.Usuario;



public class Banco {

    public static void main(String[] args) {
        List<Usuario> usuarios = ArquivoJson.lerUsuarios();
        
        String cpfDigitado = "116.136.090-51";
        String senhaDigitada = "admin";
        
        for (Usuario usuario : usuarios) {
            System.out.println("Usuario do JSON: CPF=" + usuario.getCpf() + ", Senha=" + usuario.getSenha() + ", Tipo=" + usuario.getTipo());
        }
        for (Usuario usuario : usuarios) {
            System.out.println("Tentando login: CPF=" + cpfDigitado + ", Senha=" + senhaDigitada);
            System.out.println("Verificando usuário do JSON: CPF=" + usuario.getCpf() + ", Senha=" + usuario.getSenha() + ", Tipo=" + usuario.getTipo());

            if (usuario.getCpf().equals(cpfDigitado) && usuario.getSenha().equals(senhaDigitada)) {
                System.out.println("Usuário encontrado! Tipo: [" + usuario.getTipo() + "]"); // Depuração

                if (usuario.getTipo().trim().equalsIgnoreCase("Cliente")) {
                    System.out.println("Abrindo MenuCliente...");
                    new MenuCliente(cpfDigitado).setVisible(true);
                } else if (usuario.getTipo().trim().equalsIgnoreCase("Gerente")) {
                    System.out.println("Abrindo MenuGerente...");
                    new MenuGerente(cpfDigitado).setVisible(true);
                } else if (usuario.getTipo().trim().equalsIgnoreCase("Caixa")) {
                    System.out.println("Abrindo MenuCaixa...");
                    new MenuCaixa(cpfDigitado).setVisible(true);
                }

                
                break;
            }
        }

    }
}
