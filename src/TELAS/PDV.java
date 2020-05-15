/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TELAS;

import COMUNICACAO.Comcaixa;
import COMUNICACAO.Comdescvenda;
import COMUNICACAO.Comestoque;
import COMUNICACAO.Comvenda;
import UTIL.ManipularImagem;
import VARIAVEIS.Caixa;
import VARIAVEIS.Desc_venda;
import VARIAVEIS.Estoque;
import VARIAVEIS.Produto;
import VARIAVEIS.Venda;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Aluno
 */
public class PDV extends javax.swing.JFrame {

    /**
     * Creates new form PDV
     */
    int idfuncionario;
    int idcaixa;

    public int getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(int idcaixa) {
        this.idcaixa = idcaixa;
    }
    String qrtprevia="1";   //quantidade que ja tinha
    Boolean paraum; //para resolver problema para quando voltar pra um
    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }
    
    public PDV(int num) throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable7.getModel();
       jTable7.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);
        cpro.setEditable(false);
        qproduto.setEditable(false);
        toproduto.setEditable(false);
        trproduto.setEditable(false);
        dproduto.setEditable(false);
        vu.setEditable(false);
       tre.setEditable(false);
       f12.setEditable(false);
       iq.setEditable(false);
       fc.setEditable(false);
       cc.setEditable(false);
      cc1.setEditable(false);
      no.setEditable(false);
      toproduto.setText("0.0");
      trproduto.setText("0.0");
      vu.setText("0.0");
      tre.setText("0.0");
      
     Calendar us = Calendar.getInstance();
//        Array[] ijt  meses=new Array[11];
//        int[] a = new int[10];
//      a[0]="janeiro";
     fcaixa1.setText(us.get(Calendar.DAY_OF_MONTH)+" / "+(us.get(Calendar.MONTH)+1)+" / "+us.get(Calendar.YEAR));
      this.setIdfuncionario(num);
        Comcaixa com = new Comcaixa();
          for (Caixa p:com.listadadoscaixa(this.getIdfuncionario())) { 
              ncaixa.setText("Caixa "+String.valueOf(p.getId()));
              this.setIdcaixa(p.getId());  //pegando o id do caixa para depois fazermos outras coisas
              if (p.getSituacao()) {
                  scaixa.setText("Aberto");
                  scaixa.setForeground(Color.green);
              }else{
                  scaixa.setText("Fechado");
                  scaixa.setForeground(Color.red);
                  
              }
              if (p.getSexo().equals("masculino")) {
                  
              data.setText("Funcionário : "+p.getNomefunc());
              }else{
              data.setText("Funcionária : "+p.getNomefunc());      
              }
              
          }
      CardLayout c1 = (CardLayout) PainelMae.getLayout();   //chamando o layout do primeiro
        c1.show(PainelMae,"tela1");
//    JOptionPane.showMessageDialog(null,this.getIdfuncionario());
    }
    public boolean verifica() throws SQLException{
           boolean situ=false;
        //    JOptionPane.showMessageDialog(null, separa[1]);
            Comcaixa comcaixa = new Comcaixa();         //alterando situacao do caixa
            for (Caixa caixa : comcaixa.alteradinheirocaixa(this.getIdcaixa())){
                if (caixa.getSituacao()) {
                  scaixa.setText("Aberto");
                  scaixa.setForeground(Color.green);
                  situ=true;
                }else{
                  scaixa.setText("Fechado");
                  scaixa.setForeground(Color.red);
                    
                }
            }
            return situ;
    }
    public void somando(Double dinheiro,int qtda,String qrtprevia,Boolean paraum){  
        if (qtda>1) {
        Double soma;
        soma=(Double.parseDouble(toproduto.getText())-(Integer.parseInt(qrtprevia)*dinheiro)+((dinheiro*qtda)));
        toproduto.setText(String.valueOf(soma)); 
            
        }else{
            if (paraum) {   //verificando se é a primeira vez
                  Double soma1=(Double.parseDouble(toproduto.getText())+(1*dinheiro));
              toproduto.setText(String.valueOf(soma1));
            }else{
             
        Double soma;
//        soma=(Double.parseDouble(toproduto.getText())-(Integer.parseInt(qrtprevia)*dinheiro)+((dinheiro*qtda))); verdadeira
         soma=(Double.parseDouble(toproduto.getText())-(Integer.parseInt(qrtprevia)*dinheiro)+((dinheiro*qtda)));
        toproduto.setText(String.valueOf(soma));
//        System.out.println(soma);
//        System.out.println(toproduto.getText());
//        System.out.println(dinheiro);
//        System.out.println(qtda);
            }
        }
    }
    public void alteraquantidadetable(String alt){
        int num = jTable7.getRowCount()-1;
        jTable7.setValueAt(alt, num,2); 
//        falta testar
     
    }
     public void readJTable(String codigo,String nome,String quantidade,String valor) throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel) jTable7.getModel();
            modelo.addRow(new Object[]{    
                codigo,
                nome,
                quantidade,
                valor
                  });
        

    }
     public void termina(){
         DefaultTableModel modelo = (DefaultTableModel) jTable7.getModel();
       jTable7.setRowSorter(new TableRowSorter(modelo));
         modelo.setNumRows(0);
        cpro.setText("");
        qproduto.setText("");
        dproduto.setText("");
//       f12.setText("");
//       iq.setText("");
//       fc.setText("");
//       cc.setText("");
//      cc1.setText("");
      no.setText("");
       toproduto.setText("0.0");
      trproduto.setText("0.0");
      vu.setText("0.0");
      tre.setText("0.0");
          CardLayout c1 = (CardLayout) PainelMae.getLayout();   //chamando o layout do primeiro
        c1.show(PainelMae,"tela1");
     }
     public void finalizar_vendamesmo() throws SQLException{
         Venda venda = new Venda();
         venda.setIdfunc(this.getIdfuncionario());
         venda.setCat(1);  //que será a granel por padrao
         Date data= new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy H:m:s");
       String dataformatada=formatar.format(data);
       venda.setDatavenda(dataformatada);
       venda.setTot_entrada(Double.parseDouble(tre.getText()));  //pegando entrada
       venda.setTot_saida(Double.parseDouble(trproduto.getText())); //pegando saida
      
//         venda.setDatavenda();
         Comvenda comvenda = new Comvenda();
         comvenda.adiciona(venda);
         //depois eu configuro a descricao da venda
         for (Venda nova : comvenda.getListasopraum ()) { //faco tudo aqui porque tenho o id da ultima venda
             Desc_venda desc_venda = new Desc_venda(); 
             Comestoque comes = new Comestoque();
              Comdescvenda comdesc = new Comdescvenda();
          
             //for para percorrer pela tabela montando a nota fiscal
             for (int i = 0; i<jTable7.getRowCount(); i++) {
             for (Estoque es : comes.deacod(String.valueOf(jTable7.getValueAt(i,0)))) {
             desc_venda.setIdvenda(nova.getIdvenda()); //pega o id da ultima venda
             desc_venda.setIdproduto(es.getIdproduto()); //id do produto
             desc_venda.setQtd(Integer.parseInt((String)jTable7.getValueAt(i,2))); //a quantidade tudo isso pra ta na nota
               comdesc.adiciona(desc_venda); 
               //aqui tbm eu irei da baixa no estoque a partir dos valores da lista
              
               int novaqtd;
               novaqtd=es.getQtd()-desc_venda.getQtd();
               comes.altera(es.getIdproduto(),novaqtd);
               
               //fim de da baixa no estoque
             
             }
                
                 
             }
             JOptionPane.showMessageDialog(null, "Compra realizada com sucesso !!");
             
             // fim do for para percorrer pela tabela montando a nota fiscal
         }
         
         CardLayout c1 = (CardLayout) PainelMae.getLayout();   //chamando o layout do primeiro
        c1.show(PainelMae,"card5");
         
     }
     
     public boolean verificasetem(String codigo){
         boolean situ=false;
         for (int i = 0; i <jTable7.getRowCount(); i++) {
             for (int j = 0; j < 4; j++) {
//                 JOptionPane.showMessageDialog(null,"linha "+i+"coluna"+j);
                 if ((jTable7.getValueAt(i,j).equals(codigo))) {
                    situ=true;
                 }
           
             }
             
         }
         return situ;
       
     }
     public void datroco() throws SQLException{
     Double valor=Double.parseDouble(tre.getText())-Double.parseDouble(toproduto.getText());
         if (valor<0) {
             JOptionPane.showMessageDialog(null,"O valor digitado é menor que o total a pagar ");
               tre.setEditable(true);
              tre.requestFocus(); 
         }else{
             trproduto.setText(String.valueOf(valor));
             //comeca agora o método para saber se o caixa tem dinheiro suficiente  para dar o troco
             Comcaixa comcaixavertroco = new Comcaixa();
             for (Caixa xa :comcaixavertroco.alteradinheirocaixa(this.getIdcaixa())) {
                 if (Double.parseDouble(trproduto.getText())>xa.getDinheiro()) {  //verificando se o troco é maior que ele tem no caixa
                     JOptionPane.showMessageDialog(null,"O valor do troco excede a quantidade disponível de dinheiro,"
                             + "por favor chamar o gerente !");
                 }else{   
             this.finalizar_vendamesmo(); // finaliza a venda inserindo a descricao do banco de dados
                int resposta = JOptionPane.showConfirmDialog(null, "Nova venda ?");
                 if (resposta == JOptionPane.YES_OPTION) {
                 
                cpro.setEditable(true);
              cpro.requestFocus(); 
              tre.setEditable(false);
                     Caixa newcaixa = new Caixa();            //atualizando dinheiro do caixa
                     newcaixa.setIdfuncionario(this.getIdfuncionario());
                     newcaixa.setDinheiro(Double.parseDouble(toproduto.getText()));
                     newcaixa.setId(this.getIdcaixa());
                     Double novodindim=((newcaixa.getDinheiro())+(xa.getDinheiro()));
                       newcaixa.setDinheiro(novodindim);
//                         JOptionPane.showMessageDialog(null,novodindim);
//                         JOptionPane.showMessageDialog(null,newcaixa.getDinheiro());
//                         JOptionPane.showMessageDialog(null,xa.getDinheiro());
                     comcaixavertroco.altera(newcaixa);
                     termina();
                 }else{
                cpro.setEditable(true);
              cpro.requestFocus(); 
              tre.setEditable(false);
                  Caixa newcaixa = new Caixa();            //atualizando dinheiro do caixa  2x afss 
                   newcaixa.setIdfuncionario(this.getIdfuncionario());
                     newcaixa.setDinheiro(Double.parseDouble(toproduto.getText()));
                     newcaixa.setId(this.getIdcaixa());
                     Double novodindim=(newcaixa.getDinheiro()+xa.getDinheiro());
                       newcaixa.setDinheiro(novodindim);
                     comcaixavertroco.altera(newcaixa);
                       termina();  
                 }
             }
            
                 } 
           //fim  agora o método para saber se o caixa tem dinheiro suficiente  para dar o troco
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

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vu = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        trproduto = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        scaixa = new javax.swing.JLabel();
        ncaixa = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tre = new javax.swing.JFormattedTextField();
        qproduto = new javax.swing.JFormattedTextField();
        toproduto = new javax.swing.JFormattedTextField();
        dproduto = new javax.swing.JFormattedTextField();
        cpro = new javax.swing.JFormattedTextField();
        fc = new javax.swing.JTextField();
        f12 = new javax.swing.JTextField();
        iq = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cc1 = new javax.swing.JTextField();
        cc = new javax.swing.JTextField();
        PainelMae = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PainelFilho1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        PainelFilho2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        PainelFilho3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        data = new javax.swing.JLabel();
        fcaixa1 = new javax.swing.JLabel();
        no = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1109, 800));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setText("PONTO DE VENDA");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(565, 11, 208, 29);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Código do Produto :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 70, 170, 23);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Quantidade :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 150, 148, 23);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Descrição :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(430, 70, 148, 23);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Valor Unitário :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(430, 220, 148, 23);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Valor a pagar :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 220, 148, 23);

        vu.setBackground(new java.awt.Color(255, 102, 204));
        vu.setForeground(new java.awt.Color(255, 255, 255));
        vu.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        vu.setMaximumSize(null);
        vu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vuActionPerformed(evt);
            }
        });
        jPanel1.add(vu);
        vu.setBounds(430, 240, 400, 38);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Total Recebido :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(430, 290, 148, 23);

        trproduto.setBackground(new java.awt.Color(255, 102, 204));
        trproduto.setForeground(new java.awt.Color(255, 255, 255));
        trproduto.setCaretColor(new java.awt.Color(0, 255, 153));
        trproduto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        trproduto.setMaximumSize(null);
        trproduto.setMinimumSize(new java.awt.Dimension(0, 20));
        trproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trprodutoActionPerformed(evt);
            }
        });
        trproduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trprodutoKeyPressed(evt);
            }
        });
        jPanel1.add(trproduto);
        trproduto.setBounds(10, 320, 400, 38);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Troco :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 290, 148, 23);

        scaixa.setBackground(new java.awt.Color(0, 204, 0));
        scaixa.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        scaixa.setForeground(new java.awt.Color(0, 255, 51));
        scaixa.setText("Aberto");
        jPanel1.add(scaixa);
        scaixa.setBounds(1090, 0, 260, 49);

        ncaixa.setBackground(new java.awt.Color(255, 255, 255));
        ncaixa.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        ncaixa.setForeground(new java.awt.Color(0, 255, 51));
        ncaixa.setText("Caixa 10");
        jPanel1.add(ncaixa);
        ncaixa.setBounds(32, 6, 152, 49);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/logoaumentafa.jpg"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(930, 390, 465, 384);

        tre.setBackground(new java.awt.Color(255, 102, 204));
        tre.setForeground(new java.awt.Color(255, 255, 255));
        tre.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tre.setMaximumSize(null);
        tre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treActionPerformed(evt);
            }
        });
        tre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                treKeyPressed(evt);
            }
        });
        jPanel1.add(tre);
        tre.setBounds(430, 320, 400, 38);

        qproduto.setBackground(new java.awt.Color(255, 102, 204));
        qproduto.setForeground(new java.awt.Color(255, 255, 255));
        qproduto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        qproduto.setMaximumSize(null);
        qproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qprodutoActionPerformed(evt);
            }
        });
        qproduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qprodutoKeyPressed(evt);
            }
        });
        jPanel1.add(qproduto);
        qproduto.setBounds(10, 170, 400, 38);

        toproduto.setBackground(new java.awt.Color(255, 102, 204));
        toproduto.setForeground(new java.awt.Color(255, 255, 255));
        toproduto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        toproduto.setMaximumSize(null);
        toproduto.setMinimumSize(new java.awt.Dimension(0, 0));
        toproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toprodutoActionPerformed(evt);
            }
        });
        jPanel1.add(toproduto);
        toproduto.setBounds(10, 240, 400, 38);

        dproduto.setBackground(new java.awt.Color(255, 102, 204));
        dproduto.setForeground(new java.awt.Color(255, 255, 255));
        dproduto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        dproduto.setMaximumSize(null);
        dproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dprodutoActionPerformed(evt);
            }
        });
        jPanel1.add(dproduto);
        dproduto.setBounds(430, 100, 400, 38);

        cpro.setBackground(new java.awt.Color(255, 102, 204));
        cpro.setForeground(new java.awt.Color(255, 255, 255));
        cpro.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cpro.setMaximumSize(null);
        cpro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cproMouseClicked(evt);
            }
        });
        cpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cproActionPerformed(evt);
            }
        });
        cpro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cproKeyPressed(evt);
            }
        });
        jPanel1.add(cpro);
        cpro.setBounds(10, 100, 400, 38);

        fc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fc.setForeground(new java.awt.Color(255, 0, 51));
        fc.setText("F3- Tabela");
        jPanel1.add(fc);
        fc.setBounds(210, 730, 190, 36);

        f12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        f12.setForeground(new java.awt.Color(255, 0, 51));
        f12.setText("F12-inserir código   ");
        jPanel1.add(f12);
        f12.setBounds(210, 650, 190, 36);

        iq.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        iq.setForeground(new java.awt.Color(255, 0, 51));
        iq.setText("F9 inserir quantidade");
        jPanel1.add(iq);
        iq.setBounds(210, 690, 190, 36);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/icons8-ponto-de-interrogação-filled-100.png"))); // NOI18N
        jPanel1.add(jLabel15);
        jLabel15.setBounds(40, 650, 110, 111);

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/coca-cola.jpg"))); // NOI18N
        foto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, new java.awt.Color(0, 0, 0), null, null));
        jPanel1.add(foto);
        foto.setBounds(560, 390, 221, 229);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setText("Coca Cola Super Ellery 222");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(512, 1410, 230, 30);

        cc1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cc1.setForeground(new java.awt.Color(255, 0, 51));
        cc1.setText("F1-cartão de crédito    ");
        cc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cc1ActionPerformed(evt);
            }
        });
        jPanel1.add(cc1);
        cc1.setBounds(410, 700, 200, 36);

        cc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cc.setForeground(new java.awt.Color(255, 0, 51));
        cc.setText("F2-cheque    ");
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccActionPerformed(evt);
            }
        });
        jPanel1.add(cc);
        cc.setBounds(410, 650, 200, 36);

        PainelMae.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Compra Finalizada com sucesso !! Volte sempre ao Super Ellery!!");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/carroiiii.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel13)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        PainelMae.add(jPanel3, "card5");

        PainelFilho1.setBackground(new java.awt.Color(99, 43, 52));

        jTable7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable7);

        javax.swing.GroupLayout PainelFilho1Layout = new javax.swing.GroupLayout(PainelFilho1);
        PainelFilho1.setLayout(PainelFilho1Layout);
        PainelFilho1Layout.setHorizontalGroup(
            PainelFilho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelFilho1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        PainelFilho1Layout.setVerticalGroup(
            PainelFilho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFilho1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        PainelMae.add(PainelFilho1, "tela1");

        PainelFilho2.setBackground(new java.awt.Color(255, 255, 255));
        PainelFilho2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cheque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 204, 102));
        jLabel16.setText("Valor :");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Código do Banco :");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Nome do Banco :");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Agência :");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Conta :");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Incluir Cheque");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/botoes/dinheirocheque.png"))); // NOI18N

        javax.swing.GroupLayout PainelFilho2Layout = new javax.swing.GroupLayout(PainelFilho2);
        PainelFilho2.setLayout(PainelFilho2Layout);
        PainelFilho2Layout.setHorizontalGroup(
            PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFilho2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel20))
                    .addComponent(jLabel17))
                .addGap(57, 57, 57)
                .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextField1)
                    .addComponent(jFormattedTextField3)
                    .addComponent(jFormattedTextField2)
                    .addComponent(jFormattedTextField4)
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelFilho2Layout.setVerticalGroup(
            PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFilho2Layout.createSequentialGroup()
                .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelFilho2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelFilho2Layout.createSequentialGroup()
                        .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(PainelFilho2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PainelMae.add(PainelFilho2, "tela2");

        PainelFilho3.setBackground(new java.awt.Color(255, 255, 255));
        PainelFilho3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados para pagamento com cartão de crédito", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        PainelFilho3.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel27.setText("Valor :");
        PainelFilho3.add(jLabel27);
        jLabel27.setBounds(80, 30, 51, 22);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("X");
        PainelFilho3.add(jLabel28);
        jLabel28.setBounds(190, 60, 14, 29);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel29.setText("Valor da Parcela");
        PainelFilho3.add(jLabel29);
        jLabel29.setBounds(450, 30, 132, 22);
        PainelFilho3.add(jTextField9);
        jTextField9.setBounds(280, 60, 145, 43);

        jLabel30.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel30.setText("Nº de parcelas");
        PainelFilho3.add(jLabel30);
        jLabel30.setBounds(280, 30, 118, 22);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        PainelFilho3.add(jTextField10);
        jTextField10.setBounds(440, 60, 150, 43);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bandeira", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Itaú ", "Bradesco", "Americanas", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/botoes/cartao.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelFilho3.add(jPanel2);
        jPanel2.setBounds(60, 110, 543, 180);
        PainelFilho3.add(jTextField11);
        jTextField11.setBounds(50, 60, 117, 43);

        PainelMae.add(PainelFilho3, "tela3");

        jPanel1.add(PainelMae);
        PainelMae.setBounds(840, 60, 630, 310);

        data.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        data.setText("Funcionário : Tiago Maciel");
        jPanel1.add(data);
        data.setBounds(30, 410, 430, 30);

        fcaixa1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        fcaixa1.setText("Funcionário : Tiago Maciel");
        jPanel1.add(fcaixa1);
        fcaixa1.setBounds(30, 460, 420, 30);

        no.setBackground(new java.awt.Color(255, 102, 204));
        no.setForeground(new java.awt.Color(255, 255, 255));
        no.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        no.setMaximumSize(null);
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });
        jPanel1.add(no);
        no.setBounds(430, 170, 400, 38);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Nome :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(430, 150, 148, 23);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload72.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(250, 10, 90, 70);

        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenu1.setForeground(new java.awt.Color(51, 255, 51));
        jMenu1.setText("Ações");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("Cartão de Crédito");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setText("Cheque");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("tabela");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem4.setText("inserir código");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem5.setText("inserir quantidade");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("finalizar compra");
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem6MouseClicked(evt);
            }
        });
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sair");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cproActionPerformed

    private void dprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dprodutoActionPerformed

    private void toprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toprodutoActionPerformed

    private void qprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qprodutoActionPerformed

    private void treActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_treActionPerformed

    private void trprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trprodutoActionPerformed

    private void vuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vuActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
   if (evt.getKeyCode()==KeyEvent.VK_ENTER) {    //evt.getKeyCODE pega o codigo do botao e KeyEvent.VK_Enter pega o enter

      JOptionPane.showMessageDialog(null,"ffi");  
    }//GEN-LAST:event_jPanel1KeyPressed
    }
    private void trprodutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trprodutoKeyPressed
     if (evt.getKeyCode()==KeyEvent.VK_ENTER) {    //evt.getKeyCODE pega o codigo do botao e KeyEvent.VK_Enter pega o enter

      JOptionPane.showMessageDialog(null,"ffi");  
    } 
    }//GEN-LAST:event_trprodutoKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
     if (evt.getKeyCode()==KeyEvent.VK_ENTER) {    //evt.getKeyCODE pega o codigo do botao e KeyEvent.VK_Enter pega o enter

      JOptionPane.showMessageDialog(null,"ffi");  
    } 
    }//GEN-LAST:event_formKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CardLayout c1 = (CardLayout) PainelMae.getLayout();   //chamando o layout do primeiro
        c1.show(PainelMae, "tela1");
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      CardLayout c1 = (CardLayout) PainelMae.getLayout();   //chamando o layout do primeiro
        c1.show(PainelMae,"tela3");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          CardLayout c1 = (CardLayout) PainelMae.getLayout();   //chamando o layout do primeiro
        c1.show(PainelMae,"tela2");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        Redireciona r = new Redireciona();
        r.show();
        dispose();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Redireciona r = new Redireciona();
        r.show();
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void cc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cc1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            if (verifica()) {        
        cpro.setEditable(true);
        cpro.requestFocus(); 
        cpro.selectAll();
            }else{
                JOptionPane.showMessageDialog(null,"Você não pode realizar esta ação,pois o caixa está fechado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked

    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void cproKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cproKeyPressed
   if (evt.getKeyCode()==KeyEvent.VK_ENTER) {    //evt.getKeyCODE pega o codigo do botao e KeyEvent.VK_Enter pega o enter
     cpro.setEditable(false);
       try {
           if (verificasetem(cpro.getText())) {
               
             JOptionPane.showMessageDialog(null,"Este produto já foi adicionado,apenas altere a quantidade !");  
           }else{
           Comestoque comest = new Comestoque(); 
             for (Produto p : comest.deacod(cpro.getText())) {
                 //aqui eu faco a verificacao se eu tenho esta quantidade no estoque
               Comestoque massa  = new Comestoque();
                 if (massa.verificaseaquantidadecondiz(1,p.getId())) {
                     
                no.setText(p.getNome());
                qproduto.setText("1");
                dproduto.setText(p.getDescricao());
                vu.setText(String.valueOf(p.getValor()));
                ManipularImagem.exibiImagemLabel(p.getImagem(),foto);
                paraum=true;   //para reconhecer que vai ser a primeira vez que aquele produto esta sendo passado
                somando(p.getValor(),Integer.parseInt(qproduto.getText()),qrtprevia,paraum);   //chamando funcao para somar
                readJTable(cpro.getText(),no.getText(),qproduto.getText(),vu.getText());
                 }else{
                     JOptionPane.showMessageDialog(null,"Este produto está em falta! Comunique ao gerente");
                 }
                 //fim de aqui eu faco a verificacao se eu tenho esta quantidade no estoque
                
             }
//           Estoque est = new Estoque();
           } 
       } catch (SQLException ex) {
           Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
       }
     
    }    
    }//GEN-LAST:event_cproKeyPressed

    private void cproMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cproMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cproMouseClicked

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu1KeyPressed
     
    }//GEN-LAST:event_jMenu1KeyPressed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
    
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void qprodutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qprodutoKeyPressed
 if (evt.getKeyCode()==KeyEvent.VK_ENTER) {    
     Comestoque comest;
     try {
         comest = new Comestoque();
for (Produto p : comest.deacod(cpro.getText())) {
                 if (comest.verificaseaquantidadecondiz(Integer.parseInt(qproduto.getText()),p.getId())) {             
     paraum=false;
     qproduto.setEditable(false);
    alteraquantidadetable(qproduto.getText());
 somando(Double.parseDouble(vu.getText()),Integer.parseInt(qproduto.getText()),qrtprevia, paraum);  
     cpro.requestFocus();
     cpro.setEditable(true);
                 }else{
                     JOptionPane.showMessageDialog(null,"Este produto está em falta.Comunique ao gerente !");
                 }
    
}
     } catch (SQLException ex) {
         Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
     }
                 //aqui eu faco a verificacao se eu tenho esta quantidade no estoque
          
   
    }       
    }//GEN-LAST:event_qprodutoKeyPressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            if (verifica()) {
        qproduto.setEditable(true);
    qproduto.requestFocus();
       qproduto.selectAll();
       String peguei= qproduto.getText();
       qrtprevia=peguei;  //agoria sim peguei a quantidade que já tinha antes de alterar a quantidade
                
            }else{
                 JOptionPane.showMessageDialog(null,"Você não pode realizar esta ação,pois o caixa está fechado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            if (verifica()) {
        toproduto.setEditable(false);
        qproduto.setEditable(false);
        no.setEditable(false);
        cpro.setEditable(false);
        trproduto.setEditable(false);
        dproduto.setEditable(false);
        vu.setEditable(false);
       tre.setEditable(true);
        tre.requestFocus(); 
        tre.setText("");
                
            }else{
                 JOptionPane.showMessageDialog(null,"Você não pode realizar esta ação,pois o caixa está fechado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
//      this.termina();
//        try {
//            this.finalizar_vendamesmo();
//        } catch (SQLException ex) {
//            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6MouseClicked

    private void treKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_treKeyPressed
if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
        try {
            this.datroco();  //falta ajeitar ainda as configuracoes
        } catch (SQLException ex) {
            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }//GEN-LAST:event_treKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.verifica();
        } catch (SQLException ex) {
            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelFilho1;
    private javax.swing.JPanel PainelFilho2;
    private javax.swing.JPanel PainelFilho3;
    private javax.swing.JPanel PainelMae;
    private javax.swing.JTextField cc;
    private javax.swing.JTextField cc1;
    private javax.swing.JFormattedTextField cpro;
    private javax.swing.JLabel data;
    private javax.swing.JFormattedTextField dproduto;
    private javax.swing.JTextField f12;
    private javax.swing.JTextField fc;
    private javax.swing.JLabel fcaixa1;
    private javax.swing.JLabel foto;
    private javax.swing.JTextField iq;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel ncaixa;
    private javax.swing.JFormattedTextField no;
    private javax.swing.JFormattedTextField qproduto;
    private javax.swing.JLabel scaixa;
    private javax.swing.JFormattedTextField toproduto;
    private javax.swing.JFormattedTextField tre;
    private javax.swing.JFormattedTextField trproduto;
    private javax.swing.JFormattedTextField vu;
    // End of variables declaration//GEN-END:variables
}
