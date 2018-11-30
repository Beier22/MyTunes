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
import mytunes.be.Playlist;
import mytunes.be.Song;

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
        try (Connection con = conProvider.getConnection()){
            String sql = "DELETE FROM Playlists WHERE ID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getID());
            stmt.execute();
        }
        catch(SQLServerException ex){
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex){
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createPlaylist(Playlist p)
    {
        try (Connection con = conProvider.getConnection()){
            String sql = "INSERT INTO Playlists (Name) VALUES (?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.execute();
        }
        catch(SQLServerException ex){
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex){
            Logger.getLogger(PlaylistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Playlist getPlaylist(String name)
    {
        return null;
    }
    
    private Playlist playlistFromRs(ResultSet rs)
    {
        Playlist retval = null;
        try
        {
            retval = new Playlist(rs.getInt("ID"),rs.getString("Name"));
        } catch (SQLException ex)
        {
            Logger.getLogger(SongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retval;
    }
    
    public List<Playlist> getAllPlaylists()
    {
        List<Playlist> retval = new ArrayList<>();
        try(Connection con = conProvider.getConnection())
        {
            String sqlStatement = "SELECT * FROM Playlists";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next())
            {
                retval.add(playlistFromRs(rs));
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
