/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mads_
 */
public class EditViewController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pressCancel(ActionEvent event) {
        Stage st = (Stage) cancelButton.getScene().getWindow();
        st.close();
    }

    @FXML
    private void pressSave(ActionEvent event) {
        //TODO
        
        Stage st = (Stage) saveButton.getScene().getWindow();
        st.close();
    }
    
}
