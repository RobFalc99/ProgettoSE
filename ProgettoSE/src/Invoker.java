
import java.util.ArrayList;

public class Invoker {

    private ArrayList<UserOperation> userOperations;

    /**
     * An empty constructor which only inizialize the userOperations array list
     */
    public Invoker() {
        userOperations = new ArrayList<>();
    }

    /**
     * The userOperations attribute getter
     *
     * @return An ArrayList on UserOperation which contains the userOperations
     * attribute
     */
    public ArrayList<UserOperation> getUserOperations() {
        return userOperations;
    }

    /**
     * The userOperations attribute's setter
     *
     * @param userOperations the ArrayList of the userOperations attribute
     */
    public void setUserOperations(ArrayList<UserOperation> userOperations) {
        this.userOperations = userOperations;
    }

    /**
     * Adds a new User Operation to the userOperations list
     *
     * @param uo The new User Operation to be added
     * @return True if the input User Operation is added, else otherwise (as
     * specified by Collection.add(E))
     */
    public Boolean addUserOperation(UserOperation uo) {
        return userOperations.add(uo);
    }

    /**
     * Removes the input User Operation in the userOperations list
     *
     * @param uo The User Operation to be removed
     * @return True if the input User Operation is removed, else otherwise
     */
    public Boolean removeUserOperation(UserOperation uo) {
        return userOperations.remove(uo);
    }

    /**
     * Calls the execute method of the userOperations associated with the name
     * of the string passed as a parameter
     *
     * @param name The name of the userOperations
     * @param calculator The calculator object that you need to pass to execute
     * @return True if the execute ends correctly, False otherwise
     */
    public Boolean execute(String name, Calculator calculator) {
        for (UserOperation u : userOperations) {
            if (u.getName().equals(name)) {
                return u.execute(calculator);
            }
        }
        return false;
    }

}