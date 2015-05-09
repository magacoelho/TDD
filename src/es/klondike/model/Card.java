package es.klondike.model;

public class Card {
    private Suite suite;
    private int number;
    private boolean covered;
    private int colour;
    
    
    
    
    
	public Card(Suite colour, int number, boolean covered) {
		super();
		this.suite = colour;
		this.number = number;
		this.covered = covered;
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

	
	public boolean isBlackColour() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getColour() {
	
		return this.colour;
	}

	
}
