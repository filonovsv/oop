package nsu.ccfit.filonov.seefight;

import javax.swing.*;

public class Game {
    public static void main(String[] args){

        Gamer gamer = new Gamer();
        Bot bot = new Bot();

        JFrame jFrame;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
