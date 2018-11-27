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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author mads_
 */
public class MainViewController implements Initializable {
    
    private Label label;
    @FXML
    private Button playButton;
    @FXML
    private TableColumn<?, ?> playlistNameCol;
    @FXML
    private TableColumn<?, ?> playlistSongsCol;
    @FXML
    private TableColumn<?, ?> playlistTimeCol;
    @FXML
    private TableColumn<?, ?> songTitleCol;
    @FXML
    private TableColumn<?, ?> songArtistCol;
    @FXML
    private TableColumn<?, ?> songCategoryCol;
    @FXML
    private TableColumn<?, ?> songTimeCol;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void newPlaylist(ActionEvent event) {
    }

    @FXML
    private void editPlaylist(ActionEvent event) {
    }

    @FXML
    private void deletePlaylist(ActionEvent event) {
    }

    @FXML
    private void moveUp(ActionEvent event) {
    }

    @FXML
    private void moveDown(ActionEvent event) {
    }

    @FXML
    private void deleteFromPlaylist(ActionEvent event) {
    }

    @FXML
    private void addToPlaylist(ActionEvent event) {
    }

    @FXML
    private void newSong(ActionEvent event) {
    }

    @FXML
    private void editSong(ActionEvent event) {
    }

    @FXML
    private void deleteSong(ActionEvent event) {
    }

    @FXML
    private void search(KeyEvent event) {
    }

    @FXML
    private void pressPrevious(ActionEvent event) {
    }

    @FXML
    private void pressPlay(ActionEvent event) {
    }

    @FXML
    private void pressNext(ActionEvent event) {
    }
    
}
