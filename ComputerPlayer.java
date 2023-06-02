/*
 * How will it interact with runner class to be assigned its letter?
 * How will it choose where to place its piece?
 * Computer logic: first tries winning move, then blocks player, if can't do either makes random valid move.
 */
public class ComputerPlayer {
    private String letter;
    
    public ComputerPlayer() {
        letter = "x";
    }

    public ComputerPlayer(String letter) {
        this.letter = letter;
    }
    
    // Computer makes a move by generating random number between 1 and 10
    // TODO: Code full computer logic as described above.
    public int compMove() {
        int randMove = 1 + (int) (Math.random() * 10);
        return randMove;

        //First search if a winning move can be made

    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
