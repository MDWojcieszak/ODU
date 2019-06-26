package java.model;

import model.Playlist;
import model.PlaylistsContainer;
import model.Song;
import org.junit.jupiter.api.Test;
import view.ButtonsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonsFactoryTest {

    @Test
    public void testPlaylist() {
        PojoTestUtils.validateAccessors(ButtonsFactory.class);
    }
}