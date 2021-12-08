
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
    
    public Boolean addUserOperation(UserOperation uo){
        return userOperations.add(uo);
    }
    
    public Boolean removeUserOperation(UserOperation uo){
        return userOperations.remove(uo);
    }
    
    
    
    
}
