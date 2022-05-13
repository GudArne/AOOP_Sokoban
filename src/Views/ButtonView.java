package Views;

import java.awt.Container;
import javax.swing.*;

import Controller.MouseHandler;

public class ButtonView extends JFrame{

    JFrame window =  new JFrame();
    MouseHandler mouseHandler;

    public ButtonView(MouseHandler mouseHandler) {
        this.mouseHandler = mouseHandler;
        JPanel panel = new JPanel();
        JButton up = new JButton("up");
        JButton down = new JButton("down");
        JButton left = new JButton("left");
        JButton right = new JButton("right");
        up.addActionListener(mouseHandler);
        down.addActionListener(mouseHandler);
        left.addActionListener(mouseHandler);
        right.addActionListener(mouseHandler);

        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);

        window.add(panel);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(150, 200);
        this.window.setLocation(485, 300);
        this.window.setVisible(true);
    }

}
