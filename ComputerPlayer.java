/*
 * How will it interact with runner class to be assigned its letter?
 * How will it choose where to place its piece?
 * Computer logic: first blocks player, second tries to win, if can't do either makes random valid move.
 */
public class ComputerPlayer {
    private String letter;
    
    // Computer makes a move by generating random number between 1 and 10
    // TODO: Code full computer logic as described above.
    public int compMove() {
        int randMove = 1 + (int) (Math.random() * 10);
        return randMove;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
