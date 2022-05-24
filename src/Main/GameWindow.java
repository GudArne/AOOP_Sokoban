package Main;

import javax.swing.*;

import Controller.KeyHandler;
import Controller.MouseHandler;
import Views.TileView;

public class GameWindow {
    
    TileView tileView ;

    public GameWindow(JFrame window, GamePanel gamePanel){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Sokoban");

        window.add(gamePanel);

        window.setLocation(100, 100);
        window.setVisible(true);
        window.pack();
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel(); 

        //gamePanel.setController(new MouseHandler(gamePanel.getDataModel()));
        gamePanel.setController(new KeyHandler(gamePanel.getDataModel()));
        
        new GameWindow(new JFrame(), gamePanel);
    }
}