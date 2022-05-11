package Models;

import Entities.Tile;
import Main.GamePanel;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class TileModel {
    GamePanel gamePanel;
    public ArrayList<ArrayList<Integer>> numTiles;
    public ArrayList<Tile> tiles;

    public TileModel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        numTiles = new ArrayList<>();
        tiles = new ArrayList<>();

        readTile();
        readMap("src/Resources/Map/map1.txt");
    }
    public GamePanel getGamePanel(){
        return this.gamePanel;
    }
    private void readMap(String map) {

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

    private void readTile() {
        try {

            tiles.add(new Tile(ImageIO.read(new File("src/Resources/Tiles/blank.png")), false,false));
            tiles.add(new Tile(ImageIO.read(new File("src/Resources/Tiles/blankmarked.png")), false,true));
            tiles.add(new Tile(ImageIO.read(new File("src/Resources/Tiles/wall.png")), true,false));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkMarked(int x, int y){
        x = x/ gamePanel.tileSize;
        y = y/ gamePanel.tileSize;
        if(tiles.get(numTiles.get(y).get(x)).marked)
            return true;
        else return false;
    }

    public int getTile(int x, int y)
    {
        x = x/gamePanel.tileSize;
        y = y/gamePanel.tileSize;
        return numTiles.get(y).get(x);
    }
}
