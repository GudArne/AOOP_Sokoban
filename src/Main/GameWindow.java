package Main;

import java.util.ArrayList;

import javax.swing.*;

import Controller.KeyHandler;
import Models.DataModel;
import Views.StatsView;
import Views.TileView;

public class GameWindow {
    
    TileView tileView ;

    public GameWindow(JFrame window, GamePanel gamePanel){
        this.tileView = tileView;
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
        
        GameWindow gameWindow = new GameWindow(new JFrame(), gamePanel);

    }
}
