package model;
import model.Song;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Playlist {
    private List<Song> playlist;
    //Iterator i = playlist. index();
    // the default constructor creating a new playlist
    public Playlist() {
        playlist = new ArrayList<>();

    }

    // method that saves a new song to the playlist
    public void loadSongs(String songPath) {

        playlist.add(new Song(songPath));
        System.out.println("wczytałem: "+songPath);
    }

    // get a song from a playlist
    public Song getSong(int index) {
        return playlist.get(index);
    }

    // method that returns the current length of the playlist
    public int getCount() {
        return playlist.size();
    }

    public void removeSong(int index)
    {
        playlist.remove(index);
    }
}