package com.mycompany.banco.view;


import static auxiliar.ArquivoJson.buscarUsuarioPorCPF;
import java.awt.Toolkit;
import usuario.Usuario;


public class MenuCliente extends javax.swing.JFrame {
    private String cpfLogado;
   
    
    public MenuCliente() {
        initComponents();
        setIcon();
        frontInicial();
        saldoBox.setSelected(true);
    }
    
    public MenuCliente(String cpfLogado){
        initComponents();
        this.cpfLogado = cpfLogado;
        frontInicial();
        saldoBox.setSelected(true);
    }
    
    private void frontInicial(){
        setIcon();
        jInvestimentos.setMnemonic('I');
        jRendaFixa.setMnemonic('F');
        jRendaVariavel.setMnemonic('V');
        jMenuSolicitacao.setMnemonic('S');
        jCredito.setMnemonic('c');
        jExtrato.setMnemonic('E');
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        lblLogoBanco = new javax.swing.JLabel();
        lblTituloSaldo = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        saldoBox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jInvestimentos = new javax.swing.JMenu();
        jRendaFixa = new javax.swing.JMenuItem();
        jRendaVariavel = new javax.swing.JMenuItem();
        jMenuSolicitacao = new javax.swing.JMenu();
        jCredito = new javax.swing.JMenuItem();
        jExtrato = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Bem-Vindo: ");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoBanco)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeCliente)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblTituloSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloSaldo.setText("Saldo Bancário: ");

        lblSaldo.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
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

        saldoBox.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        saldoBox.setText("Mostrar Saldo");
        saldoBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                saldoBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        saldoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoBoxActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transferir.png"))); // NOI18N
        jButton1.setText("  Transferência");

        jMenuBar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenuBar1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jInvestimentos.setText("Investimentos");
        jInvestimentos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jInvestimentosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jInvestimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInvestimentosActionPerformed(evt);
            }
        });

        jRendaFixa.setText("Renda Fixa");
        jInvestimentos.add(jRendaFixa);

        jRendaVariavel.setText("Renda Variável");
        jInvestimentos.add(jRendaVariavel);

        jMenuBar1.add(jInvestimentos);

        jMenuSolicitacao.setText("Solicitação");

        jCredito.setText("Solicitação de Crédito");
        jMenuSolicitacao.add(jCredito);

        jExtrato.setText("Extrato");
        jMenuSolicitacao.add(jExtrato);

        jMenuBar1.add(jMenuSolicitacao);

        setJMenuBar(jMenuBar1);

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
                    .addComponent(saldoBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTituloSaldo)
                            .addComponent(lblSaldo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldoBox))
                    .addComponent(jButton1))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSaldoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblSaldoAncestorAdded
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        if(user != null)
            lblSaldo.setText(String.format("R$ %.2f", user.getSaldo()));
    }//GEN-LAST:event_lblSaldoAncestorAdded

    private void lblNomeClienteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblNomeClienteAncestorAdded
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        lblNomeCliente.setText(user.getNome());
    }//GEN-LAST:event_lblNomeClienteAncestorAdded

    private void saldoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoBoxActionPerformed
        Usuario user = buscarUsuarioPorCPF(cpfLogado);
        if (saldoBox.isSelected()) {
            lblSaldo.setText(String.format("R$ %.2f", user.getSaldo())); // Exibe o saldo formatado
        } else {
            lblSaldo.setText("*"); // Esconde o saldo
        }
    }//GEN-LAST:event_saldoBoxActionPerformed

    private void saldoBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_saldoBoxAncestorAdded
        
    }//GEN-LAST:event_saldoBoxAncestorAdded

    private void jInvestimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInvestimentosActionPerformed
        
    }//GEN-LAST:event_jInvestimentosActionPerformed

    private void jInvestimentosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jInvestimentosAncestorAdded
       
    }//GEN-LAST:event_jInvestimentosAncestorAdded

    private void jMenuBar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuBar1AncestorAdded
        
    }//GEN-LAST:event_jMenuBar1AncestorAdded

    /**
     * @param args the command line arguments
     */
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
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jCredito;
    private javax.swing.JMenuItem jExtrato;
    private javax.swing.JMenu jInvestimentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuSolicitacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jRendaFixa;
    private javax.swing.JMenuItem jRendaVariavel;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTituloSaldo;
    private javax.swing.JCheckBox saldoBox;
    // End of variables declaration//GEN-END:variables
}
