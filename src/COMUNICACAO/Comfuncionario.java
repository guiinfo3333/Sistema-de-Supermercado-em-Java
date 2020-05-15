/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMUNICACAO;

import CONEXAO.conexao;
import VARIAVEIS.Funcionario;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Comfuncionario {
      private Connection co;

    public Comfuncionario() throws SQLException {
             this.co = conexao.getconexao();
    }
     public void adiciona(Funcionario p1) throws SQLException{
//Prepara a conexão p enviar o código sql para o banco de dados.
    String sql = "Insert into funcionario (nome,sexo,CPF,telefone,endereco,email,login,senha)" 
            + "values ( ?, ?, ?, ?, ?,?,?,?)";

//Executar este código dentro do banco de dados.    
    PreparedStatement stmt = co.prepareStatement(sql);

//Agora iremos informar os valores em nosso Statement.
stmt.setString (1,p1.getNome());    
stmt.setString (2,p1.getSexo());
stmt.setString (3,p1.getCpf());
stmt.setString (4,p1.getTelefone());
stmt.setString (5,p1.getEndereço());
stmt.setString (6,p1.getEmail());
stmt.setString(7,p1.getLogin());
stmt.setString(8,p1.getSenha());

          
 stmt.execute ();
  JOptionPane.showMessageDialog(null,"Funcionário adicionado  com sucesso !!");
stmt.close();   //Fecha banco.          
}
public List <Funcionario> getLista () throws SQLException {
 String sql= "select * from funcionario order by idfuncionario DESC";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Funcionario> minhaLista= new ArrayList <Funcionario> ();
 
 while (rs.next()){
     Funcionario c1 = new Funcionario();
     
     c1.setId(rs.getInt ("idfuncionario"));
     c1.setNome(rs.getString ("nome"));
     c1.setCpf(rs.getString ("CPF"));
     c1.setSexo(rs.getString ("sexo"));
     c1.setTelefone(rs.getString ("telefone"));
     c1.setEndereço(rs.getString("endereco"));
     c1.setEmail(rs.getString("email"));
     c1.setLogin(rs.getString("login"));
     c1.setSenha(rs.getString("senha")); 
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
}
 public void remove(Funcionario p1) throws SQLException {
String sql = "delete from funcionario where idfuncionario=?";
        try (PreparedStatement stmt = co.prepareStatement(sql)) {
            stmt.setInt(1,p1.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Funcionário excluído com sucesso !");
        }
}
   public void altera(Funcionario p) throws SQLException{
String sql = "update funcionario set nome=?,CPF=?,telefone=?,endereco=?,email=?,login=?,senha=? where idfuncionario=?";

PreparedStatement stmt = co.prepareStatement(sql);
stmt.setString (1,p.getNome());
stmt.setString (2,p.getCpf());
stmt.setString (3,p.getTelefone());
stmt.setString (4,p.getEndereço());
stmt.setString (5,p.getEmail());
stmt.setString (6,p.getLogin());
stmt.setString (7,p.getSenha());
stmt.setInt (8,p.getId());
stmt.execute (); //Executa o código sql.
stmt.close(); //Fecha banco.
 JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
}
    public boolean verificafunc(String c,String l) throws SQLException{
          boolean result = false;
         String sql= "select * from funcionario where CPF='"+c+"' or login='"+l+"'";
         PreparedStatement stmt= this.co.prepareStatement (sql);
       ResultSet rs= stmt.executeQuery();
	if(rs.next()){
            result = true;
           
        }
	stmt.close();
        rs.close();
	
       return result;
}
     public List<Funcionario> readForDesc(String desc) throws SQLException {
        
      String sql= "select * from funcionario WHERE nome LIKE '%"+desc+"%'";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Funcionario> minhaLista= new ArrayList <Funcionario> ();
 
 while (rs.next()){
     Funcionario c1 = new Funcionario();
     
     c1.setId(rs.getInt ("idfuncionario"));
     c1.setNome(rs.getString ("nome"));
     c1.setCpf(rs.getString ("cpf"));
     c1.setSexo(rs.getString ("sexo"));
     c1.setTelefone(rs.getString ("telefone"));
     c1.setEndereço(rs.getString("endereco"));
     c1.setEmail(rs.getString("email"));
     c1.setLogin(rs.getString("login"));
     c1.setSenha(rs.getString("senha")); 
   
     
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
     

    }
      public boolean login(String login,String senha) throws SQLException {
          boolean estado=false;
 String sql= "select * from funcionario where login='"+login+"'"+"and senha='"+senha+"'";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 while (rs.next()){
   estado=true;
  }
 rs.close();
 stmt.close();
return estado;
}
        public List<Funcionario> pegaid(String desc) throws SQLException {
        
      String sql= "select * from funcionario where login='"+desc+"'";
 
 PreparedStatement stmt= this.co.prepareStatement (sql);
 ResultSet rs= stmt.executeQuery();
 
 List <Funcionario> minhaLista= new ArrayList <Funcionario> ();
 
 while (rs.next()){
     Funcionario c1 = new Funcionario();
     
     c1.setId(rs.getInt ("idfuncionario")); 
     minhaLista.add (c1);
  }
 rs.close();
 stmt.close();
 return minhaLista;
     

    }
    
}
