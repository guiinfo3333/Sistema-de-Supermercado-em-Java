/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
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
public class Comvenda {
private Connection co;
    public Comvenda() throws SQLException {
          this.co = conexao.getconexao();
    }
    
           public void adiciona(Venda cat1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.  //precisa alterar por conta do banco
    String sql = "Insert into venda (datavenda,catvenda_idCatvenda,funcionario_idfuncionario,tot_entrada,tot_saida)" 
            + "values (?,?,?,?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);

//Agora iremos informar os valores em nosso Statement.
stmt.setString (1,cat1.getDatavenda());        
stmt.setInt (2,cat1.getCat());        
stmt.setInt (3,cat1.getIdfunc());  
stmt.setDouble (4,cat1.getTot_entrada());  
stmt.setDouble (5,cat1.getTot_saida());  

stmt.execute (); //Executa o código sql.
stmt.close();   //Fecha banco.          
JOptionPane.showMessageDialog(null, "Venda em processo..");
}
          public List <Venda> getLista () throws SQLException {
 String sql= "select * from venda order by idvenda DESC";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Venda> minhaLista= new ArrayList <Venda> ();
 
 while (rs.next()){
     Venda c1 = new Venda();
     
     c1.setIdvenda(rs.getInt ("idvenda"));;
     c1.setDatavenda(rs.getString ("datavenda"));
     c1.setCat(rs.getInt ("catvenda_idCatvenda"));
     c1.setIdfunc(rs.getInt ("funcionario_idfuncionario"));
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
          public List <Venda> getListasopraum () throws SQLException {
 String sql= "select * from venda order by idvenda DESC limit 1";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Venda> minhaLista= new ArrayList <Venda> ();
 
 while (rs.next()){
     Venda c1 = new Venda();
     
     c1.setIdvenda(rs.getInt ("idvenda"));;
     minhaLista.add (c1);
  }       
 rs.close();
 stmt.close();
 return minhaLista;   
}
           public void remove(Venda p1) throws SQLException {
String sql = "delete from venda where idvenda=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getIdvenda());
            stmt.execute();
        }
}
           //pesquisa por data ou nome do funcionario
            public List <Venda> getListacat (int desc) throws SQLException {
 String sql= "select v.idvenda,c.idcaixa,v.datavenda,cat.descricao,f.nome from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario  where c.idcaixa="+desc+" order by v.idvenda DESC";
//select v.idvenda,c.idcaixa,v.datavenda,cat.descricao,f.nome from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario where v.datavenda like '%15/06%';
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Venda> minhaLista= new ArrayList <Venda> ();
 
 while (rs.next()){
     Venda c1 = new Venda();
     
     c1.setIdvenda(rs.getInt ("idvenda"));;
     c1.setDatavenda(rs.getString ("datavenda"));
     c1.setIdcaixa(rs.getInt ("idcaixa"));
     c1.setNomecat(rs.getString ("descricao"));
     c1.setNomefunc(rs.getString ("nome"));
     
   
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
}
            public List <Venda> getListacatpordata (String desc,int idcaixa) throws SQLException {
 String sql= "select v.idvenda,c.idcaixa,v.datavenda,cat.descricao,f.nome from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario where  c.idcaixa=? and v.datavenda like '%"+desc+"%'"+" order by v.idvenda DESC";
//select v.idvenda,c.idcaixa,v.datavenda,cat.descricao,f.nome from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario where v.datavenda like '%15/06%';
 PreparedStatement stmt= this.co.prepareStatement (sql);
 stmt.setInt (1,idcaixa);         
 ResultSet rs= stmt.executeQuery();
 List <Venda> minhaLista= new ArrayList <Venda> ();
 
 while (rs.next()){
     Venda c1 = new Venda();
     
     c1.setIdvenda(rs.getInt ("idvenda"));;
     c1.setDatavenda(rs.getString ("datavenda"));
     c1.setIdcaixa(rs.getInt ("idcaixa"));
     c1.setNomecat(rs.getString ("descricao"));
     c1.setNomefunc(rs.getString ("nome"));
     
   
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
}
            public List <Venda> retornandovalores (int idcaixa) throws SQLException {
 String sql= "select v.tot_entrada,v.tot_saida from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario where  c.idcaixa=?";
//select v.idvenda,c.idcaixa,v.datavenda,cat.descricao,f.nome from venda as v join catvenda as cat on cat.idCatvenda = v.catvenda_idCatvenda join funcionario f on f.idfuncionario = v.funcionario_idfuncionario join caixa c on f.idfuncionario=c.funcionario_idfuncionario where v.datavenda like '%15/06%';
 PreparedStatement stmt= this.co.prepareStatement (sql);
 stmt.setInt (1,idcaixa);         
 ResultSet rs= stmt.executeQuery();
 List <Venda> minhaLista= new ArrayList <Venda> ();
 
 while (rs.next()){
     Venda c1 = new Venda();
     
     c1.setTot_entrada(rs.getDouble("tot_entrada"));;
     c1.setTot_saida(rs.getDouble("tot_saida"));
    
     
   
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
}
//               public void altera(Venda p) throws SQLException{
//String sql = "update catproduto set nome=?,descricao=? where idcatproduto=?";
//
//PreparedStatement stmt = co.prepareStatement(sql);
//stmt.setString (1,p.getNome());
//stmt.setString (2,p.getDesc());
//stmt.setInt (3,p.getIdcatproduto());
//stmt.execute (); //Executa o código sql.
//stmt.close(); //Fecha banco.
// JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
//}
           
}
