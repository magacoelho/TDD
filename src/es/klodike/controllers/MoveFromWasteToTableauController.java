package es.klodike.controllers;

import java.util.Stack;

import es.klondike.model.Board;
import es.klondike.model.Card;
import es.klondike.utils.Constantes;

public class MoveFromWasteToTableauController  extends KlondikeController{

	public MoveFromWasteToTableauController(Board board) {
		super(board);
	}

	public void move(int tableauTargetIndex) {
		if(this.getBoard().getWaste().size()>0){
			Stack<Card> tableauTarget =  this.getBoard().getTableau(tableauTargetIndex);
			Card cardTopWaste =this.getBoard().getWaste().peek();
			if(isValidMoveFromTableau(tableauTarget, cardTopWaste)){
					 tableauTarget.push(cardTopWaste);
				     this.getBoard().getWaste().pop();
			 }
			}
		}
	
	private boolean isValidMoveFromTableau(Stack<Card> tableauTarget,Card cardTopWaste)
	{
		return isValidMoveForEmptyTableau(tableauTarget, cardTopWaste)
				||isValidMoveFromNotEmptyTableau(tableauTarget,cardTopWaste);
	}

	private boolean isValidMoveFromNotEmptyTableau(Stack<Card> tableauTarget,
			Card cardTopWaste) {
		return tableauTarget.size()!=0&& 
		   (cardTopWaste.isConsecutiveNumber(tableauTarget.peek()))
		    &&cardTopWaste.getColour()!= tableauTarget.peek().getColour();
	}

	private boolean isValidMoveForEmptyTableau(Stack<Card> tableauTarget,
			Card cardTopWaste) {
		return cardTopWaste.getNumber()==Constantes.ORDINAL_MAXIMUN_CARD
				&&tableauTarget.size()==0;
	}

	
	}

