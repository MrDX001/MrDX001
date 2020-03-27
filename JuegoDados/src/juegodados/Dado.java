/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

import java.util.Random;

/**
 *
 * @author Estudiantes
 */
public class Dado {
    private int valor;
    private int caras;
    public Dado(){
        this.caras = 6;
        this.valor = 0;
    }
    public Dado(int caras){
        this.caras = caras;
        this.valor = 0;
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public int getValor() {
        return valor;
    }
    
    public void lanzar(){
        Random r = new Random();
        this.valor = 1 + r.nextInt(this.caras);
    }
    
    
    
}
