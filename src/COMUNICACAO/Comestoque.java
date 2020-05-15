/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
import VARIAVEIS.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guilhermefranci
 */
public class Comestoque {
    private Connection co;

    public Comestoque() throws SQLException {
        this.co = conexao.getconexao();
    }
        public void adiciona(Estoque cat1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.
    String sql = "Insert into estoque (	produto_idproduto,qtd)" 
            + "values (?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);

//Agora iremos informar os valores em nosso Statement.
stmt.setLong (1,cat1.getIdproduto());        
stmt.setInt (2,cat1.getQtd());        
stmt.execute (); //Executa o código sql.
stmt.close();   //Fecha banco.          
JOptionPane.showMessageDialog(null, "Adicionado no estoque com sucesso com quantidade 0 !!");;
}
          public List <Estoque> getLista () throws SQLException {
 String sql= "select e.idestoque, e.qtd,p.nome,p.descricao,p.codigo_produto,p.valor,p.imagem from estoque as e join produto as p on p.idproduto= e.produto_idproduto order by p.idproduto DESC ";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Estoque> minhaLista= new ArrayList <Estoque> ();
 
 while (rs.next()){
     Estoque c1 = new Estoque();     
     c1.setId(rs.getInt ("idestoque"));;
     c1.setQtd(rs.getInt ("qtd"));
     c1.setNome(rs.getString ("nome"));
     c1.setDescricao(rs.getString ("descricao"));
     c1.setCodigo_produto(rs.getString("codigo_produto"));
     c1.setValor(rs.getDouble("valor"));
     c1.setImagem(rs.getBytes("imagem"));
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
           public List <Estoque> deacod (String codigo) throws SQLException {
 String sql= "select e.idestoque, e.qtd,p.nome,p.idproduto,p.descricao,p.codigo_produto,p.valor,p.imagem from estoque as e join produto as p on p.idproduto= e.produto_idproduto where p.codigo_produto='"+codigo+"'";
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Estoque> minhaLista= new ArrayList <Estoque> ();
 
 while (rs.next()){
     Estoque c1 = new Estoque();     
     c1.setId(rs.getInt ("idestoque"));;
     c1.setIdproduto(rs.getInt ("idproduto"));;
     c1.setQtd(rs.getInt ("qtd"));
     c1.setNome(rs.getString ("nome"));
     c1.setDescricao(rs.getString ("descricao"));
     c1.setCodigo_produto(rs.getString("codigo_produto"));
     c1.setValor(rs.getDouble("valor"));
     c1.setImagem(rs.getBytes("imagem"));
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
           public void remove(Estoque p1) throws SQLException {
String sql = "delete from estoque where idestoque=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getId());
            stmt.execute();
        }
}
              public void altera(int codpro,int qtd) throws SQLException{
                  
String sql = "update estoque set qtd="+qtd+" where produto_idproduto="+codpro;
PreparedStatement stmt = co.prepareStatement(sql);
stmt.execute (); //Executa o código sql.
stmt.close(); //Fecha banco.
// JOptionPane.showMessageDialog(null, "Um item a menos!");
}
              public boolean verificaseaquantidadecondiz(int qtd,int id) throws SQLException{
                    boolean estado=false;
 String sql= "select * from estoque where produto_idproduto=? and qtd >=? ";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 stmt.setInt (1,id);        
stmt.setInt (2,qtd);    
 ResultSet rs= stmt.executeQuery();
 
 while (rs.next()){
   estado=true;
  }
 rs.close();
 stmt.close();
return estado;
                  
              }
          
}
