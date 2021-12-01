import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CalculatorTest {

    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class Calculator.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        String s = "3+4i";
        Calculator instance = new Calculator();
        Complex expResult = new Complex(3, 4);
        Complex result = instance.parse(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of pushComplex method, of class Calculator.
     */
    @Test
    public void testPushComplex() {
        System.out.println("pushComplex");
        String s = "3+4i";
        Calculator instance = new Calculator();
        Complex expResult = new Complex(3, 4);
        instance.pushComplex(s);
        Complex result = instance.getStack().top();
        assertEquals(expResult, result);
    }

    /**
     * Test of addComplex method, of class Calculator.
     */
    @Test
    public void testAddComplex() {
        System.out.println("addComplex");
        Calculator instance = new Calculator();
        String s = "3+4i";
        String s1 = "5,3+2i";
        String s2 = "4,2+1,5i";
        instance.pushComplex(s);
        instance.pushComplex(s1);
        instance.pushComplex(s2);
        Complex expResult = new Complex(9.5, 3.5);
        Complex result = instance.addComplex();
        assertEquals(expResult, result);

    }

    /**
     * Test of divComplex method, of class Calculator.
     */
    @Test
    public void testDivComplex() {
        System.out.println("divComplex");
        Calculator instance = new Calculator();
        String s = "3+4i";
        String s1 = "5,3+2i";
        instance.pushComplex(s1);
        instance.pushComplex(s);
        Complex expResult = new Complex(0.956, -0.608);
        Complex result = instance.divComplex();
        assertEquals(expResult, result);
    }

    /**
     * Test of subComplex method, of class Calculator.
     */
    @Test
    public void testSubComplex() {
        System.out.println("subComplex");
        Calculator instance = new Calculator();
        instance.pushComplex("3+4i");
        instance.pushComplex("2+3i");
        instance.subComplex();
        Complex expResult = new Complex(1, 1);
        Complex result = instance.getStack().pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of mulComplex method, of class Calculator.
     */
    @Test
    public void testMulComplex() {
        System.out.println("mulComplex");
        Calculator instance = new Calculator();
        instance.pushComplex("3+4i");
        instance.pushComplex("2+3i");
        instance.mulComplex();
        Complex expResult = new Complex(-6, 17);
        Complex result = instance.getStack().pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of clearStack method, of class Calculator.
     */
    @Test
    public void testClearStack() {
        System.out.println("clearStack");
        Calculator instance = new Calculator();
        String s = "3+4i";
        String s1 = "5,3+2i";
        instance.pushComplex(s1);
        instance.pushComplex(s);
        instance.clearStack();
        assertTrue(instance.getStack().isEmpty());
    }

    /**
     * Test of sqrtComplex method, of class Calculator.
     */
    @Test
    public void testSqrtComplex() {
        System.out.println("sqrtComplex");
        Calculator instance = new Calculator();
        instance.pushComplex("4+8i");
        Complex expResult = new Complex(2.544039299028138, 1.5723027555148466);
        Complex result = instance.sqrtComplex();
        assertEquals(expResult, result);
    }

    /**
     * Test of dupStackOperand method, of class Calculator.
     */
    @Test
    public void testDupStackOperand() {
        System.out.println("dupStackOperand");
        Calculator instance = new Calculator();
        instance.pushComplex("4+5i");
        Complex expResult = new Complex(4, 5);
        Complex result = instance.dupStackOperand();
        assertEquals(expResult, result);
    }

    /**
     * Test of swapStackOperand method, of class Calculator.
     */
    @Test
    public void testSwapStackOperand() {
        System.out.println("swapStackOperand");
        Calculator instance = new Calculator();
        instance.pushComplex("3+4i");
        instance.pushComplex("5,3+2i");
        Complex expResult = new Complex(3, 4);
        instance.swapStackOperand();
        Complex result = instance.getStack().top();
        assertEquals(expResult, result);
    }

    /**
     * Test of invSignComplex method, of class Calculator.
     */
    @Test
    public void testInvSignComplex() {
        System.out.println("invSignComplex");
        Calculator instance = new Calculator();
        instance.pushComplex("5+2i");
        Complex expResult = new Complex(-5, -2);
        Complex result = instance.invSignComplex();
        assertEquals(expResult, result);

    }

    /**
     * Test of dropStackOperand method, of class Calculator.
     */
    @Test
    public void testDropStackOperand() {
        System.out.println("dropStackOperand");
        Calculator instance = new Calculator();
        instance.pushComplex("3+2i");
        Complex expResult = new Complex(3, 5);
        instance.pushComplex("3+5i");
        Complex result = instance.dropStackOperand();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testOverStackOperand() {
       System.out.println("overStackOperand");
        Calculator instance = new Calculator();
        instance.pushComplex("3+2i");
        instance.pushComplex("1+4i");
        Complex expResult =new Complex(3,2);
        Complex result = instance.overStackOperand();
        assertEquals(expResult, result);
    }
}
