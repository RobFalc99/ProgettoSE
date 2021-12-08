
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserOperation {

    private String name;
    private ArrayList<String> operations;

    /**
     * The class constructor
     *
     * @param name The name of the new UserOperation
     * @param operations The operations' sequence of a new UserOperation
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
     *
     * @return A String which contains a UserOperation name
     */
    public String getName() {
        return name;
    }

    /**
     * The name attribute setter
     *
     * @param name The new name of a UserOperation
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The operations attribute getter
     *
     * @return A list of strings which contains a UserOperation operations'
     * sequence
     */
    public ArrayList<String> getOperations() {
        return operations;
    }

    /**
     * The operations attribute setter
     *
     * @param operations The new operations' sequence of a UserOperation
     */
    public void setOperations(ArrayList<String> operations) {
        this.operations = operations;
    }

    /**
     * Goes through the entire sequence of operations defined in the user
     * operation and executes them in sequence by calling the suitable
     * Calculator methods.
     *
     * @param calculator The calculator object on which to call the operations
     * @return True if the execute ends correctly, False otherwise
     */
    public Boolean execute(Calculator calculator) {
        Runnable r;
        Map<String, Runnable> map = new HashMap<>(calculator.getOperationMap());
        for (String s : operations) {
            if (s.matches("[" + "0123456789i.," + "]+")) {
                calculator.pushComplex(s);
            } else if (s.matches("[+-<>][ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
                if (s.charAt(0) == '<') {
                    calculator.loadVariable(s.substring(1).toUpperCase());
                } else if (calculator.getStack().getList().size() >= 1) {
                    switch (s.charAt(0)) {
                        case '>':
                            calculator.pushVariable(s.substring(1).toUpperCase());
                            break;
                        case '+':
                            calculator.addToVariable(s.substring(1).toUpperCase());
                            break;
                        case '-':
                            calculator.subToVariable(s.substring(1).toUpperCase());
                            break;
                        default:
                            break;
                    }
                }
            } else {
                if (calculator.getStack().getList().size() > 1) {
                    r = map.get(s);
                    r.run();
                }else
                    return false;
                
            }
        }
        return true;
    }

}
