package view;

import javax.swing.*;
import java.awt.*;

public class application extends JFrame{

    private JButton PreviousButton;
    private JLabel SongTitleLabel;
    private JButton NextButton;
    private JButton RandomPlayButton;
    private JButton LoopButton;
    private JButton ChooseDirectoryButton;
    private JButton FavouritesButton;
    private JButton AboutButton;
    private JButton SettingsButton;
    private JButton PlaylistsButton;
    private JButton RecentButton;
    private JButton HelpButton;
    private JButton AlbumsButton;
    private JButton PlayButton;
    private JButton previousScreenButton;
    private JButton nextScreenButton;
    private JButton SpeakerButton;
    private JSlider slider;
    private JProgressBar progressBar;
    private JLabel HelpLabel;
    private JLabel AboutLabel;

    public JFrame frame;

    public boolean muted;
    public boolean random;
    public boolean loop;
    public boolean SliderIsZero;
    public application() {

        muted = false;
        random = false;
        loop = false;
        SliderIsZero = false;
        initializeView();
    }

    public void initializeView() {

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 204, 204));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JSeparator separatorHorizontal = new JSeparator();
        {
            separatorHorizontal.setBounds(0, 464, 794, 2);
            frame.getContentPane().add(separatorHorizontal);
        }

        progressBar = new JProgressBar();
        {
            progressBar.setMaximum(425);
            progressBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            progressBar.setForeground(Color.GREEN);
            progressBar.setBackground(SystemColor.menu);
            progressBar.setBounds(179, 477, 425, 7);
            frame.getContentPane().add(progressBar);
        }

        JLabel SpeakerLabel = new JLabel("");
        {
            SpeakerLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\speaker.png"));
            SpeakerLabel.setBounds(580, 505, 30, 30);
            frame.getContentPane().add(SpeakerLabel);
        }

        JSeparator separator_1 = new JSeparator();
        {
            separator_1.setBounds(88, 0, 0, 465);
            frame.getContentPane().add(separator_1);
        }

        JSeparator separatorVertical = new JSeparator();
        {
            separatorVertical.setOrientation(SwingConstants.VERTICAL);
            separatorVertical.setBounds(226, 0, 11, 466);
            frame.getContentPane().add(separatorVertical);
        }

        JLabel LogoLabel = new JLabel();
        {
            LogoLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\logov2.png"));
            LogoLabel.setBounds(0, 260, 226, 204);
            frame.getContentPane().add(LogoLabel);
        }


        JLabel RecentLabel = new JLabel("New label");
        {
            RecentLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\recent.png"));
            RecentLabel.setBounds(25, 10, 25, 25);
            frame.getContentPane().add(RecentLabel);
        }

        JLabel FavouritesLabel = new JLabel("");
        {
            FavouritesLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\favorites.png"));
            FavouritesLabel.setBounds(25, 46, 25, 25);
            frame.getContentPane().add(FavouritesLabel);
        }

        JLabel PlaylistsLabel = new JLabel("");
        {
            PlaylistsLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\playlists.png"));
            PlaylistsLabel.setBounds(25, 82, 25, 25);
            frame.getContentPane().add(PlaylistsLabel);
        }

        JLabel AlbumsLabel = new JLabel("");
        {
            AlbumsLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\albums.png"));
            AlbumsLabel.setBounds(25, 118, 25, 25);
            frame.getContentPane().add(AlbumsLabel);
            AlbumsLabel.setVisible(false);
        }

        JLabel HelpLabelIcon = new JLabel("");
        {
            HelpLabelIcon.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\help.png"));
            HelpLabelIcon.setBounds(25, 154, 25, 25);
            frame.getContentPane().add(HelpLabelIcon);
        }

        JLabel AboutLabelIcon = new JLabel("");
        {
            AboutLabelIcon.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\about.png"));
            AboutLabelIcon.setBounds(25, 190, 25, 25);
            frame.getContentPane().add(AboutLabelIcon);
        }

        JLabel SettingsLabel = new JLabel("");
        {
            SettingsLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\25x25\\settings.png"));
            SettingsLabel.setBounds(25, 226, 25, 25);
            frame.getContentPane().add(SettingsLabel);
        }

        SongTitleLabel = new JLabel("Tytuł piosenki");
        {
            SongTitleLabel.setBackground(new Color(255, 255, 255));
            SongTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            SongTitleLabel.setForeground(new Color(0, 0, 0));
            SongTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            SongTitleLabel.setBounds(25, 495, 175, 35);
            frame.getContentPane().add(SongTitleLabel);
        }

        HelpLabel = new JLabel("");
        {
            HelpLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\HelpWindow.png"));
            HelpLabel.setBounds(226, 61, 558, 402); // x, y, width, height
            frame.getContentPane().add(HelpLabel);
            HelpLabel.setVisible(false);
        }
        AboutLabel = new JLabel("");
        {
            AboutLabel.setIcon(new ImageIcon("src\\main\\java\\pictures\\AboutWindow.png"));
            AboutLabel.setBounds(226, 61, 558, 402); // x, y, width, height
            frame.getContentPane().add(AboutLabel);
            AboutLabel.setVisible(false);
        }

        JSeparator separator = new JSeparator();
        {
            separator.setBounds(226, 60, 557, 5);
            frame.getContentPane().add(separator);
        }

        PlayButton = new JButton("");
        {
            PlayButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\playButton.png"));
            PlayButton.setBounds(362, 490, 60, 60);
            frame.getContentPane().add(PlayButton);
        }

        PreviousButton = new JButton();
        {

            PreviousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PreviousButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\previousButton.png"));
            PreviousButton.setBounds(302, 495, 50, 50);
            frame.getContentPane().add(PreviousButton);
        }

        NextButton = new JButton();
        {

            NextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            NextButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\nextButton.png"));
            NextButton.setBounds(432, 495, 50, 50);
            frame.getContentPane().add(NextButton);
        }

        RandomPlayButton = new JButton();
        {
            RandomPlayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            RandomPlayButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\randomButton1.png"));
            RandomPlayButton.setBounds(246, 497, 45, 45);
            frame.getContentPane().add(RandomPlayButton);
        }

        LoopButton = new JButton();
        {
            LoopButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            LoopButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\loopButton.png"));
            LoopButton.setBounds(492, 497, 45, 45);
            frame.getContentPane().add(LoopButton);
        }

        ChooseDirectoryButton = new JButton();
        {
            ChooseDirectoryButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\folder.png"));
            ChooseDirectoryButton.setBounds(727, 9, 45, 45);
            frame.getContentPane().add(ChooseDirectoryButton);
        }

        FavouritesButton = new JButton("Favourites");
        {
            FavouritesButton.setBounds(60, 46, 140, 25);
            frame.getContentPane().add(FavouritesButton);
        }

        AboutButton = new JButton("About");
        {
            AboutButton.setBounds(60, 190, 140, 25);
            frame.getContentPane().add(AboutButton);
        }

        SettingsButton = new JButton("Settings");
        {
            SettingsButton.setBounds(60, 226, 140, 25);
            frame.getContentPane().add(SettingsButton);
        }

        PlaylistsButton = new JButton("Playlists");
        {
            PlaylistsButton.setBounds(60, 82, 140, 25);
            frame.getContentPane().add(PlaylistsButton);
        }

        RecentButton = new JButton("Recent");
        {
            RecentButton.setBounds(60, 10, 140, 25);
            frame.getContentPane().add(RecentButton);
        }

        HelpButton = new JButton("Help");
        {
            HelpButton.setBounds(60, 154, 140, 25);
            frame.getContentPane().add(HelpButton);
        }

        AlbumsButton = new JButton("Albums");
        {
            AlbumsButton.setBounds(60, 118, 140, 25);
            frame.getContentPane().add(AlbumsButton);
            AlbumsButton.setVisible(false);
        }

        previousScreenButton = new JButton();
        {
            previousScreenButton.setBounds(226, 440, 279, 25);
            previousScreenButton.setText("Previous Page");
            frame.getContentPane().add(previousScreenButton);
        }

        nextScreenButton = new JButton();
        {
            nextScreenButton.setBounds(505, 440, 279, 25);
            nextScreenButton.setText("Next Page");
            frame.getContentPane().add(nextScreenButton);
        }

        SpeakerButton = new JButton();
        {
            SpeakerButton.setIcon(new ImageIcon("src\\main\\java\\pictures\\speaker.png"));
            SpeakerButton.setBounds(580, 505, 30, 30);
            frame.getContentPane().add(SpeakerButton);
        }

        slider = new JSlider();
        {
            slider.setBackground(new Color(204, 204, 204));
            slider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            slider.setBounds(618, 507, 140, 25);
            frame.getContentPane().add(slider);
        }

    }

    public JButton getPreviousButton()
    {
        return PreviousButton;
    }

    public JButton getNextButton() {
        return NextButton;
    }

    public JButton getRandomPlayButton() {
        return RandomPlayButton;
    }

    public JButton getLoopButton() {
        return LoopButton;
    }

    public JButton getChooseDirectoryButton() {
        return ChooseDirectoryButton;
    }

    public JButton getFavouritesButton() {
        return FavouritesButton;
    }

    public JButton getAboutButton() {
        return AboutButton;
    }

    public JButton getSettingsButton() {
        return SettingsButton;
    }

    public JButton getPlaylistsButton() {
        return PlaylistsButton;
    }

    public JButton getRecentButton() {
        return RecentButton;
    }

    public JButton getHelpButton() {
        return HelpButton;
    }

    public JButton getAlbumsButton() {
        return AlbumsButton;
    }

    public JButton getPlayButton() {
        return PlayButton;
    }

    public JButton getPreviousScreenButton() {
        return previousScreenButton;
    }

    public JButton getNextScreenButton() {
        return nextScreenButton;
    }

    public JButton getSpeakerButton() {
        return SpeakerButton;
    }

    public JSlider getSlider() {
        return slider;
    }

    public JProgressBar getProgressBar()
    {
        return progressBar;
    }

    public JLabel getHelpLabel() {
        return HelpLabel;
    }

    public JLabel getAboutLabel() {
        return AboutLabel;
    }

    public JLabel getSongTitleLabel() {
        return SongTitleLabel;
    }
}
