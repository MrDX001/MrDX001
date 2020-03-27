/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

/**
 *
 * @author Estudiantes
 */
public class Juego {
    private Dado dado1;
    private Dado dado2;
    private Jugador jug1;
    private int valApostado;
    
    private int prevDado;
    private int numLanza;
    private int estado;
    
    
    public Juego(Jugador jug1, int valApostado){
        this.jug1 = jug1;
        this.valApostado = valApostado;
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        
        this.prevDado = 0;
        this.numLanza = 0;
        this.estado = 0;
    }
    
    public void lanzar(){
        this.dado1.lanzar();
        this.dado2.lanzar();
        this.numLanza++;
        int resDado = this.dado1.getValor() + this.dado2.getValor();
        if((resDado == 7 || resDado == 11) && this.numLanza == 1){
            //Gana
            this.estado = 1;
        }
        else if((resDado == 2 || resDado == 3 || resDado == 12) && this.numLanza == 1){
            //Pierde
            this.valApostado = this.valApostado * -1;
            this.estado = 2;
        }
        else if(this.numLanza == 1){
            this.prevDado = resDado; 
        }
        else{
            if(resDado == this.prevDado){
                this.estado = 1;
            }
            else if(resDado == 7){
                this.valApostado = this.valApostado * -1;
                this.estado = 2;
            }        
        }
    }
    public void terminarJuegoAntes(){
        this.valApostado = this.valApostado * -1;
        this.estado = 2;
    }

    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    }

    public int getValApostado() {
        return valApostado;
    }

    public Jugador getJug1() {
        return jug1;
    }

    public int getEstado() {
        return estado;
    }
    
    
    
}
