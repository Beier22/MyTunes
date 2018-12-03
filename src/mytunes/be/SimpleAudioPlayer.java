/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
/**
 *
 * @author Tothko
 */
public class SimpleAudioPlayer {
    String filePath;
    static MediaPlayer mediaPlayer;
    Media hit;
    public SimpleAudioPlayer(){
        /*this.filePath = filePath;
        hit = new Media(new File(filePath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);*/
    }
   
    public void play(String path){
        
       System.out.println(path);
       hit = new Media(new File(path).toURI().toString());
       mediaPlayer = new MediaPlayer(hit);
       mediaPlayer.stop();
       mediaPlayer.play(); 
       
    }
    public void pause(){
        mediaPlayer.pause();
        
    }
    
    public void stop(){
        mediaPlayer.stop();
    }
    public void playNext(String next){
        filePath = next;
        mediaPlayer.pause();
        
    }
    public void playPrevious(String previous){
        filePath = previous;
        mediaPlayer.pause();
        
    }
  
    }
    /*Long currentFrame;
    Clip clip;
    String status;
    AudioInputStream audioInputStream;
    String filePath;
    
    public SimpleAudioPlayer(String filePath)throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object 
        this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(this.filePath).getAbsoluteFile());
        System.out.println(audioInputStream);
        // create clip reference 
        clip = AudioSystem.getClip();
        System.out.println(clip);
        // open audioInputStream to the clip 
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
        
        
    }

    public void play()  
    { 
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
      
    // Method to pause the audio 
    public void pause()  
    { 
        if (status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  
        this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
      
    // Method to resume the audio 
    public void resumeAudio() throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    } 
      
    // Method to restart the audio 
    public void restart() throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
      
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    } 
      
    // Method to jump over a specific part 
    public void jump(long c) throws UnsupportedAudioFileException, IOException, 
                                                        LineUnavailableException  
    { 
        if (c > 0 && c < clip.getMicrosecondLength())  
        { 
            clip.stop(); 
            clip.close(); 
            resetAudioStream(); 
            currentFrame = c; 
            clip.setMicrosecondPosition(c); 
            this.play(); 
        } 
    } 
      
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } */
    
    

