package controller;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;



public class utils {

    private static MediaPlayer player;
    private static Media media;
    private static String fileNameVariable;
    public static void inicialize_player(String fileName)
    {
        File file = new File(fileName.replace('\\', '/'));
        media = new Media(file.toURI().toASCIIString());
        player = new MediaPlayer(media);

    }
    public static void stopSound()
    {
        player.pause();
    }
    public static void startSound()
    {
        player.play();
    }
    public static void changeCurrentTime(double NewTime)
    {
        player.seek(Duration.millis(NewTime));
    }
    public static double getCurrentTime()
    {
        return player.getCurrentTime().toMillis();
    }
    public static void loadSong(String fileName)
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                fileNameVariable = fileName;
                inicialize_player(fileName);
                return;
            }
        };
        r.run();
    }
    public static double getSongTime() {
        return player.getStopTime().toMillis();
    }
    public static void loop(boolean loop)
    {
        if(loop) {
            player.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    player.seek(Duration.millis(0));
                    return;
                }
            });
        }
        else
        {
            player.setOnEndOfMedia(null);
        }

    }
    public static void setVolume(double volume)
    {
        player.setVolume(volume);
    }
    public static void setMute(boolean value)
    {
        player.setMute(value);
    }
    public static  void setStart()
    {
        player.seek(Duration.millis(0));
    }
    public static String getFileName()
    {
        return fileNameVariable;
    }
}
