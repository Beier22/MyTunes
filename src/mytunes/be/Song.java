/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 *
 * @author Tothko
 */



public class Song {
    
    public Song(){
        file = "kurva.mp3";
        
    }
    private String title;
    private String file;
    private int  totalTime;
    private String artist;
    private String category;
    private int currentTime;
    Media hit = new Media(new File(file).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(hit);
   
   public void pause(){

}
   public void play(){
       mediaPlayer.play();
}
   public void play(int time){
       mediaPlayer.setStartTime(time);

}

   
   
   
   
   
   
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
   
}


