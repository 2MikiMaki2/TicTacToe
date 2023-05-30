public class Checker {
    
    // Checks if the given location on the board is empty
    public boolean checkIsEmpty(String[][] board, int row, int col) {
        if (board[row][col] != " ") {
            return false;
        }
        return true;
    }

    public boolean boardCheck(String[][] board) {
        // Checks horizontally if someone won
        for (int r = 0; r < board.length; r++) {
            boolean horizontalSame = true;
            for (int c = 1; c < board[r].length; c++) {
                if (!board[r][c].equals(board[r][c - 1])) {
                    horizontalSame = false;
                }
            }
            if (horizontalSame) {
                System.out.println("The winner was " + board[r]);
                return horizontalSame;
            }
        }

        // Checks vertically if someone won
        for (int c = 0; c < board[0].length; c++) {
            boolean verticalSame = true;
            for (int r = 1; r < board.length; r++) {
                if (!board[r][c].equals(board[r - 1][c])) {
                    verticalSame = false;
                }
            }
            if (verticalSame) {
                System.out.println("The winner was " + board[c]);
                return verticalSame;
            }
        }

        // Diagonal checks for whether someone won
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true;
        }
        if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
            return true;
        }
        
        return false;
    }
    
}
