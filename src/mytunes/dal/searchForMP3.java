/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import java.io.File;
import java.util.List;

/**
 *
 * @author Tothko
 */
public class searchForMP3 {
    public void walk(String path) {

    File root = new File(path);
    File[] list = root.listFiles();

    if (list == null) return;

    for (File f : list) {
        System.out.println(f);
        if (f.toString().contains(".mp3")){
        if (f.isDirectory()) {
            walk(f.getAbsolutePath());
        }
        else {
            //
        }
        
    }}
}
}
