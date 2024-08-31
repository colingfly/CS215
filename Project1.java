//Colin Gibbons-Fly
// Project 1
//January 23, 2024
/* The Project class contains the main method and prompts the user to repeatedly input information about the player's. 
Following that input it will output the average age of all players, and displays the tallest player  who's age
is less than the average age
*/ 
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in);  
        Scanner input = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>(); // create array list of players
        int totalAge = 0; // create total age, neeeded to find average age
        System.out.print("How many players are there? "); // ask how many players there are so program knows how long to run
        int numPlayers = input.nextInt(); //  create numPlayers  from above variable to use in loop

        for (int i = 1; i <= numPlayers; i++) { // start i at 1, run loop until you reach number of players entered, increase i by 1
            System.out.print("Enter Player " + i + "'s First and Last Name: "); // gather players name
            String name = scanner.nextLine(); // create name variable from above input
            if (name.equalsIgnoreCase("end")) { // allow user to enter 'end' to terminate program
                break;
            }

            System.out.print("Enter Player Feet (If player is 5'10, enter 5): "); // enter players height in feet
            int feet = scanner.nextInt(); // create variable called feet from above input
            System.out.print("Enter Player Inches (If player is 5'10, enter 10): "); // enter remaining inches
            int inches = scanner.nextInt(); // create variable called inches from above input
            scanner.nextLine(); // consume the rest of the line

            System.out.print("Enter Player Age: "); // ask user to input player age
            int age = scanner.nextInt(); // create age variable from above input
            scanner.nextLine(); // consume the rest of the line

            Player player = new Player(name, new Height(feet, inches), age); // Use Player class to create player variable
            players.add(player); // add to player array list
            totalAge += age; // add age to totalAge, combined age of all players
        }

        double averageAge = (double) totalAge / players.size(); // find average age by dividing total age by amount of players in list array
        System.out.println("Average Age: " + averageAge); // print average age

        Player tallestEligiblePlayer = null; // initiliaze tallest player above average height variable, starting  null
        for (Player player : players) { //loop through players list
            if (player.getAge() <= averageAge) { //check if players age is less than or equal to average age
                if (tallestEligiblePlayer == null || // // Check if we haven't found an eligible player yet or... 
                    player.getHeight().toInches() > tallestEligiblePlayer.getHeight().toInches()) {  // if the current player is taller than the current tallest
                    tallestEligiblePlayer = player; //update tallest player to current player
                }
            }
        }

        if (tallestEligiblePlayer != null) { //check if we've found the tallest eligible player
            System.out.println("Tallest player with age <= average: " + tallestEligiblePlayer); //print details of the player
        } else {
            System.out.println("No eligible players found."); //print if no  eligible players are found
        }

        scanner.close(); //stop input scanner
    }
}