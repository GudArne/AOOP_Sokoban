package Views;

import javax.swing.*;

public class StatsView extends JFrame {

    private JLabel attemptsLabel= new JLabel();
    private JLabel stepCounterLabel= new JLabel();
    private JLabel markedCratesLabel = new JLabel();
    private JFrame window =  new JFrame();

    // Constructs a StatsView object
    public StatsView() {
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        this.window.setTitle("Statistics");
        JLabel info1 = new JLabel("Press '0' to cheat");
        panel.add(info1);
        JLabel info2 = new JLabel("Press 'Esc' to restart");
        panel.add(info2);

        attemptsLabel.setText("Attempts: " + 0 + "      ");
        panel.add(attemptsLabel);

        stepCounterLabel.setText("Steps: " + 0+ "      ");
        panel.add(stepCounterLabel);

        markedCratesLabel.setText("Marked Crates: (" + 1 + " / 7)");
        panel.add(markedCratesLabel);

        window.add(panel);
        this.window.setSize(150, 200);
        this.window.setLocation(485, 100);
        this.window.setVisible(true);
    }

    // Returns the game panel
    public StatsView getGamePanel(){
        return this;
    }

    // Updates the attempts counter
    public void setAttemptsLabel(int value){
        attemptsLabel.setText("Attempts: " + value+ "    ");
    }

    // Updates the step counter
    public void setStepCounterLabel(int value){
        stepCounterLabel.setText("Steps: " + value+ "    ");
    }

    // Updates the marked crates counter
    public void setMarkedCrates(int currentVal, int maxVal){
        markedCratesLabel.setText("Marked Crates: (" + currentVal + " / " + maxVal + ")");
    }

}
