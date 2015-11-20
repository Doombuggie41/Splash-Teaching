package cardGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class goJava {
	public static void main(String[] args) {
		//Create the card decks
		Card[] deck = new Card[40];
		Card[] player = new Card[10];
		Card[] other = new Card[10];
		//Creates some other useful variables
		int cardNumber = 0, pScore = 0, oScore = 0;
		Scanner in = new Scanner(System.in);
		//Adds the cards to the deck
		for(int c = 0; c <=  9; c++){
			deck[cardNumber] = new Card('r', c );
			cardNumber++;
			deck[cardNumber] = new Card('g', c );
			cardNumber++;
			deck[cardNumber] = new Card('y', c );
			cardNumber++;
			deck[cardNumber] = new Card('b', c );
			cardNumber++;
		}
		
		//So now we got a stacked deck.
		//Now we have to shuffle it
		Collections.shuffle(Arrays.asList(deck));
		System.out.println("Top Card is " + deck[39].getSuit() + " " + deck[39].getValue());
		
		//Player and Computer draw cards
		for(int c = 0; c <= 9; c ++){
			player[c] = deck[c];
			other[c] = deck[39 - c];
		}
		
		String input = "";
		while(pScore < 5 && oScore < 5){
			System.out.println("Player One Hand ");
			//Prints out Player One's Hand in the view of player one
			printHand(player); //Methods are under everything
			//Player 2 hand as of player one's view
			System.out.println("");
			System.out.println("");
			System.out.println("Player Two Hand");
			printHandHide(other);
			//Take an input
			System.out.println("");
			System.out.println("Guess a Card. Enter int the form of c1");
			input = in.nextLine();
			//Guess = new Card( input.charAt(0) , Integer.parseInt(input.substring(1)) );
			//Go Through other player's cards to see if it exits
			for (int c = 0; c < other.length; c++){
				//If the player has the card, checks to see if inputed card is of the same suit and value
				//as one that the player has.
				if(other[c].getSuit() ==  input.charAt(0) && other[c].getValue() == Integer.parseInt(input.substring(1))){
					other[c].flip(); //Flips the card over
					pScore++; //Adds one to the score
					System.out.println("Match Found! You have " + pScore + "/5 matches");
				}
			}
			if(pScore == 5) //Ends the game if player one wins before player two goes
				break;
			//Just some formatting
			System.out.println("");
			System.out.println("---------------------------------------------");
			System.out.println("");
			//Time for the next player's move
			System.out.println("Player Two Hand ");
			//Prints out Player Two Hand in the view of player Two
			printHand(other);
			//Player 2 hand as of player one's view
			System.out.println("");
			System.out.println("");
			System.out.println("Player one Hand");
			printHandHide(player);
			//Take an input
			System.out.println("");
			System.out.println("Guess a Card. Enter int the form of c1");
			input = in.nextLine();
			//Guess = new Card( input.charAt(0) , Integer.parseInt(input.substring(1)) );
			//Go Through other player's cards to see if it exits
			for (int c = 0; c < player.length; c++){
				//If the player has the card, checks to see if inputed card is of the same suit and value
				//as one that the player has. && means both must be true
				if(player[c].getSuit() ==  input.charAt(0) && player[c].getValue() == Integer.parseInt(input.substring(1))){
					player[c].flip(); //Flips the card over
					oScore++; //adds one to the score
					System.out.println("Match Found! You have " + oScore + "/5 matches");
				}
			}
			System.out.println("The score is... Player 1: " + pScore +" to Player 2: " + oScore);
			System.out.println("");
			System.out.println("---------------------------------------------");
			System.out.println("");
		}
		//Checks for the winner
		if(pScore == 5)
			System.out.println("Player 1 Wins!");
		else
			System.out.println("Player 2 Wins!");
		
		
	}
	
	//Method for printing out a particular hand, does not try anything
	public static void printHand(Card[] deck){
		for (int c = 0; c < deck.length; c++){
			//As opposed to println, print will keep it on the same line
			System.out.print("| " + deck[c].getSuit());
			if(deck[c].isFacedUp()) //We will use a plus sign to signify that the card is flipped
				System.out.print("+");
			else
				System.out.print(" ");
			System.out.print(deck[c].getValue()+ " | ");
		}
	}
	//Prints a particular hand with all cards hidden but the flipped ones
	public static void printHandHide(Card[] deck){
		for (int c = 0; c < deck.length; c++){
			System.out.print("|");
			if(deck[c].isFacedUp()) //Will only print card if the card is flipped
				System.out.print(" " + deck[c].getSuit() + "+" + deck[c].getValue() + " | ");
			else//Otherwise, it remains a mystery
				System.out.print(" ? ? | ");
		}
	}

}
