package model;

import java.io.File;

public class Song {
    private String song;

    // create a song based on the current file path
    public Song(String songPath) {
        song = songPath;
    }

    public String getFile()
    {
        return song;
    }
}
