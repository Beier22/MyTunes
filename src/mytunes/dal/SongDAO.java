/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        /*try(Connection con = conProvider.getConnection())
        {
            String sql = "DELETE FROM Songs WHERE cprno =?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s.getId());
            pstmt.execute();
        } catch (SQLServerException ex)
        {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
