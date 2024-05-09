package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class to define the Settings Panel
 * */
public class SettingsPanel {
    public JPanel mainPanel;
    private JButton volumeUpButton;
    private JButton volumeDownButton;
    private JButton backButton;
    private Game game;
    private GameLevel level;



    public SettingsPanel(Game game, GameLevel level) {
        this.game=game;
        this.level=level;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToMain();
            }
        });
        volumeUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.back_volume_up();
            }
        });
        volumeDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.back_volume_down();
            }
        });
    }
}
