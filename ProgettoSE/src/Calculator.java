
import org.apache.commons.math3.complex.ComplexFormat;


/*  Calculator.java
    24-nov-2021
    9.06.19
    FALCONE     */
public class Calculator {

    Stack<Complex> stack;

    public Calculator() {
        this.stack = new Stack<>();
    }

    public Calculator(Stack<Complex> stack) {
        this.stack = stack;
    }

    public Complex parse(String s) {
        ComplexFormat cf = new ComplexFormat();
        if (s.equals("i")){
            s="0+i";
        }
        if(s.contains("+i")){
            s=s.replace("+i", "+1i");
        }
        if(s.contains("-i")){
            s=s.replace("-i", "-1i");
        }
        if(!s.contains("i")){
            s+="+0i";
        }
        if(s.matches("[" + "0123456789i.,"+ "]+" )){
            s="0+"+s;
        }
        return new Complex(cf.parse(s.replace(".", ",")));
    }

    

    
    
    //==============================LUIGI
    public void pushComplex(String s) {
        Complex c = parse(s);
        stack.push(c);
    }
    //=============================ROB
    public void subComplex() {
        Complex firstOperand = stack.secondLast();
        Complex secondOperand = stack.top();
        stack.push(new Complex(firstOperand.subtract(secondOperand)));
    }
    public Complex mulComplex(){
        Complex firstOperand = stack.secondLast();
        Complex secondOperand = stack.top();
        Complex res = new Complex(firstOperand.multiply(secondOperand));
        stack.push(res);
        return res;
    }
    
    
    //==============================EUG
    public Complex addComplex(){
        Complex c1=stack.top();
        Complex c2=stack.secondLast();
        Complex sum = new Complex(c1.add(c2));
        stack.push(sum);
        return sum;
    }
    
    
    //=================================ADO
    

}
