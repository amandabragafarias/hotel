/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entidades;

/**
 *
 * @author Amanda
 */
public class PessoaVip extends Pessoa{
       private double taxaDesconto;
    

    /**
     * @return the taxaDesconto
     */
    public double getTaxaDesconto() {
        return taxaDesconto;
    }

    /**
     * @param taxaDesconto the taxaDesconto to set
     */
    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }
    public PessoaVip(String nome, String sexo, String cpf, double taxaDesconto){
        super(nome, sexo, cpf);
        this.taxaDesconto=taxaDesconto;
    }
}
