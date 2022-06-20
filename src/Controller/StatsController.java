package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import Models.StatsModel;

// Handles the events from the statsView and the gameview
public class StatsController implements PropertyChangeListener{
    
    private StatsModel statsModel;

    public StatsController(StatsModel statsModel) {
        this.statsModel = statsModel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("stepCountIncreased")){
            statsModel.increaseStepCount();
        }
        if(evt.getPropertyName().equals("increaseAttempts")){
            statsModel.increaseAttempts();
            statsModel.resetMarked();
            statsModel.resetSteps();
        }
        if(evt.getPropertyName().equals("resetGame")){
            statsModel.resetStats();
        }
        if(evt.getPropertyName().equals("increaseMarked")){
            statsModel.increaseMarked();
        }
        if(evt.getPropertyName().equals("decreaseMarked")){
            statsModel.decreaseMarked();
        }
    }
}
