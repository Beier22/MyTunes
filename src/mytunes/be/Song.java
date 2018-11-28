/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;

/**
 *
 * @author Tothko
 */
public class Song {

    private int ID;
    private String title;
    private String filePath = "D:\\School\\NetbeansProject\\MojeTunes2\\MyTunes\\music\\Undead.mp3";
    private int totalTime;
    private String artist;
    private String category;
    
    public Song(int ID) {
        this.ID = ID;
        
        
        try {
          
            SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer(filePath);
            
            audioPlayer.play();
            while(true){
                
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
        System.out.println("Song succesfully created");
    }

    public void play(int time) {

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

}
