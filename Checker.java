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

    public static int hConsCheck(String[][] board, String letter) {
        // Checks horizontally for two consecutive appearances of *letter*
        int hIndex = 1;
        for (int r = 0; r < board.length; r++) {
            int hCount = 0;
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].equals(letter)) {
                    hCount++;
                } else {
                    hCount = 0;
                }

                if (hCount == 2) {
                    return hIndex;
                }

                hIndex++;
            }
        }

        return -1;
    }

    public static int vConsCheck(String[][] board, String letter) {
        // Checks vertically for two consecutive appearances of *letter*
        int vIndex = 1;
        for (int c = 0; c < board[0].length; c++) {
            int vCount = 0;
            for (int r = 0; r < board.length; r++) {
                if (board[r][c].equals(letter)) {
                    vCount++;
                } else {
                    vCount = 0;
                }

                if (vCount == 2) {
                    return vIndex;
                }

                vIndex+= 3;
            }
            vIndex-= 5;
        }

        return -1;
    }

    public static int dConsCheck(String[][] board, String letter) {
        // Checks diagonals for two consecutive appearances of *letter*
        if (board[0][0].equals(board[1][1])) {
            return 9;
        }
        if (board[2][2].equals(board[1][1])) {
            return 1;
        }
        if (board[0][2].equals(board[1][1])) {
            return 7;
        }
        if (board[2][0].equals(board[1][1])) {
            return 3;
        }

        return -1;
    }
    
}