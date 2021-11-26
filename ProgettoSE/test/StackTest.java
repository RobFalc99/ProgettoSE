/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FALCONE
 */
public class StackTest {

    public StackTest() {
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
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Complex c = new Complex(2.1, 4.3);
        Stack<Complex> instance = new Stack<>();
        instance.push(c);
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack<Complex> instance = new Stack<>();
        instance.push(new Complex(1,2));
        Complex expResult = new Complex(2.1, 4.3);
        instance.push(expResult);
        Complex result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        Stack<Complex> instance = new Stack<>();
        Complex expResult = new Complex(2.1, 4.3);
        instance.push(expResult);
        Complex result = instance.top();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Stack<Complex> instance = new Stack<>();
        Boolean expResult = true;
        Boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Stack<Complex> instance = new Stack<>();
        Complex expResult = new Complex(2.1, 4.3);
        instance.push(expResult);
        instance.clear();
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSecondLast() {
        System.out.println("secondLast");
        Stack<Complex> instance = new Stack<>();
        instance.push(new Complex(5,6));
        instance.push(new Complex(5,6));
        Complex expResult = new Complex(2.1,4.3);
        instance.push(expResult);
        instance.push(new Complex(3.2,5.1));
        Complex result = instance.secondLast();
        assertEquals(expResult, result);
        
    }


    /**
     * Test of dupOperand method, of class Stack.
     */
    @Test
    public void testDupOperand() {
        System.out.println("dupOperand");
        Stack instance = new Stack();
        Object expResult = new Complex(1,4);
        instance.push(expResult);
        Object result = instance.dupOperand();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of swapOperand method, of class Stack.
     */
    @Test
    public void testSwapOperand() {
        System.out.println("swapOperand");
        Stack <Complex> instance = new Stack<>();
        instance.push(new Complex(2.1,4.3));
        instance.push(new Complex(5,6));
        Complex expResult = new Complex(2.1,4.3);
        instance.swapOperand();
        Complex result = instance.top();
        assertEquals(expResult,result);
    }

}
