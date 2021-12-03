
import org.apache.commons.math3.complex.ComplexFormat;

public class Calculator {

    private Stack<Complex> stack;
    private Variables variables;

    /**
     * An empty constructor
     */
    public Calculator() {
        stack = new Stack<>();
        variables = new Variables();
    }

    /**
     * A constructor which initialize the stack attribute to a passed Stack
     * parameter
     *
     * @param stack The stack to which initialize the attribute
     */
    public Calculator(Stack<Complex> stack) {
        this.stack = stack;
        variables = new Variables();
    }

    /**
     * Getter of the stack attribute
     *
     * @return The stack attribute
     */
    public Stack<Complex> getStack() {
        return stack;
    }

    /**
     * Getter of the variables attribute
     *
     * @return The variables hash map attribute
     */
    public Variables getVariables() {
        return variables;
    }

    /**
     * Parses a string to a Complex number
     *
     * @param s The input string
     * @return A Complex representing the passed string
     */
    public Complex parse(String s) {
        ComplexFormat cf = new ComplexFormat();
        if (s.equals("0")) {
            return new Complex(0);
        }
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
        if (s.startsWith("+")) {
            s = s.substring(1, s.length());
        }
        if (s.startsWith("-") && s.substring(1, s.length()).matches("[" + "0123456789i.," + "]+") && s.endsWith("i")) {
            s = "0-" + s.substring(1, s.length());
            return new Complex(cf.parse(s.replace(".", ",")));
        }
        if (s.matches("[" + "0123456789i.," + "]+")) {
            s = "0+" + s;
        }
        return new Complex(cf.parse(s.replace(".", ",")));
    }

    /**
     * Pushes a Complex number into the Stack
     *
     * @param s The Complex number, as a string, to be pushed
     */
    public void pushComplex(String s) {
        Complex c = parse(s);
        stack.push(c);
    }

    /**
     * Swaps the second last Complex in the Stack with the last one
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
        Complex c1 = stack.pop();
        Complex c2 = stack.pop();
        Complex res = new Complex(c2.subtract(c1));
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
        Complex c1 = stack.pop();
        Complex c2 = stack.pop();
        Complex res = new Complex(c2.multiply(c1));
        stack.push(res);
        return res;
    }

    /**
     * Pushes a copy of the last Complex in the Stack
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
        Complex c1 = stack.pop();
        Complex c2 = stack.pop();
        Complex res = new Complex(c2.add(c1));
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
        Complex c1 = stack.pop();
        Complex c2 = stack.pop();
        Complex res = new Complex(c2.divide(c1));
        stack.push(res);
        return res;
    }

    /**
     * Removes all the Complex numbers from the Stack
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
        Complex c1 = stack.pop();
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
        Complex c1 = stack.pop();
        Complex res = new Complex(c1.negate());
        stack.push(res);
        return res;
    }

    /**
     * Removes the last Complex number from the Stack
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex dropStackOperand() {
        return stack.dropOperand();
    }

    /**
     * Copies the second last element in the stack
     *
     * @return The Complex number pushed into the Stack
     */
    public Complex overStackOperand() {
        Complex ret = stack.overOperand();
        return ret;
    }

    /**
     * Sets a variable's value as the last element in the stack
     *
     * @param var The variable name
     * @return Complex saved in the variable
     */
    public Complex pushVariable(String var) {
        Complex ret = stack.top();
        return new Complex(variables.setVariable(var, ret));
    }

    /**
     * Loads a variable's value as an operand in the stack
     *
     * @param var The variable name
     * @return Complex pushed into the stack
     */
    public Complex loadVariable(String var) {
        Complex ret = new Complex(variables.getVariable(var));
        stack.push(ret);
        return ret;
    }

    /**
     * Update the value of the indicated variable as the sum of the current
     * value of the variable and the last operand in the Stack
     *
     * @param key The variable's name to be updated
     * @return The sum between the current value of the variable and the last
     * operand in the Stack
     */
    public Complex addToVariable(String key) {
        return new Complex(variables.addValue(key, stack.top()));
    }

    /**
     * Update the value of the indicated variable as the difference of the
     * current value of the variable and the last operand in the Stack
     *
     * @param key The variable's name to be updated
     * @return The difference between the current value of the variable and the
     * last operand in the Stack
     */
    public Complex subToVariable(String key) {
        return new Complex(variables.subValue(key, stack.top()));
    }

}
