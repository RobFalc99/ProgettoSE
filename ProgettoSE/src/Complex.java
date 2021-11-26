/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Eugenio
 */
public class Complex extends org.apache.commons.math3.complex.Complex{
    
    public Complex(double real) {
        super(real);
    }
    public Complex(org.apache.commons.math3.complex.Complex c){
        super(c.getReal(), c.getImaginary());
    }



    @Override
    public String toString() {
        String comp="";
        if (this.getReal()==0 && this.getImaginary()==0){
            comp+="0+i";
            return comp;
        }
        if (this.getReal()!=0){
            comp+=Double.toString(this.getReal());
        }        
        if (this.getImaginary()<0){
            comp+=Double.toString(this.getImaginary())+"i";
        }
        else if(this.getImaginary()>0){
            comp+="+"+Double.toString(this.getImaginary())+"i";
        }
        return comp;
    }
        
    
}
