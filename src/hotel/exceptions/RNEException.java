/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.exceptions;

/**
 *
 * @author Amanda
 */
public class RNEException extends Exception{
    public RNEException(){
        super("Reserva não encontrada.");
    }
}
