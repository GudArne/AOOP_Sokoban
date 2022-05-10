package Entities;

import java.awt.image.BufferedImage;

public class Player {

    public String direction;
    public BufferedImage playerImage;

    public int playerX,playerY;

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


