package Models;

import Entities.Tile;
import Main.GamePanel;
import java.io.*;
import java.util.ArrayList;

public class TileModel { // MapModel
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
    private void readTile() {
        tiles.add(new Tile("blank", false,false));
        tiles.add(new Tile("blankmarked", false,true));
        tiles.add(new Tile("wall", true,false));

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
