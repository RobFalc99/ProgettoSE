
import org.apache.commons.math3.complex.ComplexFormat;


public class Calculator {

    Stack<Complex> stack;

    /**
     * An empty constructor
     */
    public Calculator() {
        stack = new Stack<>();
    }

    /**
     * A constructor which initialize the stack attribute to a passed Stack
     * parameter
     *
     * @param stack The stack to which initialize the attribute
     */
    public Calculator(Stack<Complex> stack) {
        this.stack = stack;
    }

    /**
     * Parse a string to a Complex number
     *
     * @param s The input string
     * @return A Complex representing the passed string
     */
    public Complex parse(String s) {
        ComplexFormat cf = new ComplexFormat();
        if (s.equals("i")) {
            s = "0+i";
        }
        if (s.contains("+i")) {
            s = s.replace("+i", "+1i");
        }
        if (s.contains("-i")) {
            s = s.replace("-i", "-1i");
        }
        if (!s.contains("i")) {
            s += "+0i";
        }
        if (s.matches("[" + "0123456789i.," + "]+")) {
            s = "0+" + s;
        }
        return new Complex(cf.parse(s.replace(".", ",")));
    }

    /**
     * Push a Complex number into the Stack
     *
     * @param s The Complex number, as a string, to be pushed
     */
    public void pushComplex(String s) {
        Complex c = parse(s);
        stack.push(c);
    }

    /**
     * Swap the second last Complex in the Stack with the last one
     */
    public void swapStackOperand() {
        stack.swapOperand();
    }

    /**
     * Pushes a new Complex number into the Stack, which is the result of the
     * subtraction between the second last Complex in the Stack and the last one
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex subComplex() {
        Complex c1 = stack.secondLast();
        Complex c2 = stack.top();
        Complex res = new Complex(c1.subtract(c2));
        stack.push(res);
        return res;
    }

    /**
     * Pushes a new Complex number into the Stack, which is the result of the
     * multiplication product between the second last Complex in the Stack and
     * the last one
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex mulComplex() {
        Complex c1 = stack.secondLast();
        Complex c2 = stack.top();
        Complex res = new Complex(c1.multiply(c2));
        stack.push(res);
        return res;
    }

    /**
     * Push a copy of the last Complex in the Stack
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex dupStackOperand() {
        Complex res = stack.dupOperand();
        return res;
    }

    /**
     * Pushes a new Complex number into the Stack, which is the result of the
     * addition between the second last Complex in the Stack and the last one
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex addComplex() {
        Complex c1 = stack.top();
        Complex c2 = stack.secondLast();
        Complex res = new Complex(c1.add(c2));
        stack.push(res);
        return res;
    }

    /**
     * Pushes a new Complex number into the Stack, which is the result of the
     * division between the second last Complex in the Stack and the last one
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex divComplex() {
        Complex c1 = stack.top();
        Complex c2 = stack.secondLast();
        Complex res = new Complex(c2.divide(c1));
        stack.push(res);
        return res;
    }

    /**
     * Remove all the Complex numbers from the Stack
     */
    public void clearStack() {
        stack.clear();
    }

    /**
     * Pushes a new Complex number into the Stack, which is the result of the
     * square root of the last Complex number in the Stack
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex sqrtComplex() {
        Complex c1 = stack.top();
        Complex res = new Complex(c1.sqrt());
        stack.push(res);
        return res;
    }

    /**
     * Pushes a new Complex number into the Stack, which is the result of the
     * reversal of sign of the last Complex number in the Stack
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex invSignComplex() {
        Complex c1 = stack.top();
        Complex res = new Complex(c1.negate());
        stack.push(res);
        return res;
    }

    /**
     * Remove the last Complex number from the Stack
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex dropStackOperand() {
        return stack.dropOperand();
    }
}
