/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
public class InvokerTest {
    
    public InvokerTest() {
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
     * Test of getUserOperations method, of class Invoker.
     */
    @Test
    public void testGetUserOperations() {
        System.out.println("getUserOperations");
        Invoker instance = new Invoker();
        ArrayList<UserOperation> expResult = null;
        ArrayList<UserOperation> result = instance.getUserOperations();
    }
    
}
