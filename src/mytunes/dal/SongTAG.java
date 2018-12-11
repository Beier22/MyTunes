/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SongTAG {

    private String title;

    private int duration;
    private String artist;
    private String category;
    private String filePath;

    public SongTAG(String filePath) {
        this.filePath = filePath;
    }

    public void learnMetadata() {

        try {

            InputStream input = new FileInputStream(new File(filePath));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            String[] metadataNames = metadata.names();

            for (String name : metadataNames) {
                System.out.println(name + ": " + metadata.get(name));
            }

            //title = metadata.get("title");
            //artist = metadata.get("xmpDM:artist");
            //duration = (Integer.parseInt(metadata.get("xmpDM:duration")) / 1000) / 60;
            //category = metadata.get("genre");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getCategory() {
        return category;
    }

}
