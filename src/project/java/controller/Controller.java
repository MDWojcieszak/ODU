package controller;



public class Controller implements ActionListener, ChangeListener, MouseMotionListener, MouseListener {

    private boolean RecentView = false;
    private boolean FavouritesView = false;
    private boolean PlaylistsView = true;
    private boolean PlaylistsSongView = false;
    private boolean AlbumsView = false;
    private boolean chooseTrack = false;
    private int card = 0;
    private int SongIndex;
    private int currentPlaylist = 0;
    private int  index = 0;
    private Playlist playlist;
    private volatile boolean isPlaying = false;
    private boolean HelpLabel = false;
    private boolean AboutLabel = false;
    private boolean muted = false;
    private boolean isRandom = false;
    private boolean loop = false;
    private int mousePossition;
    private boolean SliderIsZero = false;
    private String bootDirectoryName = "D:\\OdtwarzaczDlaUbogich\\arrival.mp3";
    private application GUI;
    private File directory;
    private ArrayList<File> files;
    private ArrayList<JButton> buttons;
    private PlaylistsContainer playlistsContainer;
    private Thread thread;
    private FileController file;
	private ButtonsFactory buttonsFactory;

    public Controller() throws Exception {

		 this.GUI = new application();
        this.GUI.frame.setVisible(true);
        playlistsContainer = new PlaylistsContainer();
        buttonsFactory = new ButtonsFactory();
        buttons = buttonsFactory.createButtons(15);
        for (JButton b : buttons)
            GUI.frame.getContentPane().add(b);


        this.addActionListeners();
        load_player("H:\\JAVA\\OdtwarzaczDlaUbogich\\arrival.mp3");
        Thread thread = new Thread()
        {
            public void run() {
                while (true)
                {
                    if(isPlaying && !loop)
                    {
                        if(utils.getCurrentTime() == utils.getSongTime())
                        {
                            try {
                                chooseSong(true);
                                playButtonAction();
                                playButtonAction();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        thread.start();
        file = new FileController("H:\\JAVA\\OdtwarzaczDlaUbogich\\test.txt");
        file.fileRead();
        for(int i=0;i<=file.getFileContent().size()/2;i+=2)
        {
            File temp = new File(file.getFileContent().get(i+1));
            files = new ArrayList<File>(Arrays.asList(temp.listFiles()));
            ListIterator listIterator = files.listIterator();
            playlist = new Playlist();
            for(File f:files)
                playlist.loadSongs(listIterator.next().toString());

            playlistsContainer.addPlaylist(playlist, file.getFileContent().get(i));
            view();
        }
    }
	private void addActionListeners() {
        GUI.getPreviousButton().addActionListener(this);
        GUI.getNextButton().addActionListener(this);
        GUI.getRandomPlayButton().addActionListener(this);
        GUI.getLoopButton().addActionListener(this);
        GUI.getChooseDirectoryButton().addActionListener(this);
        GUI.getFavouritesButton().addActionListener(this);
        GUI.getAboutButton().addActionListener(this);
        GUI.getSettingsButton().addActionListener(this);
        GUI.getPlayButton().addActionListener(this);
        GUI.getRecentButton().addActionListener(this);
        GUI.getHelpButton().addActionListener(this);
        GUI.getAlbumsButton().addActionListener(this);
        GUI.getPlaylistsButton().addActionListener(this);
        GUI.getPreviousScreenButton().addActionListener(this);
        GUI.getNextScreenButton().addActionListener(this);
        GUI.getSpeakerButton().addActionListener(this);
        GUI.getSlider().addChangeListener(this);
        GUI.getProgressBar().addMouseMotionListener(this);
        GUI.getProgressBar().addMouseListener(this);
        for (JButton b : buttons)
            b.addActionListener(this);
    }
	@Override
    public void mouseClicked(MouseEvent e) {
        utils.changeCurrentTime(utils.getSongTime() * mousePossition / 425);
        GUI.getProgressBar().setValue(mousePossition);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePossition = e.getX();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if ((((JSlider) e.getSource()) == GUI.getSlider())) {
            try {
                sliderAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ((((JButton) e.getSource()) == GUI.getPreviousButton())) {
            try {
                previousButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        if ((((JButton) e.getSource()) == GUI.getNextButton())) {
            try {
                nextButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getRandomPlayButton())) {
            try {
                randomButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getLoopButton())) {
            try {
                loopButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getChooseDirectoryButton())) {
            try {
                folderButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getFavouritesButton())) {
            try {
                favouritesButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getAboutButton())) {
            try {
                aboutButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getSettingsButton())) {
            try {
                settingsButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getPlaylistsButton())) {
            try {
                playlistsButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getRecentButton())) {
            try {
                recentButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getHelpButton())) {
            try {
                helpButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getAlbumsButton())) {
            try {
                albumsButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getPlayButton())) {
            try {
                playButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getPreviousScreenButton())) {
            try {
                previousScreenButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getNextScreenButton())) {
            try {
                nextScreenButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if ((((JButton) e.getSource()) == GUI.getSpeakerButton())) {
            try {
                speakerButtonAction();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }
	private void previousButtonAction() throws Exception {
        
    }

    private void nextButtonAction() throws Exception {
        
    }

    private void randomButtonAction() throws Exception
    {
        if(isRandom)
        {
            isRandom = false;
            GUI.getRandomPlayButton().setIcon(new ImageIcon("src\\project\\java\\pictures\\randomButton1.png"));
        }
        else
        {
            isRandom = true;
            GUI.getRandomPlayButton().setIcon(new ImageIcon("src\\project\\java\\pictures\\randomButton.png"));
        }
    }

    private void loopButtonAction() throws Exception {
        if (!loop) {
            loop = true;
            utils.loop(true);
            GUI.getLoopButton().setIcon(new ImageIcon("src\\project\\java\\pictures\\loop1Button.png"));
        } else {
            loop = false;
            utils.loop(false);
            GUI.getLoopButton().setIcon(new ImageIcon("src\\project\\java\\pictures\\loopButton.png"));
        }
    }

    private void folderButtonAction() throws Exception {
		JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("choosertitle");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + fc.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + fc.getSelectedFile());

            directory = fc.getSelectedFile();
            playlist = new Playlist();
            files = new ArrayList<File>(Arrays.asList(directory.listFiles()));
            ListIterator listIterator=files.listIterator();

            for(File file:files)
                playlist.loadSongs(listIterator.next().toString());

            String playlistName = JOptionPane.showInputDialog("Please write playlist name!");
            file.fileAppend(playlistName,directory.toString());
            playlistsContainer.addPlaylist(playlist, playlistName);
            view();
            File plik = new File(playlistName);
            utils.loadSong(playlistsContainer.getPlaylist(currentPlaylist).getSong( index).getFile());


        } else {
            System.out.println("No Selection ");
        }

    }

    private void favouritesButtonAction() throws Exception {
        
    }

    private void aboutButtonAction() throws Exception {
       
    }

    private void settingsButtonAction() throws Exception {
        System.out.println("Działa");
    }

    private void playlistsButtonAction() throws Exception {
        
    }

    private void recentButtonAction() throws Exception {
        
    }

    private void helpButtonAction() throws Exception {
       
    }

    private void albumsButtonAction() throws Exception {
        
    }

    private void playButtonAction() throws Exception {


    }

    private void previousScreenButtonAction() throws Exception {
        
    }

    private void nextScreenButtonAction() throws Exception {

    }

    private void speakerButtonAction() throws Exception {
        
    }

    private void sliderAction() throws Exception {
        
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
	
}