/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
import VARIAVEIS.Fornecedor;
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
public class Comfornecedor {
private Connection co;
    public Comfornecedor() throws SQLException {
         this.co = conexao.getconexao();
    }
    public void adiciona(Fornecedor cat1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.
    String sql = "Insert into fornecedor (nome,cnpj,endereco,catfornecedor_idcatfornecedor,telefone,email)" 
            + "values (?,?,?,?,?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);

//Agora iremos informar os valores em nosso Statement.
stmt.setString (1,cat1.getNome());        
stmt.setString (2,cat1.getCnpj());        
stmt.setString (3,cat1.getEndereco());        
stmt.setInt (4,cat1.getCat());        
stmt.setString (5,cat1.getTelefone());        
stmt.setString (6,cat1.getEmail());        
stmt.execute (); //Executa o código sql.
stmt.close();   //Fecha banco.          
JOptionPane.showMessageDialog(null, " Fornecedor cadastrado com sucesso !!");
}
       public List <Fornecedor> getLista () throws SQLException {
 String sql= "select * from fornecedor";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Fornecedor> minhaLista= new ArrayList <Fornecedor> ();
 
 while (rs.next()){
     Fornecedor c1 = new Fornecedor();
     
     c1.setId(rs.getInt ("idfornecedor"));;
     c1.setNome(rs.getString ("nome"));;
     c1.setCnpj(rs.getString ("cnpj"));
     c1.setEndereco(rs.getString ("endereco"));
     c1.setCat(rs.getInt("catfornecedor_idcatfornecedor"));
     c1.setTelefone(rs.getString ("telefone"));
     c1.setEmail(rs.getString ("email"));
   
     
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
                  public void remove(Fornecedor p1) throws SQLException {
String sql = "delete from fornecedor where idfornecedor=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getId());
            stmt.execute();
        }
        
}
                        public void altera(Fornecedor p) throws SQLException{
String sql = "update fornecedor set nome=?,cnpj=?,endereco=?,catfornecedor_idcatfornecedor=?,telefone=?,email=? where idfornecedor=?";

PreparedStatement stmt = co.prepareStatement(sql);
stmt.setString (1,p.getNome());
stmt.setString (2,p.getCnpj());
stmt.setString (3,p.getEndereco());
stmt.setInt (4,p.getCat());
stmt.setString (5,p.getTelefone());
stmt.setString (6,p.getEmail());
stmt.setInt (7,p.getId());
stmt.execute (); //Executa o código sql.
stmt.close(); //Fecha banco.
 JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!!");
}
                         public boolean verificaproduto(String c) throws SQLException{
          boolean result = false;
         String sql= "select * from fornecedor where cnpj='"+c+"'";
         PreparedStatement stmt= this.co.prepareStatement (sql);
       ResultSet rs= stmt.executeQuery();
	if(rs.next()){
            result = true;
           
        }
	stmt.close();
        rs.close();
	
       return result;
}
                         
               public List<Fornecedor> readForDesc(String desc) throws SQLException {
        
      String sql= "select * from fornecedor WHERE nome LIKE '%"+desc+"%'";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Fornecedor> minhaLista= new ArrayList <Fornecedor> ();
 
 while (rs.next()){
     Fornecedor c1 = new Fornecedor();
     
     c1.setId(rs.getInt ("idfornecedor"));;
     c1.setNome(rs.getString ("nome"));;
     c1.setCnpj(rs.getString ("cnpj"));
     c1.setEndereco(rs.getString ("endereco"));
     c1.setCat(rs.getInt("catfornecedor_idcatfornecedor"));
     c1.setTelefone(rs.getString ("telefone"));
     c1.setEmail(rs.getString ("email"));
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
     

    }
   
}
