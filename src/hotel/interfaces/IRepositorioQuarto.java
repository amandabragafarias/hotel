/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.interfaces;

import hotel.entidades.Quarto;
import hotel.exceptions.QJCException;
import hotel.exceptions.QNEException;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public interface IRepositorioQuarto {
    public void cadastrarQuarto(Quarto quarto) throws QJCException;
      public Quarto buscarQuartoPorNumero(int numero)throws QNEException;
      public void removerQuartoPorNumero(int numero)throws QNEException;
      public ArrayList<Quarto> buscarQuartoPorAndar(int andar)throws QNEException;
}
