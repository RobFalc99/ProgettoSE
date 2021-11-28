
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnCommitOperation;
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
    private ChoiceBox<String> choiceBoxOperation;
    @FXML
    private ListView<Complex> stackOperand;
    @FXML
    private Button btnSwap;
    @FXML
    private AnchorPane anchorPane;

    private Calculator calculator;

    ArrayList<String> operazioni = new ArrayList<>();
    private ObservableList<Complex> complexOperand;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new Calculator();
        complexOperand = FXCollections.observableArrayList();
        operazioni.add("+");
        operazioni.add("-");
        operazioni.add("*");
        operazioni.add("/");
        operazioni.add("sqrt");
        operazioni.add("+-");
        choiceBoxOperation.getItems().addAll(operazioni);
        stackOperand.setItems(complexOperand);

    }

    @FXML
    private void commitOperation(ActionEvent event) {
        if ("+".equals(choiceBoxOperation.getValue())) {
            if (complexOperand.size() >= 2) {
                calculator.addComplex();
            } else {
                popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less than 2 operands entered");
            }

        } else if ("-".equals(choiceBoxOperation.getValue())) {
            if (complexOperand.size() >= 2) {
                calculator.subComplex();
            } else {
                popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less than 2 operands entered");
            }
        } else if ("*".equals(choiceBoxOperation.getValue())) {
            if (complexOperand.size() >= 2) {
                calculator.mulComplex();
            } else {
                popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less than 2 operands entered");
            }

        } else if ("/".equals(choiceBoxOperation.getValue())) {
            if (complexOperand.size() >= 2) {
                calculator.divComplex();
            } else {
                popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less than 2 operands entered");
            }
        } else if ("sqrt".equals(choiceBoxOperation.getValue())) {
            if (complexOperand.size() >= 1) {
                calculator.sqrtComplex();
            } else {
                popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less or more  than 1 operands entered");
            }
        } else if ("+-".equals(choiceBoxOperation.getValue())) {
            if (complexOperand.size() >= 1) {
                calculator.invSignComplex();
            } else {
                popUp(AlertType.ERROR, "Error", "Not enough operands", "There are less or more  than 1 operands entered");
            }
        }
        txtFieldOperand.clear();
        complexOperand.clear();
        complexOperand.addAll(calculator.getStack().getList());
    }

    @FXML
    private void commitOperand(ActionEvent event) {
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

    @FXML
    private void clearAction(ActionEvent event) {
        if (complexOperand.size() >= 1) {
            complexOperand.clear();
            calculator.clearStack();
        } else {
            popUp(AlertType.ERROR, "Error", "Not enough operands", "There is less than 1 operand entered");
        }
    }

    @FXML
    private void dupAction(ActionEvent event) {
        if (complexOperand.size() >= 1) {
            calculator.dupStackOperand();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
        } else {
            popUp(AlertType.ERROR, "Error", "Not enough operands", "There is less than 1 operand entered");
        }
    }

    @FXML
    private void dropAction(ActionEvent event) {
        if (complexOperand.size() >= 1) {
            calculator.dropStackOperand();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
        } else {
            popUp(AlertType.ERROR, "Error", "Not enough operands", "There is less than 1 operand entered");
        }
    }

    @FXML
    private void swapAction(ActionEvent event) {
        if (complexOperand.size() > 1) {
            calculator.swapStackOperand();
            complexOperand.clear();
            complexOperand.addAll(calculator.getStack().getList());
        } else {
            popUp(AlertType.ERROR, "Error", "Not enough operands", "There is less than 1 operand entered");
        }
    }

    private void popUp(AlertType type, String title, String header, String message) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }

}
