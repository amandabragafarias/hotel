/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entidades;

import java.util.Date;

/**
 *
 * @author Amanda
 */
public class Reserva {
    private Pessoa pessoa;
    private Quarto quarto;
    private Date dataDoAluguel;
    private Date dataDevolucao;
    private String codigo;
    private double valorReserva;

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the quarto
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    /**
     * @return the dataDoAluguel
     */
    public Date getDataDoAluguel() {
        return dataDoAluguel;
    }

    /**
     * @param dataDoAluguel the dataDoAluguel to set
     */
    public void setDataDoAluguel(Date dataDoAluguel) {
        this.dataDoAluguel = dataDoAluguel;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the valorReserva
     */
    public double getValorReserva() {
        return valorReserva;
    }

    /**
     * @param valorReserva the valorReserva to set
     */
    public void setValorReserva(double valorReserva) {
        this.valorReserva = valorReserva;
    }
    
    public Reserva(Pessoa pessoa, Quarto quarto, Date dataDoAluguel, Date dataDevolucao, String codigo, double valorReserva){
        this.pessoa=pessoa;
        this.quarto=quarto;
        this.dataDoAluguel=dataDoAluguel;
        this.dataDevolucao=dataDevolucao;
        this.codigo=codigo;
        this.valorReserva=valorReserva;
    }
}
