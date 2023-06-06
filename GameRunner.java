import java.io.Console;

public class GameRunner {
    
    // Add try and except to check if player input is valid
    // Implement serialization (on what?)
    private static GameBoard runGame(String s){
        Console console = System.console();

        GameBoard board = new GameBoard();
        ComputerPlayer ai = new ComputerPlayer();

        int odd = 0;
        System.out.print("Alright, you're " + s + "!");
        if (s.equalsIgnoreCase("x")){
            System.out.println (" You go first!");
            odd = 1;
            ai.setLetter("o");
        }
        else if (s.equalsIgnoreCase("o")){
            System.out.println (" You go second!");
            odd = 0;
            ai.setLetter("x");
        }

        for (int i = 1; i <= 9; i++){
            if (i % 2 == odd){
                boolean isMoveAvail = false;
                do {
                    try {
                        System.out.println("Pick a number from 1-9.");
                        String playerMove = console.readLine();
                        int num1 = Integer.parseInt(playerMove);
                        board.placeMove(num1, s);
                        isMoveAvail = true;
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }
                } while (!isMoveAvail);
                System.out.println(board);
                if (Checker.winCheck(board.getBoard())){
                    System.out.println("You win! Good game.");;
                    return board;
                }
            }

            else {
                System.out.println ("Now, the computer goes!");
                int compTurn = ai.compMove(board);
                board.placeMove(compTurn, ai.getLetter());
                System.out.println(board);
                if (Checker.winCheck(board.getBoard())){
                    System.out.println("The computer wins! Good game.");
                    return board;
                }
            }
        }
        System.out.println ("Nobody wins, it's a draw!");
        return board;
    }

    public static void main(String[] args){
        Console console = System.console();
        
        System.out.println("Hi! Welcome to Tic-Tac-Toe!");
        while (true){
            System.out.println("Main Menu");
            System.out.println("\tType 'N' for a new game");
            System.out.println("\tType 'V' to view a saved game");
            System.out.println("\tType 'X' to exit the game");
            
            String response = Utils.input("");
            switch (response.toUpperCase()){
                case "N":
                    System.out.println("Alright, let's play!");
                    String response2 = "";
                    int exOrOh = (int)(Math.random() * 10 + 1);
                    
                    if (exOrOh > 0 && exOrOh <= 5){
                        response2 ="x";
                    }
                    if (exOrOh > 5 && exOrOh <= 10){
                        response2 = "o";
                    }
                    GameBoard board = runGame(response2);
                    //System.out.println ("That was a good game! Enter a file name to save this game! Otherwise, press the 'enter' key to skip this step!");
                    //String fileName = console.readLine();
                    String fileName = Utils.input("That was a good game! Enter a file name to save this game! Otherwise, press the 'enter' key to skip this step!");
                    if (!fileName.equals("")){
                        board.save(fileName);
                    }
                    break;
                
                case "X":
                    System.out.println("Fine! See you next time!");
                    return;

                case "V":
                    System.out.println("Please enter the file name!");
                    fileName = console.readLine();
                    GameBoard g = GameBoard.load(fileName);
                    if (g != null){
                        System.out.println(g);
                    }
                    break;
            } 
        }  
      
    }
}
