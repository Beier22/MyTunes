/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import java.util.List;
import mytunes.be.Playlist;

/**
 *
 * @author Marek
 */
public class PlaylistDAO
{
    private ConnectionProvider conProvider;
    
    public PlaylistDAO()
    {
        conProvider = new ConnectionProvider();
    }
    
    public void deletePlaylist(Playlist p)
    {
        
    }
    
    public void createPlaylist(Playlist p)
    {
        
    }
    
    public Playlist getPlaylist(String name)
    {
        return null;
    }

    public List<Playlist>getAllPlaylists()
    {
        return null;
    }


    
    
}
