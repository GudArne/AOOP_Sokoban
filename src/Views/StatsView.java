package Views;

import javax.swing.*;

public class StatsView extends JFrame {

    String text = "";
    int value = 0;
    JLabel attemptsLabel= new JLabel();
    JLabel stepCounterLabel= new JLabel();
    JLabel markedCratesLabel = new JLabel();
    JFrame window =  new JFrame();

    public StatsView(String text, int value) {
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        this.window.setTitle("Statistics");
        JLabel info1 = new JLabel("Press '0' to cheat");
        panel.add(info1);
        JLabel info2 = new JLabel("Press 'Esc' to restart");
        panel.add(info2);

        attemptsLabel.setText(text + " " + value + "      ");
        panel.add(attemptsLabel);

        stepCounterLabel.setText("Steps: " + value+ "      ");
        panel.add(stepCounterLabel);

        markedCratesLabel.setText("Marked Crates: (" + 1 + " / 7)");
        panel.add(markedCratesLabel);

        window.add(panel);
        this.window.setSize(150, 200);
        this.window.setLocation(485, 100);
        this.window.setVisible(true);
    }
    public StatsView getGamePanel(){
        return this;
    }
    public void setAttemptsLabel(String text, int value){
        this.text = text;
        this.value = value;
        attemptsLabel.setText(text + " " + value+ "    ");
    }
    public void setStepCounterLabel(int value){
        this.value = value;
        stepCounterLabel.setText("Steps: " + value+ "    ");
    }
    public void setMarkedCrates(int value){
        this.value = value;
        markedCratesLabel.setText("Marked Crates: (" + value + " / 7)");
    }

}
