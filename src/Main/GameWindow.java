package Main;

import javax.swing.*;

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
        GameWindow gameWindow = new GameWindow(new JFrame(), new GamePanel());
    }
}
