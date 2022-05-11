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
    private int stepCount = 0;

    Player player;
    public PlayerModel(GamePanel gamePanel, DataModel dataModel, TileModel tileModel, CrateModel crateModel) {
        this.gamePanel = gamePanel;
        this.dataModel = dataModel;
        this.tileModel = tileModel;
        this.crateModel = crateModel;

        setImage();
        player = new Player(gamePanel.tileSize, 2 * gamePanel.tileSize, playerImage);
    }



    private void setImage(){
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
            Crate crate = crateModel.getCrate(getX(), checkNext(direction));
            if(crate == null){
                updatePlayer(direction);
                setStepCount(getStepCount() + 1);
            }
            else if(crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(crate);
                updatePlayer(direction);
                setStepCount(getStepCount() + 1);
            }
        }
        else if(Objects.equals(direction, "down") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(getX(), checkNext(direction));
            if(crate == null){
                updatePlayer(direction);
                setStepCount(getStepCount() + 1);
            }
            else if(crateModel.checkCrateCollision(direction, crate.getxPos(), crate.yPos)){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(crate);
                updatePlayer(direction);
                setStepCount(getStepCount() + 1);
            }
        }
        else if(Objects.equals(direction, "left") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(checkNext(direction), getY());
            if(crate == null){
                updatePlayer(direction); //move player
                setStepCount(getStepCount() + 1);
            }
            else if(crateModel.checkCrateCollision(direction,crate.getxPos(), crate.getyPos())){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(crate);
                updatePlayer(direction);
                setStepCount(getStepCount() + 1);
            }
        }
        else if(Objects.equals(direction, "right") && checkCollision(direction))
        {
            Crate crate = crateModel.getCrate(checkNext(direction), getY());
            if(crate == null){
                updatePlayer(direction); //move player
                setStepCount(getStepCount() + 1);
            }
            else if(crateModel.checkCrateCollision(direction, crate.getxPos(), crate.getyPos())){
                crateModel.moveCrate(crate,direction);
                crateModel.swapImage(crate);
                updatePlayer(direction);
                setStepCount(getStepCount() + 1);
            }
        }
        if(Objects.equals(direction, "esc"))
        {
            setRestart();
            crateModel.setRestart();
        }
        crateModel.checkIfWon();
        System.out.println("step count: " + getStepCount());

    }
    private boolean checkCollision(String direction){
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
    private void setRestart(){
        player.setPlayerX(gamePanel.tileSize);
        player.setPlayerY(2 * gamePanel.tileSize);
    }
    public int getStepCount(){
        return stepCount;
    }
    public void setStepCount(int stepCount){
        this.stepCount = stepCount;
    }
    public void updatePlayer(String direction){
        switch (direction){
            case "up" -> player.setPlayerY(getY() - gamePanel.tileSize);
            case "down" -> player.setPlayerY(getY() + gamePanel.tileSize);
            case "left" -> player.setPlayerX(getX() - gamePanel.tileSize);
            case "right" -> player.setPlayerX(getX() + gamePanel.tileSize);
        }
    }
}
