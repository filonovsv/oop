package nsu.ccfit.filonov.seefight;

import nsu.ccfit.filonov.seefight.square.Square;
import nsu.ccfit.filonov.seefight.square.SquareEmpty;
import nsu.ccfit.filonov.seefight.square.SquareMiss;
import nsu.ccfit.filonov.seefight.square.SquareShip;

public class Bot {

    private static Square MySquares[];
    private static Square OppSquares[];

    public Bot(){
        MySquares = new Square[100];
        for(int i=0; i <100; i++){
            MySquares[i] = new SquareEmpty();
        }
        OppSquares = new Square[100];
        for(int i=0; i <100; i++){
            OppSquares[i] = new SquareEmpty();
        }
        MySquares[0]= new SquareShip();
        MySquares[1]= new SquareShip();
        MySquares[2]= new SquareShip();
        MySquares[3]= new SquareShip();
        MySquares[16]= new SquareShip();
        MySquares[17]= new SquareShip();
        MySquares[18]= new SquareShip();
        MySquares[20]= new SquareShip();
        MySquares[21]= new SquareShip();
        MySquares[22]= new SquareShip();
        MySquares[56]= new SquareShip();
        MySquares[57]= new SquareShip();
        MySquares[69]= new SquareShip();
        MySquares[79]= new SquareShip();
        MySquares[91]= new SquareShip();
        MySquares[81]= new SquareShip();
        MySquares[24]= new SquareShip();
        MySquares[54]= new SquareShip();
        MySquares[96]= new SquareShip();
        MySquares[98]= new SquareShip();
    }

    public static int makeMove() {
        int a =0;
        boolean is_search = false;
        while (!is_search){
            a = (int)(Math.random()*100);
            if(OppSquares[a].getClass() != SquareMiss.class){
                is_search = true;
                OppSquares[a] = new SquareMiss();
            }
        }
        return a;
    }

    public static Square getReaction(int x, int y) {

        return MySquares[y*10 + x];
    }

    public static Square getReaction(int a){
        return MySquares[a];
    }

}
