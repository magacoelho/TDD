package es.klodike.controllers;

import es.klondike.model.Card;
import es.klondike.model.Tableau;

public class MoveFromDeckToWasteController {

	private Tableau tableau;

	public MoveFromDeckToWasteController(Tableau tableau) {
		this.tableau= tableau;
	}

	public void moveFromDeckToWaste() {
		if(tableau.getDeck().size()>=1){
		  tableau.getWaste().push(tableau.getDeck().pop());
		  tableau.getWaste().peek().setCovered(false);
		}
		else{
		   for(Card card: tableau.getWaste()){
			   card.setCovered(true);
		       tableau.getDeck().push(card);
		      
	    }
		   tableau.getWaste().removeAllElements();
	   }
	}

}
