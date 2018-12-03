/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.bll;

import mytunes.be.SimpleAudioPlayer;

/**
 *
 * @author Tothko
 */
public class PlayerModel implements IPlayerModel{
    String path;
    SimpleAudioPlayer SAP;

    public PlayerModel(String path) {
        this.path = path;
        SAP = new SimpleAudioPlayer(path);
    }
    
    @Override
    public void play(){
        SAP.play();
    }
    @Override
    public void stop(){
        SAP.stop();
    }
            
    @Override
    public void playNext(){
        SAP.playNext(path);
    }
    @Override
    public void playPrevious(){
        SAP.playPrevious(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
