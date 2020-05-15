/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
import VARIAVEIS.Desc_venda;
import VARIAVEIS.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALUNO
 */
public class Comdescvenda {
   private Connection co;
    public Comdescvenda() throws SQLException {
             this.co = conexao.getconexao();
    }
       public void adiciona(Desc_venda cat1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.
    String sql = "Insert into desc_venda (qtd,produto_idproduto,venda_idvenda)" 
            + "values (?,?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);


stmt.setInt (1,cat1.getQtd());        
stmt.setInt (2,cat1.getIdproduto());        
stmt.setInt (3,cat1.getIdvenda());        
stmt.execute (); //Executa o código sql.
stmt.close();   //Fecha banco.          
//JOptionPane.showMessageDialog(null, "Compra realizada com sucesso !!");
}
           public void remove(Desc_venda p1) throws SQLException {
String sql = "delete from desc_venda where id=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getId());
            stmt.execute();
        }
}
              public void altera(Desc_venda p) throws SQLException{
String sql = "update catproduto set qtd=?,produto_idproduto=?,venda_idvenda=? where id=?";

PreparedStatement stmt = co.prepareStatement(sql);
stmt.setInt (1,p.getQtd());
stmt.setInt (2,p.getIdproduto());
stmt.setInt (3,p.getIdvenda());
stmt.execute (); //Executa o código sql.
stmt.close(); //Fecha banco.
 JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
}
               public List <Venda> abrindodesc (int idvenda) throws SQLException {
//select v.idvenda,c.idcaixa,v.datavenda,cat.descricao,f.nome from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario where v.datavenda like '%15/06%';
 String sql= "select des.qtd,p.nome,p.valor from desc_venda as des join venda as v on des.venda_idvenda = v. idvenda join produto p on des.produto_idproduto = p.idproduto where v.idvenda=?";

PreparedStatement stmt= this.co.prepareStatement (sql);
 stmt.setInt (1,idvenda); 
 
 ResultSet rs= stmt.executeQuery();
 List <Venda> minhaLista= new ArrayList <Venda> ();
 
 while (rs.next()){
     Venda c1 = new Venda();
     
     c1.setQtdn(rs.getInt("qtd"));;
     c1.setAddn(rs.getString("nome"));
     c1.setValor(rs.getDouble("valor"));
    
     
   
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
                   
               }
       
    
    
}
