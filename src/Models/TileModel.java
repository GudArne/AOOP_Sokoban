package Models;

import Entities.Tile;
import Main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TileModel {
    GamePanel gamePanel;
    public ArrayList<ArrayList<Integer>> numTiles;
    public ArrayList<Tile> tiles;

    public TileModel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        numTiles = new ArrayList<>();
        tiles = new ArrayList<>();

        readTile();
        readMap("Resources/Map/map1.txt");
    }
    public GamePanel getGamePanel(){
        return this.gamePanel;
    }
    public void readMap(String map) {

        int index = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(map)));
            String line;
            ArrayList<String> converter = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                converter.add(line);
                String[] temp = converter.get(index).split(" ");
                index++;
                ArrayList<Integer> intTiles = new ArrayList<>();
                for (String s : temp) {
                    intTiles.add(Integer.parseInt(s));
                }
                numTiles.add(intTiles);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readTile() {
        try {

            tiles.add(new Tile(ImageIO.read(new File("Pictures/Tiles/blank.png")), false,false));
            tiles.add(new Tile(ImageIO.read(new File("Pictures/Tiles/blankmarked.png")), false,true));
            tiles.add(new Tile(ImageIO.read(new File("Pictures/Tiles/wall.png")), true,false));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTile(int x, int y)
    {
        x = x/gamePanel.tileSize;
        y = y/gamePanel.tileSize;
        return numTiles.get(y).get(x);
    }
}
