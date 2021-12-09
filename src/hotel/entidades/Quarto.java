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
public class Quarto {
     private int andar;
    private int numero;
    private String tipo;
    private double diaria;

    /**
     * @return the andar
     */
    public int getAndar() {
        return andar;
    }

    /**
     * @param andar the andar to set
     */
    public void setAndar(int andar) {
        this.andar = andar;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the diaria
     */
    public double getDiaria() {
        return diaria;
    }

    /**
     * @param diaria the diaria to set
     */
    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
    
    public Quarto(int andar, int numero, String tipo, double diaria){
        this.andar=andar;
        this.numero=numero;
        this.tipo=tipo;
        this.diaria=diaria;
                
    }
}
