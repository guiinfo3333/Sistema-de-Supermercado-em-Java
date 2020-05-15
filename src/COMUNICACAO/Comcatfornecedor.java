/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
import VARIAVEIS.Catfornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Informatica
 */
public class Comcatfornecedor {
private Connection co;
    public Comcatfornecedor() throws SQLException {
         this.co = conexao.getconexao();
        
    }
    
      public void adiciona(Catfornecedor cat1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.
    String sql = "Insert into catfornecedor (nome,descricao)" 
            + "values (?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);

//Agora iremos informar os valores em nosso Statement.
stmt.setString (1,cat1.getNome());        
stmt.setString (2,cat1.getDescricao());        
stmt.execute (); //Executa o código sql.
stmt.close();   //Fecha banco.          
JOptionPane.showMessageDialog(null, "Categoria de fornecedor cadastrada !!");
}
        public List <Catfornecedor> getLista () throws SQLException {
 String sql= "select * from catfornecedor";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Catfornecedor> minhaLista= new ArrayList <Catfornecedor> ();
 
 while (rs.next()){
     Catfornecedor c1 = new Catfornecedor();
     
     c1.setId(rs.getInt ("idcatfornecedor"));;
     c1.setNome(rs.getString ("nome"));;
     c1.setDescricao(rs.getString ("descricao"));
   
     
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
           public void remove(Catfornecedor p1) throws SQLException {
String sql = "delete from catfornecedor where idcatfornecedor=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getId());
            stmt.execute();
        }
}
            public void altera(Catfornecedor p) throws SQLException{
String sql = "update catfornecedor set nome=?,descricao=? where idcatfornecedor=?";

PreparedStatement stmt = co.prepareStatement(sql);
stmt.setString (1,p.getNome());
stmt.setString (2,p.getDescricao());
stmt.setInt (3,p.getId());
stmt.execute (); //Executa o código sql.
stmt.close(); //Fecha banco.
 JOptionPane.showMessageDialog(null, "Categoria de fornecedor alterada com sucesso!!");
}
            public List <Catfornecedor> getListacat (String desc) throws SQLException {
 String sql= "select * from catfornecedor WHERE nome LIKE '%"+desc+"%' order by idcatfornecedor DESC";
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Catfornecedor> minhaLista= new ArrayList <Catfornecedor> ();
 
 while (rs.next()){
     Catfornecedor c1 = new Catfornecedor();     
     c1.setId(rs.getInt ("idcatfornecedor"));;
     c1.setNome(rs.getString ("nome"));
     c1.setDescricao(rs.getString ("descricao"));
   
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
}
}
