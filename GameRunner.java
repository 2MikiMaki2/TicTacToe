import java.util.Scanner;
public class GameRunner {
    
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
        else{
            return false;
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
                    return true;
                }
            }

            else {
                System.out.println ("Now, the computer goes!");
                ai.compMove(board);
                System.out.println(board);
                if (Checker.winCheck(board.getBoard())){
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
