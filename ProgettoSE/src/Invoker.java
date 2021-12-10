
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Invoker {

    private ArrayList<UserOperation> userOperations;

    /**
     * An empty constructor which only inizialize the userOperations array list
     */
    public Invoker() {
        userOperations = new ArrayList<>();
    }

    /**
     * The userOperations attribute's getter
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
     * @return True if the input User Operation is added, False otherwise (as
     * specified by Collection.add(E))
     */
    public Boolean addUserOperation(UserOperation uo) {
        return userOperations.add(uo);
    }

    /**
     * Removes the input User Operation in the userOperations list
     *
     * @param uo The User Operation to be removed
     * @return True if the input User Operation is removed, False otherwise
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
     * @return True if the execution ends correctly, False otherwise
     */
    public Boolean execute(String name, Calculator calculator) {
        for (UserOperation u : userOperations) {
            if (u.getName().equals(name)) {
                return u.execute(calculator);
            }
        }
        return false;
    }

    /**
     * Modifies en existing User Operation by setting the new operations'
     * sequence passed in input
     *
     * @param uoName The name of the userOperations
     * @param uoSeqOperations The new operations' sequence to save
     * @return True if the change ends correctly, False otherwise
     */
    public Boolean modifyUserOperation(String uoName, ArrayList<String> uoSeqOperations) {
        for (UserOperation uo : userOperations) {
            if (uo.getName().equals(uoName)) {
                uo.setOperations(uoSeqOperations);
                return true;
            }
        }
        return false;
    }

    /**
     * Imports all the user operations saved on a file passed as an parameter
     * and adds them in the userOperations ArrayList
     *
     * @param fileBySave	The file from which import the user operations
     * @return	True if the import ends correctly, False otherwise
     */
    public Boolean importUserOperationsByFile(File fileBySave) {
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileBySave));
            line = reader.readLine();
            if (!line.equals("UserOperationName, UserOperationSequence")) {
                return false;
            }
            while ((line = reader.readLine()) != null) {
                Scanner scan = new Scanner(line);
                scan.useDelimiter(",");
                String usName = scan.next();
                String usOperations = scan.next();
                ArrayList<String> usListOperations = new ArrayList<>(Arrays.asList(usOperations.split(" ")));

                this.addUserOperation(new UserOperation(usName, usListOperations));
            }
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    /**
     * Saves on a file the UserOperations contained in the Invoker attribute
     * list
     *
     * @param fileToSave the file on which to save
     * @return True if the execution ends correctly, False otherwise
     * @throws Exception IOException
     */
    public Boolean saveUserOperationOnFile(File fileToSave) throws Exception {
        try (PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(fileToSave)))) {
            w.print("UserOperationName, UserOperationSequence\n");
            for (UserOperation u : userOperations) {
                w.print(u.getName() + ",");
                ArrayList<String> operations = u.getOperations();
                for (String s : operations) {
                    w.print(s + " ");
                }
                w.print("\n");
            }
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
