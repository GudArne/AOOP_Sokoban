package Main;

import java.util.ArrayList;

import javax.swing.*;

import Controller.KeyHandler;
import Models.DataModel;

public class GameWindow {
    
    

    public GameWindow(JFrame window, GamePanel gamePanel){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Sokoban");

        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }

    public static void main(String[] args) {
        System.out.println("test");
        String data = "";
        DataModel model = new DataModel(data);

        GamePanel gamePanel = new GamePanel(model);
        model.attach(gamePanel);
        
        GameWindow gameWindow = new GameWindow(new JFrame(), gamePanel);
    }
}
