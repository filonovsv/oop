package nsu.ccfit.filonov.seefight;

import javax.swing.*;

public class Frame {

    private static JFrame window;

    public Frame(){
        window = new JFrame("See battle");
        window.setSize(655, 350);
        window.add(new Panel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
     public static JFrame getWindow(){
        return window;
    }
}
