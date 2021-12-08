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
public class UserOperationTest {
    
    public UserOperationTest() {
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
     * Test of getName method, of class UserOperation.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UserOperation instance = new UserOperation();
        String expResult = "";
        String result = instance.getName();
    }

    /**
     * Test of setName method, of class UserOperation.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UserOperation instance = new UserOperation();
        instance.setName(name);
    }

    /**
     * Test of getOperations method, of class UserOperation.
     */
    @Test
    public void testGetOperations() {
        System.out.println("getOperations");
        UserOperation instance = new UserOperation();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getOperations();
    }

    /**
     * Test of setOperations method, of class UserOperation.
     */
    @Test
    public void testSetOperations() {
        System.out.println("setOperations");
        ArrayList<String> operations = null;
        UserOperation instance = new UserOperation();
        instance.setOperations(operations);
    }
    
}
