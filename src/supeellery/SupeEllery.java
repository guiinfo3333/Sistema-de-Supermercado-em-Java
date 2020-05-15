/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supeellery;

import COMUNICACAO.Comadministrador;
import COMUNICACAO.Comcaixa;
import COMUNICACAO.Comdescvenda;
import COMUNICACAO.Comestoque;
import COMUNICACAO.Comfornecedor;
import COMUNICACAO.Comfuncionario;
import COMUNICACAO.Comproduto;
import COMUNICACAO.Comvenda;
import CONEXAO.conexao;
import TELAS.Redireciona;
import VARIAVEIS.Administrador;
import VARIAVEIS.Caixa;
import VARIAVEIS.Desc_venda;
import VARIAVEIS.Fornecedor;
import VARIAVEIS.Funcionario;
import VARIAVEIS.Produto;
import VARIAVEIS.Venda;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




/**
 *
 * @author Aluno
 */
public class SupeEllery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {    
        //Connection conectar = conexao.getconexao();
        //conectar.close();
        //JOptionPane.showMessageDialog(null,"banco desconectado");
/* Catproduto c1 = new Catproduto();
        c1.setNome("gelados");
        Comcatproduto com = new Comcatproduto();
        com.adiciona (c1);
        System.out.println("adicionado ao banco");
         */
//            Comproduto com = new Comproduto();;
//             Produto p = new Produto();
//             p.setNome("oi22");   
//             p.setDescricao("hoje22");
//             p.setMarca("ambev");
//             p.setCodigo_produto("99999999999999933333");
//             p.setQtdminima(20000);
//             p.setCatproduto_idcatproduto(1);
//             p.setValor(15.00);
//             com.adiciona(p);
//              p.setId(13);

//          
//  Comcatproduto op = new Comcatproduto();
//  Catproduto p = new Catproduto();
//  p.setDesc("hoje");
//  p.setNome("hojdfsrfwefe");
//  p.setIdcatproduto(2);
//             op.altera(p);
//
//        if (op.verificaproduto(20000)) {
//                JOptionPane.showMessageDialog(null, "Este produto já foi cadastrado !!");
//        }
//Funcionario func = new Funcionario();
//func.setCpf("455-2325-833-4");
//func.setNome("gui");
//func.setEmail("jshjd");
//func.setEndereço("jhsdj");
//func.setTelefone("(85)98533-7317");
//func.setSexo("masculino");
//func.setLogin("masculino");
//func.setSenha("masculino");
//
//        Comfuncionario co = new Comfuncionario();
//        if (co.verificafunc("455-2325-833-4")) {
//            System.out.println("já");
//        }else{
//            System.out.println("nao");
//            
//        }
//        
//        Comfornecedor d = new Comfornecedor();
//        Fornecedor p= new Fornecedor();
//             p.setNome("oi");
//             p.setCnpj("455-2325-833-4");
//             p.setTelefone("85-4348394");
//             p.setEmail("kkdsdkds");
//             p.setEndereco("kskd");
//             p.setCat(3);
//             d.adiciona(p);
//    }
//        Administrador a = new Administrador();
//   
//        co=conexao.getconexao();
//        
//        Comadministrador com = new Comadministrador();
//        Comfuncionario comfunc= new Comfuncionario();
//       
//        for (Funcionario p :comfunc.pegaid("nat")) {
//            System.out.println(p.getId());
//        }
//          Date data = new Date();
//        System.out.println("Data Agora: "+data);
//      Calendar c = Calendar.getInstance();
//      System.out.println("Data/Hora atual: "+c.getTime());
//        System.out.println("Ano: "+c.get(Calendar.YEAR));
//        System.out.println("Mês: "+c.get(Calendar.MONTH));
//        System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));
//      Venda venda = new Venda();
//         venda.setIdfunc(1);
//         venda.setCat(1);  //que será a granel por padrao
//         Date data= new Date();
//        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy H:m:s");
//       String dataformatada=formatar.format(data);
//       venda.setDatavenda(dataformatada);
////         venda.setDatavenda();
//         Comvenda comvenda = new Comvenda();
//         comvenda.adiciona(venda);
// Desc_venda desc_venda = new Desc_venda(); 
//
//                Comdescvenda comdesc = new Comdescvenda();
//             desc_venda.setIdvenda(1); //pega o id da ultima venda
//             desc_venda.setIdproduto(1); //id do produto
//             desc_venda.setQtd((30)); //a quantidade tudo isso pra ta na nota
//               comdesc.adiciona(desc_venda); 
//Comcaixa comcaixa = new Comcaixa();
//        Caixa p = new Caixa();
//        p.setDinheiro(160.00);
//        p.setIdfuncionario(1);
//        p.setId(1);
//comcaixa.altera(p);
//Comvenda comvenda = new Comvenda();
//        for (Venda v : comvenda.getListacatpordata("14")) {
//            System.out.println(v.getDatavenda());
//        }
Redireciona r = new Redireciona();
r.setVisible(true);
}
}