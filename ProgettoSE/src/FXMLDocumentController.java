
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnCommitOperand;
    @FXML
    private TextField txtFieldOperand;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDup;
    @FXML
    private Button btnDrop;
    @FXML
    private ListView<Complex> stackOperand;
    @FXML
    private Button btnSwap;
    @FXML
    private AnchorPane anchorPane;
    
    private Calculator calculator;
    
    private ObservableList<Complex> complexOperand;
    @FXML
    private Button btnOver;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnMul;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnSqrt;
    @FXML
    private Button btnInvSign;
    @FXML
    private TextField txtFieldVariable;
    @FXML
    private Button btnCommitVariable;
    @FXML
    private TextField txtFieldUsOperationName;
    @FXML
    private TextField txtFieldUsOperationSeq;
    @FXML
    private Button btnInsertUserOperation;
    @FXML
    private ChoiceBox<String> choiceBoxUserOperations;
    @FXML
    private Button btnLoadOnTxtFieldUsOperationSeq;
    @FXML
    private Button btnDeleteUserOperation;
    @FXML
    private Button btnCommitUserOperation;
    
    private Invoker invoker;
    
    private ObservableList<String> definedUserOperations;
    @FXML
    private Button btnModifyUserOperationSeq;
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem importByFile;
    @FXML
    private MenuItem saveOnFile;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new Calculator();
        complexOperand = FXCollections.observableArrayList();
        stackOperand.setItems(complexOperand);
        invoker = new Invoker();
        definedUserOperations = FXCollections.observableArrayList();
        choiceBoxUserOperations.setItems(definedUserOperations);
    }
    
    private void updateView() {
        txtFieldOperand.clear();
        txtFieldVariable.clear();
        complexOperand.clear();
        complexOperand.addAll(calculator.getStack().getList());
        txtFieldUsOperationName.clear();
        txtFieldUsOperationSeq.clear();
    }
    
    private void insertOperand() {
        String operand = txtFieldOperand.getText();
        if (operand.matches("[" + "0123456789i.,+-" + "]+")) {
            calculator.pushComplex(operand);
            updateView();
        } else {
            popUp(AlertType.ERROR, "ERROR", "Illegal expression", "You are entering an invalid operand format. Please re-enter the operand as 5,3+2,6i");
        }
    }
    
    private void insertVariable() {
        String varOperation = txtFieldVariable.getText();
        if (varOperation.matches("[+-<>][ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
            if (varOperation.charAt(0) == '<') {
                calculator.loadVariable(varOperation.substring(1).toUpperCase());
            } else if (checkOperationCondition(1)) {
                if (varOperation.charAt(0) == '>') {
                    calculator.pushVariable(varOperation.substring(1).toUpperCase());
                }
                if (varOperation.charAt(0) == '+') {
                    calculator.addToVariable(varOperation.substring(1).toUpperCase());
                }
                if (varOperation.charAt(0) == '-') {
                    calculator.subToVariable(varOperation.substring(1).toUpperCase());
                }
            }
            updateView();
        } else {
            popUp(AlertType.ERROR, "ERROR", "Not a variable operation", "The entered variable isn't an alphabet letter");
        }
    }
    
    private Boolean checkOperationCondition(int minOperands) {
        if (complexOperand.size() >= minOperands) {
            return true;
        } else {
            popUp(AlertType.ERROR, "ERROR", "Not enough operands", "There are less than " + minOperands + " operands entered");
            return false;
        }
    }
    
    @FXML
    private void commitOperand(ActionEvent event) {
        insertOperand();
    }
    
    @FXML
    private void clearAction(ActionEvent event) {
        if (checkOperationCondition(1)) {
            complexOperand.clear();
            calculator.clearStack();
        }
    }
    
    @FXML
    private void dupAction(ActionEvent event) {
        if (checkOperationCondition(1)) {
            calculator.dupStackOperand();
            updateView();
        }
    }
    
    @FXML
    private void dropAction(ActionEvent event) {
        if (checkOperationCondition(1)) {
            calculator.dropStackOperand();
            updateView();
        }
    }
    
    @FXML
    private void swapAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.swapStackOperand();
            updateView();
        }
    }
    
    private void popUp(AlertType type, String title, String header, String message) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
    
    @FXML
    private void addAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.addComplex();
            updateView();
        }
    }
    
    @FXML
    private void subAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.subComplex();
            updateView();
        }
    }
    
    @FXML
    private void mulAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.mulComplex();
            updateView();
        }
    }
    
    @FXML
    private void divAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            if (!calculator.getStack().top().equals(new Complex(0))) {
                calculator.divComplex();
                updateView();
            }
        } else {
            popUp(AlertType.ERROR, "ERROR", "Impossible to execute division", "You are trying to divide by zero");
        }
    }
    
    @FXML
    private void sqrtAction(ActionEvent event) {
        if (checkOperationCondition(1)) {
            calculator.sqrtComplex();
            updateView();
        }
    }
    
    @FXML
    private void overAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.overStackOperand();
            updateView();
        }
    }
    
    @FXML
    private void invSignAction(ActionEvent event) {
        if (checkOperationCondition(1)) {
            calculator.invSignComplex();
            updateView();
        }
    }
    
    @FXML
    private void onEnterAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            insertOperand();
        }
    }
    
    @FXML
    private void onEnterVariableAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            insertVariable();
        }
    }
    
    @FXML
    private void commitVariable(ActionEvent event) {
        insertVariable();
    }
    
    private ArrayList<String> checkUserOperation() {
        String userOperationName = txtFieldUsOperationName.getText();
        ArrayList<String> operations = new ArrayList<>();
        Scanner scan = new Scanner(txtFieldUsOperationSeq.getText());
        scan.useDelimiter(" ");
        ArrayList<String> correctOperations = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "+-", "sqrt", "clear", "drop", "swap", "over", "dup"));
        while (scan.hasNext()) {
            String newOperation = scan.next();
            if (correctOperations.contains(newOperation)
                    || newOperation.matches("[+-<>][ABCDEFGHIJKLMNOPQRSTUVWXYZ]")
                    || newOperation.matches("(\\d+,\\d+)|(\\d+,\\d+i)|(\\d+,\\d+[+-]\\d+,\\d+i)|(\\d+[+-]\\d+,\\d+i)|(\\d+[+-]\\d+i)|(\\d+)|(\\d+i)")) {
                operations.add(newOperation);
            } else {
                popUp(AlertType.ERROR, "ERROR", "Impossible to define the user operation", "The user operation contains a not supported operation: " + newOperation);
                return null;
            }
        }
        return operations;
    }
    
    private void insertUserOperation() {
        if (txtFieldUsOperationName.getText().isEmpty() || txtFieldUsOperationSeq.getText().isEmpty()) {
            popUp(AlertType.ERROR, "ERROR", "Impossible to define the user operation", "Hasn't been defined any user operation");
        } else {
            ArrayList<String> operations = checkUserOperation();
            if (operations != null) {
                invoker.addUserOperation(new UserOperation(txtFieldUsOperationName.getText(), operations));
                definedUserOperations.add(txtFieldUsOperationName.getText());
                popUp(AlertType.CONFIRMATION, "SUCCESS", "The new user operation has been defined with success", "The new user operation\nName: " + txtFieldUsOperationName.getText() + "\nOperations: " + operations);
                updateView();
            }
        }
    }
    
    private void modifyUserOperation() {
        if (txtFieldUsOperationName.getText().isEmpty() || txtFieldUsOperationSeq.getText().isEmpty()) {
            popUp(AlertType.ERROR, "ERROR", "Impossible to modify the user operation", "There are some missing informations");
        } else {
            ArrayList<String> newOperations = checkUserOperation();
            Boolean modified = false;
            if (newOperations != null) {
                definedUserOperations.remove(txtFieldUsOperationName.getText());
                modified = invoker.modifyUserOperation(txtFieldUsOperationName.getText(), newOperations);
            }
            if (modified == true) {
                definedUserOperations.add(txtFieldUsOperationName.getText());
                popUp(AlertType.CONFIRMATION, "SUCCESS", "The user operation has been modified with success", "The new user operation\nName: " + txtFieldUsOperationName.getText() + "\nOperations: " + newOperations);
                updateView();
            } else {
                popUp(AlertType.ERROR, "ERROR", "Impossible to modify the user operation", "Some errors occur");
            }
        }
        
    }
    
    @FXML
    private void onEnterUserOperationAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (definedUserOperations.contains(txtFieldUsOperationName.getText())) {
                modifyUserOperation();
            } else {
                insertUserOperation();
            }
        }
    }
    
    @FXML
    private void newUserOperationAction(ActionEvent event) {
        if (definedUserOperations.contains(txtFieldUsOperationName.getText())) {
            popUp(AlertType.ERROR, "ERROR", "The new user operation can't be defined", "There's already an user operation with the same name: " + txtFieldUsOperationName.getText());
        } else {
            insertUserOperation();
        }
    }
    
    @FXML
    private void loadOnTxtFieldUsOperationSeqAction(ActionEvent event) {
        String operationSeqInput = txtFieldUsOperationSeq.getText();
        String selectedUserOperationName = choiceBoxUserOperations.getSelectionModel().getSelectedItem();
        UserOperation oldUserOperation = null;
        if (definedUserOperations.contains(selectedUserOperationName)) {
            ArrayList<UserOperation> usOp = invoker.getUserOperations();
            for (UserOperation uO : usOp) {
                if (uO.getName().equals(selectedUserOperationName)) {
                    oldUserOperation = uO;
                }
            }
            ArrayList<String> operations = oldUserOperation.getOperations();
            if (!operationSeqInput.endsWith(" ")) {
                operationSeqInput += " ";
            }
            for (String op : operations) {
                operationSeqInput += op + " ";
            }
            txtFieldUsOperationSeq.setText(operationSeqInput);
        } else {
            popUp(AlertType.ERROR, "ERROR", "The user operation doesn't exist", "The user operation " + selectedUserOperationName + " isn't defined yet");
        }
    }
    
    @FXML
    private void deleteUserOperationAction(ActionEvent event) {
        String userOperationName = choiceBoxUserOperations.getSelectionModel().getSelectedItem();
        UserOperation toRemoveUO = null;
        if (definedUserOperations.contains(userOperationName)) {
            ArrayList<UserOperation> usOp = invoker.getUserOperations();
            for (UserOperation uO : usOp) {
                if (uO.getName().equals(userOperationName)) {
                    toRemoveUO = uO;
                }
            }
        }
        if (toRemoveUO != null) {
            invoker.removeUserOperation(toRemoveUO);
            updateView();
            definedUserOperations.remove(userOperationName);
            popUp(AlertType.CONFIRMATION, "SUCCESS", "The old user operation has been removed", "The old user operation\nName: " + toRemoveUO.getName() + "\nOperations: " + toRemoveUO.getOperations());
        } else {
            popUp(AlertType.ERROR, "ERROR", "The user operation specified doesn't exist", "The user operation " + userOperationName + " isn't defined yet");
        }
    }
    
    @FXML
    private void commitUserOperationAction(ActionEvent event) {
        String userOperationName = choiceBoxUserOperations.getSelectionModel().getSelectedItem();
        UserOperation toCommitUO = null;
        if (definedUserOperations.contains(userOperationName)) {
            ArrayList<UserOperation> usOp = invoker.getUserOperations();
            for (UserOperation uO : usOp) {
                if (uO.getName().equals(userOperationName)) {
                    toCommitUO = uO;
                }
            }
        }
        if (toCommitUO != null) {
            Boolean res = invoker.execute(userOperationName, calculator);
            if (res == true) {
                updateView();
                choiceBoxUserOperations.getSelectionModel().clearSelection();
                popUp(AlertType.CONFIRMATION, "SUCCESS", "The user operation has been successfully runned", "The user operation\nName: " + toCommitUO.getName() + "\nOperations: " + toCommitUO.getOperations());
            } else {
                popUp(AlertType.ERROR, "ERROR", "The user operation can't be executed due to an error", "The user operation name: " + userOperationName + " contains an operation which can't be executed");
            }
        } else {
            popUp(AlertType.ERROR, "ERROR", "The invoked user operation doesn't exist", "The user operation " + userOperationName + " isn't defined yet");
        }
    }
    
    @FXML
    private void modifyUserOperationSeqAction(ActionEvent event) {
        modifyUserOperation();
    }
    
    @FXML
    private void importFileAction(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(anchorPane.getScene().getWindow());
        if (file != null) {
            String s;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            s = reader.readLine();
            if (s.equals("UserOperationName, UserOperationSequence")) {
                Boolean c = invoker.importUserOperationsByFile(file);
                for (UserOperation uo : invoker.getUserOperations()) {
                    if (!definedUserOperations.contains(uo)) {
                        definedUserOperations.add(uo.getName());
                    }
                }
            } else {
                popUp(AlertType.ERROR, "ERROR", "In this file there aren't user operations", "The first line of this file doesn't contain a string of the type [UserOperationName, UserOperationSequence]");
            }
        }
    }
    
    @FXML
    private void saveFileAction(ActionEvent event) throws Exception {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(anchorPane.getScene().getWindow());
        Boolean c = invoker.saveUserOperationOnFile(file);
    }
    
}
