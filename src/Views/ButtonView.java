package Views;

import javax.swing.*;

import Controller.Handler;

public class ButtonView extends JFrame{

    private JFrame window =  new JFrame();
    private Handler mouseHandler;

    // Constructs a ButtonView object
    public ButtonView(Handler mouseHandler) {
        this.mouseHandler = mouseHandler;
        JPanel panel = new JPanel();
        JButton up = new JButton("up");
        JButton down = new JButton("down");
        JButton left = new JButton("left");
        JButton right = new JButton("right");
        JButton restart = new JButton("restart");
        up.addActionListener(mouseHandler);
        down.addActionListener(mouseHandler);
        left.addActionListener(mouseHandler);
        right.addActionListener(mouseHandler);
        restart.addActionListener(mouseHandler);

        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);
        panel.add(restart);

        window.add(panel);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(150, 200);
        this.window.setLocation(485, 300);
        this.window.setVisible(true);
    }

}
