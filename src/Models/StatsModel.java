package Models;

import Views.StatsView;

public class StatsModel {
        
    private StatsView statsView;
    private int stepCount;
    private int attempts;
    private int marked;

    public StatsModel(StatsView statsView) {
        this.stepCount = 0;
        this.attempts = 0;
        this.marked = 1;
        this.statsView = statsView;
    }

    //
    // Stats logic
    //
    public void increaseMarked() {
        statsView.setMarkedCrates(++marked, 7);
    }

    public void decreaseMarked() {
        statsView.setMarkedCrates(--marked, 7);
    }

    public void resetMarked() {
        statsView.setMarkedCrates(marked = 1, 7);
    }

    public void increaseStepCount() {
        statsView.setStepCounterLabel(++stepCount);
    }

    public void increaseAttempts() {
        statsView.setAttemptsLabel(++attempts);
    }

    public void resetStats() {
        stepCount = 0;
        attempts = 0;
        statsView.setStepCounterLabel(stepCount);
        statsView.setAttemptsLabel(attempts);
    }

    public void resetSteps(){
        stepCount = 0;
        statsView.setStepCounterLabel(stepCount);
    }
}
