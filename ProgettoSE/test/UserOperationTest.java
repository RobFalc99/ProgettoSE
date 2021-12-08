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

    Calculator calculator;
    UserOperation instance;

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
        ArrayList<String> operationsUo1 = new ArrayList<>();
        operationsUo1.add("dup");
        operationsUo1.add("*");
        calculator = new Calculator();
        instance = new UserOperation("op1", operationsUo1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class UserOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        calculator.pushComplex("5");
        instance.execute(calculator);
        assertEquals(calculator.getStack().top(), calculator.parse("25"));

    }

}
