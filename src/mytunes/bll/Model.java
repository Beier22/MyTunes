/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.bll;

import java.util.List;
import mytunes.be.Playlist;
import mytunes.be.Song;

/**
 *
 * @author Marek
 */
public class Model implements IModel
{
    private SongDAO songDao;
    private PlaylistDAO playlistDao;
    
    public Model()
    {
        songDao = new SongDAO();
        playlistDao = new PlaylistDAO();
    }
    
    @Override
    public List<Song> getAllSongs()
    {
        return songDao.getAllSongs(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Playlist> getAllPlaylists()
    {
        return playlistDao.getAllSongs(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveSong(Song s)
    {
        songDao.saveSong(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void savePlaylist(Playlist p)
    {
        playlistDao.savePlaylist(p); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSong(Song s)
    {
        songDao.deleteSong(s); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePlaylist(Playlist p)
    {
        playlistDao.deletePlaylist(p); //To change body of generated methods, choose Tools | Templates.
    }
    
}
