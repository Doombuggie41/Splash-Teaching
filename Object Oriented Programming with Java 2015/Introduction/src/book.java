
public class book {
	//Attributes of the book
	boolean isHardcover;
	int pages;
	String author;
	String name;
	String genre;
	
	//Constructor for the book
	public book(boolean isHardcover, int pages, String author, String name,
			String genre){ //These are "parameters"
		this.isHardcover = isHardcover; //remember "this" refers to the attributes of the book whereas without "this" will refer to the parameters of the function
		this.pages = pages;
		this.author = author;
		this.name = name;
	}
	
	//Turns the book into a string so that you can print it out.
	public String toString(){ //Returns a string
		return "It is " +isHardcover + " that the " + pages  +
				" page book " +name+ " by " + author + " is Hardcover.";
	}
}
