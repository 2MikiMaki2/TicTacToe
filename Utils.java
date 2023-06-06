/*
Utils - utility methods for console input

Author - Marc Shepard
*/

import java.util.Scanner;

// Input class - consists of only static methods
public class Utils {
  // A static scanner to support console input
  private static Scanner scan = new Scanner(System.in);

  // Return a string reply to a question
  public static String input (String question) {
    System.out.println(question);
    return scan.nextLine().trim();
  } 

  // Return a whole number reply to a question
  public static int inputNum (String question) {
    System.out.print (question);
    int num = -1;
    while (num <= 0) {
      try {
        String numStr = scan.nextLine();
        num = Integer.parseInt(numStr);
      } catch (Exception e) {}
      if (num <= 0)
        System.out.println ("Please enter a positive integer: ");
    }
    return num;
  }
}