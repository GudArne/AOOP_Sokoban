package Views;

import Main.GamePanel;
import Models.CrateModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CrateView{
    private CrateModel crateModel;
    private GamePanel gamePanel;

    // Constructs a CrateView object
    public CrateView(GamePanel gamePanel, CrateModel crateModel) {
        this.crateModel = crateModel;
        this.gamePanel = gamePanel;
    }

    // Returns the image of a marked or unmarked crate
    private BufferedImage getImage(boolean marked){
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
        for(int i = 0; i < crateModel.getCrates().size(); i++){
            graphics2D.drawImage(getImage(crateModel.getCrates().get(i).isMarked()),crateModel.getCrates().get(i).getxPos(),crateModel.getCrates().get(i).getyPos(),gamePanel.tileSize, gamePanel.tileSize,null);
        }
    }
}
