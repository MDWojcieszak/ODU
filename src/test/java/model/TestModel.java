package java.model;

import model.Playlist;
import model.PlaylistsContainer;
import model.Song;
import java.ProjoTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestModel {


    @Test
    public void testPlaylist()
    {
        PojoTestUtils.validateAccessors(Playlist.class);
    }

    @Test
    public void testPlaylistCointainer()
    {
        PojoTestUtils.validateAccessors(PlaylistsContainer.class);
    }

    @Test
    public void testSong()
    {
        PojoTestUtils.validateAccessors(Song.class);
    }

}
