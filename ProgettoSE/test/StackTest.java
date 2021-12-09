
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
        instance.push(operand2);
        assertEquals(operand2, instance.top());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        instance.push(operand1);
        instance.push(operand2);
        instance.pop();
        assertEquals(operand1, instance.top());
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        instance.push(operand2);
        instance.push(operand1);
        assertEquals(operand1, instance.top());
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        instance.push(operand1);
        instance.push(operand2);
        instance.pop();
        instance.pop();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        instance.push(operand1);
        instance.push(operand2);
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
        assertEquals(operand1, instance.secondLast());
    }

    /**
     * Test of dupOperand method, of class Stack.
     */
    @Test
    public void testDupOperand() {
        System.out.println("dupOperand");
        instance.push(operand1);
        instance.dupOperand();
        assertEquals(instance.top(), instance.secondLast());
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
        assertEquals(operand1, instance.top());
    }

    /**
     * Test of dropOperand method, of class Stack.
     */
    @Test
    public void testDropOperand() {
        System.out.println("dropOperand");
        instance.push(operand1);
        instance.push(operand2);
        instance.dropOperand();
        assertEquals(operand1, instance.top());
    }

    /**
     * Test of overOperand method, of class Stack.
     */
    @Test
    public void testOverOperand() {
        System.out.println("overOperand");
        instance.push(operand1);
        instance.push(operand2);
        assertEquals(operand1, instance.overOperand());
    }

}
