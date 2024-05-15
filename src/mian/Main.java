package mian;

import panels.GamePanel.GameManagement.GamePanel;
import panels.GameResultsPanel.PanelResults;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("my pacman");
        GamePanel gamePanel = new GamePanel();
//        PanelResults panelResults = new PanelResults();
//        JSplitPane sl = new JSplitPane(SwingConstants.TOP, gamePanel, panelResults);
//        window.add(sl);
        gamePanel.startGameThread();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
