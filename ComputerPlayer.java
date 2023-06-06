import java.util.*;

public class ComputerPlayer {
    private String letter;
    private String oppLetter;
    
    public ComputerPlayer() {
        letter = "x";
    }

    public ComputerPlayer(String letter) {
        setLetter(letter);
    }
    
    // Computer makes a move by checking if it can win, then checking if it can block, then checking availability of corners and middle, then making random move
    public int compMove(GameBoard board) {
        String[][] boardArray = board.getBoard();
        // First search if a winning move can be made
        int hWinMove = Checker.hConsCheck(board, letter);
        if (hWinMove != -1) {
            return hWinMove;
        }
        int vWinMove = Checker.vConsCheck(board, letter);
        if (vWinMove != -1) {
            return vWinMove;
        }
        int dWinMove = Checker.dConsCheck(board, letter);
        if (dWinMove != -1) {
            return dWinMove;
        }
        int cWinMove = Checker.cConsCheck(board, letter);
        if (cWinMove != -1) {
            return cWinMove;
        }

        // Second search if blocking move can be made
        int hBlockMove = Checker.hConsCheck(board, oppLetter);
        if (hBlockMove != -1) {
            return hBlockMove;
        }
        int vBlockMove = Checker.vConsCheck(board, oppLetter);
        if (vBlockMove != -1) {
            return vBlockMove;
        }
        int dBlockMove = Checker.dConsCheck(board, oppLetter);
        if (dBlockMove != -1) {
            return dBlockMove;
        }
        int cBlockMove = Checker.cConsCheck(board, oppLetter);
        if (cBlockMove != -1) {
            return cBlockMove;
        }

        // Third check if corners are empty or center is empty
        if (Checker.checkIsEmpty(boardArray, 1, 1)) {
            return 5;
        }
        if (Checker.checkIsEmpty(boardArray, 0, 0)) {
            return 1;
        }
        if (Checker.checkIsEmpty(boardArray, 2, 0)) {
            return 7;
        }
        if (Checker.checkIsEmpty(boardArray, 0, 2)) {
            return 3;
        }
        if (Checker.checkIsEmpty(boardArray, 2, 2)) {
            return 9;
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
        return emptyIndices.get(randIndex);

    }

    public void setLetter(String letter) {
        this.letter = letter;
        if (letter.equals("x")) {
            oppLetter = "o";
        } else {
            oppLetter = "x";
        }
    }

    public String getLetter() {
        return letter;
    }
}