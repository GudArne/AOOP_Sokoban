package Models;

import Entities.Player;
import Controller.KeyHandler;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;

public class PlayerModel extends Player {
    KeyHandler keyHandler;
    GamePanel gamePanel;

    public PlayerModel(GamePanel gamePanel, KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

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
        if(keyHandler.anyPressed) {
            if (keyHandler.up) {
            }
            else if (keyHandler.down) {

            }
            else if(keyHandler.left){

            }
            else if (keyHandler.right){

            }
        }
    }

    public int getX(){
        return worldX;
    }
    public int getY(){
        return worldY;
    }
}
