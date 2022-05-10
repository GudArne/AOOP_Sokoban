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

        playerX = 0;
        playerY = 0;

        setStart();
        setImage();
    }
     public void setStart(){
         playerY = 2* gamePanel.tileSize;
         playerX = gamePanel.tileSize;
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
            Crate crate = crateModel.getCrate(playerX, checkNext(direction));
            if(crate == null){
                playerY -=gamePanel.tileSize;
                System.out.println("player: up");
            }
            else if(crateModel.checkCrateCollision(direction,playerX, playerY)){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(playerX,checkNext(direction));
             playerY -= gamePanel.tileSize;
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
            Crate crate = crateModel.getCrate(checkNext(direction), playerY);
            if(crate == null){
                playerX +=gamePanel.tileSize; //move player
                System.out.println("player: right");
            }
            else if(crateModel.checkCrateCollision(direction,playerX, playerY)){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(crate.xPos, crate.yPos);
                playerX += gamePanel.tileSize;
            }
        }
        System.out.println(worldX +  " \n" + worldY);

    }
    public boolean checkCollision(String direction){
        switch (direction){
            case "up" ->{
                if(!tileModel.tiles.get(tileModel.getTile(playerX, playerY - gamePanel.tileSize)).collision)
                    return true;
            }
            case "down" ->{
                if(!tileModel.tiles.get(tileModel.getTile(playerX, playerY + gamePanel.tileSize)).collision)
                    return true;
            }
            case "left" ->{
                if(!tileModel.tiles.get(tileModel.getTile(playerX - gamePanel.tileSize, playerY)).collision)
                    return true;
            }
            case "right" ->{
                if(!tileModel.tiles.get(tileModel.getTile(playerX + gamePanel.tileSize, playerY)).collision)
                    return true;
            }
        }
        return false;
    }

    public int getX(){
        return playerX;
    }
    public int getY(){
        return playerY;
    }

    public int checkNext(String direction){
        int retInt = 0;
        switch (direction){
            case "up" -> retInt = playerY - gamePanel.tileSize;
            case "down" ->retInt = playerY + gamePanel.tileSize;
            case "left" -> retInt = playerX - gamePanel.tileSize;
            case "right" -> retInt = playerX + gamePanel.tileSize;
        }
        return retInt;
    }
}
