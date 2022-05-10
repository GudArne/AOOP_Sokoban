package Models;

import Entities.Crate;
import Entities.Player;
import Controller.KeyHandler;
import Main.GamePanel;
import Models.DataModel;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Objects;

import Models.TileModel;
public class PlayerModel extends Player {
    GamePanel gamePanel;
    DataModel dataModel;
    TileModel tileModel;

    CrateModel crateModel;

    public PlayerModel(GamePanel gamePanel, DataModel dataModel, TileModel tileModel) {
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.tileModel = tileModel;
        crateModel = new CrateModel(gamePanel,tileModel);

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
        if(Objects.equals(direction, "up") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(worldX, checkNext(direction));
            if(crate == null)
                worldY -=gamePanel.tileSize;
            else if(crateModel.checkCrateCollision(direction,worldX,worldY)){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(worldX,checkNext(direction));
                worldY -= gamePanel.tileSize;
            }

            //if(check crate)
            System.out.println("player: up");
        }
        else if(Objects.equals(direction, "down") && checkCollision(direction))
        {
            System.out.println("player: down");
        }
        else if(Objects.equals(direction, "left") && checkCollision(direction))
        {
            System.out.println("player: left");
        }
        else if(Objects.equals(direction, "right") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(checkNext(direction), worldY);
            if(crate == null)
                worldX +=gamePanel.tileSize;
            else if(crateModel.checkCrateCollision(direction,worldX,worldY)){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(crate.xPos, crate.yPos);
                worldX += gamePanel.tileSize;
            }
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

    public int checkNext(String direction){
        int retInt = 0;
        switch (direction){
            case "up" -> retInt = worldY - gamePanel.tileSize;
            case "down" ->retInt = worldY + gamePanel.tileSize;
            case "left" -> retInt = worldX - gamePanel.tileSize;
            case "right" -> retInt = worldX + gamePanel.tileSize;
        }
        return retInt;
    }
}
