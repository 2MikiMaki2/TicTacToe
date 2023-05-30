import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Hi! Welcome to Tic-Tac-Toe! Do you wanna play a game?");
        System.out.println("Type 'Y' for yes, or type 'N' for no!");
        String response = scan.nextLine();
        if (response.equalsIgnoreCase("Y")){
            System.out.println("Alright, let's play!");
            String response2 = scan.nextLine();
            int exOrOh = (int)(Math.random() * 10 + 1);
            String[][] help = new String[3][3];
            
            if (exOrOh > 0 && exOrOh <= 5){
                response2 = "x";
            }
            if (exOrOh > 5 && exOrOh <= 10){
                response2 = "o";
            }

            if (response2.equals("x")){
                System.out.println("Alright, you're ex! You go first!");
                for (int i = 1; i <= 10; i++){
                    while (i % 3 == 0){
                        System.out.println("First, pick a row!");
                        int r1 = scan.nextInt();
                        System.out.println("Next, pick a column!");
                        int c1 = scan.nextInt();
                        System.out.println("Placing an ex at " + r1 + ", " + c1 + "!");
                        help[r1][c1] = "x";
                    }
                    System.out.println(help);
                }
            }

            else if (response2.equalsIgnoreCase("o")){
                System.out.println("Alright, you're oh! You go second!");
                for (int i = 2; i <= 10; i++){
                    while (i % 2 == 0){
                        System.out.println("First, pick a row!");
                        int r2 = scan.nextInt();
                        System.out.println("Next, pick a column!");
                        int c2 = scan.nextInt();
                        System.out.println("Placing an oh at " + r2 + ", " + c2 + "!");
                        help[r2][c2] = "o";
                    }
                    System.out.println(help);
                }
            }
        }
        else{
            System.out.println("Fine! See you next time!");
        }
    }
}
