import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
 
public class CalculatorTest {
    private Calculator instance;
    private String operand1;
    private String operand2;
 
    public CalculatorTest() {
    }

    @Before
    public void setUp() {
        instance=new Calculator();
        operand1="3+4i";
        operand2="5,3+2i";
    }

    
    /**
     * Test of parse method, of class Calculator.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        assertEquals(new Complex(3,4), instance.parse(operand1));
    }
 
    /**
     * Test of pushComplex method, of class Calculator.
     */
    @Test
    public void testPushComplex() {
        System.out.println("pushComplex");
        instance.pushComplex(operand1);
        assertEquals(new Complex(3, 4), instance.getStack().top());
    }
 
    /**
     * Test of addComplex method, of class Calculator.
     */
    @Test
    public void testAddComplex() {
        System.out.println("addComplex");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        assertEquals(new Complex(8.3, 6), instance.addComplex());
 
    }
 
    /**
     * Test of divComplex method, of class Calculator.
     */
    @Test
    public void testDivComplex() {
        System.out.println("divComplex");
        instance.pushComplex(operand2);
        instance.pushComplex(operand1);
        assertEquals(new Complex(0.956, -0.608), instance.divComplex());
    }
 
    /**
     * Test of subComplex method, of class Calculator.
     */
    @Test
    public void testSubComplex() {
        System.out.println("subComplex");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        instance.subComplex();
        assertEquals(new Complex(-2.3, 2), instance.getStack().pop());
    }
 
    /**
     * Test of mulComplex method, of class Calculator.
     */
    @Test
    public void testMulComplex() {
        System.out.println("mulComplex");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        instance.mulComplex();
        Assert.assertEquals(7.9, instance.getStack().top().getReal(), 0.02);
        Assert.assertEquals(27.2, instance.getStack().top().getImaginary(), 0.02);
    }
 
    /**
     * Test of sqrtComplex method, of class Calculator.
     */
    @Test
    public void testSqrtComplex() {
        System.out.println("sqrtComplex");
        instance.pushComplex(operand1);
        assertEquals(new Complex(2, 1), instance.sqrtComplex());
    }
 
    /**
     * Test of dupStackOperand method, of class Calculator.
     */
    @Test
    public void testDupStackOperand() {
        System.out.println("dupStackOperand");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        assertEquals(new Complex(5.3, 2), instance.dupStackOperand());
    }
 
    /**
     * Test of swapStackOperand method, of class Calculator.
     */
    @Test
    public void testSwapStackOperand() {
        System.out.println("swapStackOperand");
        Calculator instance = new Calculator();
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        instance.swapStackOperand();
        assertEquals(new Complex(3, 4), instance.getStack().top());
    }
 
    /**
     * Test of invSignComplex method, of class Calculator.
     */
    @Test
    public void testInvSignComplex() {
        System.out.println("invSignComplex");
        instance.pushComplex(operand1);
        assertEquals(new Complex(-3, -4), instance.invSignComplex());
 
    }
 
    /**
     * Test of dropStackOperand method, of class Calculator.
     */
    @Test
    public void testDropStackOperand() {
        System.out.println("dropStackOperand");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        assertEquals(new Complex(5.3, 2), instance.dropStackOperand());
 
    }
    
    /**
     * Test of overStackOperand method, of class Calculator.
     */
    @Test
    public void testOverStackOperand() {
       System.out.println("overStackOperand");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        assertEquals(new Complex(3,4), instance.overStackOperand());
    }
    
    /**
     * Test of clearStack method, of class Calculator.
     */
    @Test
    public void testClearStack() {
        System.out.println("clearStack");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        instance.clearStack();
        assertTrue(instance.getStack().isEmpty());
    }

    /**
     * Test of pushVariable method, of class Calculator.
     */
    @Test
    public void testPushVariable() {
        System.out.println("pushVariable");
        instance.pushComplex(operand1);
        instance.pushVariable("A");
        Complex result = instance.getVariables().get("A");
        assertEquals(new Complex(3,4), result);
    }

    /**
     * Test of loadVariable method, of class Calculator.
     */
    @Test
    public void testLoadVariable() {
        System.out.println("loadVariable");
        instance.pushComplex(operand1);
        instance.pushComplex(operand2);
        instance.pushVariable("A");
        instance.dropStackOperand();
        instance.loadVariable("A");
        Complex result = instance.getStack().top();
        assertEquals(new Complex(5.3,2), result);
    }

}