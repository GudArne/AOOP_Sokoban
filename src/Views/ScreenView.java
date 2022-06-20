package Views;

import Main.GamePanel;
import Models.CrateModel;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenView extends JPanel{

    private CrateModel crateModel;
    private GamePanel gamePanel;
    private BufferedImage image;

    // Constructs a ScreenView object
    public ScreenView(GamePanel gamePanel, CrateModel crateModel) {
        this.crateModel = crateModel;
        this.gamePanel = gamePanel;
        setImage();
    }

    // set the "winner" image on the screen
    private void setImage(){
        try{
            image = ImageIO.read(new File("src/Resources/Screen/Winner.jpeg"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Draw the view
    public void draw(Graphics2D graphics2D){
        if (crateModel.checkIfWon())
        {
            graphics2D.drawImage(image,0,0,384,432,null);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        draw((Graphics2D) g);
    }

    // Get the graphics object of the game panel and call the draw method.
    public void screenRepaint(){
        paintComponent(gamePanel.getGraphics());
    }

}
