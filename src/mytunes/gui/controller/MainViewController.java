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
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mytunes.be.Playlist;
import mytunes.be.SimpleAudioPlayer;
import mytunes.be.Song;
import mytunes.bll.IModel;
import mytunes.bll.Model;
import mytunes.bll.PlayerModel;

/**
 *
 * @author mads_
 */
public class MainViewController implements Initializable {

 

    private IModel model = new Model();

    private ObservableList<Song> songs;
    private ObservableList<Playlist> playlists;

    private Playlist selectedPlaylist;
    private Song playingSong;
    private Song selectedSong;
    private PlayerModel pmodel = new PlayerModel();
    @FXML
    private ListView<Song> songsInPlaylistTable;
    
    @FXML
    private ListView<Playlist> playlistTable;
            
    @FXML
    private ListView<Song> loadedPlaylist;
    
    @FXML
    private Label currentlyPlaying;
    @FXML
    private Button buttonPrevious;
    @FXML
    private Button buttonPlay;
    @FXML
    private Button buttonNext;
    @FXML
    private TextField songPlayingField;
    @FXML
    private Slider sliderChannels;
    @FXML
    private Slider sliderVolume;
    @FXML
    private Slider sliderSongtime;
    @FXML
    private Button buttonStop;
    @FXML
    private Button buttonShuffle;
    @FXML
    private Button buttonRepeat;
    @FXML
    private Button buttonRepeatCount;
    
    private boolean isPlaying = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        songs = FXCollections.observableArrayList();
        songs.addAll(model.getAllSongs());;
        loadedPlaylist.setItems(songs);
        //songTimeCol.setCellValueFactory(new PropertyValueFactory("duration"));

        playlists = FXCollections.observableArrayList();
        playlists.addAll(model.getAllPlaylists());
        playlistTable.setItems(playlists);
        
        
        
        

    }

    public void updatePlaylistTable() {

        playlistTable.getItems().clear();
        playlists.removeAll();
        playlists.addAll(model.getAllPlaylists());
        playlistTable.setItems(playlists);
    }

    public void updateSongTable() {

        loadedPlaylist.getItems().clear();
        songs.removeAll();
        songs.addAll(model.getAllSongs());
        loadedPlaylist.setItems(songs);
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

    private void editPlaylist(ActionEvent event) throws IOException {
        Stage s = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/PlaylistEditView.fxml"));
        s.setScene(new Scene(loader.load()));
        s.setTitle("Edit Playlist");
        PlaylistEditViewController questions = loader.<PlaylistEditViewController>getController();
        s.show();
    }

    private void deletePlaylist(ActionEvent event) {
        Playlist p = playlistTable.getSelectionModel().getSelectedItem();
        model.deletePlaylist(p);
        updatePlaylistTable();
    }


    @FXML
    private void addToPlaylist(ActionEvent event) {
        Song s;
        Playlist p;
        if(playlistTable.getSelectionModel().getSelectedItem() != null && loadedPlaylist.getSelectionModel().getSelectedItem() != null)
        {
            s = loadedPlaylist.getSelectionModel().getSelectedItem();
            p = playlistTable.getSelectionModel().getSelectedItem();
            model.addSongToPlaylist(p, s);
            selectPlaylist(null);
        }
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

    private void editSong(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/gui/view/EditView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Edit Song");
        EditViewController songEdit = loader.<EditViewController>getController();
        stage.show();
    }

    private void deleteSong(ActionEvent event) {
        Song s = loadedPlaylist.getSelectionModel().getSelectedItem();
        model.deleteSong(s);
        updateSongTable();
    }

    private void search(KeyEvent event) {
       /* ObservableList<Playlist> playlistRs = FXCollections.observableArrayList();
        ObservableList<Song> songRs = FXCollections.observableArrayList();
        String input = searchInput.getText().toLowerCase();
        
        for (Song s : songs) {
            if(s.getTitle().toLowerCase().contains(input))
                songRs.add(s);
        }
        
        songsTable.setItems(songRs);
        
        for (Playlist p : playlists) {
            if(p.getName().toLowerCase().contains(input))
                playlistRs.add(p);
        }
        
        playlistTable.setItems(playlistRs);
*/
    }

    @FXML
    private void pressPrevious(ActionEvent event) {
    }

    @FXML
    private Song pressPlay(ActionEvent event) {
        Song s;
        if ((s = loadedPlaylist.getSelectionModel().getSelectedItem()) != null && isPlaying == false) {
            s = loadedPlaylist.getSelectionModel().getSelectedItem();
            pmodel.play(s);
            isPlaying = true;
        } else if (isPlaying == true) {
            pmodel.pause();
            isPlaying = false;
        } else {
            return null;
        }
        return s;

    }

    @FXML
    private void pressNext(ActionEvent event) {
    }

    @FXML
    private void selectPlaylist(MouseEvent event) {
        ObservableList<Song> songs = FXCollections.observableArrayList();
        Playlist p = playlistTable.getSelectionModel().getSelectedItem();
        if(p!=null)
        {
            songs = model.getPlaylistSongs(p);
            songsInPlaylistTable.setItems(songs);
        }
        
    }

    @FXML
    private void selectPlaylistSong(MouseEvent event) {
    }

    @FXML
    private void pressStop(ActionEvent event) {
    }

    @FXML
    private void pressShuffle(ActionEvent event) {
    }

    @FXML
    private void pressRepeat(ActionEvent event) {
    }

    @FXML
    private void pressRepeatCount(ActionEvent event) {
    }

    @FXML
    private void viewAllSongs(ActionEvent event) {
        initialize(null, null);
    }

}
