package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileController {
    private static File file;
    private static ArrayList<String> fileContent;
    private static Path configFilePath;

    public FileController(String filePath)
    {
        fileContent = new ArrayList<>();
        configFilePath = Paths.get(filePath);
    }

    public static void fileRead()
    {
        try (Stream<String> stream = Files.lines(configFilePath)) {
            stream.forEach(line -> fileContent.add(line));
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fileAppend(String playlistName, String path)
    {
        try {
            Files.write(configFilePath, (playlistName+"\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(configFilePath, (path+"\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static ArrayList<String> getFileContent()
    {
        return fileContent;
    }
    public File getFile()
    {
        return file;
    }
}
