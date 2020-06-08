package nsu.ccfit.filonov.seefight;

import nsu.ccfit.filonov.seefight.square.Square;
import nsu.ccfit.filonov.seefight.square.SquareEmpty;
import nsu.ccfit.filonov.seefight.square.SquareShip;


public class Gamer {

    private static Square MySquares[];
    private static Square OppSquares[];

    public Gamer(){
        MySquares = new Square[100];
        for(int i=0; i <100; i++){
            MySquares[i] = new SquareEmpty();
        }
        OppSquares = new Square[100];
    }

    public static void placeShips(int x, int y) {

        MySquares[x*10 +y] = new SquareShip();
    }

    public static Square getReaction(int a) {
        return MySquares[a];
    }
}
