
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserOperationTest {

    Calculator calculator;
    UserOperation instance1;
    UserOperation instance2;
    
    ArrayList<String> operationsUo1;
    ArrayList<String> operationsUo2;

    public UserOperationTest() {
    }

    @Before
    public void setUp() {
        operationsUo1 = new ArrayList<>(Arrays.asList("dup","*"));
        operationsUo2 = new ArrayList<>(Arrays.asList("dup","*","swap", "ciao"));
        calculator = new Calculator();
        instance1 = new UserOperation("op1", operationsUo1);
        instance2 = new UserOperation("op2", operationsUo2);
    }

    /**
     * Test of execute method, of class UserOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        calculator.pushComplex("5");
        instance1.execute(calculator);
        assertEquals(calculator.getStack().top(), calculator.parse("25"));
        calculator.pushComplex("6");
        assertFalse(instance2.execute(calculator));
    }

}
