package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Class to define the Control Panel
 * */
public class ControlPanel {
    public JPanel mainPanel;
    private JButton pausePlayButton;
    private JButton exitButton;
    private JButton settingsButton;
    private Game game;

    /**
     * Initialize the ControlPanel
     * */
    public ControlPanel(Game game) {
        this.game=game;
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSettings();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pausePlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });
    }
}
