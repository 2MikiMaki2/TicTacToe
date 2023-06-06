public class Checker {
    
    // Checks if the given location on the board is empty
    public static boolean checkIsEmpty(String[][] board, int row, int col) {
        if (!board[row][col].equals(" ")) {
            return false;
        }
        return true;
    }

    public static boolean winCheck(String[][] board) {
        // Checks horizontally if someone won
        for (int r = 0; r < board.length; r++) {
            boolean horizontalSame = true;
            for (int c = 1; c < board[r].length; c++) {
                if (!board[r][c].equals(board[r][c - 1])) {
                    horizontalSame = false;
                }
            }
            if (horizontalSame && board[r][0] != " ") {
                System.out.println("The winner was " + "'" + board[r][0] + "'!");
                return true;
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
            if (verticalSame && board[0][c] != " ") {
                System.out.println("The winner was " + "'" + board[0][c] +"'!");
                return true;
            }
        }

        // Diagonal checks for whether someone won
        if (!board[0][0].equals(" ") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            System.out.println("The winner was " + "'" + board[0][0] + "'!");
            return true;
        }
        if (!board[2][0].equals(" ") && board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
            System.out.println("The winner was " + "'" + board[2][0] +"'!");
            return true;
        } 
        
        return false;
    }

    public static int hConsCheck(GameBoard gBoard, String letter) {
        // Checks horizontally for two appearances of *letter*
        String[][] board = gBoard.getBoard();
        for (int r = 0; r < board.length; r++) {
            int hCount = 0;
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].equals(letter)) {
                    hCount++;
                } else if (! board[r][c].equals(" ")){
                    hCount = 0;
                }
            }

            if (hCount == 2) {
                // find the empty space and return the index
                for (int c = 0; c < board[r].length; c++) {
                    if (board[r][c].equals(" ")){
                        return r * 3 + c + 1;
                    }
                }
            }

        }

        return -1;
    }

    public static int vConsCheck(GameBoard gBoard, String letter) {
        // Checks vertically for two appearances of *letter*
        String[][] board = gBoard.getBoard();
        for (int c = 0; c < board[0].length; c++) {
            int vCount = 0;
            for (int r = 0; r < board.length; r++) {
                if (board[r][c].equals(letter)) {
                    vCount++;
                } else if (! board[r][c].equals(" ")){
                    vCount = 0;
                }
            }    

            if (vCount == 2) {
                for (int r = 0; r < board.length; r++){
                    if (board[r][c].equals(" ")){
                        return r * 3 + c + 1;
                    } 
                }
            }
        }
        return -1;
    }

    public static int dConsCheck(GameBoard gBoard, String letter) {
        // Checks diagonals for two appearances of *letter*
        String[][] board = gBoard.getBoard();
        if (board[0][0].equals(letter) && board[1][1].equals(letter) && board[2][2].equals(" ")) {
            return 9;
        }
        if (board[0][0].equals(letter) && board[1][1].equals(" ") && board[2][2].equals(letter)) {
            return 5;
        }
        if (board[0][0].equals(" ") && board[1][1].equals(letter) && board[2][2].equals(letter)) {
            return 1;
        }

        if (board[0][2].equals(letter) && board[1][1].equals(letter) && board[2][0].equals(" ")) {
            return 7;
        }
        if (board[0][2].equals(letter) && board[1][1].equals(" ") && board[2][0].equals(letter)) {
            return 5;
        }
        if (board[0][2].equals(" ") && board[1][1].equals(letter) && board[2][0].equals(letter)) {
            return 3;
        }

        return -1;
    }

}