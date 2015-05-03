package es.klondike.model;

public class Card {
    private Suite colour;
    private int number;
    private boolean covered;
    
    
    
	public Card(Suite colour, int number, boolean covered) {
		super();
		this.colour = colour;
		this.number = number;
		this.covered = covered;
	}

	public Suite getColour() {
		return colour;
	}

	public void setColour(Suite colour) {
		this.colour = colour;
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
}
