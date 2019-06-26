package java.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestController
{

    @Test
    public void testPathConversion() {
        assertEquals("testMusic.mp3", MagicBuilder.getSongnameFromPath("H:\\ODU\\src\\project\\java\\pictures\\testMusic.mp3"));
    }


}
