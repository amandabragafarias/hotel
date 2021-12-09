/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.interfaces;

import hotel.entidades.Reserva;
import hotel.exceptions.DIException;
import hotel.exceptions.PNEException;
import hotel.exceptions.QJRException;
import hotel.exceptions.RNEException;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public interface IRepositorioReserva {
      public void reservarQuarto(Reserva reserva)throws QJRException, DIException;
    public void cancelarReserva(String codigo)throws RNEException;
    public Reserva buscarReservaPorCodigo(String codigo)throws RNEException;
    public ArrayList<Reserva> buscarReservaPorQuarto(int numero)throws RNEException;
    public ArrayList<Reserva> buscarReservaPorCpfPessoa(String cpf)throws RNEException;
    public int retornarCodigo();
}
