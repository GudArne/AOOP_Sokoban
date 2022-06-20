package Views;

import Main.GamePanel;
import Models.PlayerModel;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PlayerView extends JPanel{
    private GamePanel gamePanel;
    private PlayerModel playerModel;

    // Constructs a PlayerView object
    public PlayerView(GamePanel gamePanel, PlayerModel playerModel){
        this.gamePanel = gamePanel;
        this.playerModel = playerModel;
    }
    // Gets the image of the player
    private BufferedImage getImage(){
        BufferedImage image;
        try {
            image = ImageIO.read(new File("src/Resources/Player/player.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Draw the view
    public void draw(Graphics2D graphics2D){
        graphics2D.drawImage(getImage(),playerModel.getX(),playerModel.getY(), gamePanel.tileSize,gamePanel.tileSize,null);
    }

    @Override
    public void paintComponent(Graphics g) {
        draw((Graphics2D) g);
    }

    // Get the graphics object of the game panel and call the draw method.
    public void playerRepaint(){
        paintComponent(gamePanel.getGraphics());
    }

}
