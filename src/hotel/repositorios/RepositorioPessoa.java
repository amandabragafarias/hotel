/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.repositorios;

import hotel.entidades.Pessoa;
import hotel.exceptions.PJCException;
import hotel.exceptions.PNEException;
import hotel.interfaces.IRepositorioPessoa;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class RepositorioPessoa implements IRepositorioPessoa{

    ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    
    public void cadastrarPessoa(Pessoa pessoa) throws PJCException{
        try{
            buscarPessoaPorCpf(pessoa.getCpf());
            throw new PJCException();
        }catch(PNEException e){
            pessoas.add(pessoa);
        }
}
    public Pessoa buscarPessoaPorCpf(String cpf) throws PNEException{
         if(pessoas.size()>0){
           for(Pessoa pessoa: pessoas){
                if(pessoa.getCpf().equals(cpf)){
                    return pessoa;
                }
            }
        }
        throw new PNEException();
    }
    
    public void removerPessoaPorCpf(String cpf) throws PNEException{
       boolean aux = false;
		for(Pessoa pessoa: pessoas){
		if(pessoa.getCpf().equals(cpf)){
		pessoas.remove(pessoa);
			aux = true;
			break;
		}
		}
		if(!aux){
       throw new PNEException();
      }
    }
    
    public ArrayList<Pessoa> buscarPessoaPorNome(String nome) throws PNEException{
          ArrayList<Pessoa> aux = new ArrayList<Pessoa>();
        if(pessoas.size()>0){
            for(Pessoa pessoa:pessoas){
               if(pessoa.getNome().equals(nome)){
                    aux.add(pessoa);
                }
            }
        }
        if(aux.size()>0){
            return aux;
        }
         throw new PNEException();
        
    }

    
}
