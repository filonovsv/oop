package nsu.ccfit.filonov.seefight;

import nsu.ccfit.filonov.seefight.square.Square;
import nsu.ccfit.filonov.seefight.square.SquareEmpty;
import nsu.ccfit.filonov.seefight.square.SquareShip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    private int i;
    private int botKill = 0;
    private int gamerKill = 0;
    private JButton squares[] = new JButton[200];

    public Panel() {
        setLayout(null);
        i = 0;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                squares[x * 10 + y] = new JButton();
                squares[x * 10 + y].setBounds(x * 30, y * 30, 30, 30);
                add(squares[x * 10 + y]);
            }
        }

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                squares[x * 10 + y + 100] = new JButton();
                squares[x * 10 + y + 100].setBounds(x * 30 + 350, y * 30, 30, 30);
                add(squares[x * 10 + y + 100]);
            }
        }
        for (JButton jButton : squares) {
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (i < 20) {
                        i++;
                        jButton.setBackground(Color.GRAY);
                        Gamer.placeShips(jButton.getX() / 30, jButton.getY() / 30);

                    } else {
                        if (jButton.getX() < 300) {
                        } else {
                            if (Bot.getReaction((jButton.getX() - 350) / 30,
                                    jButton.getY() / 30).getClass() == SquareShip.class) {
                                jButton.setBackground(Color.RED);
                                gamerKill++;
                                if (gamerKill ==20) {
                                    JOptionPane.showConfirmDialog(null,
                                            "Вы победили!", "", JOptionPane.DEFAULT_OPTION);
                                    System.exit(0);
                                }
                            } else {
                                jButton.setBackground(Color.blue);
                                Square square;
                                do {
                                    int move = Bot.makeMove();
                                    square = Gamer.getReaction(move);
                                    if (square.getClass() == SquareShip.class) {
                                        squares[move].setBackground(Color.RED);
                                        botKill++;
                                        if (botKill ==20) {
                                            JOptionPane.showConfirmDialog(null,
                                                    "Вы проиграли!", "", JOptionPane.DEFAULT_OPTION);
                                            System.exit(0);
                                        }
                                    } else if (square.getClass() == SquareEmpty.class) {
                                        squares[move].setBackground(Color.blue);
                                    }
                                } while (square.getClass() == SquareShip.class);
                            }
                        }
                    }
                }
            });

        }
    }
}
