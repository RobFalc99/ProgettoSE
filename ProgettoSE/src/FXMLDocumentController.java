/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author FALCONE
 */
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
    private ListView<String> stackOperand;
    @FXML
    private Button btnSwap;
    @FXML
    private AnchorPane anchorPane;

    private Scene scene;

    private Window window;

    private Calculator calculator;

    ArrayList<String> operazioni = new ArrayList<String>();
    private ObservableList<String> complexOperand;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new Calculator();
        complexOperand= FXCollections.observableArrayList();
        operazioni.add("+");
        operazioni.add("-");
        operazioni.add("*");
        choiceBoxOperation.getItems().addAll(operazioni);
        stackOperand.setItems(complexOperand);
    }

    @FXML
    private void commitOperation(ActionEvent event) {
        if ("+".equals(choiceBoxOperation.getValue())) {

        } else if ("-".equals(choiceBoxOperation.getValue())) {
            calculator.subComplex();
        } else if ("*".equals(choiceBoxOperation.getValue())) {
            calculator.mulComplex();
        }
    }

    @FXML
    private void commitOperand(ActionEvent event) {
        String operand = txtFieldOperand.getText();
        if (operand.matches(".*i")) {
            calculator.pushComplex(operand);
            complexOperand.add(operand);
            Collections.reverse(complexOperand);
        } else {
            popUp(AlertType.WARNING, "Warning", "Illegal expression", "You are entering an invalid operand format. Please re-enter the operand as 5.3 + 2.6i or 0 + 4i");
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
    }

    @FXML
    private void dupAction(ActionEvent event) {
    }

    @FXML
    private void dropAction(ActionEvent event) {
    }

    @FXML
    private void swapAction(ActionEvent event) {
    }

    private void popUp(AlertType type, String title, String header, String message) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }

}
