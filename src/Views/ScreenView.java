package Views;

import Main.GamePanel;
import Models.CrateModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenView {

    CrateModel crateModel;
    GamePanel gamePanel;

    BufferedImage image;
    public ScreenView(GamePanel gamePanel, CrateModel crateModel) {
        this.crateModel = crateModel;
        this.gamePanel = gamePanel;
        setImage();
    }
    private void setImage(){
        try{
            image = ImageIO.read(new File("src/Resources/Screen/Winner.jpeg"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void draw(Graphics2D graphics2D){
        if (crateModel.checkIfWon())
        {
            graphics2D.drawImage(image,0,0,384,432,null);
        }
    }


}
