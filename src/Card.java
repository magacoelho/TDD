
public class Card {
    private Colour colour;
    private int number;
    private boolean covered;
    
    
    
	public Card(Colour colour, int number, boolean covered) {
		super();
		this.colour = colour;
		this.number = number;
		this.covered = covered;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public boolean isUncovered() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCovered() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setCovered(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
