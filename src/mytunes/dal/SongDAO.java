/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        try(Connection con = conProvider.getConnection())
        {
            String sql = "DELETE FROM PlaylistsSongs WHERE SongID = ?; DELETE FROM Songs WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, s.getID());
            pstmt.setInt(2, s.getID());
            pstmt.execute();
        } catch (SQLServerException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addSong(Song s)
    {
        try(Connection con = conProvider.getConnection())
        {
            String sql = "INSERT INTO Songs(Title,Category,Duration,Path,Artist) VALUES (?,?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s.getTitle());
            pstmt.setString(2, s.getCategory());
            pstmt.setInt(3,s.getDuration());
            pstmt.setString(4, s.getFilePath());
            pstmt.setString(5, s.getArtist());
            pstmt.execute();
        } catch (SQLServerException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Song getSong(int id)
    {
        Song retval= null;
        try(Connection con = conProvider.getConnection())
        {
            String sql = "SELECT * FROM Songs WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id); 
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                retval = songFromRs(rs);
            }
        } catch (SQLServerException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }
    
    public List<Song> getAllSongs()
    {
        List<Song> retval = new ArrayList<>();
        try(Connection con = conProvider.getConnection())
        {
            String sqlStatement = "SELECT * FROM Songs";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next())
            {
                retval.add(songFromRs(rs));
            }
        } catch (SQLServerException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }
    
    private Song songFromRs(ResultSet rs)
    {
        Song retval = null;
        try
        { 
            retval = new Song(rs.getString("Title"),rs.getString("Artist"),rs.getString("Path"),rs.getString("Category"),rs.getInt("Duration"));
            retval.setDuration(rs.getInt("Duration"));
            retval.setCategory(rs.getString("Category"));
            retval.setArtist(rs.getString("Artist"));
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }
}
