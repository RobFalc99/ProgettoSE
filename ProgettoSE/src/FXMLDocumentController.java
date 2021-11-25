/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private ListView<Complex> stackOperand;
    @FXML
    private Button btnSwap;
    @FXML
    private AnchorPane anchorPane;

    private Scene scene;

    private Window window;
    
    ArrayList<String> operazioni = new ArrayList<String>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operazioni.add("+");
        operazioni.add("-");
        choiceBoxOperation.getItems().addAll(operazioni);
    }

    @FXML
    private void commitOperation(ActionEvent event) {
    }

    @FXML
    private void commitOperand(ActionEvent event) {
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
