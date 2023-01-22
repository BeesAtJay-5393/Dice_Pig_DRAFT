//Toobejay Yaaj
//Steve Hughes
//CS245
//1/22/23

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Create an CLASS OBJECT that represents the player as they both will share the
        //same METHODS and VARIABLES. (We wouldn't want to copy and paste, would we?)
        Player player1 = new Player("John");
        Player player2 = new Player("Sarah");
        Scanner scan = new Scanner(System.in);
        Die die = new Die();

        //This is a turn counter. Since the game PIG can only be played with two
        //players, a BOOLEAN to determine whose turn it is will be more efficient
        //than having an INT do the job.
        boolean turn = true;
        boolean win = false;
        String name1 = player1.getName();
        String name2 = player2.getName();
        int roundPoints = 0, num = 0;
        String response = "y";

        int rollResult = die.roll();
        System.out.println(rollResult);

        while (!win) {
            if (turn) {
                turn = false;
                while (response.equals("yes") || response.equals("y")) {
                    System.out.println("PLayer 1, " + name1 + ", you have " + player1.getPoints() + " final points.");
                    System.out.println("You currently have " + roundPoints + "  points this round.");
                    System.out.println("Would you like to roll the dice?");
                    response = scan.nextLine().toString().toLowerCase();

                    if (response.equals("yes") || response.equals("y")) {
                        num = die.roll();
                        System.out.println("You rolled: " + num);
                        if (num == 1) {
                            System.out.println("Better luck next time!");
                            //The following BREAK statement will BREAK out of the
                            //current WHILE LOOP.
                            break;
                        } else {
                            roundPoints += num;
                        }


                    }
                }

                //The next line adds the final points from the round to the CLASS
                //VARIABLE for storage.
                if (num != 1) {
                    player1.addPoints(roundPoints);
                }

                //Reset all LOCAL VARIABLES for the next player
            }

            else {
                turn = true;
                while (response.equals("yes") || response.equals("y")) {
                    System.out.println("PLayer 2, " + name2 + ", you have " + player2.getPoints() + " final points.");
                    System.out.println("You currently have " + roundPoints + "  points this round.");
                    System.out.println("Would you like to roll the dice?");
                    response = scan.nextLine().toString().toLowerCase();

                    if (response.equals("yes") || response.equals("y")) {
                        num = die.roll();
                        System.out.println("You rolled: " + num);
                        if (num == 1) {
                            System.out.println("Better luck next time!");
                            //The following BREAK statement will BREAK out of the
                            //current WHILE LOOP.
                            break;
                        } else {
                            roundPoints += num;
                        }


                    }
                }

                //The next line adds the final points from the round to the CLASS
                //VARIABLE for storage.
                if (num != 1) {
                    player2.addPoints(roundPoints);
                }

                //Reset all LOCAL VARIABLES for the next player
            }
            response = "y";
            roundPoints = 0;
            System.out.println("TURN END!");

            //Check for a winner!
            if (player1.getPoints() >= 100) {
                System.out.println("Player 1 wins!");
                win = true;
            }
            else if (player2.getPoints() >= 100){
                System.out.println("Player 2 wins!");
                win = true;
            }
        }
    }
}