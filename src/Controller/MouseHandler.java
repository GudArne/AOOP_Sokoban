package Controller;

import java.awt.*;
import java.awt.event.*;

import Models.DataModel;

public class MouseHandler implements ActionListener {

    private DataModel dataModel;
    public MouseHandler(DataModel dataModel) {
        this.dataModel = dataModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String code = e.getActionCommand();
        System.out.println("Mouse clicked");

        if(code.equals("up")) {
            dataModel.update("up");
        }
        if(code.equals("left")) {
            dataModel.update("left");
        }
        if(code.equals("down")) {
            dataModel.update("down");
        }
        if(code.equals("right")) {
            dataModel.update("right");
        }
        
    }
}
