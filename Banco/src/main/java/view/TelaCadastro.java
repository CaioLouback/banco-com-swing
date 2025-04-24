package view;

import auxiliar.Cadastro;
import auxiliar.Formatacao;
import java.awt.Toolkit;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

// Aluno Caio Louback  matrícula 202335032
public class TelaCadastro extends javax.swing.JFrame {
  
    public TelaCadastro() {
        initComponents();
        setIcon();
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[a-zA-Z ]+")) {  
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z ]+")) {  
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        }); 
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cadastroicon.png")));
    }
    
    private void reset(){
        txtCPF.setFocusable(false);
        txtSenha.setFocusable(false);
        txtNome.setFocusable(false);
        txtConfSenha.setFocusable(false);

        txtCPF.setText("");
        txtSenha.setText("");
        txtNome.setText("");
        txtConfSenha.setText("");

        txtCPF.setFocusable(true);
        txtSenha.setFocusable(true);
        txtNome.setFocusable(true);
        txtConfSenha.setFocusable(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Painel = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        Box = new javax.swing.JComboBox<>();
        lblOpcao = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        CheckBoxSenha = new javax.swing.JCheckBox();
        lblConfSenha = new javax.swing.JLabel();
        txtConfSenha = new javax.swing.JPasswordField();
        lblLogoBanco = new javax.swing.JLabel();
        lblCadastro = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);

        Painel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Caixa", "Gerente"}));
        Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionPerformed(evt);
            }
        });

        lblOpcao.setText("Escolha uma opção abaixo:");

        lblNome.setText("Nome:");

        lblCPF.setText("CPF:");

        lblSenha.setText("Senha:");

        txtNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        CheckBoxSenha.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        CheckBoxSenha.setText("Mostrar Senha");
        CheckBoxSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxSenhaActionPerformed(evt);
            }
        });

        lblConfSenha.setText("Confirmar Senha:");

        lblLogoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobanco pq.png"))); // NOI18N
        lblLogoBanco.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCadastro.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblCadastro.setText("CADASTRO");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(lblLogoBanco)
                .addGap(17, 17, 17))
            .addGroup(PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNome)
                                .addComponent(lblCPF)
                                .addComponent(lblSenha)
                                .addComponent(CheckBoxSenha)
                                .addComponent(lblConfSenha)
                                .addComponent(txtConfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addComponent(txtSenha))))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblOpcao))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblCadastro))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lblCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOpcao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxSenha)
                .addGap(18, 18, 18)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnVoltar))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxActionPerformed
       //
    }//GEN-LAST:event_BoxActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
         if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Favor inserir um nome!");
            return;
        }
        if (txtCPF.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Favor inserir um CPF!");
            return;
        }
        if (txtSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Favor inserir uma senha!");
            return;
        }
        if (txtConfSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Favor confirmar a sua senha!");
            return;
        }
        if(Arrays.equals(txtConfSenha.getPassword(), txtSenha.getPassword())){
            // Obtendo os valores
            String nome = txtNome.getText().trim();
            String senha = new String(txtSenha.getPassword());
            String numCpf = txtCPF.getText().trim();

            Formatacao cpf = new Formatacao(numCpf);
            
            if (!cpf.isCPF()) {
                JOptionPane.showMessageDialog(this, "CPF inválido! Favor inserir um CPF válido!");
                return;
            }

            Cadastro c = new Cadastro();
            String tipoUsuario = Box.getSelectedItem().toString();

            if ("Cliente".equals(tipoUsuario)) {
                c.cadastrarCliente(nome, numCpf, senha);
            } else if ("Caixa".equals(tipoUsuario)) {
                c.cadastrarCaixa(nome, numCpf, senha);
            } else if ("Gerente".equals(tipoUsuario)) {
                c.cadastrarGerente(nome, numCpf, senha);
            }

            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            reset();
        } else {
            JOptionPane.showMessageDialog(this, "Sua confirmação de senha está incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);   
        }  
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        
    }//GEN-LAST:event_txtNomeActionPerformed

    private void CheckBoxSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxSenhaActionPerformed
        if(CheckBoxSenha.isSelected()){
            txtSenha.setEchoChar((char)0);
            txtConfSenha.setEchoChar((char)0);
        }else{
            txtSenha.setEchoChar('*');
            txtConfSenha.setEchoChar('*');
        }    
    }//GEN-LAST:event_CheckBoxSenhaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Login login = new Login();
        login.setLocationRelativeTo(null); 
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
   
                TelaCadastro tela = new TelaCadastro();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box;
    private javax.swing.JCheckBox CheckBoxSenha;
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblConfSenha;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOpcao;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    
}
