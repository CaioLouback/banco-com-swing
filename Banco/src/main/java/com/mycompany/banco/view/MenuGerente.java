package com.mycompany.banco.view;

import auxiliar.ArquivoJson;
import static auxiliar.ArquivoJson.buscarUsuarioPorCPF;
import static auxiliar.ArquivoJson.removerSolicitacaoCredito;
import static auxiliar.Verifica.emprestimo;

import java.awt.Toolkit;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import usuario.Usuario;


public class MenuGerente extends javax.swing.JFrame {
    private String cpfGerente;
    
    public MenuGerente(String cpfGerente) {
        initComponents();
        setIcon();
        this.cpfGerente = cpfGerente;
      
    }
    
    public MenuGerente(){
        initComponents();
  
    }
    
    private void atualizarTabela() {
    // Obtém as solicitações de crédito e atualiza a tabela
    List<Map<String, Object>> solicitacoesCredito = ArquivoJson.lerSolicitacaoCredito();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Nome");
    model.addColumn("CPF");
    model.addColumn("Valor");

    // Preenche a tabela com os dados atualizados
    for (Map<String, Object> solicitacao : solicitacoesCredito) {
        String nome = (String) solicitacao.get("nome");
        String cpf = (String) solicitacao.get("cpf");
        double valor = (double) solicitacao.get("valor");
        model.addRow(new Object[]{nome, cpf, valor});
    }

    tbTabela.setModel(model);
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGerente = new javax.swing.JLabel();
        lblNomeGerente = new javax.swing.JLabel();
        Painel = new javax.swing.JPanel();
        lblTituloPequeno = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JButton();
        btnAprovar = new javax.swing.JButton();
        btnReprovar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblLogoBanco = new javax.swing.JLabel();
        lblClick = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerente");
        setResizable(false);

        lblGerente.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblGerente.setText("Gerente:");

        lblNomeGerente.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNomeGerente.setText("Nome ");
        lblNomeGerente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblNomeGerenteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTituloPequeno.setText("Verifique se há solicitações de crédito: ");

        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verificar.png"))); // NOI18N
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnAprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aprovado.png"))); // NOI18N
        btnAprovar.setText("Aprovar");
        btnAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprovarActionPerformed(evt);
            }
        });

        btnReprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/negado.png"))); // NOI18N
        btnReprovar.setText("Reprovar");
        btnReprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReprovarActionPerformed(evt);
            }
        });

        tbTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Valor"
            }
        ));
        jScrollPane2.setViewportView(tbTabela);

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(btnVerificar)
                        .addGap(128, 128, 128)
                        .addComponent(btnAprovar)
                        .addGap(18, 18, 18)
                        .addComponent(btnReprovar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lblTituloPequeno)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloPequeno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerificar)
                    .addComponent(btnAprovar)
                    .addComponent(btnReprovar))
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblLogoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobanco.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblClick.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        lblClick.setText("Deslogar");
        lblClick.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClickMouseClicked(evt);
            }
        });

        jMenu1.setText("File");
        MenuBar.add(jMenu1);

        jMenu2.setText("Edit");
        MenuBar.add(jMenu2);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeGerente))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClick))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeGerente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblNomeGerenteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblNomeGerenteAncestorAdded
        Usuario user = buscarUsuarioPorCPF(cpfGerente);
        lblNomeGerente.setText(user.getNome());
    }//GEN-LAST:event_lblNomeGerenteAncestorAdded

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
  
        List<Map<String, Object>> solicitacoesCredito = ArquivoJson.lerSolicitacaoCredito();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Valor");
        
        
        for (Map<String, Object> solicitacao : solicitacoesCredito) {
            String nome = (String) solicitacao.get("nome");
            String cpf = (String) solicitacao.get("cpf");
            double valor = (double) solicitacao.get("valor");
            model.addRow(new Object[]{nome, cpf, valor});
        }

        
        tbTabela.setModel(model);
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprovarActionPerformed
        // Obtém o índice da linha selecionada
        int selectedRow = tbTabela.getSelectedRow();

        // Verifica se há uma linha selecionada
        if (selectedRow != -1) {
            // Pega os valores da linha selecionada
          
            String cpf = (String) tbTabela.getValueAt(selectedRow, 1);  // CPF está na coluna 1
            double valor = (double) tbTabela.getValueAt(selectedRow, 2); // Valor está na coluna 2

            // Aqui você pode chamar o método para realizar a transferência
            emprestimo(cpf, valor);
            
            removerSolicitacaoCredito(cpf, valor);
            JOptionPane.showMessageDialog(this, "Solicitacão aceita!", "Aprovado!", JOptionPane.INFORMATION_MESSAGE);
            atualizarTabela();
        } else {
            // Caso não tenha linha selecionada
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAprovarActionPerformed

    private void btnReprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReprovarActionPerformed
        // Obtém o índice da linha selecionada
        int selectedRow = tbTabela.getSelectedRow();

        // Verifica se há uma linha selecionada
        if (selectedRow != -1) { // Pega os valores da linha selecionada
         
            String cpf = (String) tbTabela.getValueAt(selectedRow, 1);  // CPF está na coluna 1
            double valor = (double) tbTabela.getValueAt(selectedRow, 2); // Valor está na coluna 2

            removerSolicitacaoCredito(cpf, valor);
            
        } else {
            // Caso não tenha linha selecionada
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_btnReprovarActionPerformed

    private void lblClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClickMouseClicked
        Usuario user = buscarUsuarioPorCPF(cpfGerente);
            
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
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuGerente user = new MenuGerente();
                user.setVisible(true);
                user.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnAprovar;
    private javax.swing.JButton btnReprovar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClick;
    private javax.swing.JLabel lblGerente;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblNomeGerente;
    private javax.swing.JLabel lblTituloPequeno;
    private javax.swing.JTable tbTabela;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
    }
}
