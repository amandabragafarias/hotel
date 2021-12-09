/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.repositorios;

import hotel.entidades.Quarto;
import hotel.exceptions.QJCException;
import hotel.exceptions.QNEException;
import hotel.interfaces.IRepositorioQuarto;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class RepositorioQuarto implements IRepositorioQuarto{

    ArrayList<Quarto> quartos = new ArrayList<>();
    
    public void cadastrarQuarto(Quarto quarto) throws QJCException {
        try{
            buscarQuartoPorNumero(quarto.getNumero());
            throw new QJCException();
        }catch(QNEException e){
            quartos.add(quarto);
        }
    }
    public Quarto buscarQuartoPorNumero(int numero)throws QNEException{
         for (Quarto quarto : quartos) {
            if (quarto.getNumero()==numero) {
                return quarto;
            }
        }
        throw new QNEException();
    
        
        
    }
    public void removerQuartoPorNumero(int numero)throws QNEException{
        boolean aux = false;
		for(Quarto quarto: quartos){
			if(quarto.getNumero()==(numero)){
				quartos.remove(quarto);
				aux = true;
				break;
			}
		}
		if(!aux){
         throw new QNEException();
        
    }
        
    }
    
    public ArrayList<Quarto> buscarQuartoPorAndar(int andar)throws QNEException{
        ArrayList<Quarto> aux = new ArrayList<Quarto>();
        if(quartos.size()>0){
            for(Quarto quarto:quartos){
                if(quarto.getAndar()==andar){
                    aux.add(quarto);
                }
            }
        }
        if(aux.size()>0){
            return aux;
        }
        throw new QNEException();
        
        
    }
    
}
