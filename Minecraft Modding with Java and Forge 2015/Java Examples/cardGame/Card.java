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
		facedUp = !facedUp;
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
	public boolean equals(Card c){
		if(c.getSuit() == suit && c.getValue() == value)
			return true;
		else
			return false;
	}
}
