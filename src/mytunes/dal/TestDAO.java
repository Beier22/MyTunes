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
public class TestDAO
{
    public static void main(String[] kokot)
    {
        SongDAO dao = new SongDAO();
        List<Song> songs = dao.getAllSongs();
        for (Song song : songs)
        {
            System.out.println(song);
        }
        Song s = dao.getSong(1);
        System.out.println(s);
    }
    
}
