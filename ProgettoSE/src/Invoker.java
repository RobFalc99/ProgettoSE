
import java.util.ArrayList;

public class Invoker {
    
    private ArrayList<UserOperation> userOperations;

    /**
     *  An empty constructor which only inizialize the userOperations array list
     */
    public Invoker() {
        userOperations = new ArrayList<>();
    }

    /**
     * The userOperations attribute getter
     * @return  An ArrayList on UserOperation which contains the userOperations attribute
     */
    public ArrayList<UserOperation> getUserOperations() {
        return userOperations;
    }

    /**
     * The userOperations attribute's setter
     * @param userOperations the ArrayList of the userOperations attribute
     */
    public void setUserOperations(ArrayList<UserOperation> userOperations) {
        this.userOperations = userOperations;
    }
    
    
    
    /**
     * Calls the execute method of the userOperations associated with the name of the string passed as a parameter
     * @param name The name of the userOperations
     * @param calculator The calculator object that you need to pass to execute
     */
    public void execute (String name, Calculator calculator){
        for (UserOperation u: userOperations){
            if (u.getName().equals(name))
                u.execute(calculator);
        }
    }
    
    
}
