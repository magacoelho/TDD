package es.klodike.controllers;

import es.klondike.model.Card;
import es.klondike.model.Board;
import es.klondike.utils.Constantes;

public class MoveFromDeckToWasteController {


	private Board board;

	public MoveFromDeckToWasteController(Board board) {
		this.board= board;
	}

	public void moveFromDeckToWaste() {
		if(board.getDeck().size()>=Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE){
		  moveMinimunCardsFromDeckToWaste();
		}
		else{
		   moveAllWasteCardsToEmptyDeck();
	   }
	}

	private void moveAllWasteCardsToEmptyDeck() {
		for(Card card: board.getWaste()){
			   card.setCovered(Constantes.COVERED_CARD);
		       board.getDeck().push(card);
		      
	    }
		   board.getWaste().removeAllElements();
	}

	private void moveMinimunCardsFromDeckToWaste() {
		board.getWaste().push(board.getDeck().pop());
		board.getWaste().peek().setCovered(Constantes.UNCOVERED_CARD);
	}
	
	

}
