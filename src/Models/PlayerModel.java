package Models;

import Entities.Crate;
import Entities.Player;
import Controller.KeyHandler;
import Main.GamePanel;
import Models.DataModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

import Models.TileModel;
public class PlayerModel {
    GamePanel gamePanel;
    DataModel dataModel;
    TileModel tileModel;

    CrateModel crateModel;
    BufferedImage playerImage;

    Player player;
    public PlayerModel(GamePanel gamePanel, DataModel dataModel, TileModel tileModel) {
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.tileModel = tileModel;
        crateModel = new CrateModel(gamePanel,tileModel);

        setImage();
        player = new Player(gamePanel.tileSize, 2 * gamePanel.tileSize, playerImage);
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
            Crate crate = crateModel.getCrate(player.playerX, checkNext(direction));
            if(crate == null){
                player.playerY -=gamePanel.tileSize;
                System.out.println("player: up");
            }
            else if(crateModel.checkCrateCollision(direction,player.playerX, player.playerY)){
                crateModel.moveCrate(crate,direction);
                //crateModel.swapImage(player.playerX,checkNext(direction));
                player.playerY -= gamePanel.tileSize;
            }

            //if(check crate)
            System.out.println("player: up");
        }
        else if(Objects.equals(direction, "down") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(player.playerX, checkNext(direction));
            if(crate == null){
                player.playerY +=gamePanel.tileSize;
                System.out.println("player: up");
            }
            else if(crateModel.checkCrateCollision(direction,player.playerX, player.playerY)){
                crateModel.moveCrate(crate,direction);
                //crateModel.swapImage(player.playerX,checkNext(direction));
                player.playerY += gamePanel.tileSize;
            }

            System.out.println("player: down");
        }
        else if(Objects.equals(direction, "left") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(checkNext(direction), player.playerY);
            if(crate == null){
                player.playerX -=gamePanel.tileSize; //move player
                System.out.println("player: right");
            }
            else if(crateModel.checkCrateCollision(direction,player.playerX, player.playerY)){
                crateModel.moveCrate(crate,direction);
                //crateModel.swapImage(crate.xPos, crate.yPos);
                player.playerX -= gamePanel.tileSize;
            }
            System.out.println("player: left");
        }
        else if(Objects.equals(direction, "right") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(checkNext(direction), player.playerY);
            if(crate == null){
                player.playerX +=gamePanel.tileSize; //move player
                System.out.println("player: right");
            }
            else if(crateModel.checkCrateCollision(direction,player.playerX, player.playerY)){
                crateModel.moveCrate(crate,direction);
                //crateModel.swapImage(crate.xPos, crate.yPos);
                player.playerX += gamePanel.tileSize;
            }
        }
        System.out.println(player.playerY +  " \n" + player.playerX);

    }
    public boolean checkCollision(String direction){
        switch (direction){
            case "up" ->{
                if(!tileModel.tiles.get(tileModel.getTile(player.playerX, player.playerY - gamePanel.tileSize)).collision)
                    return true;
            }
            case "down" ->{
                if(!tileModel.tiles.get(tileModel.getTile(player.playerX, player.playerY + gamePanel.tileSize)).collision)
                    return true;
            }
            case "left" ->{
                if(!tileModel.tiles.get(tileModel.getTile(player.playerX - gamePanel.tileSize, player.playerY)).collision)
                    return true;
            }
            case "right" ->{
                if(!tileModel.tiles.get(tileModel.getTile(player.playerX + gamePanel.tileSize, player.playerY)).collision)
                    return true;
            }
        }
        return false;
    }

    public int getX(){
        return player.getPlayerX();
    }
    public int getY(){
        return player.getPlayerY();
    }

    public int checkNext(String direction){
        int retInt = 0;
        switch (direction){
            case "up" -> retInt = player.playerY - gamePanel.tileSize;
            case "down" ->retInt = player.playerY + gamePanel.tileSize;
            case "left" -> retInt = player.playerX - gamePanel.tileSize;
            case "right" -> retInt = player.playerX + gamePanel.tileSize;
        }
        return retInt;
    }

    public BufferedImage getPlayerImage() {
        return playerImage;
    }
}
