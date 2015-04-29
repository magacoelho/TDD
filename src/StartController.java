import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class StartController {
	
	
	private Tableau tableau;

	
	public StartController() {
		super();
		this.tableau= new Tableau();
		
	}

	public int sizeWaste() {
		return this.tableau.getWaste().size();
	}

	public int sizeDeck() {
		return this.tableau.getDeck().size();
	}

	public int getNumberFoundations() {
		return this.tableau.getFoundations().size();
	}

	public ArrayList<Integer> getSizeFoundations() {
		ArrayList<Integer> sizeFoundations= new ArrayList<Integer>();
		for (Stack<Card> fundation :  this.tableau.getFoundations()) {
			sizeFoundations.add(fundation.size());
		}
		return sizeFoundations;
	}

	public ArrayList<Integer> getSizeFourColurs() {
		ArrayList<Integer> sizeFourColours= new ArrayList<Integer>();

		for (Stack<Card> fourColour :this.tableau.getAllFourColor()) {
		  	
		  sizeFourColours.add(fourColour.size());
		}
		return sizeFourColours;
	}

	public Tableau getTableau() {
		
		return this.tableau;
	}

	
	
	public ArrayList<Stack<Card>> getAllFourColor() {
		return this.tableau.getAllFourColor();
	}

	public Integer getSizeFullDeck() {
		return this.tableau.getFullDeck().size();
	}

	public boolean verifyNotRepetedCards() {
		boolean noRepetidas= true;
	    for (Card card : this.tableau.getFullDeck()) {
			if( this.tableau.getFullDeck().lastIndexOf(card)!= this.tableau.getFullDeck().indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	    for (Stack<Card> stack :this.tableau.getAllFourColor()) {
			for (Card card : stack) {
				 for (Stack<Card> stack2 : this.tableau.getAllFourColor()){
					 if(stack2.lastIndexOf(card)!=stack2.indexOf(card)){
						 noRepetidas=false;
						 break;
					 }
				 }
			}
		}
	    for (Card card : this.tableau.getWaste())  {
	    	if(this.tableau.getWaste().lastIndexOf(card)!=this.tableau.getWaste().indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	   return noRepetidas;
	}

}
