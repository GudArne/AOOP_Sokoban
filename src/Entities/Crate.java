package Entities;

import java.awt.image.BufferedImage;

public class Crate {
    int xPos;
    int yPos;

    public boolean marked = false;
    BufferedImage image;

    Crate(int xPos, int yPos, BufferedImage image, boolean marked){
        this.xPos = xPos;
        this.yPos = yPos;
        this.image = image;
        this.marked = marked;
    }
}
