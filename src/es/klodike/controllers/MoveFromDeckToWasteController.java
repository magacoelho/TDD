package es.klodike.controllers;

import es.klondike.model.Card;
import es.klondike.model.Board;
import es.klondike.utils.Constantes;

public class MoveFromDeckToWasteController extends KlondikeController{


	public MoveFromDeckToWasteController(Board board) {
		super(board);
	}

	public void moveFromDeckToWaste() {
		if(this.getBoard().getDeck().size()>=Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE){
		  moveMinimunCardsFromDeckToWaste();
		}
		else{
		   moveAllWasteCardsToEmptyDeck();
	   }
	}

	private void moveAllWasteCardsToEmptyDeck() {
		for(Card card: this.getBoard().getWaste()){
			   card.setCovered(Constantes.COVERED_CARD);
			   this.getBoard().getDeck().push(card);
		      
	    }
		this.getBoard().getWaste().removeAllElements();
	}

	private void moveMinimunCardsFromDeckToWaste() {
		this.getBoard().getWaste().push(this.getBoard().getDeck().pop());
		this.getBoard().getWaste().peek().setCovered(Constantes.UNCOVERED_CARD);
	}
	
	

}
