package Entities;

import java.awt.image.BufferedImage;

public class Player {

    public String direction;
    public BufferedImage playerImage;

    public int playerX,playerY;
    public Player(int playerX, int playerY, BufferedImage playerImage){
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerImage = playerImage;
    }

    // return playerX
    public int getPlayerX() {
        return playerX;
    }
    // return playerY
    public int getPlayerY() {
        return playerY;
    }
    // set playerX
    public void setPlayerX(int x) {
        this.playerX = x;
    }
    // set playerY
    public void setPlayerY(int y) {
        this.playerY = y;
    }
}


