package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Views.CrateView;
import Views.PlayerView;
import Views.ScreenView;
import Views.TileView;

// Handles the events from the gameViews and the gameModels
public class GameController implements PropertyChangeListener{
    
    private CrateView crateView;
    private PlayerView playerView;
    private TileView tileView;
    private ScreenView screenView;

    public GameController(CrateView crateView, PlayerView playerView, TileView tileView, ScreenView screenView) {
        this.crateView = crateView;
        this.playerView = playerView;
        this.tileView = tileView;
        this.screenView = screenView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if(evt.getPropertyName().equals("gameUpdated")){
            tileView.tileRepaint();
            crateView.crateRepaint();
            playerView.playerRepaint();
        }
        if(evt.getPropertyName().equals("gameWon")){
            screenView.screenRepaint();
        }
    }
}
