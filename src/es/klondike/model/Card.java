package es.klondike.model;


public class Card {
    private Suite suite;
    private int number;
    private boolean covered;
    private Colour colour;

 public Card(Suite suite, int number, boolean covered) {
		super();
		this.suite = suite;
		this.number = number;
		this.covered = covered;
	}

	public Card(Suite suite, int number, boolean covered, Colour colour) {
		this.suite = suite;
		this.number = number;
		this.covered = covered;
		this.colour=colour;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isCovered() {
		return this.covered;
	}

	public void setCovered(boolean covered) {
		this.covered=covered;
	}

	public Colour getColour() {
		return this.colour;
	}

	public void setColour(Colour colour) {
		this.colour= colour;
	}
    
	public boolean isConsecutiveNumber(Card card){
		return this.getNumber()==card.getNumber()+1;
	}
}
