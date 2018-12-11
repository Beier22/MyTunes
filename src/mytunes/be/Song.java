/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mytunes.dal.SongTAG;

/**
 *
 * @author Tothko
 */
public class Song {

    private int ID;
    private String title;
    private String filePath;
    private int duration;
    private String artist;
    private String category;
    
    
    

    /*private StringProperty durationStringProperty()
    {
       if (durationString == null) durationString = new SimpleStringProperty(this, "durationString");
            return durationString;  
    }
    
    private StringProperty filePathProperty()
    {
        if (filePath == null) filePath = new SimpleStringProperty(this, "lastName");
            return filePath; 
    }
    
    private StringProperty titleProperty()
    {
        if (title == null) title = new SimpleStringProperty(this, "title");
            return title; 
    }
    
    private StringProperty artistProperty()
    {
        if (artist == null) artist = new SimpleStringProperty(this, "artist");
            return artist; 
    }
    
    private StringProperty categoryProperty()
    {
        if (category == null) category = new SimpleStringProperty(this, "category");
            return category; 
    }*/

    public Song(){
    
}
    public Song(String title, String artist, String filePath, String genre, int duration) {
        this.category = genre;
        this.artist = artist;
        this.title = title;
        this.filePath = filePath;
        this.duration = duration;
        
       /* 
        try {

            SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer(filePath);

            audioPlayer.play();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
        System.out.println("Song succesfully created");*/
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    
    @Override
    public String toString()
    {
        return +ID+" " + title + ", " + artist;
    }
    
    
    
    

}
