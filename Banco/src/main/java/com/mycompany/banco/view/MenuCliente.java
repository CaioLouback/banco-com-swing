package com.mycompany.banco.view;

import static dao.ArquivoJson.buscarUsuarioPorCPF;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import usuario.Usuario;

// Aluno Caio Louback  matrícula 202335032
public class MenuCliente extends javax.swing.JFrame {
    private String cpfLogado;
    
    public MenuCliente() {
        initComponents();
        setIcon();
        frontInicial();
        CheckBoxSaldo.setSelected(true);
        atualizarSaldo();
        
    }
    
    public MenuCliente(String cpfLogado){
        initComponents();
        this.cpfLogado = cpfLogado;
        frontInicial();
        CheckBoxSaldo.setSelected(true);
        atualizarSaldo();
        
    }
    
    private void frontInicial(){
        setIcon();
        MenuInvestimentos.setMnemonic('I');
        MenuFixa.setMnemonic('F');
        MenuVariavel.setMnemonic('V');
        MenuSolicitacao.setMnemonic('S');
        MenuCredito.setMnemonic('c');
        MenuExtrato.setMnemonic('E');
    }
    
    private void atualizarSaldo() {
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        if (user != null) {
            lblSaldo.setText(String.format("R$ %.2f", user.getSaldo()));
        }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        lblBoasVindas = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        lblLogoBanco = new javax.swing.JLabel();
        lblClick = new javax.swing.JLabel();
        lblTituloSaldo = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        CheckBoxSaldo = new javax.swing.JCheckBox();
        btnTransferencia = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        MenuInvestimentos = new javax.swing.JMenu();
        MenuFixa = new javax.swing.JMenuItem();
        MenuVariavel = new javax.swing.JMenuItem();
        MenuSolicitacao = new javax.swing.JMenu();
        MenuCredito = new javax.swing.JMenuItem();
        MenuExtrato = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBoasVindas.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblBoasVindas.setText("Bem-Vindo: ");

        lblNomeCliente.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNomeCliente.setText("Nome do Cliente");
        lblNomeCliente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblNomeClienteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblLogoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobanco.png"))); // NOI18N
        lblLogoBanco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblClick.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        lblClick.setText("Deslogar");
        lblClick.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClickMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoBanco)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblBoasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeCliente)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClick)
                .addContainerGap())
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(lblBoasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClick)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTituloSaldo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lblTituloSaldo.setText("Saldo Bancário: ");

        lblSaldo.setFont(new java.awt.Font("Cambria Math", 0, 16)); // NOI18N
        lblSaldo.setText("0");
        lblSaldo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblSaldoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        CheckBoxSaldo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        CheckBoxSaldo.setText("Mostrar Saldo");
        CheckBoxSaldo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                CheckBoxSaldoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        CheckBoxSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxSaldoActionPerformed(evt);
            }
        });

        btnTransferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transferir.png"))); // NOI18N
        btnTransferencia.setText("  Transferência");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        MenuBar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MenuBarAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        MenuInvestimentos.setText("Investimentos");
        MenuInvestimentos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MenuInvestimentosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        MenuInvestimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInvestimentosActionPerformed(evt);
            }
        });

        MenuFixa.setText("Renda Fixa");
        MenuFixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFixaActionPerformed(evt);
            }
        });
        MenuInvestimentos.add(MenuFixa);

        MenuVariavel.setText("Renda Variável");
        MenuVariavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVariavelActionPerformed(evt);
            }
        });
        MenuInvestimentos.add(MenuVariavel);

        MenuBar.add(MenuInvestimentos);

        MenuSolicitacao.setText("Solicitação");
        MenuSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSolicitacaoActionPerformed(evt);
            }
        });

        MenuCredito.setText("Solicitação de Crédito");
        MenuCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCreditoActionPerformed(evt);
            }
        });
        MenuSolicitacao.add(MenuCredito);

        MenuExtrato.setText("Extrato");
        MenuExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExtratoActionPerformed(evt);
            }
        });
        MenuSolicitacao.add(MenuExtrato);

        MenuBar.add(MenuSolicitacao);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSaldo))
                    .addComponent(CheckBoxSaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTransferencia)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTituloSaldo)
                            .addComponent(lblSaldo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckBoxSaldo))
                    .addComponent(btnTransferencia))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSaldoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblSaldoAncestorAdded
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        lblSaldo.setText(formato.format(user.getSaldo()));
    }//GEN-LAST:event_lblSaldoAncestorAdded

    private void lblNomeClienteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblNomeClienteAncestorAdded
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        lblNomeCliente.setText(user.getNome());
    }//GEN-LAST:event_lblNomeClienteAncestorAdded

    private void CheckBoxSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxSaldoActionPerformed
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        if (CheckBoxSaldo.isSelected()) {
            lblSaldo.setIcon(null);
            NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            lblSaldo.setText(formato.format(user.getSaldo())); 
        } else {
            lblSaldo.setText(""); 
            lblSaldo.setIcon(new ImageIcon(getClass().getResource("/ocultar.png")));
        }
    }//GEN-LAST:event_CheckBoxSaldoActionPerformed

    private void CheckBoxSaldoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CheckBoxSaldoAncestorAdded
        
    }//GEN-LAST:event_CheckBoxSaldoAncestorAdded

    private void MenuInvestimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInvestimentosActionPerformed
        
    }//GEN-LAST:event_MenuInvestimentosActionPerformed

    private void MenuInvestimentosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MenuInvestimentosAncestorAdded
       
    }//GEN-LAST:event_MenuInvestimentosAncestorAdded

    private void MenuBarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MenuBarAncestorAdded
        
    }//GEN-LAST:event_MenuBarAncestorAdded

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        Transferencia trans = new Transferencia(cpfLogado);
        this.dispose();
        trans.setVisible(true);
        trans.setLocationRelativeTo(null);    
        
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        atualizarSaldo();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       atualizarSaldo();
    }//GEN-LAST:event_formWindowGainedFocus

    private void MenuSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSolicitacaoActionPerformed
        
    }//GEN-LAST:event_MenuSolicitacaoActionPerformed

    private void MenuExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExtratoActionPerformed
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        ConfirmacaoLogin conf = new ConfirmacaoLogin(user, true);
        conf.setVisible(true);
        conf.setLocationRelativeTo(null);  
    }//GEN-LAST:event_MenuExtratoActionPerformed

    private void MenuCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCreditoActionPerformed
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        Credito cred = new Credito(user.getNome(),user.getCpf());
        cred.setVisible(true);
        cred.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_MenuCreditoActionPerformed

    private void MenuFixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFixaActionPerformed
        
    }//GEN-LAST:event_MenuFixaActionPerformed

    private void MenuVariavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVariavelActionPerformed
       
    }//GEN-LAST:event_MenuVariavelActionPerformed

    private void lblClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClickMouseClicked
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
            
        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente finalizar a sua sessão com " + user.getNome() + "?",
            "Finalizar Sessão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (resposta == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            
            this.dispose(); 
        } 
    }//GEN-LAST:event_lblClickMouseClicked

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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuCliente menu = new MenuCliente();
                menu.setLocationRelativeTo(null); 
                menu.setVisible(true);
                
                
            }
        });
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxSaldo;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuCredito;
    private javax.swing.JMenuItem MenuExtrato;
    private javax.swing.JMenuItem MenuFixa;
    private javax.swing.JMenu MenuInvestimentos;
    private javax.swing.JMenu MenuSolicitacao;
    private javax.swing.JMenuItem MenuVariavel;
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JLabel lblClick;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTituloSaldo;
    // End of variables declaration//GEN-END:variables
}
