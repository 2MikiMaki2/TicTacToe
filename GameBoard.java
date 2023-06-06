import java.io.Serializable;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GameBoard implements Serializable{
    private String[][] board;
    private static final long serialVersionUID = 1L;
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
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = " ";
            }
        }

    }

    public String toString(){
        String result = "";
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (j == 2) {
                    result += board[i][j];
                } else {
                    result += board[i][j] + " | ";
                }
            }
            if (i == 2) {
                return result;
            }
            result += "\n---------\n";
        }
        return result;
    }

    public void placeMove(int num1, String a){
        if (num1 > 9 || num1 < 1){
            throw new IllegalArgumentException("That's out of the valid range. Try again.");
        }
        Position p = move.get(num1);
        if (!Checker.checkIsEmpty(board, p.row, p.col)){
            throw new IllegalArgumentException("That spot is not empty. Try again.");
        }
        System.out.println("Placing an " + a + " at (" + p.row + ", " + p.col + ")!");
        board[p.row][p.col] = a;
    }

    public String[][] getBoard(){
        return board;
    }

    public HashMap<Integer, Position> getHash() {
        return move;
    }

    public void save(String fileName){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        }catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public static GameBoard load(String fileName){
        try{
            FileInputStream fis = new FileInputStream(fileName);
 
	         //Creating ObjectOutputStream object.
	         ObjectInputStream ois = new ObjectInputStream(fis);
 
	         //write object.
	         GameBoard b = (GameBoard) ois.readObject();
 
	         //close streams.
	         ois.close();
	         fis.close();
            return b;
	      }catch(Exception e)
	      {
	          System.out.println(e);
	      }
          return null;
    }
}