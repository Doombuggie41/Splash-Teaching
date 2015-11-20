package playground;

import java.util.Scanner; //Scanner class had to be imported

public class programOne {
	//Your main classes should have this below. 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Print something
		System.out.println("Hello World!");
		//Print a number and words
		System.out.println("The greatest number ever is: " + 42);
		//Now let's take an input. Scanners are an easy way to let us take in an input
		Scanner in = new Scanner(System.in);  //Scanner class had to be imported
		//Let's create some variables
		System.out.println("Enter a number");
		int number = in.nextInt(); //This will allow you to enter a number and bind it to a variable.
		System.out.println("The number you entered is " + number);
		//Now let us do it with a string
		//A string is a word
		String word = "word";
		//or it can be letters... or a group of words
		word = "d"; word = "To be, or not to be";
		//Now we will combine letters and numbers with the input.
		
		System.out.println("What is your name.");
		String name = in.next();
		System.out.println("How old are you?");
		int age = in.nextInt();
		System.out.println("Your name is " + name + ", and you are " + age + "years old");
		//Numbers do not have to be whole, they can heave decimals.
		//Numbers with decimals are called doubles
		double decimals = 3.14;
		System.out.println("The first three digits of pi are " + decimals);
		//Funny things don't really happen when you add doubles and ints
		number = 1;
		decimals = 1.5;
		System.out.println("number + decimal  =" + number + decimals);
		//multiplying though...
		number = 3;
		System.out.println("number * decimal  =" + number * decimals);
		//Dividing?
		System.out.println("number / decimal  =" + number / decimals);
		
		//Lets divide some integers
		System.out.println("50 / 20 = " + 50 / 20);
		//What? 2? What? Where's the remainder?
		System.out.println("50 % 20 =" + 50 % 20 ); //Modulus function will give you the remainder
		
		//Now let's look at booleans
		//They are true or false
		Boolean example = true;
		example = false;
		
		//More about booleans later, you actually use them more than you think
		
		//such as in if statements!
		
		//Let's play a game called "Guess the Number"
		
		System.out.println("Pick a number between 1 and 10");
		int guess = in.nextInt();
		if(guess == 7){ //if this is true... then
			System.out.println("You guessed the number");
		}
		else if(guess == 6 || guess == 5){ //checks another condition
			//OR statement ( || ) means that one or the other can be true
			//So the number can be 5 or 6 to print the below statment
			System.out.println("Close! But, WRONG!");
		}
		else{ //otherwise do this
			System.out.println("You 1ose, computers ru13 lolz");
		}
		//now, if only there was a way that I could guess more than one number...
		//oh snap! there is, loops
		guess = -1; //Sets the number equal to something other than the guess
		while(guess != 7){ //do while the guess does not = 7
			System.out.println("Pick a number between 1 and 10");
			guess = in.nextInt();
		}
		System.out.println("You win!"); //why no if statement? because in order to exit the loop, the number must be 7
		//Now there are other kinds of loops, but I want to teach them with something called arrays.
		int[] manyNumbers = new int[10]; //creates an array of 10 elements
		//all of the elements are currently "null" there is nothing in them.
		for(int counter = 0; counter < manyNumbers.length; counter = counter + 1){ //Start the counter at 0, go until the counter is higher than the number of elements in the array, and increment the counter 1 each time.
			manyNumbers[counter] = counter + 1; //index 0 will be 1, index 9 (the last one) will be 10
		}
		
		//Now let's combine some elements and make a quick game about guessing numbers.
		//I'll introduce methods here too.
		//you get 10 guesses;
		int myNumber = 2; //Number to be guessed
		boolean guessed = false; //If the number is guessed or not
		int guesscount = 0; //number of guesses, this is used to avoid an ArrayIndexOutOfBounds Exception
		int[] guesses = new int[10];
		//Start count at 0, while count is less than guesses.length (which is 10), add one to the count each cycle
		for(int count = 0; count < guesses.length; count++){
			//count++ is the same as count = count + 1
			System.out.println("Pick a number between 1 and 10");
			guesses[count] = in.nextInt(); //Guess at particular index = number that is inputed
			if(isNumber(myNumber, guesses[count]) == true){
				guesscount++; //adds one to the counted guesses
				guessed = true; //number is guessed
				break; //ends the loop
			}
			else{ //Number that is guessed is wront
				System.out.println("You guessed wrong, guess again!");
				guesscount++; //add to the number of guesses
			}
		}
		if(guessed == true) //If number is guessed
			System.out.println("You guessed the number in " + guesscount + " guesses"); //Prints out number of guesses
		else //If number was not guessed
			System.out.println("You did not guess the number"); 
		//Now we will display what was guessed.
		System.out.println("Your guesses were: ");
		String s = ""; //String that will display the guesses
		for (int c = 0; c < guesscount; c ++){ //guesscount is used as opposed to legnth in the case of there being less than 10 guesses
			s = s.concat(guesses[c] + ", "); //.concat adds to the end of a string. 
			//It returns the string (s in this case) with whatever you pass through it
			//(the guess and ", " added to the end.
		}
		s = s.substring(0, s.length() - 2); //removes the trailing ", "
		System.out.print(s); //prints the guesses as a string
		//Remember, .out.print as opposed to println will print on the current line as opposed to starting a new line.
		
		
	}
	//This is a method that checks to see if two numbers are equal
	public static boolean isNumber(int guess, int number){
		if(guess == number) //if the guess is the number, return true
			return true;
		else //if it is not, return false
			return false;
	}
}
