package Models;

import Entities.Player;
import Controller.KeyHandler;
import Main.GamePanel;
import Models.DataModel;

import javax.imageio.ImageIO;
import java.io.File;

public class PlayerModel extends Player {
    KeyHandler keyHandler;
    GamePanel gamePanel;
    DataModel dataModel;

    public PlayerModel(GamePanel gamePanel, DataModel dataModel) {
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;

        worldX = 0;
        worldY = 0;

        setStart();
    }
     public void setStart(){
         worldY = 2* gamePanel.tileSize;
         worldX = gamePanel.tileSize;
     }

    public void setImage(){
        try {
            playerImage = ImageIO.read(new File("Insert picture")); //TODO insert picture
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(dataModel.getData() == "up")
        {
            System.out.println("update: up");
        }
        if(dataModel.getData() == "down")
        {
            System.out.println("update: down");
        }
        if(dataModel.getData() == "left")
        {
            System.out.println("update: left");
        }
        if(dataModel.getData() == "right")
        {
            System.out.println("update: right");
        }

    }

    public int getX(){
        return worldX;
    }
    public int getY(){
        return worldY;
    }
}
