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
    private UserOperation uo1;
    private UserOperation uo2;
    private ArrayList<String> operationsUo1;
    private ArrayList<String> operationsUo2;
    private Invoker instance;
    
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
        instance = new Invoker();
        operationsUo1=new ArrayList<>();
        operationsUo2=new ArrayList<>();
        uo1=new UserOperation("hypotenuse", operationsUo1);
        uo2=new UserOperation("solve2degree", operationsUo2);
        operationsUo1.add("dup");
        operationsUo1.add("*");
        operationsUo1.add("swap");
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of addUserOperation method, of class Invoker.
     */
    @Test
    public void testAddUserOperation() {
        System.out.println("addUserOperation");
        Boolean result=instance.addUserOperation(uo1);
        assertEquals(instance.getUserOperations().contains(uo1), result);
    }

    /**
     * Test of removeUserOperation method, of class Invoker.
     */
    @Test
    public void testRemoveUserOperation() {
        System.out.println("removeUserOperation");
        instance.addUserOperation(uo1);
        Boolean result=instance.removeUserOperation(uo1);
        assertEquals(!instance.getUserOperations().contains(uo1), result);
    }
    
}
