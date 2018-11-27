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
public interface IModel
{
    List<Song> getAllSongs();
    List<Playlist> getAllPlaylists();
    void saveSong(Song s);
    void savePlaylist(Playlist p);
    void deleteSong(Song s);
    void deletePlaylist(Playlist p);    
}
