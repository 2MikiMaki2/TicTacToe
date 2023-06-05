import java.util.Scanner;
public class GameRunner {
    
    // TODO: Add try and except to check if player input is valid
    // TODO: Implement serialization (on what?)
    private static boolean runGame(String s){
        Scanner scan = new Scanner(System.in);
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
                int num1 = 10;
                while (!board.placeMove(num1, s)){
                    System.out.println("Pick a number from 1-9!");
                    num1 = scan.nextInt();
                }
                System.out.println(board);
                if (Checker.winCheck(board.getBoard())){
                    System.out.println("You win! Good game.");;
                    return true;
                }
            }

            else {
                System.out.println ("Now, the computer goes!");
                int compTurn = ai.compMove(board);
                board.placeMove(compTurn, ai.getLetter());
                System.out.println(board);
                if (Checker.winCheck(board.getBoard())){
                    System.out.println("The computer wins! Good game.");
                    return true;
                }
            }
        }
        System.out.println ("Nobody wins, it's a draw!");
        scan.close();
        return false;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Hi! Welcome to Tic-Tac-Toe! Do you wanna play a game?");
        System.out.println("Type 'Y' for yes, or type 'N' for no!");
        
        String response = scan.nextLine();
        switch (response){
            case "Y":
                System.out.println("Alright, let's play!");
                String response2 = "";
                int exOrOh = (int)(Math.random() * 10 + 1);
                
            if (exOrOh > 0 && exOrOh <= 5){
                    response2 ="x";
                }
                if (exOrOh > 5 && exOrOh <= 10){
                    response2 = "o";
                }
                runGame(response2);
                
                break;
            
            case "N":
                System.out.println("Fine! See you next time!");
                break;
        }   
        scan.close();
    }
}
