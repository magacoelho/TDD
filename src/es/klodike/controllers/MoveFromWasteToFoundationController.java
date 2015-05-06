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
		if(foundation.size()==0){
			if(cardToMove.getNumber()==Constantes.ORDINAL_MINIMUN_CARD){
			     foundation.setSuite(cardToMove.getSuite());
			     foundation.getStackCard().push(cardToMove);
	        }
		}
		else{
			 if(cardToMove.getSuite().equals(foundation.getSuite())){
				 Card cardTop = foundation.getStackCard().peek();
				 if(cardTop.getNumber() ==cardToMove.getNumber() -1){
					 foundation.getStackCard().push(cardToMove);
				 }
			 }
			
			
		}
	}

	public Foundation getFoundation(int i) {
		
		return board.getFoundations().get(i);
	}

	public Card pushCard(Card card, int foundationIndex) {
		return this.getFoundation(foundationIndex).getStackCard().push(card);
	}
 
}
