
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class InvokerTest {

    private Calculator calculator;
    private UserOperation uo1;
    private UserOperation uo2;
    private ArrayList<String> operationsUo1;
    private ArrayList<String> operationsUo2;
    private ArrayList<String> operationsModifiedUo1;
    private Invoker instance;

    public InvokerTest() {
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
        instance = new Invoker();
        operationsUo1 = new ArrayList<>(Arrays.asList("dup", "*"));
        operationsUo2 = new ArrayList<>(Arrays.asList("dup", "*", "notAnOperation"));
        operationsModifiedUo1 = new ArrayList<>(Arrays.asList("dup", "+"));
        uo1 = new UserOperation("hypotenuse", operationsUo1);
        uo2 = new UserOperation("notACorrectUserOperation", operationsUo2);
    }

    /**
     * Test of addUserOperation method, of class Invoker.
     */
    @Test
    public void testAddUserOperation() {
        System.out.println("addUserOperation");
        Boolean result = instance.addUserOperation(uo1);
        assertEquals(instance.getUserOperations().contains(uo1), result);
    }

    /**
     * Test of removeUserOperation method, of class Invoker.
     */
    @Test
    public void testRemoveUserOperation() {
        System.out.println("removeUserOperation");
        instance.addUserOperation(uo1);
        Boolean result = instance.removeUserOperation(uo1);
        assertEquals(!instance.getUserOperations().contains(uo1), result);
    }

    /**
     * Test of execute method, of class UserOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        instance.addUserOperation(uo1);
        instance.addUserOperation(uo2);
        calculator.pushComplex("5");
        instance.execute("hypotenuse", calculator);
        assertEquals(calculator.getStack().top(), calculator.parse("25"));
        calculator.pushComplex("6");
        assertFalse(instance.execute("notACorrectUserOperation", calculator));
    }


    /**
     * Test of modifyUserOperation method, of class Invoker.
     */
    @Test
    public void testModifyUserOperation() {
        System.out.println("modifyUserOperation");
        instance.addUserOperation(uo1);
        instance.addUserOperation(uo2);
        assertTrue(instance.modifyUserOperation("hypotenuse", operationsModifiedUo1));
        calculator.pushComplex("3+4i");
        instance.execute(uo1.getName(), calculator);
        assertEquals(calculator.parse("6+8i"), calculator.getStack().top());
    }

}
