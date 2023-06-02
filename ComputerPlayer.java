/*
 * How will it interact with runner class to be assigned its letter?
 * How will it choose where to place its piece?
 * Computer logic: first tries winning move, then blocks player, if can't do either makes random valid move.
 */
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
    public void compMove(GameBoard board) {
        // First search if a winning move can be made
        int hWinMove = Checker.hConsCheck(board.getBoard(), letter);
        if (hWinMove != -1) {
            if (hWinMove % 3 == 0) {
                hWinMove -= 3;
                // Call GameBoard placeMove
            }
            // Call GameBoard placeMove with hWinMove++
        }

        int vWinMove = Checker.vConsCheck(board.getBoard(), letter);
        if (vWinMove != -1) {
            if (vWinMove == 7 || vWinMove == 8 || vWinMove == 9) {
                vWinMove -= 6;
                // Call GameBoard placeMove
            }
            // Call GameBoard placeMove with vWinMove++
        }

        int dWinMove = Checker.dConsCheck(board.getBoard(), letter);
        if (dWinMove != -1) {
            // Call GameBoard placeMove
        }

        // Second search if blocking move can be made
        int hBlockMove = Checker.hConsCheck(board.getBoard(), oppLetter);
        if (hBlockMove != -1) {
            if (hBlockMove % 3 == 0) {
                hBlockMove -= 3;
                // Call GameBoard placeMove
            }
            // Call GameBoard placeMove with hWinMove++
        }

        int vBlockMove = Checker.vConsCheck(board.getBoard(), oppLetter);
        if (vBlockMove != -1) {
            if (vBlockMove == 7 || vBlockMove == 8 || vBlockMove == 9) {
                vBlockMove -= 6;
                // Call GameBoard placeMove
            }
            // Call GameBoard placeMove with vWinMove++
        }

        int dBlockMove = Checker.dConsCheck(board.getBoard(), oppLetter);
        if (dBlockMove != -1) {
            // Call GameBoard placeMove
        }

    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
