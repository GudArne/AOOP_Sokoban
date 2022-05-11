package Views;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
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

        final Container contentPane = this.getContentPane();
        setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        this.window.setTitle("Statistics");

        attemptsLabel.setText(text + " " + value);
        this.window.add(attemptsLabel, BorderLayout.PAGE_START);

        stepCounterLabel.setText("Steps: " + value);
        this.window.add(stepCounterLabel, BorderLayout.CENTER);

        markedCratesLabel.setText("Marked Crates: (" + 1 + " / 7)");
        this.window.add(markedCratesLabel, BorderLayout.PAGE_END);

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
        attemptsLabel.setText(text + " " + value);
    }
    public void setStepCounterLabel(int value){
        this.value = value;
        stepCounterLabel.setText("Steps: " + value);
    }
    public void setMarkedCrates(int value){
        this.value = value;
        markedCratesLabel.setText("Marked Crates: (" + value + " / 7)");
    }

}
