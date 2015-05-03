package es.klodike.controllers;

import es.klondike.model.Card;
import es.klondike.model.Tableau;

public class MoveFromDeckToWasteController {

	private static final boolean COVERED_CARD = true;
	private static final boolean UNCOVERED_CARD = false;
	public static final int NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE = 1;
	private Tableau tableau;

	public MoveFromDeckToWasteController(Tableau tableau) {
		this.tableau= tableau;
	}

	public void moveFromDeckToWaste() {
		if(tableau.getDeck().size()>=NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE){
		  moveMinimunCardsFromDeckToWaste();
		}
		else{
		   moveAllWasteCardsToEmptyDeck();
	   }
	}

	private void moveAllWasteCardsToEmptyDeck() {
		for(Card card: tableau.getWaste()){
			   card.setCovered(COVERED_CARD);
		       tableau.getDeck().push(card);
		      
	    }
		   tableau.getWaste().removeAllElements();
	}

	private void moveMinimunCardsFromDeckToWaste() {
		tableau.getWaste().push(tableau.getDeck().pop());
		tableau.getWaste().peek().setCovered(UNCOVERED_CARD);
	}
	
	

}
