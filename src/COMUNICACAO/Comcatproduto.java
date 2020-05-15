/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
import VARIAVEIS.Catproduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Comcatproduto {
    private Connection co;
    public Comcatproduto() throws SQLException {
     this.co = conexao.getconexao();
    }
    //metodo adicionar
        public void adiciona(Catproduto cat1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.
    String sql = "Insert into catproduto (nome,descricao)" 
            + "values (?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);

//Agora iremos informar os valores em nosso Statement.
stmt.setString (1,cat1.getNome());        
stmt.setString (2,cat1.getDesc());        
stmt.execute (); //Executa o código sql.
stmt.close();   //Fecha banco.          
JOptionPane.showMessageDialog(null, "nova categoria cadastrada com sucesso !!");
}
   public List <Catproduto> getLista () throws SQLException {
 String sql= "select * from catproduto";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Catproduto> minhaLista= new ArrayList <Catproduto> ();
 
 while (rs.next()){
     Catproduto c1= new Catproduto ();
     
     c1.setIdcatproduto(rs.getInt ("idcatproduto"));;
     c1.setNome(rs.getString ("nome"));
     c1.setDesc(rs.getString ("descricao"));
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
      public void remove(Catproduto p1) throws SQLException {
String sql = "delete from catproduto where idcatproduto=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getIdcatproduto());
            stmt.execute();
        }
}
    public void altera(Catproduto p) throws SQLException{
String sql = "update catproduto set nome=?,descricao=? where idcatproduto=?";

PreparedStatement stmt = co.prepareStatement(sql);
stmt.setString (1,p.getNome());
stmt.setString (2,p.getDesc());
stmt.setInt (3,p.getIdcatproduto());
stmt.execute (); //Executa o código sql.
stmt.close(); //Fecha banco.
 JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
}
     public List <Catproduto> getListacat (String desc) throws SQLException {
 String sql= "select * from catproduto WHERE nome LIKE '%"+desc+"%' order by idcatproduto DESC";
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Catproduto> minhaLista= new ArrayList <Catproduto> ();
 
 while (rs.next()){
     Catproduto c1 = new Catproduto();
     
     c1.setIdcatproduto(rs.getInt ("idcatproduto"));;
     c1.setNome(rs.getString ("nome"));
     c1.setDesc(rs.getString ("descricao"));
   
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
}
    
}
