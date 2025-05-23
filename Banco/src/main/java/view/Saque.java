package view;

import static auxiliar.MovimentacoesBancarias.saque;
import dao.ArquivoJson;
import static dao.ArquivoJson.buscarUsuarioPorCPF;
import static dao.ArquivoJson.pedidoSaque;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import user.Usuario;

// Aluno Caio Louback  matrícula 202335032
public class Saque extends javax.swing.JFrame {
    private String cpfCaixa;
    
    public Saque() {
        initComponents();
        setIcon();
        campoMonetario();
    }
    
    public Saque(String cpfCaixa) {
        initComponents();
        setIcon();
        this.cpfCaixa = cpfCaixa;
        campoMonetario();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/saque.png")));
    }
    
    private void campoMonetario() {
       NumberFormat formato = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
       formato.setMaximumFractionDigits(2); // Permite duas casas decimais
       formato.setMinimumFractionDigits(2); // Sempre exibe duas casas decimais

       NumberFormatter formatador = new NumberFormatter(formato);
       formatador.setAllowsInvalid(false);
       formatador.setOverwriteMode(true);
       formatador.setCommitsOnValidEdit(true); // Atualiza automaticamente

       txtValor.setFormatterFactory(new DefaultFormatterFactory(formatador));
       txtValor.setValue(0.00); 
    }
    
    private double formatarValor(String valorTexto) {
        if (valorTexto == null || valorTexto.isEmpty()) {
            return 0.0;
        }
        try {
            String valorLimpo = valorTexto.replace("R$", "").replace(".", "").replace(",", ".").trim();
            return Double.parseDouble(valorLimpo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0.0;
        }
    }
    
    private void reset(){
        txtCPF.setFocusable(false);
        txtSenha.setFocusable(false);
        
        txtCPF.setText("");
        txtSenha.setText("");
  
        txtCPF.setFocusable(true);
        txtSenha.setFocusable(true);
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogoBanco = new javax.swing.JLabel();
        Painel = new javax.swing.JPanel();
        txtCPF = new javax.swing.JFormattedTextField();
        btnSaque = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtValor = new javax.swing.JFormattedTextField();
        lblValor = new javax.swing.JLabel();
        lblTituloSaldo = new javax.swing.JLabel();
        btnConsultarSaldo = new javax.swing.JButton();
        lblSaldo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Saque");
        setResizable(false);

        lblLogoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobancopqline.png"))); // NOI18N

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSaque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/saque.png"))); // NOI18N
        btnSaque.setText("Sacar");
        btnSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaqueActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("SAQUE");

        lblCPF.setText("Cliente (CPF):");

        lblSenha.setText("Senha:");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));

        lblValor.setText("Valor:");

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99))
            .addGroup(PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCPF)
                            .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(lblSenha)
                            .addComponent(txtSenha)
                            .addComponent(lblValor)
                            .addComponent(txtValor)))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnSaque)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSaque)
                .addGap(27, 27, 27))
        );

        lblTituloSaldo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloSaldo.setText("Saldo: ");

        btnConsultarSaldo.setText("Consultar Saldo");
        btnConsultarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarSaldoActionPerformed(evt);
            }
        });

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblSaldo.setText("0");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblLogoBanco))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConsultarSaldo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTituloSaldo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSaldo)))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblLogoBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloSaldo)
                    .addComponent(lblSaldo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnConsultarSaldo))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarSaldoActionPerformed
        String cpfDoCliente = txtCPF.getText();
        Usuario user;
        
        if (cpfDoCliente != null && !cpfDoCliente.isEmpty()) { 
            user = buscarUsuarioPorCPF(cpfDoCliente);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Usuário não tem cadastro no banco ou o campo CPF está em branco.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                lblSaldo.setText(formato.format(user.getSaldo()));
            }
        }

    }//GEN-LAST:event_btnConsultarSaldoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        MenuCaixa caixa = new MenuCaixa(cpfCaixa);
        caixa.setVisible(true);
        caixa.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaqueActionPerformed
        String cpfDoCliente = txtCPF.getText();
        String senhaDigitada = new String(txtSenha.getPassword());
        Usuario user = buscarUsuarioPorCPF(cpfDoCliente);
        
        if(user == null){
            JOptionPane.showMessageDialog(this, "Usuário não tem cadastro no banco ou o campo CPF está em branco.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (txtSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Favor inserir uma senha!");
            return;
        }
        
        if(!(user.getSenha().equals(senhaDigitada))){
            JOptionPane.showMessageDialog(this, "Senha incorreta!", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        
        List<Usuario> usuarios = ArquivoJson.lerUsuarios();
        
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpfDoCliente) && usuario.getSenha().equals(senhaDigitada)) {
                double valor = formatarValor(txtValor.getText());
                if(valor > 0){
                    if(valor >= 1000000 && valor <= usuario.getSaldo()){
                        JOptionPane.showMessageDialog(this, "Valor de saque alto. Favor procurar o seu gerente.", "Atenção!", JOptionPane.WARNING_MESSAGE);
                        pedidoSaque(usuario.getCpf(), valor);
                    }else if(valor < usuario.getSaldo()) {
                        saque(user, valor);
                        JOptionPane.showMessageDialog(this, "Saque realizado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        reset(); 
                    } else {
                        JOptionPane.showMessageDialog(this, "SALDO INSUFICIENTE!", "Saldo", JOptionPane.INFORMATION_MESSAGE);
                    } 
                } else {
                    JOptionPane.showMessageDialog(this, "Favor inserir um valor diferente de 0 e positivo.", "Atenção!", JOptionPane.WARNING_MESSAGE);
                }   
            }  
        }
    }//GEN-LAST:event_btnSaqueActionPerformed

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
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Saque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnConsultarSaldo;
    private javax.swing.JButton btnSaque;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTituloSaldo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    
}
