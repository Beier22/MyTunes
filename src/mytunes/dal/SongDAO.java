/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import java.util.List;
import mytunes.be.Song;

/**
 *
 * @author Marek
 */
public class SongDAO
{
    private ConnectionProvider conProvider;

    public SongDAO()
    {
        conProvider = new ConnectionProvider();
    }
    
    public void removeSong(Song s)
    {
        
    }
    
    public void addSong(Song s)
    {
        
    }
    
    public Song getSong(String name)
    {
        return null;
    }
    
    public List<Song> getAllSongs()
    {
       return null; 
    }
}
