package com.mycompany.banco;

import com.mycompany.banco.view.Login;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Banco {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            Login login = new Login();  // Substitua "Login" pelo nome correto do seu JFrame
            login.setLocationRelativeTo(null);
            login.setVisible(true);  // Torna o JFrame visível
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
