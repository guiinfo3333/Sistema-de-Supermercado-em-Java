/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELAS;

import COMUNICACAO.Comadministrador;
import VARIAVEIS.Administrador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Aluno
 */
public class CadastroAdmin extends javax.swing.JFrame {
  TelaInicial telainicial;

    public TelaInicial getTelainicial() {
        return telainicial;
    }

    public void setTelainicial(TelaInicial telainicial) {
        this.telainicial = telainicial;
    }
  
    
    /**
     * Creates new form CadastroAdmin
     */
    public CadastroAdmin() {
        initComponents();
         DefaultTableModel modelo = (DefaultTableModel) tableadmin.getModel();
       tableadmin.setRowSorter(new TableRowSorter(modelo));
        try {
            readJTable();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void readJTable() throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel) tableadmin.getModel();
        modelo.setNumRows(0); //para tirar todas para nao dá o problema da duplicação
         Comadministrador prod = new Comadministrador();

        for (Administrador p : prod.getLista ()) {  //ele vai pegar o que tiver dentro do array list e colocar
            //dentro do objeto do produto p

            modelo.addRow(new Object[]{    //criamos um vetor que vai pegar o que já tem
                 p.getId(),
                p.getNome(),
                p.getSexo(),
                p.getCpf(),
                p.getTelefone(),
                p.getEndereço(),
                p.getEmail(),
                p.getLogin(),
                p.getSenha()
            });
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        n = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        l = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        s = new javax.swing.JPasswordField();
        c = new javax.swing.JFormattedTextField();
        e = new javax.swing.JFormattedTextField();
        t = new javax.swing.JFormattedTextField();
        mas = new javax.swing.JRadioButton();
        fem = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableadmin = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        end = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(null);
        jPanel2.add(n);
        n.setBounds(250, 60, 370, 35);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText(" *Nome :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(60, 60, 107, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("*Senha :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(690, 180, 92, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText(" *Cpf :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(60, 180, 66, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("*telefone :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 240, 93, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("*email :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(690, 60, 79, 25);
        jPanel2.add(l);
        l.setBounds(840, 120, 370, 35);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("*Login :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(690, 120, 79, 25);
        jPanel2.add(s);
        s.setBounds(840, 170, 370, 40);

        try {
            c.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(c);
        c.setBounds(250, 170, 370, 35);
        jPanel2.add(e);
        e.setBounds(840, 60, 370, 35);

        try {
            t.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(t);
        t.setBounds(250, 240, 370, 35);

        mas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        mas.setText("Masculino");
        jPanel2.add(mas);
        mas.setBounds(250, 120, 118, 31);

        fem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fem.setText("Feminino");
        jPanel2.add(fem);
        fem.setBounds(400, 120, 110, 31);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("*Sexo :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 120, 66, 25);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/y1.png"))); // NOI18N
        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(440, 290, 189, 57);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/y2.png"))); // NOI18N
        jButton4.setText("Apagar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(670, 290, 189, 57);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/y2.png"))); // NOI18N
        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(690, 620, 160, 57);

        tableadmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "nome", "sexo", "cpf", "telefone", "endereço", "email", "login", "senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableadminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableadmin);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 360, 1261, 250);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/y3.png"))); // NOI18N
        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(470, 620, 157, 57);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("*Endereço :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(690, 240, 438, 25);

        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });
        jPanel2.add(end);
        end.setBounds(840, 230, 370, 35);

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("ADMININISTRADOR");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(550, 0, 250, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/cad.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 0, 1480, 690);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1470, 690);

        jMenu1.setText("Voltar");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1489, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if(n.getText()==null || c.getText().trim().equals("") ||  t.getText()==null || e.getText().trim().equals("") ||  l.getText()==null || s.getText().trim().equals("") || end.getText()==null ||  (mas.isSelected()==false && fem.isSelected()==false) ){
                JOptionPane.showMessageDialog(null,"Preencha os espaços vazios !!");
            }else{
                Comadministrador ver = new Comadministrador();
                if (ver.verificafunc(c.getText(),l.getText())) {
                    JOptionPane.showMessageDialog(null,"Este funcionário já é cadastrado!!");
                }else{

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar este funcionário ?");
                    if (resposta == JOptionPane.YES_OPTION) {
                        Administrador p = new Administrador();
                        p.setNome(n.getText());
                        p.setCpf(c.getText());
                        p.setEmail(e.getText());
                        p.setEndereço(end.getText());
                        p.setLogin(l.getText());
                        p.setSenha(s.getText());
                        p.setTelefone(t.getText());
                        if (mas.isSelected()) {
                            p.setSexo("masculino");
                        }else{
                            p.setSexo("feminino");
                        }

                        try {
                            Comadministrador cp = new Comadministrador();
                            cp.adiciona(p);
                        } catch (SQLException ex) {
                            Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }//fim do else para saber se o produto já está cadastrado
            }
            readJTable();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroProduto1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        n.setText("");
        c.setText("");
        e.setText("");
        end.setText("");
        l.setText("");
        s.setText("");
        t.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (tableadmin.getSelectedRow() != -1) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar este admnistrador ?");
            if (resposta == JOptionPane.YES_OPTION) {   //if para confirmacao

                Administrador p = new Administrador();
                p.setId((int) tableadmin.getValueAt(tableadmin.getSelectedRow(), 0));  //botando para dentro do array o valor do id
              Comadministrador dao;
                try {
                    dao = new Comadministrador();
                    dao.remove(p);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

                n.setText("");
                c.setText("");
                e.setText("");
                end.setText("");
                l.setText("");
                s.setText("");
                t.setText("");
                try {
                    readJTable();  //para ler novamente para atualizar
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }} else {
                JOptionPane.showMessageDialog(null, "Selecione um administrador para ser excluído.");
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableadminMouseClicked
        if (tableadmin.getSelectedRow() != -1) {

            n.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 1).toString());
            c.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 3).toString());
            e.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 6).toString());
            end.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 4).toString());
            l.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 7).toString());
            s.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 8).toString());
            t.setText(tableadmin.getValueAt(tableadmin.getSelectedRow(), 4).toString());

        }
    }//GEN-LAST:event_tableadminMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar este funcionário ?");
        if (resposta == JOptionPane.YES_OPTION) {
            Administrador p = new Administrador();
            Comadministrador dao;
            p.setNome(n.getText());
            p.setCpf(c.getText());
            p.setEmail(e.getText());
            p.setEndereço(end.getText());
            p.setLogin(l.getText());
            p.setSenha(s.getText());
            p.setTelefone(t.getText());
            p.setId((int) tableadmin.getValueAt(tableadmin.getSelectedRow(), 0));  //pegamos o id da linha selecionada
            try {
                dao = new Comadministrador();
                dao.altera(p);
                readJTable();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            n.setText("");
            c.setText("");
            e.setText("");
            end.setText("");
            l.setText("");
            s.setText("");
            t.setText("");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    this.setVisible(false);
    dispose();
    getTelainicial().setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
    this.setVisible(false);
    dispose();
    getTelainicial().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField c;
    private javax.swing.JFormattedTextField e;
    private javax.swing.JFormattedTextField end;
    private javax.swing.JRadioButton fem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField l;
    private javax.swing.JRadioButton mas;
    private javax.swing.JFormattedTextField n;
    private javax.swing.JPasswordField s;
    private javax.swing.JFormattedTextField t;
    private javax.swing.JTable tableadmin;
    // End of variables declaration//GEN-END:variables
}