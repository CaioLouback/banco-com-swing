package com.mycompany.banco.view;

import static auxiliar.ArquivoJson.buscarUsuarioPorCPF;
import static auxiliar.ArquivoJson.solicitacaoDeCredito;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import usuario.Usuario;

// Aluno Caio Louback  matrícula 202335032
public class Credito extends javax.swing.JFrame {
    String nomeCliente;
    String cpfCliente;
   
    public Credito(String nomeCliente, String cpfCliente) {
        initComponents();
        setIcon();
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        preencherTermos(nomeCliente, cpfCliente);
        btnConfirmar.setEnabled(false);
    }
    
    public Credito (){
        initComponents();
        setIcon();
    }
    
    private void preencherTermos(String nomeCliente, String cpfCliente) {
        int valor = Slider.getValue();  

        String termoAceite = """
        <html>
        <p>Eu, <b>%s</b>, inscrito no CPF<b>%s</b>, declaro que li e estou ciente das condições do empréstimo solicitado junto ao <b>Banco Louback</b>, aceitando integralmente os seguintes termos:</p>
        <h3>1. Valor e Condições do Empréstimo</h3>
        <ul>
            <li>Valor solicitado: <b>R$ %d</b></li>  
            <li>Taxa de juros: <b>3%% ao mês</b></li>  
        </ul>
        <h3>2. Condições Gerais</h3>
        <ul>
            <li>O empréstimo está sujeito à análise de crédito e demais políticas do banco.</li>
            <li>O pagamento das parcelas deverá ser efetuado nas datas acordadas, sob pena de incidência de juros e multa por atraso.</li>
            <li>Em caso de inadimplência, poderão ser tomadas medidas administrativas e judiciais cabíveis para a cobrança da dívida.</li>
            <li>O cliente autoriza o banco a debitar automaticamente as parcelas em conta corrente, caso aplicável.</li>
            <li>O cliente declara que os dados fornecidos são verídicos e atualizados.</li>
        </ul>
        <h3>3. Proteção de Dados</h3>
        <p>O cliente autoriza o tratamento de seus dados para fins de análise e concessão do crédito, conforme a legislação vigente.</p>
        <br/>
        
        </html>
    """;

        String termoFormatado = String.format(termoAceite, nomeCliente, cpfCliente, valor);

        txtPainelTermos.setContentType("text/html"); 
        txtPainelTermos.setText(termoFormatado);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelPrincipal = new javax.swing.JPanel();
        lblSolicitacao = new javax.swing.JLabel();
        Slider = new javax.swing.JSlider();
        lblValor = new javax.swing.JLabel();
        lblRS = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPainelTermos = new javax.swing.JTextPane();
        CheckBoxTermos = new javax.swing.JCheckBox();
        PainelLogo = new javax.swing.JPanel();
        lblLogoBanco = new javax.swing.JLabel();
        lblTituloCredito = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitação de Crédito");
        setResizable(false);

        PainelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSolicitacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSolicitacao.setText("Valor a ser solicidado: ");

        Slider.setMaximum(50000);
        Slider.setValue(0);
        Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderStateChanged(evt);
            }
        });

        lblValor.setText("0");

        lblRS.setText("R$");

        jScrollPane2.setViewportView(txtPainelTermos);

        CheckBoxTermos.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        CheckBoxTermos.setText("Aceito os temos do contrato");
        CheckBoxTermos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxTermosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelPrincipalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValor))
                    .addGroup(PainelPrincipalLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelPrincipalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckBoxTermos)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRS)
                    .addComponent(lblValor))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxTermos)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PainelLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLogoBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logobancopqline.png"))); // NOI18N

        javax.swing.GroupLayout PainelLogoLayout = new javax.swing.GroupLayout(PainelLogo);
        PainelLogo.setLayout(PainelLogoLayout);
        PainelLogoLayout.setHorizontalGroup(
            PainelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelLogoLayout.setVerticalGroup(
            PainelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTituloCredito.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lblTituloCredito.setText("SOLICITAÇÃO DE CRÉDITO");

        btnConfirmar.setText("Solicitar Crédito");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblTituloCredito))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PainelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnConfirmar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblTituloCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnVoltar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderStateChanged
        lblValor.setText(String.valueOf(Slider.getValue())); 
        preencherTermos(nomeCliente, cpfCliente);
    }//GEN-LAST:event_SliderStateChanged

    private void CheckBoxTermosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxTermosActionPerformed
        btnConfirmar.setEnabled(CheckBoxTermos.isSelected()); 
    }//GEN-LAST:event_CheckBoxTermosActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Usuario user = buscarUsuarioPorCPF(cpfCliente);
        double valor = Slider.getValue();
        solicitacaoDeCredito(cpfCliente, valor);
        JOptionPane.showMessageDialog(this,"Sua solicitação foi enviada com sucesso! Basta aguardar a liberação pelo gerente. ","Agora é só aguardar!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        MenuCliente cliente = new MenuCliente(cpfCliente);
        cliente.setLocationRelativeTo(null); 
        cliente.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/dinheiropq.png")));
    }
   
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
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Credito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxTermos;
    private javax.swing.JPanel PainelLogo;
    private javax.swing.JPanel PainelPrincipal;
    private javax.swing.JSlider Slider;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLogoBanco;
    private javax.swing.JLabel lblRS;
    private javax.swing.JLabel lblSolicitacao;
    private javax.swing.JLabel lblTituloCredito;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextPane txtPainelTermos;
    // End of variables declaration//GEN-END:variables

    
}
