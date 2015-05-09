package es.klodike.controllers;

import es.klodike.controllers.test.Foundation;
import es.klondike.model.Board;
import es.klondike.model.Card;
import es.klondike.model.Suite;
import es.klondike.utils.Constantes;

public class MoveFromWasteToFoundationController {

	private Board board;

	public MoveFromWasteToFoundationController(Board board) {
		this.board= board;
		
	}

	public void moveCardFromWasteToFoundation(Card cardToMove, int targetFoundationIndex) {

		Foundation foundation= this.getFoundation(targetFoundationIndex);
		if(!isEmptyWaste())
		if(isEmptyFoundation(foundation)){
			insertFirstCardIntoFoundation(cardToMove, foundation);
		}
		else{
			 insertOtherCardIntoFoundation(cardToMove, foundation);
		}
	}
	

	public boolean isEmptyWaste() {
		// TODO Auto-generated method stub
		return board.getWaste().size()==0;
	}

	public void insertOtherCardIntoFoundation(Card cardToMove, Foundation foundation) {
		if(cardToMove.getSuite().equals(foundation.getSuite())){
			 Card cardTop = getTopCardFoundation(foundation);
			 if(cardTop.getNumber() ==cardToMove.getNumber() -1){
				 insertCardIntoFoundation(cardToMove, foundation);
			 }
		 }
	}

	public Card getTopCardFoundation(Foundation foundation) {
		return foundation.getStackCard().peek();
	}

	public void insertFirstCardIntoFoundation(Card cardToMove,	Foundation foundation) {
		if(cardToMove.getNumber()==Constantes.ORDINAL_MINIMUN_CARD){
		     foundation.setSuite(cardToMove.getSuite());
		     insertCardIntoFoundation(cardToMove, foundation);
		}
	}

	public void insertCardIntoFoundation(Card cardToMove, Foundation foundation) {
		foundation.getStackCard().push(cardToMove);
	}
  
	
	public boolean isEmptyFoundation(Foundation foundation) {
		return foundation.size()==0;
	}

	public Foundation getFoundation(int i) {
		return board.getFoundations().get(i);
	}

	public Card pushCard(Card card, int foundationIndex) {
		return this.getFoundation(foundationIndex).getStackCard().push(card);
	}

	public Board getBoard() {
		return this.board;
	}

	
}
