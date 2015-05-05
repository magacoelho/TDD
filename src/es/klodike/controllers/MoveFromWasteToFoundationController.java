package es.klodike.controllers;

import es.klondike.model.Board;
import es.klondike.model.Card;
import es.klondike.model.Suite;

public class MoveFromWasteToFoundationController {

	private Board board;

	public MoveFromWasteToFoundationController(Board board) {
		this.board= board;
		
	}

	public void moveCardFromWasteToFoundation(Card cardToMove, int targetFoundation) {
		board.getFoundations().get(targetFoundation).setSuite(cardToMove.getSuite());
		board.getFoundations().get(targetFoundation).getStackCard().push(cardToMove);
		
	}
 
}
