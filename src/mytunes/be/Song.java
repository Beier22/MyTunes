/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Tothko
 */
public class Song {

    private int ID;
    private StringProperty title;
    private StringProperty filePath;// = "D:\\School\\NetbeansProject\\MojeTunes2\\MyTunes\\music\\TEST.wav";
    private int duration;
    private StringProperty artist;
    private StringProperty category;
    private StringProperty durationString;
    
    private StringProperty durationStringProperty()
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
    }

    public Song(int ID, String title, String filePath) {
        this.ID = ID;
        titleProperty().set(title);
        filePathProperty().set(filePath);
        
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

    public void play(int time) {

    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return titleProperty().get();
    }

    public void setTitle(String title) {
        titleProperty().set(title);
    }

    public String getFilePath() {
        return filePathProperty().getValue();
    }

    public void setFilePath(String filePath) {
        filePathProperty().setValue(filePath);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        //durationStringProperty().set(value);
    }

    public String getArtist() {
        return artistProperty().getValue();
    }

    public void setArtist(String artist) {
        artistProperty().setValue(artist);
    }

    public String getCategory() {
        return categoryProperty().getValue();
    }

    public void setCategory(String category) {
        categoryProperty().setValue(category);
    }

    @Override
    public String toString()
    {
        return "Song{" + "ID=" + ID + ", title=" + titleProperty().getValue() + ", filePath=" + 
                filePathProperty().getValue() + ", duration=" + duration + ", artist=" + artistProperty().getValue() 
                + ", category=" + categoryProperty().getValue() + '}';
    }
    
    
    
    

}
