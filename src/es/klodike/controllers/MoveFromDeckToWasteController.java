package es.klodike.controllers;

import es.klondike.model.Card;
import es.klondike.model.Tableau;
import es.klondike.utils.Constantes;

public class MoveFromDeckToWasteController {


	private Tableau tableau;

	public MoveFromDeckToWasteController(Tableau tableau) {
		this.tableau= tableau;
	}

	public void moveFromDeckToWaste() {
		if(tableau.getDeck().size()>=Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE){
		  moveMinimunCardsFromDeckToWaste();
		}
		else{
		   moveAllWasteCardsToEmptyDeck();
	   }
	}

	private void moveAllWasteCardsToEmptyDeck() {
		for(Card card: tableau.getWaste()){
			   card.setCovered(Constantes.COVERED_CARD);
		       tableau.getDeck().push(card);
		      
	    }
		   tableau.getWaste().removeAllElements();
	}

	private void moveMinimunCardsFromDeckToWaste() {
		tableau.getWaste().push(tableau.getDeck().pop());
		tableau.getWaste().peek().setCovered(Constantes.UNCOVERED_CARD);
	}
	
	

}
