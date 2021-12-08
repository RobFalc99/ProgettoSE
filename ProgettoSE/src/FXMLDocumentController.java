
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

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
            popUp(AlertType.ERROR, "Error", "Illegal expression", "You are entering an invalid operand format. Please re-enter the operand as 5,3+2,6i");
        }
    }

    private void insertVariable() {
        String varOperation = txtFieldVariable.getText();
        if (varOperation.matches("[+-<>][ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
            if (checkOperationCondition(1)){
                if (varOperation.charAt(0) == '>') {
                    calculator.pushVariable(varOperation.substring(1).toUpperCase());
                }
                if (varOperation.charAt(0) == '<') {
                    calculator.loadVariable(varOperation.substring(1).toUpperCase());
                }
                if (varOperation.charAt(0) == '+') {
                    calculator.addToVariable(varOperation.substring(1).toUpperCase());
                }
                if (varOperation.charAt(0) == '-') {
                    calculator.subToVariable(varOperation.substring(1).toUpperCase());
                }
                updateView();
            } 
        } else {
            popUp(AlertType.ERROR, "Error", "Not a variable operation", "The entered variable isn't an alphabet letter");
        }
    }

    private Boolean checkOperationCondition(int minOperands) {
        if (complexOperand.size() >= minOperands) {
            return true;
        } else {
            popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less than " + minOperands + " operands entered");
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
        if (!calculator.getStack().top().equals(new Complex(0))) {
            if (checkOperationCondition(2)) {
                calculator.divComplex();
                updateView();
            }
        } else {
            popUp(AlertType.ERROR, "Error", "Impossible to execute division", "You are trying to divide by zero");
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

    private void insertUserOperation() {
        String userOperationName = txtFieldUsOperationName.getText();
        ArrayList<String> operations = new ArrayList<>();
        Scanner scan = new Scanner(txtFieldUsOperationSeq.getText());
        ArrayList<String> correctOperations = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "+-", "sqrt", "clear", "drop", "swap", "over", "dup"));
        while (scan.hasNext()) {
            String newOperation = scan.next();
            if (correctOperations.contains(newOperation)) {
                operations.add(newOperation);
            } else if (newOperation.matches("[+-<>][ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
                operations.add(newOperation);
            } else if(newOperation.matches("[" + "0123456789i.,+-" + "]+")){
                operations.add(newOperation);
            } else {
                popUp(AlertType.ERROR, "Error", "Impossible to define the user operation", "The user operation contains the not supported operation: "+newOperation);
                return;
            }
        }
        invoker.addUserOperation(new UserOperation(userOperationName, operations));
        definedUserOperations.add(userOperationName);
        updateView();
        popUp(AlertType.CONFIRMATION, "SUCCESS", "The new user operation has been pushed with success", "The new user operation\nName: "+userOperationName+"\nOperations: "+operations);
    }

    @FXML
    private void onEnterUserOperationAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            insertUserOperation();
    }

    @FXML
    private void newUserOperationAction(ActionEvent event) {
        insertUserOperation();
    }

    @FXML
    private void loadOnTxtFieldUsOperationSeqAction(ActionEvent event) {
    }

    @FXML
    private void deleteUserOperationAction(ActionEvent event) {
    }

    @FXML
    private void commitUserOperationAction(ActionEvent event) {
    }

}
