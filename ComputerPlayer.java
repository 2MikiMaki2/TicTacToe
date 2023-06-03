import java.util.*;

public class ComputerPlayer {
    private String letter;
    private String oppLetter;
    
    public ComputerPlayer() {
        letter = "x";
    }

    public ComputerPlayer(String letter) {
        this.letter = letter;
        if (letter.equals("x")) {
            oppLetter = "o";
        } else {
            oppLetter = "x";
        }
    }
    
    // Computer makes a move by generating random number between 1 and 10
    // TODO: Code full computer logic as described above.
    public boolean compMove(GameBoard board) {
        String[][] boardArray = board.getBoard();
        // First search if a winning move can be made
        int hWinMove = Checker.hConsCheck(boardArray, letter);
        if (hWinMove != -1) {
            // Call GameBoard placeMove with hWinMove++
            return true;
        }
        int vWinMove = Checker.vConsCheck(boardArray, letter);
        if (vWinMove != -1) {
            // Call GameBoard placeMove with vWinMove++
            return true;
        }
        int dWinMove = Checker.dConsCheck(boardArray, letter);
        if (dWinMove != -1) {
            // Call GameBoard placeMove
            return true;
        }

        // Second search if blocking move can be made
        int hBlockMove = Checker.hConsCheck(boardArray, oppLetter);
        if (hBlockMove != -1) {
            // Call GameBoard placeMove with hWinMove++
            return true;
        }
        int vBlockMove = Checker.vConsCheck(boardArray, oppLetter);
        if (vBlockMove != -1) {
            // Call GameBoard placeMove with vWinMove++
            return true;
        }
        int dBlockMove = Checker.dConsCheck(boardArray, oppLetter);
        if (dBlockMove != -1) {
            // Call GameBoard placeMove
            return true;
        }

        // Third check if corners are empty or center is empty
        if (Checker.checkIsEmpty(boardArray, 0, 0)) {
            // Call GameBoard placeMove
            return true;
        }
        if (Checker.checkIsEmpty(boardArray, 2, 0)) {
            // Call GameBoard placeMove
            return true;
        }
        if (Checker.checkIsEmpty(boardArray, 0, 2)) {
            // Call GameBoard placeMove
            return true;
        }
        if (Checker.checkIsEmpty(boardArray, 2, 2)) {
            // Call GameBoard placeMove
            return true;
        }
        if (Checker.checkIsEmpty(boardArray, 1, 1)) {
            // Call GameBoard placeMove
            return true;
        }

        // Finally make random move
        ArrayList<Integer> emptyIndices = new ArrayList<Integer>();
        int emptyIndex = 1;
        for (int r = 0; r < boardArray.length; r++) {
            for (int c = 0; c < boardArray[r].length; c++) {
                if (Checker.checkIsEmpty(boardArray, r, c)) {
                    emptyIndices.add(emptyIndex);
                }
                emptyIndex++;
            }
        }
        int randIndex = (int) (Math.random() * (emptyIndices.size()));
        // Call GameBoard placeMove using hashmap to translate randIndex to a location on 2D array

        return false;

    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
