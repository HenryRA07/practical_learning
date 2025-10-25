/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.poo.practical_learning.problems;

/**
 *
 * @author HenryDev (Jeam Henry Romero Aguilar)
 */

public class QuadraticEquation {
    
    private Double a; 
    private Double b; 
    private Double c;

    public QuadraticEquation(Double a, Double b, Double c) {
        
        if (a == 0){
            throw new IllegalArgumentException("El valor del coeficiente 'a' no puede ser cero");
        } 
        setA(a);
        setB(b);
        setC(c);
    }
    
    public double getDiscriminant(){
        return Math.pow(this.b, 2) - 4*(this.a * this.c) ;
    }
    
    
    public String getRoots(){
        double d = getDiscriminant();
        if(d > 0) {
            double x1 = (-this.b + Math.sqrt(d)) / (2*this.a);
            
            double x2 = (-this.b - Math.sqrt(d)) / ( 2*this.a); 
           
            return "Dos raices reales y distintas: " + x1 + " y " + x2;
            
        }else if (d == 0 ){
            double raizDoble = - (this.b)/ (2*this.a);  
            return "Raiz doble: " + raizDoble;
        } else if (d < 0) {
            return "Raices complejas";
        }
       return null;
    }
    
    
    
    public Double getA() {
        return a;
    }

    public final void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public final void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public final void setC(Double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("%.0fx^2 %+.0fx %+.0f", this.a, this.b, this.c);
    }
    
}
