package com.mycompany.banco.view;

import static auxiliar.Verifica.transferenciaBancaria;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import usuario.Usuario;


public class ConfirmacaoLogin extends javax.swing.JFrame {
    private Usuario logado;
    private boolean transferencia;
    private boolean extrato;
    private boolean deposito;
    private boolean saque;
    private Usuario destino;
    private double valor;
    
    public ConfirmacaoLogin() {
        initComponents();
        setIcon();
        this.logado = null;
        this.destino = null;
        this.valor = 0;
        extrato = false;
        saque = false;
        deposito = false;
        this.transferencia = false;
    }
    public ConfirmacaoLogin(Usuario logado, Usuario destino, double valor, boolean transferencia){
        initComponents();
        setIcon();
        this.logado = logado;
        this.destino = destino;
        this.valor = valor;
        extrato = false;
        saque = false;
        deposito = false;
        this.transferencia = transferencia;
    }
    
    public ConfirmacaoLogin(Usuario logado, boolean extrato){
        initComponents();
        setIcon();
        this.logado = logado;
        destino = null;
        valor = 0;
        this.extrato = extrato;
        transferencia = false;
        saque = false;
        deposito = false;
        
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/confir.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        CheckBox = new javax.swing.JCheckBox();
        btnConfirmar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();
        lblMsg2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação de Dados");
        setResizable(false);

        lblUsuario.setText("Usuário (CPF):");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha:");

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        CheckBox.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        CheckBox.setText("Mostrar Senha");
        CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirmacaoLogin.png"))); // NOI18N

        lblMsg.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 0, 0));
        lblMsg.setText("Nunca compartilhe sua senha com ninguém. ");

        lblMsg2.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        lblMsg2.setForeground(new java.awt.Color(255, 0, 0));
        lblMsg2.setText("Ela é pessoal e de sua total responsabilidade!");

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CheckBox)
                                .addComponent(lblUsuario)
                                .addComponent(txtCPF)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSenha)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnConfirmar)))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMsg2)
                            .addComponent(lblMsg))
                        .addGap(37, 37, 37))))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsg2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(CheckBox)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxActionPerformed
        if(CheckBox.isSelected())
        txtSenha.setEchoChar((char)0);
        else
        txtSenha.setEchoChar('*');
    }//GEN-LAST:event_CheckBoxActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String senha = new String (txtSenha.getPassword());
        
        if(!(txtCPF.getText().equals(logado.getCpf())) || (!(logado.getSenha().equals(senha))))
           JOptionPane.showMessageDialog(this,"Login ou senha estão incorretos!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        else{
            if(transferencia == true){
                transferenciaBancaria(logado, destino, valor);
                JOptionPane.showMessageDialog(this,"Confirmação realizada com sucesso! Sua trasferência foi bem sucedida! ","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else if (extrato == true){
                Extrato extra = new Extrato(logado);
                extra.setVisible(true);
                extra.setLocationRelativeTo(null);    
            } else if (deposito == true){
                
            } else if (saque == true){
                
            }
            this.dispose(); 
        }
                
    }//GEN-LAST:event_btnConfirmarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmacaoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmacaoLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox;
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblMsg2;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
 
}
