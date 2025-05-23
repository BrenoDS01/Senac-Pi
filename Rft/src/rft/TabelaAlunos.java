/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rft;


import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author flash
 */
public class TabelaAlunos extends javax.swing.JFrame {

    /**
     * Creates new form TabelaAlunos
     */
    public TabelaAlunos() {
        initComponents();
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldBusca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        confirmarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        confirmarBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Avignon Pro", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("TABELA ALUNOS");

        fieldBusca.setBackground(new java.awt.Color(255, 255, 0));

        jLabel2.setFont(new java.awt.Font("Avignon Pro", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("PESQUISAR:");

        confirmarBtn.setBackground(new java.awt.Color(255, 255, 0));
        confirmarBtn.setFont(new java.awt.Font("Avignon Pro", 1, 24)); // NOI18N
        confirmarBtn.setText("CONFIRMAR");
        confirmarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBtnActionPerformed(evt);
            }
        });

        tabela.setModel(montarTabela());
        jScrollPane1.setViewportView(tabela);

        confirmarBtn1.setBackground(new java.awt.Color(255, 255, 0));
        confirmarBtn1.setFont(new java.awt.Font("Avignon Pro", 1, 24)); // NOI18N
        confirmarBtn1.setText("DELETAR");
        confirmarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(282, 282, 282))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmarBtn)
                .addGap(18, 18, 18)
                .addComponent(confirmarBtn1)
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmarBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBtnActionPerformed
         String busca = fieldBusca.getText().trim(); 

        if (busca.isEmpty()) {
            tabela.setModel(montarTabela());
        } else {
            tabela.setModel(montarTabelaBusca(busca));
        }  
    }//GEN-LAST:event_confirmarBtnActionPerformed

    private void confirmarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBtn1ActionPerformed
             int linhaSelecionada = tabela.getSelectedRow();

    if (linhaSelecionada >= 0) {
        String id = tabela.getValueAt(linhaSelecionada, 0).toString(); 

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse registro?");
        if (resposta == JOptionPane.YES_OPTION) {
            if (LoginFuncao.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");
                tabela.setModel(montarTabela()); 
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir registro.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
    }  
    }//GEN-LAST:event_confirmarBtn1ActionPerformed

      private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                       
       
       tabela.setModel(montarTabela());
        jScrollPane1.setViewportView(tabela); 
        
    }   
    
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
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaAlunos().setVisible(true);
            }
        });
    }
    
    private DefaultTableModel montarTabela() {
        LoginFuncao dao = new LoginFuncao();
        String[] colunas = {"Id", "Nome", "Telefone", "CPF", "Endereco", "Peso"};

       
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);
        
        

        List<CadastroAlunos> lista = LoginFuncao.listarTodos();
        

        for (int i = 0; i < lista.size(); i++) {
            CadastroAlunos ca = lista.get(i);

            String[] linha = {
                
                Integer.toString(ca.getId()),
                ca.getNome(),
                Long.toString(ca.getTelefone()),
                Long.toString(ca.getCpf()),
                ca.getEndereco(),
                Integer.toString(ca.getPeso())
                
            };
            tabela.addRow(linha);
        }
        
        return tabela;
    }
    
    private DefaultTableModel montarTabelaBusca(String busca) {
        String[] colunas = {"Id", "Nome", "Telefone", "Cpf", "Endereco", "Peso"};

        //Criamos a tabela
        DefaultTableModel tabela = new DefaultTableModel(colunas, 0);

        List<CadastroAlunos> lista = LoginFuncao.buscarPorNome(busca);

        for (int i = 0; i < lista.size(); i++) {
             CadastroAlunos ca = lista.get(i);

            String[] linha = {
                
                ca.getNome(),
                Long.toString(ca.getTelefone()),
                Long.toString(ca.getCpf()),
                ca.getEndereco(),
                Integer.toString(ca.getPeso())
                
            };
            tabela.addRow(linha);
        }

        if (tabela.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com esse nome!", "Filtro", JOptionPane.INFORMATION_MESSAGE);
        }

        return tabela;
    }
    
    private int getPosicao() {
        int posicao = tabela.getSelectedRow();
        if (posicao <= -1) {
            JOptionPane.showMessageDialog(null, "Selecione um item para excluir.");
        }
        return Integer.parseInt((String) tabela.getValueAt(posicao, 0));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmarBtn;
    private javax.swing.JButton confirmarBtn1;
    private javax.swing.JTextField fieldBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
