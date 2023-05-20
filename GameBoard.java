public class GameBoard{
        private String[][] gameBoard;
        private String ex;
        private String oh;
        
        public String playerPick(String pick){
            if (pick.equalsIgnoreCase("x")){
                ex = "x";
                return ex;
            }
            else{
                oh = "o";
                return oh;
            }
        }

        public String[][] newGame(){
            String[][] newBoard = new String[3][3];
            gameBoard = newBoard;
            return gameBoard;  
        }
    }