package Models;

import Entities.Player;
import Controller.KeyHandler;
import Main.GamePanel;
import Models.DataModel;

import javax.imageio.ImageIO;
import java.io.File;
import Models.TileModel;
public class PlayerModel extends Player {
    GamePanel gamePanel;
    DataModel dataModel;
    TileModel tileModel;

    public PlayerModel(GamePanel gamePanel, DataModel dataModel, TileModel tileModel) {
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.tileModel = tileModel;

        worldX = 0;
        worldY = 0;

        setStart();
        setImage();
    }
     public void setStart(){
         worldY = 2* gamePanel.tileSize;
         worldX = gamePanel.tileSize;
     }

    public void setImage(){
        try {
            playerImage = ImageIO.read(new File("src/Resources/Player/player.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(){
        String direction = dataModel.getData();
        if(direction == "up" && checkCollision(direction))
        {
            System.out.println("player: up");
        }
        else if(direction == "down" && checkCollision(direction))
        {
            System.out.println("player: down");
        }
        else if(direction == "left" && checkCollision(direction))
        {
            System.out.println("player: left");
        }
        else if(direction == "right" && checkCollision(direction))
        {
            System.out.println("player: right");
        }

    }
    public boolean checkCollision(String direction){
        switch (direction){
            case "up" ->{
                if(!tileModel.tiles.get(tileModel.getTile(worldX, worldY - gamePanel.tileSize)).collision)
                    return true;
            }
            case "down" ->{
                if(!tileModel.tiles.get(tileModel.getTile(worldX, worldY + gamePanel.tileSize)).collision)
                    return true;
            }
            case "left" ->{
                if(!tileModel.tiles.get(tileModel.getTile(worldX - gamePanel.tileSize, worldY)).collision)
                    return true;
            }
            case "right" ->{
                if(!tileModel.tiles.get(tileModel.getTile(worldX + gamePanel.tileSize, worldY)).collision)
                    return true;
            }
        }
        return false;
    }

    public int getX(){
        return worldX;
    }
    public int getY(){
        return worldY;
    }
}
