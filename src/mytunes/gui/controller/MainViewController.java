/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mytunes.be.Playlist;
import mytunes.be.SimpleAudioPlayer;
import mytunes.be.Song;
import mytunes.bll.IModel;
import mytunes.bll.Model;

/**
 *
 * @author mads_
 */
public class MainViewController implements Initializable {
    
    private Label label;
    @FXML
    private Button playButton;
    @FXML
    private TableColumn<Playlist, String> playlistNameCol;
    @FXML
    private TableColumn<Playlist, String> playlistSongsCol;
    @FXML
    private TableColumn<Playlist, Integer> playlistTimeCol;
    @FXML
    private TableColumn<Song, String> songTitleCol;
    @FXML
    private TableColumn<Song, String> songArtistCol;
    @FXML
    private TableColumn<Song, String> songCategoryCol;
    @FXML
    private TableColumn<Song, Integer> songTimeCol;
    @FXML
    private TableView<Playlist> playlistTable;
    @FXML
    private TableView<Song> songsTable;
    
    private IModel model = new Model();
    
    private ObservableList<Song> songs;
    
    private ObservableList<Playlist> playlists;
    private SimpleAudioPlayer player = new SimpleAudioPlayer();
    @FXML
    private Slider slider;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        songs = FXCollections.observableArrayList();
        songs.addAll(model.getAllSongs());
        songsTable.setItems(songs);
        songTitleCol.setCellValueFactory(new PropertyValueFactory("title"));
        songArtistCol.setCellValueFactory(new PropertyValueFactory("artist"));
        songCategoryCol.setCellValueFactory(new PropertyValueFactory("category"));
        //songTimeCol.setCellValueFactory(new PropertyValueFactory("duration"));
        
        playlists = FXCollections.observableArrayList();
        playlists.addAll(model.getAllPlaylists());
        playlistTable.setItems(playlists);
        playlistNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        
    }    
    
    public void updatePlaylistTable(){
        
        playlistTable.getItems().clear();
        playlists.removeAll();
        playlists.addAll(model.getAllPlaylists());
        playlistTable.setItems(playlists);
    }
    
    public void updateSongTable(){
        
        songsTable.getItems().clear();
        songs.removeAll();
        songs.addAll(model.getAllSongs());
        songsTable.setItems(songs);
    }

    @FXML
    private void newPlaylist(ActionEvent event) throws IOException {
        
        
        
        Stage s = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/PlaylistEditView.fxml"));
        s.setScene(new Scene(loader.load()));
        s.setTitle("New Playlist");
        PlaylistEditViewController questions = loader.<PlaylistEditViewController>getController();
        s.showAndWait();
        updatePlaylistTable();
    }

    @FXML
    private void editPlaylist(ActionEvent event) throws IOException {
        Stage s = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/PlaylistEditView.fxml"));
        s.setScene(new Scene(loader.load()));
        s.setTitle("Edit Playlist");
        PlaylistEditViewController questions = loader.<PlaylistEditViewController>getController();
        s.show();
    }

    @FXML
    private void deletePlaylist(ActionEvent event) {
        Playlist p = playlistTable.getSelectionModel().getSelectedItem();
        model.deletePlaylist(p);
        updatePlaylistTable();
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
    private void newSong(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/EditView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("New Song");
        EditViewController songEdit = loader.<EditViewController>getController();
        stage.showAndWait();
        updateSongTable();
    }

    @FXML
    private void editSong(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/EditView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Edit Song");
        EditViewController songEdit = loader.<EditViewController>getController();
        stage.show();
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
        player.anything();
        //getTableView();
        
    }

    @FXML
    private void pressNext(ActionEvent event) {
    }

    @FXML
    private void selectPlaylist(MouseEvent event) {
    }

    @FXML
    private void selectPlaylistSong(MouseEvent event) {
    }

    @FXML
    private void selectSong(MouseEvent event) {
    }

    @FXML
    private void dragSlider(MouseEvent event) {
    }
    
}
