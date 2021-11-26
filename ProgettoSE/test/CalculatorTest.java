/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Complex expResult = new Complex(3,4);
        Complex result = instance.parse(s);
        assertEquals(expResult, result);
    }
    /**
     * Test of pushComplex method, of class Calculator.
     */
    @Test
    public void testPushComplex (){
        System.out.println("pushComplex");
        String s = "3+4i";
        Calculator instance = new Calculator();
        Complex expResult = new Complex(3,4);
        instance.pushComplex(s);
        Complex result = instance.stack.top();
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
        String s1= "5,3+2i";
        String s2= "4,2+1,5i";
        instance.pushComplex(s);
        instance.pushComplex(s1);
        instance.pushComplex(s2);
        Complex expResult = new Complex(9.5, 3.5);
        Complex result = instance.addComplex();
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
        Complex expResult = new Complex(3,4);
        instance.swapStackOperand();
        Complex result = instance.stack.top();
        assertEquals(expResult, result);    
    }
}
