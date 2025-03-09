package com.mycompany.banco.view;

import static auxiliar.ArquivoJson.buscarUsuarioPorCPF;

import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import usuario.Usuario;

// Aluno Caio Louback  matrícula 202335032
public class Transferencia extends javax.swing.JFrame{
    private String cpfLogado;
    
    public Transferencia() {
        initComponents();
        setIcon();
        campoMonetario();
    }
    
     public Transferencia(String cpfLogado) {
        initComponents();
        setIcon();
        this.cpfLogado = cpfLogado;
        campoMonetario();
        
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
       txtValor.setValue(0.00); // Começa com zero reais e centavos
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
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/transferir.png")));
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
        lblLogoBanco = new javax.swing.JLabel();
        lblTransferencia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PainelTransferencia = new javax.swing.JPanel();
        lblValor = new javax.swing.JLabel();
        lblDestinatario = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JFormattedTextField();
        txtDestino = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JFormattedTextField();
        btnTransferir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transferência Bancária");
        setResizable(false);

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLogoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobanco.png"))); // NOI18N
        lblLogoBanco.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        lblTransferencia.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblTransferencia.setText("TRANSFERÊNCIA BANCÁRIA");

        PainelTransferencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblValor.setText("Valor:");

        lblDestinatario.setText("Destinatário (CPF):");

        lblCliente.setText("Cliente (CPF):");

        try {
            txtCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDestino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        txtValor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelTransferenciaLayout = new javax.swing.GroupLayout(PainelTransferencia);
        PainelTransferencia.setLayout(PainelTransferenciaLayout);
        PainelTransferenciaLayout.setHorizontalGroup(
            PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTransferenciaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelTransferenciaLayout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(40, 58, Short.MAX_VALUE))
                    .addGroup(PainelTransferenciaLayout.createSequentialGroup()
                        .addGroup(PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PainelTransferenciaLayout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(txtDestino)
                    .addComponent(txtValor))
                .addGap(29, 29, 29))
        );
        PainelTransferenciaLayout.setVerticalGroup(
            PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelTransferenciaLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelTransferenciaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCliente))
                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestinatario)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btnTransferir.setText("Realizar Transferência");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PainelTransferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogoBanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(PainelLayout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTransferir))
                                .addGroup(PainelLayout.createSequentialGroup()
                                    .addGap(325, 325, 325)
                                    .addComponent(jLabel3)))))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblTransferencia)))
                .addGap(45, 45, 45))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Usuario userLogado = buscarUsuarioPorCPF(cpfLogado);
        
        if(userLogado.getTipo().equals("Caixa")){
            MenuCaixa caixa = new MenuCaixa(cpfLogado);
            caixa.setLocationRelativeTo(null); 
            caixa.setVisible(true);
        } else if (userLogado.getTipo().equals("Cliente")){
            MenuCliente cliente = new MenuCliente(cpfLogado);
            cliente.setLocationRelativeTo(null); 
            cliente.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        Usuario userDestino = buscarUsuarioPorCPF(txtDestino.getText());
        Usuario userLogado = buscarUsuarioPorCPF(cpfLogado);
        
        if(userLogado.getTipo().equals("Caixa")){
            double valor = formatarValor(txtValor.getText());
            Usuario cliente = buscarUsuarioPorCPF(txtCliente.getText());
            
            if (txtCliente.getText() == null || userDestino == null) {
                JOptionPane.showMessageDialog(this, "CPF inválido! Favor inserir um CPF que tenha conta no banco.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            }else if (valor == 0) {
                JOptionPane.showMessageDialog(this, "Insira um valor que não seja 0.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (valor > cliente.getSaldo()) {
                JOptionPane.showMessageDialog(this, "SALDO INSUFICIENTE!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (valor < 0){
                JOptionPane.showMessageDialog(this, "VALOR NEGATIVO NÃO SÃO ACEITOS!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }else {
                ConfirmacaoLogin conf = new ConfirmacaoLogin(cliente, userDestino, valor, true);
                conf.setVisible(true);
                conf.setLocationRelativeTo(null);
            }
        }else if (userLogado.getTipo().equals("Cliente")) {
            double valor = formatarValor(txtValor.getText());
            if (!(txtCliente.getText().equals(cpfLogado))) {
                JOptionPane.showMessageDialog(this, "CPF inválido! Favor inserir o mesmo CPF do seu login.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (userDestino == null) {
                JOptionPane.showMessageDialog(this, "CPF inválido! Favor inserir um CPF que tenha conta no banco.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (valor == 0) {
                JOptionPane.showMessageDialog(this, "Insira um valor que não seja 0.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (valor > userLogado.getSaldo()) {
                JOptionPane.showMessageDialog(this, "SALDO INSUFICIENTE!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else if (valor < 0) {
                JOptionPane.showMessageDialog(this, "VALOR NEGATIVO NÃO SÃO ACEITOS!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }else{
                ConfirmacaoLogin conf = new ConfirmacaoLogin(userLogado, userDestino, valor, true);
                conf.setVisible(true);
                conf.setLocationRelativeTo(null);
            }
        }  
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        
   
    }//GEN-LAST:event_txtValorActionPerformed

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
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Transferencia trans = new Transferencia();
                trans.setVisible(true);
                trans.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JPanel PainelTransferencia;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblTransferencia;
    private javax.swing.JLabel lblValor;
    private javax.swing.JFormattedTextField txtCliente;
    private javax.swing.JFormattedTextField txtDestino;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    
}
