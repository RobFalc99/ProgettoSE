
import org.apache.commons.math3.complex.Complex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VariablesTest {

    private String key;
    private Complex value;
    private Variables instance;

    public VariablesTest() {
    }

    @Before
    public void setUp() {
        key = "A";
        value = new Complex(2, 3);
        instance = new Variables();
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
        assertEquals(value, instance.getVariable(key));
    }

    /**
     * Test of addValue method, of class Variables.
     */
    @Test
    public void testAddValue() {
        System.out.println("addValue");
        instance.setVariable(key, value);
        Complex result = instance.addValue(key, value);
        assertEquals(result, instance.get(key));
    }

    /**
     * Test of subValue method, of class Variables.
     */
    @Test
    public void testSubValue() {
        System.out.println("subValue");
        instance.setVariable(key, value);
        Complex result = instance.subValue(key, value);
        assertEquals(instance.get(key), result);
    }

}
