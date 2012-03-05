package RPS;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kai
 */

import java.util.Scanner;
        
public class FrontEnd {
//    private Player humanPlayer;
//    private Player ComPlayer;
    private static int flag = 1;
    public static void main( String[] args) {
         
        //int flag = 0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("*******************************");
        System.out.println("*   ROCK - PAPER - SCISSORS   *");
        System.out.println("*         Team KAI            *");
        System.out.println("*******************************");
        do {
            System.out.println("\n\t MAIN MENU");
            System.out.println("Enter 1 to start a match.");
            System.out.println("Enter 2 to display score.");
            System.out.println("Enter 3 to display help.");
            System.out.println("Enter 4 to quit.");
            System.out.print("Please enter a number:");    
            int c = s.nextInt();
            if (c == 1) {
                //call startMatch();
                System.out.println("Start Match");
                flag = 1;
            }
            else if (c == 2) {
                //call displayScore();
                System.out.println("\nScore");
                flag = 0;
            }
            else if (c == 3) {
                //call displayHelp();
                displayHelp();
            }
            else if (c == 4) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            else {
                System.out.print("\nThe number is invalid. Please enter again.\n");
                flag = 0;
            }
        } while (flag == 0);
    }
 //   private Stats displayScore() {
 //       return null;
 //   }
    private static void displayHelp() {
        System.out.println("\nHelp Message:");
        System.out.println("*The player enters his/her choice(rock/paper/scissors).");
        System.out.println("*Computer computes its choice by random.");
        System.out.println("*The winner of the game is determined as follows:");
        System.out.println("* -Rock defeats Scissors.");
        System.out.println("* -Scissors defeats Paper.");
        System.out.println("* -Paper defeats Rock.");
        flag = 0;
    }
}
