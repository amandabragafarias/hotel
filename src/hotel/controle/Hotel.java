/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controle;

import hotel.entidades.Pessoa;
import hotel.entidades.Quarto;
import hotel.entidades.Reserva;
import hotel.exceptions.DIException;
import hotel.exceptions.PJCException;
import hotel.exceptions.PNEException;
import hotel.exceptions.QJCException;
import hotel.exceptions.QJRException;
import hotel.exceptions.QNEException;
import hotel.exceptions.RNEException;
import hotel.interfaces.IRepositorioPessoa;
import hotel.interfaces.IRepositorioQuarto;
import hotel.interfaces.IRepositorioReserva;
import hotel.repositorios.RepositorioPessoa;
import hotel.repositorios.RepositorioQuarto;
import hotel.repositorios.RepositorioReserva;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class Hotel {
    
    IRepositorioQuarto repositorioQuartos = new RepositorioQuarto();
    public void cadastrarQuarto(Quarto quarto)throws QJCException{
        repositorioQuartos.cadastrarQuarto(quarto);
    }
    public Quarto buscarQuartoPorNumero(int numero)throws QNEException{
        return repositorioQuartos.buscarQuartoPorNumero(numero);
    }
    public void removerQuartoPorNumero(int numero)throws QNEException{
        repositorioQuartos.removerQuartoPorNumero(numero);
    }
    public ArrayList<Quarto> buscarQuartoPorAndar(int andar)throws QNEException{
        return repositorioQuartos.buscarQuartoPorAndar(andar);
    }
    
    IRepositorioPessoa repositorioPessoas = new RepositorioPessoa();
    public void cadastrarPessoa(Pessoa pessoa)throws PJCException{
        repositorioPessoas.cadastrarPessoa(pessoa);
    }
     public void removerPessoaPorCpf(String cpf)throws PNEException{
         repositorioPessoas.removerPessoaPorCpf(cpf);
     }
     public Pessoa buscarPessoaPorCpf(String cpf)throws PNEException{
         return repositorioPessoas.buscarPessoaPorCpf(cpf);
     }
     public ArrayList<Pessoa> buscarPessoaPorNome(String nome)throws PNEException{
         return repositorioPessoas.buscarPessoaPorNome(nome);
     }
    
     IRepositorioReserva repositorioReservas = new RepositorioReserva();
     public void reservarQuarto(Reserva reserva)throws QJRException, DIException{
         repositorioReservas.reservarQuarto(reserva);
     }
      public void cancelarReserva(String codigo)throws RNEException{
          repositorioReservas.cancelarReserva(codigo);
      }
      public Reserva buscarReservaPorCodigo(String codigo)throws RNEException{
          return repositorioReservas.buscarReservaPorCodigo(codigo);
      }
      public ArrayList<Reserva> buscarReservaPorQuarto(int numero)throws RNEException{
          return repositorioReservas.buscarReservaPorQuarto(numero);
      }
        public ArrayList<Reserva> buscarReservaPorCpfPessoa(String cpf)throws RNEException{
            return repositorioReservas.buscarReservaPorCpfPessoa(cpf);
        }
        public int retornarCodigo(){
            return repositorioReservas.retornarCodigo();
        }
}
