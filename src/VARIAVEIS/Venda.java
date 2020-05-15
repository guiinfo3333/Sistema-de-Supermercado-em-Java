/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VARIAVEIS;

/**
 *
 * @author ALUNO
 */
public class Venda {
    private int idvenda;
    private String datavenda;
    private int cat;
    private int idfunc;
    private String nomefunc;
    private String nomecat;
    private double tot_entrada;
    private double tot_saida;
    private int idcaixa;
    private String addn;
    private int qtdn;
    private Double valor;

    public String getAddn() {
        return addn;
    }

    public void setAddn(String addn) {
        this.addn = addn;
    }

    public int getQtdn() {
        return qtdn;
    }

    public void setQtdn(int qtdn) {
        this.qtdn = qtdn;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
  

    public int getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(int idcaixa) {
        this.idcaixa = idcaixa;
    }

   
    

    public double getTot_entrada() {
        return tot_entrada;
    }

    public void setTot_entrada(double tot_entrada) {
        this.tot_entrada = tot_entrada;
    }

    public double getTot_saida() {
        return tot_saida;
    }

    public void setTot_saida(double tot_saida) {
        this.tot_saida = tot_saida;
    }

    public String getNomefunc() {
        return nomefunc;
    }

    public void setNomefunc(String nomefunc) {
        this.nomefunc = nomefunc;
    }

    public String getNomecat() {
        return nomecat;
    }

    public void setNomecat(String nomecat) {
        this.nomecat = nomecat;
    }
    

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public String getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(String datavenda) {
        this.datavenda = datavenda;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getIdfunc() {
        return idfunc;
    }

    public void setIdfunc(int idfunc) {
        this.idfunc = idfunc;
    }
    
            
    
}
