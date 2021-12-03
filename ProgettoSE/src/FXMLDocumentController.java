
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new Calculator();
        complexOperand = FXCollections.observableArrayList();
        stackOperand.setItems(complexOperand);

    }

    private void insertOperand() {
        String operand = txtFieldOperand.getText();
        if (operand.matches("[" + "0123456789i.,+-" + "]+")) {
            calculator.pushComplex(operand);
            txtFieldOperand.clear();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
        } else {
            popUp(AlertType.ERROR, "Error", "Illegal expression", "You are entering an invalid operand format. Please re-enter the operand as 5,3+2,6i");
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
        if(checkOperationCondition(1)){
            complexOperand.clear();
            calculator.clearStack();
        }
    }

    @FXML
    private void dupAction(ActionEvent event) {
        if(checkOperationCondition(1)){
            calculator.dupStackOperand();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void dropAction(ActionEvent event) {
        if(checkOperationCondition(1)){
            calculator.dropStackOperand();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void swapAction(ActionEvent event) {
        if(checkOperationCondition(2)){
            calculator.swapStackOperand();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
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
            txtFieldOperand.clear();
            stackOperand.getItems().setAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void subAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.subComplex();
            txtFieldOperand.clear();
            stackOperand.getItems().setAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void mulAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.mulComplex();
            txtFieldOperand.clear();
            stackOperand.getItems().setAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void divAction(ActionEvent event) {
        if (!calculator.getStack().top().equals(new Complex(0))) {
            if (checkOperationCondition(2)) {
                calculator.divComplex();
                txtFieldOperand.clear();
                stackOperand.getItems().setAll(calculator.getStack().getList());
            }
        } else {
            popUp(AlertType.ERROR, "Error", "Impossible to execute division", "You are trying to divide by zero");
        }
    }

    @FXML
    private void sqrtAction(ActionEvent event) {
        if(checkOperationCondition(1)){
            calculator.sqrtComplex();
            stackOperand.getItems().setAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void overAction(ActionEvent event) {
        if (checkOperationCondition(2)) {
            calculator.overStackOperand();
            stackOperand.getItems().setAll(calculator.getStack().getList());
        }
    }

    @FXML
    private void invSignAction(ActionEvent event) {
        if (checkOperationCondition(1)) {
            calculator.invSignComplex();
            stackOperand.getItems().setAll(calculator.getStack().getList());
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
    }

    @FXML
    private void commitVariable(ActionEvent event) {
    }

}
