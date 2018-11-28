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
        /*try(Connection con = conProvider.getConnection())
        {
            String sql = "DELETE FROM Songs/Artists WHERE SongID =? ; DELETE FROM Playlists/Songs WHERE SongID = ?; DELETE FROM Songs WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s.getId());
            pstmt.setString(2, s.getId());
            pstmt.setString(3, s.getId());
            pstmt.execute();
        } catch (SQLServerException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void addSong(Song s)
    {
        try(Connection con = conProvider.getConnection())
        {
            String sql = "INSERT INTO Songs(Title,Category,Duration,File) VALUES (?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, s.getTitle());
            pstmt.setString(2, s.getCategory());
           // pstmt.setString(3, s.getDuration());
           // pstmt.setString(3, s.getFile());
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
            String sql = "SELECT Songs.*,Artists.Name FROM ((Songs INNER JOIN  WHERE ID = ? INNER JOIN Songs/Artists  ;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ""+id);
            ResultSet rs = pstmt.executeQuery();
            //retval = new Song(rs.getInt("ID"),rs.getString("Title"),rs.getString("File"));
            //retval.setDuration(rs.getInt("Duration"));
            retval.setCategory(rs.getString("Category"));
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
                String id = rs.getString("ID");
                String title = rs.getString("Title");
                String job = rs.getString("Category");
                //Song s = new Song(id,title,job);
                //retval.add(s);
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
}
