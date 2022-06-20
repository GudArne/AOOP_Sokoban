package Main;

import javax.swing.*;

import Controller.KeyHandler;
import Controller.MouseHandler;
import Views.TileView;

public class GameWindow {
    
    TileView tileView;
    JFrame window;

    public GameWindow(JFrame window, GamePanel gamePanel){
        this.window = window;
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Sokoban");

        window.add(gamePanel);

        window.setLocation(100, 100);
        window.setVisible(true);
        window.pack();
    }
    public JFrame getFrame(){
        return window;
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel(); 

        // Toggle which controller to use. 
        gamePanel.setController(new MouseHandler(gamePanel.getPlayerModel()));
        gamePanel.setController(new KeyHandler(gamePanel.getPlayerModel()));
        
        new GameWindow(new JFrame(), gamePanel);
    }
}