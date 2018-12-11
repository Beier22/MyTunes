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

 

    

    private ObservableList<Song> songsInPlaylist;
    private ObservableList<Song> loadedSongs;
    private ObservableList<Playlist> playlists;
    
    private Playlist selectedPlaylist;
    private Song playingSong;
    private Song selectedSong;
    
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
    private boolean shuffleEnabled = false;
    private boolean repeatEnabled = false;
    private int repeatCount = 0;
    private int currentID = 0;
    @FXML
    private TextField searchSongsField;
    @FXML
    private TextField songsPlaylistSearchField;
    @FXML
    private TextField playlistSearchField;
    private PlayerModel pmodel;
    private IModel model; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Model();
        loadedSongs= FXCollections.observableArrayList();
        loadedSongs.addAll(model.loadAllSongs());
        loadedPlaylist.setItems(loadedSongs);
        //songTimeCol.setCellValueFactory(new PropertyValueFactory("duration"));

        playlists = FXCollections.observableArrayList();
        playlists.addAll(model.getAllPlaylists());
        playlistTable.setItems(playlists);
        pmodel = new PlayerModel();
        
        
        
        

    }
    public void updateSonginPlaylistTable(Playlist p) {

        songsInPlaylistTable.getItems().clear();
        songsInPlaylist.removeAll();
        songsInPlaylist.addAll(model.getPlaylistSongs(p));
        songsInPlaylistTable.setItems(songsInPlaylist);
    }
           

    public void updatePlaylistTable() {

        playlistTable.getItems().clear();
        playlists.removeAll();
        playlists.addAll(model.getAllPlaylists());
        playlistTable.setItems(playlists);
    }

    public void updateSongTable() {

        loadedPlaylist.getItems().clear();
        loadedSongs.removeAll();
        loadedSongs.addAll(model.getAllSongs());
        loadedPlaylist.setItems(loadedSongs);
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
        pmodel.playPrevious(getNext(event));
               
    }

    @FXML
    private Song pressPlay(ActionEvent event) {
        Song s;
        if ((s = loadedPlaylist.getSelectionModel().getSelectedItem()) != null && isPlaying == false) {
            s = loadedPlaylist.getSelectionModel().getSelectedItem();
            playingSong = s;
            currentID = s.getID();
            isPlaying = true;
            pmodel.play(s);
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
        pmodel.playNext(playingSong);
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
        pmodel.stop();
        
    }

    @FXML
    private void pressShuffle(ActionEvent event) {
        
        if(shuffleEnabled){
            shuffleEnabled = false;
            
        }
        else{
            shuffleEnabled = true;
            
        }
    }

    @FXML
    private void pressRepeat(ActionEvent event) {
        if(repeatEnabled){
            repeatEnabled=false;
        }
        else
            repeatEnabled = true;
    }

    @FXML
    private void pressRepeatCount(ActionEvent event) {
    }

    @FXML
    private void viewAllSongs(ActionEvent event) {
        model.loadAllSongs();
    }

    @FXML
    private void searchSongs(KeyEvent event) {
        ObservableList<Song> results = FXCollections.observableArrayList();
        String input = searchSongsField.getText().toLowerCase();
        
        for (Song s : loadedSongs) {
            if(s.getTitle().toLowerCase().contains(input))
                results.add(s);
        }
        
        loadedPlaylist.setItems(results);
        
    }

    @FXML
    private void songsPlaylistSearch(KeyEvent event) {
        ObservableList<Song> results = FXCollections.observableArrayList();
        String input = songsPlaylistSearchField.getText().toLowerCase();
        
        for (Song s : songsInPlaylist) {
            if(s.getTitle().toLowerCase().contains(input))
                results.add(s);
        }
        
        songsInPlaylistTable.setItems(results);
        
    }

    @FXML
    private void playlistSearch(KeyEvent event) {
        ObservableList<Playlist> results = FXCollections.observableArrayList();
        String input = playlistSearchField.getText().toLowerCase();
        
        for (Playlist p : playlists) {
            if(p.getName().toLowerCase().contains(input))
                results.add(p);
        }
        
        playlistTable.setItems(results);
        
    }
    private Song getNext(ActionEvent event){
        Song nextSong = null;
        
        if(repeatEnabled && (event == null)){
            return playingSong;
        }
        else if(shuffleEnabled) {
            for (Song song : loadedSongs) {
           if(song.getID() == playingSong.getID()+(int)Math.random()*model.getMaxID()){
           nextSong=song;
           }
            
        }
            return nextSong;
        }
        
        else{
            for (Song song : loadedSongs) {
           if(song.getID() == playingSong.getID()+1){
           nextSong=song;
           }
            
        }
       
            
            return nextSong;
        }
    }
    private Song getPrevious(){
        Song previousSong = null;
        for (Song song : loadedSongs) {
           if(song.getID() == playingSong.getID()-1){
           previousSong=song;
           return previousSong;
           }
            
        }
       return previousSong;
    }

}
