package Views;

import Main.GamePanel;
import Models.CrateModel;
import Models.DataModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CrateView{
    CrateModel crateModel;
    GamePanel gamePanel;
    DataModel dataModel;

    // Constructs a CrateView object
    public CrateView(GamePanel gamePanel, CrateModel crateModel) {
        this.crateModel = crateModel;
        this.gamePanel = gamePanel;
    }

    // Returns the image of the crate
    public BufferedImage getImage(boolean marked){
        BufferedImage image;
        try {
            if(marked)
                image = ImageIO.read(new File("src/Resources/Objects/cratemarked.png"));
            else
                image = ImageIO.read(new File("src/Resources/Objects/crate.png"));
            return image;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Draw the view
    public void draw(Graphics2D graphics2D) {
        for(int i = 0; i < crateModel.objectArrayList.size(); i++){
            graphics2D.drawImage(getImage(crateModel.getObjectArrayList().get(i).marked),crateModel.getObjectArrayList().get(i).xPos,crateModel.getObjectArrayList().get(i).yPos,gamePanel.tileSize, gamePanel.tileSize,null);
        }
    }
}
