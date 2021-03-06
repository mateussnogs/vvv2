package Tela.Principal;

import Tela.Secundaria.TelaCadastrarPontoDeVenda;
import Tela.Tela;
import Tela.Secundaria.TelaCadastroCliente;
import Tela.Secundaria.TelaCadastroFuncionario;
import Tela.Secundaria.TelaViagens;
import controllers.FuncionarioCtrl;

public class TelaDeMenu extends Tela {
    private static TelaDeMenu TELA = null;
    
    public static TelaDeMenu instancia() {
        if(TELA == null){
            TELA = new TelaDeMenu();
        }
        
        return TELA;
    }
    
    private TelaDeMenu() {
        initComponents();
        
        String cargo;
        
        if(FuncionarioCtrl.getUsuarioLogado().getCargo() == FuncionarioCtrl.FUNCIONARIO){
            cargo = "Funcionário: ";
            
            painelGerente.setVisible(false);
            painelGerente.repaint();
            super.setSize(super.getWidth(), super.getHeight() - painelGerente.getHeight());
            
        }else{
            cargo = "Gerente: ";
            
            painelGerente.setVisible(true);
            painelGerente.repaint();
        }
        
        nomeDeUsuario.setText(cargo + FuncionarioCtrl.getUsuarioLogado().getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrarClienteButton = new javax.swing.JButton();
        irViagensButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nomeDeUsuario = new javax.swing.JLabel();
        painelGerente = new javax.swing.JPanel();
        cadastrarPontoDeVendaButton = new javax.swing.JButton();
        cadastrarFuncionarioButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cadastrarClienteButton.setText("Cadastrar Cliente");
        cadastrarClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteButtonActionPerformed(evt);
            }
        });

        irViagensButton.setText("Ir para Viagens");
        irViagensButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irViagensButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Menu");

        nomeDeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeDeUsuario.setText("Gerente:");
        nomeDeUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelGerente.setBackground(new java.awt.Color(200, 200, 200));

        cadastrarPontoDeVendaButton.setText("Cadastrar Ponto de Venda");
        cadastrarPontoDeVendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPontoDeVendaButtonActionPerformed(evt);
            }
        });

        cadastrarFuncionarioButton.setText("Cadastrar Funcionário");
        cadastrarFuncionarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFuncionarioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelGerenteLayout = new javax.swing.GroupLayout(painelGerente);
        painelGerente.setLayout(painelGerenteLayout);
        painelGerenteLayout.setHorizontalGroup(
            painelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastrarPontoDeVendaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(cadastrarFuncionarioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelGerenteLayout.setVerticalGroup(
            painelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cadastrarPontoDeVendaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarFuncionarioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(painelGerente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cadastrarClienteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(irViagensButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeDeUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nomeDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastrarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(irViagensButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarPontoDeVendaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPontoDeVendaButtonActionPerformed
        this.abrirTelaRelativa(new TelaCadastrarPontoDeVenda());
    }//GEN-LAST:event_cadastrarPontoDeVendaButtonActionPerformed

    private void cadastrarClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteButtonActionPerformed
        this.abrirTelaRelativa(new TelaCadastroCliente());
    }//GEN-LAST:event_cadastrarClienteButtonActionPerformed

    private void irViagensButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irViagensButtonActionPerformed
        this.abrirTelaRelativa(new TelaViagens());
    }//GEN-LAST:event_irViagensButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        FuncionarioCtrl.logout();
        this.abrirTelaRelativa(TelaDeLogin.instancia());
        TELA = null;
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void cadastrarFuncionarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFuncionarioButtonActionPerformed
        this.abrirTelaRelativa(new TelaCadastroFuncionario());
    }//GEN-LAST:event_cadastrarFuncionarioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarClienteButton;
    private javax.swing.JButton cadastrarFuncionarioButton;
    private javax.swing.JButton cadastrarPontoDeVendaButton;
    private javax.swing.JButton irViagensButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nomeDeUsuario;
    private javax.swing.JPanel painelGerente;
    // End of variables declaration//GEN-END:variables
}
