package cardGame;

public class Card {
	char suit;
	int value;
	boolean facedUp;
	
	public Card(char s, int v){
		suit = s;
		value = v;
		facedUp = false;
	}
	
	public void flip(){
		if (facedUp)
			facedUp = false;
		else
			facedUp = true;
	}
	
	public int getValue(){
		return value;
	}
	public char getSuit(){
		return suit;
	}
	public boolean isFacedUp(){
		return facedUp;
	}
}
