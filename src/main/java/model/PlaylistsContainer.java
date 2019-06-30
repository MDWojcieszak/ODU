package model;
import model.Playlist;
import java.util.*;
import java.io.File;

public class PlaylistsContainer {
    private List<Playlist> playlistsContainer;
    private List<String> playlistsName;

    public PlaylistsContainer() {
        playlistsContainer = new ArrayList<>();
        playlistsName = new ArrayList<>();
    }


    public void addPlaylist(Playlist playlist, String playlistName)
    {
        playlistsContainer.add(playlist);
        playlistsName.add(playlistName);
    }

    public String getPlaylistName(int index)
    {
        return playlistsName.get(index);
    }

    public Playlist getPlaylist(int index) {
        return playlistsContainer.get(index);
    }

    public int getNumberOfPlaylists() {
        return playlistsContainer.size();
    }
}
