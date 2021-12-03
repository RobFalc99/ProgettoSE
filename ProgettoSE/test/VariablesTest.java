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
 * @author luigi
 */
public class VariablesTest {
    private String key;
    private Complex value;
    private Variables instance;
    
    public VariablesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        key = "A";
        value = new Complex(2,3);
        instance = new Variables();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setVariables method, of class Variables.
     */
    @Test
    public void testSetVariables() {
        System.out.println("setVariables");
        instance.setVariable(key, value);
        assertEquals(value, instance.get(key));
    }


    /**
     * Test of getVariable method, of class Variables.
     */
    @Test
    public void testGetVariable() {   
        System.out.println("getVariable");
        instance.setVariable(key, value);
        assertEquals(value,instance.getVariable(key));
    }
    
}