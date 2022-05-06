package Entities;

import java.awt.image.BufferedImage;

public class Tile {
    BufferedImage tileImage;
    public boolean collision = false;
    public boolean marked = false;
    int positionX;
    int positionY;

    Tile(BufferedImage bufferedImage, Boolean collision, Boolean marked)
    {
        this.tileImage = bufferedImage;
        this.collision = collision;
        this.marked = marked;
    }
}
