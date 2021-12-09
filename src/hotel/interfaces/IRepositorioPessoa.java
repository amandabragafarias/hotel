/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.interfaces;

import hotel.entidades.Pessoa;
import hotel.exceptions.PJCException;
import hotel.exceptions.PNEException;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public interface IRepositorioPessoa {
     public void cadastrarPessoa(Pessoa pessoa)throws PJCException;
    public void removerPessoaPorCpf(String cpf)throws PNEException;
    public Pessoa buscarPessoaPorCpf(String cpf)throws PNEException;
    public ArrayList<Pessoa> buscarPessoaPorNome(String nome)throws PNEException;
}
