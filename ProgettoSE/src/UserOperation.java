
import java.util.ArrayList;

public class UserOperation {
    
    private String name;
    private ArrayList<String> operations;

    /**
     * The class constructor
     * @param name          The name of the new UserOperation
     * @param operations    The operations' sequence of a new UserOperation
     */
    public UserOperation(String name, ArrayList<String> operations) {
        this.name = name;
        this.operations = operations;
    }

    /**
     * An empty constructor
     */
    public UserOperation() {
    }


    /**
     * The name attribute getter
     * @return  A String which contains a UserOperation name
     */
    public String getName() {
        return name;
    }

    /**
     * The name attribute setter
     * @param name  The new name of a UserOperation
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The operations attribute getter
     * @return  A list of strings which contains a UserOperation operations' sequence
     */
    public ArrayList<String> getOperations() {
        return operations;
    }

    /**
     * The operations attribute setter
     * @param operations    The new operations' sequence of a UserOperation
     */
    public void setOperations(ArrayList<String> operations) {
        this.operations = operations;
    }
    
    
    
}
