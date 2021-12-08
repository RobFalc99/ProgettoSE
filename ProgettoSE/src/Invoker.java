
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
     * Adds a new User Operation to the userOperations list
     * @param uo The new User Operation to be added 
     * @return True if the input User Operation is added, else otherwise (as specified by Collection.add(E))
     */
    public Boolean addUserOperation(UserOperation uo){
        return userOperations.add(uo);
    }
    
    /**
     * Removes the input User Operation in the userOperations list
     * @param uo The User Operation to be removed 
     * @return True if the input User Operation is removed, else otherwise
     */
    public Boolean removeUserOperation(UserOperation uo){
        return userOperations.remove(uo);
    }
    
    
    
    
}
