/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.vm.jcomplex.Complex;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author FALCONE
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
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
    private ChoiceBox<?> choiceBoxOperation;
    @FXML
    private ListView<?> stackOperand;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

}
