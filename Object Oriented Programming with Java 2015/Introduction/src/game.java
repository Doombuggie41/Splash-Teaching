import java.util.Scanner;


public class game {
	//Attributs for the player
	int health;
	String name;
	int attack;
	
	//Constructor for the game
	public game(int health, String name, int attack){
		this.health = health;
		this.name = name;
		this.attack = attack;
	}
	
	//Playing the actual game
	public void play(){
		System.out.println("You're walking through the woods");
		System.out.println("Nobody is around, and your phone is dead");
		System.out.println("Out of the corner of your eye you spot him...");
		monster cannibal = new monster(5, "Shia LeBeauf", 1); //Our first monster
		System.out.println(cannibal.name);
		fight(cannibal); //runs the fight method
		monster[] monsterList = new monster[3]; //creates an array of three monsters
		//The monsters in the array
		monsterList[0] = new monster(1, "ant", 0);
		monsterList[1] = new monster(1, "ghost", 2);
		monsterList[2] = new monster(1, "Lizard", 3);
		//Will run from 0 to 2, while your health is greater than zero.
		for(int index = 0; index < monsterList.length && this.health > 0; index++){
			fight(monsterList[index]); //fights monster at whatever index in the array.
			System.out.println("Your health is " + this.health);
		}
		if(this.health > 0){ //If your health is greater than zero, you win
			System.out.println("You've won the game!");
		}
		else{ //Health was less than or equal to zero. You lose
			System.out.println("You've lost the game!");
		}
	}
	public void fight(monster m){
		System.out.println("You are now fighting " + m.name);
		while(m.health > 0){
			System.out.println("enter 'a' to attack, or 'd' to dodge");
			//creates scanner
			Scanner in = new Scanner(System.in);
			//Takes in input
			String input = in.next();
			//User entered 'a'
			if(input.equals("a")){
				System.out.println("You attack and deal " + this.attack + " damage");
				m.health = m.health - this.attack; //subtracts your attack from moster health
				if(m.health <= 0){ //checks if monster is dead
					System.out.println(m.name + " has been defeated.");
					break; //stops the while loop
				}
				System.out.println(m.name + " is now at " + m.health + " health"); //monster health
				//monster attacks
				System.out.println(m.name + " attacks!");
				this.health = this.health - m.attack;
			}
			else if(input.equals("d")){ //you try to dodge
				if(Math.random() > .5){ //generates a number between 0 and 1
					System.out.println("You dodged " +m.name);
				}
				else{
					System.out.println("You were too slow");
					this.health = this.health - m.attack;
					System.out.println(m.name +" dealt " + m.attack + " damage");
				}
			}
			else{
				//user entered something other than 'd' or 'a'
				System.out.println("You were too slow!!!");
				this.health = this.health - m.attack;
				System.out.println(m.name +" dealt " + m.attack + " damage");
				System.out.println("Type the right input next time!");
			}
		}
	}
}
