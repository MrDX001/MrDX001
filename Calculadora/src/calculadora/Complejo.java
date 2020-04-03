/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class Complejo {
    private float parteReal;
    private float parteImaginario;

    public float getParteReal() {
        return parteReal;
    }

    public void setParteReal(float parteReal) {
        this.parteReal = parteReal;
    }

    public float getParteImaginario() {
        return parteImaginario;
    }

    public void setParteImaginario(float parteImaginario) {
        this.parteImaginario = parteImaginario;
    }
    
    
    public Complejo(){
        this.parteReal = 0;
        this.parteImaginario = 0;
    }
    public Complejo(float parteReal, float parteImaginaria){
        this.parteReal = parteReal;
        this.parteImaginario = parteImaginaria;
    }
    public Complejo(Complejo c1){
        this.parteReal = c1.parteReal;
        this.parteImaginario = c1.parteImaginario;
    }
    
    public Complejo suma(Complejo c1){
       return new Complejo(this.parteReal + c1.parteReal, this.parteImaginario + c1.parteImaginario);
    }
    public Complejo resta(Complejo c1){
       return new Complejo(this.parteReal - c1.parteReal, this.parteImaginario - c1.parteImaginario);
    }
    public Complejo conjugado(){
       return new Complejo(this.parteReal,this.parteImaginario * -1);
    }
    public Complejo multiplicacion(Complejo c1){
       return new Complejo((this.parteReal * c1.parteReal) + ((this.parteImaginario * c1.parteImaginario)*-1),(this.parteReal * c1.parteImaginario) + (this.parteImaginario * c1.parteReal));
    }
    public Complejo dividir(Complejo numInt){
        Complejo num = this.multiplicacion(numInt.conjugado());
        Complejo den = numInt.multiplicacion(numInt.conjugado());
	return new Complejo(num.parteReal / den.parteReal, num.parteImaginario / den.parteReal); 
    }
    public double norma(){
        return Math.sqrt((this.parteReal * this.parteReal) + (this.parteImaginario*this.parteImaginario));
    }
    public String imprimir(){
        if(this.parteReal != 0 && this.parteImaginario > 0){
            return (this.parteReal + " + " + this.parteImaginario + "i");
        }
        else if(this.parteReal != 0 && this.parteImaginario < 0){
            return (this.parteReal + " - " + (this.parteImaginario*-1) + "i");
        }
        else if(this.parteReal == 0){
            return (this.parteImaginario + "i");
        }
        else if(this.parteImaginario == 0){
            return String.valueOf(this.parteReal);
        }
        else{
            return "";
        }
    }
    public void leer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la parte real:");
        this.parteReal = sc.nextFloat();
        System.out.println("Ingrese la parte imaginaria:");
        this.parteImaginario = sc.nextFloat();
    }

      
    
    
    
}