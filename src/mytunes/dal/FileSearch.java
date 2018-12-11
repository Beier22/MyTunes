/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import java.io.File;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;



/**
 *
 * @author Tothko
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mytunes.be.Song;


public class FileSearch {
  private int i = 0;
  private List<Song> songs;
  private String fileNameToSearch;
  
  
  public String getFileNameToSearch() {
	return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
	this.fileNameToSearch = fileNameToSearch;
  }

  
  public FileSearch(){
      songs = new ArrayList();
      searchDirectory(new File("music"), ".mp3");
      //searchDirectory(new File("music"), ".wav");
      
  }

  public void searchDirectory(File directory, String fileNameToSearch) {

	setFileNameToSearch(fileNameToSearch);

	if (directory.isDirectory()) {
	    search(directory);
	}
  }

  private void search(File file) {
      
	if (file.isDirectory()) {
	    if (file.canRead()) {
                
		for (File temp : file.listFiles()) {
                    i++;
		    if (temp.isDirectory()) {
			search(temp);
		    } else {
			if (temp.getAbsolutePath().contains(".mp3")) {
                            Song s = new Song();
                            
                            //SongTAG tag = new SongTAG(temp.getAbsolutePath());
                            //tag.learnMetadata();
                            
                              s.setID(i);  
                            
                            
                            s.setTitle(temp.getName());
                            s.setFilePath(temp.getAbsolutePath());
                            //s.setDuration(temp);
                            //s.setCategory(tag.getCategory());
                            System.out.println(s);
			    songs.add(s);
		    }
                        else if(temp.getAbsolutePath().contains(".wav")){
                            Song s = new Song();
                            s.setID(i); 
                            s.setTitle(temp.getName());
                            s.setFilePath(temp.getAbsolutePath());
			    songs.add(s);
                        }
		}
	    }
}
      }

  }
  
  public List<Song> getSongs(){
      
      return songs;
      
  }

}
