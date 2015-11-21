import java.util.*;

public class hello {
	
	public static void main(String[] args){
		//int x = 210 / 5; //equals 42
		//System.out.println("Hello World " + x); //prints to the console
		/*
		System.out.println("Enter a number please."); //Asks for the input
		Scanner in = new Scanner(System.in); //Takes the input 
		int x = 42; //what I want the input to be
		int myNumber = in.nextInt(); //what the user inputs
		while(myNumber != 42){ //runs while what the user imported is not equal to 42
			System.out.println("LOL WRONG GET THE GAMEGUIDE N00B1111"); //Tells the player they lost
			myNumber = in.nextInt(); //Asks for a new input
		}
		System.out.println("xXxCorrectElite360NoScopexXx"); //You win
		//Examples of data types
		String s = "lololol"; 
		char c = 'c';
		int u = 42;
		boolean b = true;
		double pi = 3.14159;
		*/
		//A data type that you made
		//book LordOfTheRings = new book(true, 1000, "JRR Tolkien", "Lord of the Rings", "Fiction");	
		//System.out.println(LordOfTheRings);
		game g = new game(10, "Ryan", 2 ); //Makes a character
		g.play(); //Runs the play method
		//If you wanted to play a game, you must make a new game.
	}
	
}