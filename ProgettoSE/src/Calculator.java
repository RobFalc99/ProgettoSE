
import org.apache.commons.math3.complex.Complex;
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
        return cf.parse(s);
    }

    public void pushComplex(String s) {
        Complex c = parse(s);
        stack.push(c);
    }

    public void subComplex() {
        Complex firstOperand = stack.secondLast();
        Complex secondOperand = stack.top();
        stack.push(firstOperand.subtract(secondOperand));
    }
    
    public Complex mulComplex(){
        Complex firstOperand = stack.secondLast();
        Complex secondOperand = stack.top();
        Complex res = firstOperand.multiply(secondOperand);
        stack.push(res);
        return res;
    }
}
