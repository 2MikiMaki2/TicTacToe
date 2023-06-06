import java.util.HashMap;

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
        // Checks horizontally for two consecutive appearances of *letter*
        String[][] board = gBoard.getBoard();
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
                    int hMoveIndex = hIndex;
                    if (hIndex % 3 == 0) {
                        hMoveIndex -= 2;
                    } else {
                        hMoveIndex++;
                    }
                    Position hPos = gBoard.getHash().get(hMoveIndex);
                    if (checkIsEmpty(board, hPos.getRow(), hPos.getCol())) {
                        return hMoveIndex;
                    } else {
                        break;
                    }
                    
                }

                hIndex++;
            }
        }

        return -1;
    }

    public static int vConsCheck(GameBoard gBoard, String letter) {
        // Checks vertically for two consecutive appearances of *letter*
        String[][] board = gBoard.getBoard();
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
                    int vMoveIndex = vIndex;
                    if (vIndex == 7 || vIndex == 8 || vIndex == 9) {
                        vMoveIndex -= 6;
                    } else {
                        vMoveIndex += 3;
                    }
                    Position vPos = gBoard.getHash().get(vMoveIndex);
                    if (checkIsEmpty(board, vPos.getRow(), vPos.getCol())) {
                        return vMoveIndex;
                    } else {
                        break;
                    }
                    
                }

                if (!(vIndex == 7 || vIndex == 8 || vIndex == 9)) {
                    vIndex += 3;
                }
                
            }
            vIndex -= 5;
        }

        return -1;
    }

    public static int dConsCheck(GameBoard gBoard, String letter) {
        // Checks diagonals for two consecutive appearances of *letter*
        String[][] board = gBoard.getBoard();
        HashMap<Integer, Position> translation = gBoard.getHash();
        if (board[0][0].equals(letter) && board[0][0].equals(board[1][1]) && checkIsEmpty(board, translation.get(9).getRow(), translation.get(9).getCol())) {
            return 9;
        }
        if (board[2][2].equals(letter) && board[2][2].equals(board[1][1]) && checkIsEmpty(board, translation.get(1).getRow(), translation.get(1).getCol())) {
            return 1;
        }
        if (board[0][2].equals(letter) && board[0][2].equals(board[1][1]) && checkIsEmpty(board, translation.get(7).getRow(), translation.get(7).getCol())) {
            return 7;
        }
        if (board[2][0].equals(letter) && board[2][0].equals(board[1][1]) && checkIsEmpty(board, translation.get(3).getRow(), translation.get(3).getCol())) {
            return 3;
        }

        return -1;
    }

    public static int cConsCheck(GameBoard gBoard, String letter) {
        // Checks if two corners are equal with empty space between them
        String[][] board = gBoard.getBoard();
        if (board[0][0].equals(letter) && board[0][2].equals(letter) && checkIsEmpty(board, 0, 1)) {
            return 2;
        }
        if (board[2][0].equals(letter) && board[2][2].equals(letter) && checkIsEmpty(board, 2, 1)) {
            return 8;
        }
        if (board[0][0].equals(letter) && board[2][0].equals(letter) && checkIsEmpty(board, 1, 0)) {
            return 4;
        }
        if (board[0][2].equals(letter) && board[2][2].equals(letter) && checkIsEmpty(board, 1, 2)) {
            return 6;
        }
        if (board[0][0].equals(letter) && board[2][2].equals(letter) && checkIsEmpty(board, 1, 1)) {
            return 5;
        }
        if (board[2][0].equals(letter) && board[0][2].equals(letter) && checkIsEmpty(board, 1, 1)) {
            return 5;
        }

        return -1;
    }
    
}