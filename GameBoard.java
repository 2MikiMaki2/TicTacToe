import java.util.HashMap;

public class GameBoard{
    private String[][] board;
    HashMap<Integer, Position> move;{
    move  = new HashMap<Integer, Position>();
        move.put(1, new Position(0, 0));
        move.put(2, new Position(0, 1));
        move.put(3, new Position(0, 2));
        move.put(4, new Position(1, 0));
        move.put(5, new Position(1, 1));
        move.put(6, new Position(1, 2));
        move.put(7, new Position(2, 0));
        move.put(8, new Position(2, 1));
        move.put(9, new Position(2, 2));
        }

    public GameBoard(){
        board = new String[3][3];

    }

    public boolean placeMove(int num1, String a){
        if (num1 > 9 || num1 < 1){
            return false;
        }
        Position p = move.get(num1);
        if (!Checker.checkIsEmpty(board, p.row, p.col)){
            return false;
        }
        System.out.println("Placing an x at (" + p.row + ", " + p.col + ")!");
        board[p.row][p.col] = a;
        return true;
    }

    public String[][] getBoard(){
        return board;
    }
}  