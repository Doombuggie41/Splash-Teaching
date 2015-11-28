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
		System.out.println("number + decimal  =" + number * decimals);
		//Dividing?
		System.out.println("number + decimal  =" + number / decimals);
		
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
		else{ //otherwise do this
			System.out.println("You 1ose, computers ru13 lolz");
		}
		//now, if only there was a way that I could guess more than one number...
		//oh snap! there is, loops
		guess = -1;
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
		int myNumber = 2;
		boolean guessed = false;
		int guesscount = 0;
		int[] guesses = new int[10];
		for(int count = 0; count < guesses.length; count++){
			System.out.println("Pick a number between 1 and 10");
			guesses[count] = in.nextInt();
			if(isNumber(myNumber, guesses[count]) == true){
				guesscount = count + 1;
				//System.out.println("foo");
				guessed = true;
				break; //ends the loop
			}
			else{
				System.out.println("You guessed wrong, guess again!");
			}
		}
		if(guessed == true)
			System.out.println("You guessed the number in " + guesscount + " guesses");
		else
			System.out.println("You did not guess the number");
		System.out.println("Your guesses were: ");
		String s = "";
		for (int c = 0; c < guesscount; c ++){
			s = s.concat(guesses[c] + ", ");
		}
		s = s.substring(0, s.length() - 2);
		System.out.print(s);
		
		
	}
	public static boolean isNumber(int guess, int number){
		if(guess == number)
			return true;
		else
			return false;
	}
}
