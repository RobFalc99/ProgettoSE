
import org.apache.commons.math3.complex.Complex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    private Complex operand1;
    private Complex operand2;
    private Stack<Complex> instance;

    public StackTest() {
    }

    @Before
    public void setUp() {
        operand1 = new Complex(2.1, 4.3);
        operand2 = new Complex(5, 6);
        instance = new Stack<>();
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        instance.push(operand1);
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        instance.push(operand2);
        instance.push(operand1);
        Complex result = instance.pop();
        assertEquals(operand1, result);
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        instance.push(operand1);
        Complex result = instance.top();
        assertEquals(operand1, result);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Boolean result = instance.isEmpty();
        assertTrue(result);
    }

    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        instance.push(operand1);
        instance.clear();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of secondLast method, of class Stack.
     */
    @Test
    public void testSecondLast() {
        System.out.println("secondLast");
        instance.push(operand2);
        instance.push(operand2);
        instance.push(operand1);
        instance.push(operand2);
        Complex result = instance.secondLast();
        assertEquals(operand1, result);
    }

    /**
     * Test of dupOperand method, of class Stack.
     */
    @Test
    public void testDupOperand() {
        System.out.println("dupOperand");
        instance.push(operand1);
        Complex result = instance.dupOperand();
        assertEquals(operand1, result);
    }

    /**
     * Test of swapOperand method, of class Stack.
     */
    @Test
    public void testSwapOperand() {
        System.out.println("swapOperand");
        instance.push(operand1);
        instance.push(operand2);
        instance.swapOperand();
        Complex result = instance.top();
        assertEquals(operand1, result);
    }

    /**
     * Test of dropOperand method, of class Stack.
     */
    @Test
    public void testDropOperand() {
        System.out.println("dropOperand");
        instance.push(operand1);
        Complex result = instance.dropOperand();
        assertEquals(operand1, result);
    }

    /**
     * Test of overOperand method, of class Stack.
     */
    @Test
    public void testOverOperand() {
        System.out.println("overOperand");
        Complex second = new Complex(2, 1);
        instance.push(operand1);
        instance.push(second);
        Object result = instance.overOperand();
        assertEquals(operand1, result);
    }

}
