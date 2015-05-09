package es.klondike.model;

import es.klondike.utils.Colour;

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

	public Object getColour() {
		return this.colour;
	}

	
}
