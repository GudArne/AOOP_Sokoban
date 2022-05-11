package Entities;

import java.awt.image.BufferedImage;

public class Crate {
    public int xPos;
    public int yPos;

    public boolean marked = false;
    public BufferedImage image;

    public Crate(int xPos, int yPos, BufferedImage image, boolean marked){
        this.xPos = xPos;
        this.yPos = yPos;
        this.image = image;
        this.marked = marked;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean getMarked(){
        return this.marked;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
