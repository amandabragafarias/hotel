                                                                                                                                                             /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.repositorios;

import hotel.entidades.Pessoa;
import hotel.entidades.Quarto;
import hotel.entidades.Reserva;
import hotel.exceptions.DIException;
import hotel.exceptions.PNEException;
import hotel.exceptions.QJRException;
import hotel.exceptions.RNEException;
import hotel.interfaces.IRepositorioReserva;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Amanda
 */
public class RepositorioReserva implements IRepositorioReserva {

    ArrayList<Reserva> reservas = new ArrayList<>();
    int cod = 0;

    public int retornarCodigo() {
        return cod;
    }

  
    public void reservarQuarto(Reserva reserva) throws QJRException, DIException{
        try {
            buscarReservaPorQuarto(reserva.getQuarto().getNumero());
            throw new QJRException();            
        }catch(RNEException e){
        boolean cadastro = false;
        
            if(reserva.getDataDevolucao().getYear()>reserva.getDataDoAluguel().getYear()){
            cadastro = true;
            
        }else if(reserva.getDataDevolucao().getYear()==reserva.getDataDoAluguel().getYear()){
           if(reserva.getDataDevolucao().getMonth()>reserva.getDataDoAluguel().getMonth()){   
          
            cadastro = true;
           }
           else if(reserva.getDataDevolucao().getMonth()==reserva.getDataDoAluguel().getMonth()){
               if(reserva.getDataDevolucao().getDate()>=reserva.getDataDoAluguel().getDate())
                cadastro = true;
            }
            
        }
            if(cadastro == true){
                reservas.add(reserva);
                cod++;
            }else{
                throw new DIException();
            }
        }
    }

    public void cancelarReserva(String codigo) throws RNEException {
        boolean aux = false;
        for (Reserva reserva : reservas) {
            if (reserva.getCodigo().equals(codigo)) {
                reservas.remove(reserva);
                aux = true;
                break;

            }
        }
        if (!aux) {
            throw new RNEException();
        }
    }

    public Reserva buscarReservaPorCodigo(String codigo) throws RNEException {
        if (reservas.size() > 0) {
            for (Reserva reserva : reservas) {
                if (reserva.getCodigo().equals(codigo)) {
                    return reserva;
                }
            }
        }
        throw new RNEException();

    }

    public ArrayList<Reserva> buscarReservaPorQuarto(int numero) throws RNEException {
        ArrayList<Reserva> aux = new ArrayList<Reserva>();
        if (reservas.size() > 0) {
            for (Reserva reserva : reservas) {
                Quarto quarto = reserva.getQuarto();
                if (quarto.getNumero() == numero) {
                    aux.add(reserva);
                }
            }
        }
        if (aux.size() > 0) {
            return aux;
        }
        throw new RNEException();

    }

    public ArrayList<Reserva> buscarReservaPorCpfPessoa(String cpf) throws RNEException {
        ArrayList<Reserva> aux = new ArrayList<Reserva>();
        if (reservas.size() > 0) {
            for (Reserva reserva : reservas) {
                Pessoa pessoa = reserva.getPessoa();
                if (pessoa.getCpf().equals(cpf)) {
                    aux.add(reserva);
                }
            }
        }
        if (aux.size() > 0) {
            return aux;
        }
        throw new RNEException();

    }

}
