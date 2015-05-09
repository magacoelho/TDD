package es.klodike.controllers;

import java.util.Stack;

import es.klondike.model.Board;
import es.klondike.model.Card;

public class MoveFromWasteToTableauController  extends KlondikeController{

	public MoveFromWasteToTableauController(Board board) {
		super(board);
	}

	public void move(int tableauTargetIndex) {
		Card cardTopWaste =this.getBoard().getWaste().peek();
		Stack<Card> tableauTarget =   this.getBoard().getTableaus().get(tableauTargetIndex);
	    tableauTarget.push(cardTopWaste);
	    this.getBoard().getWaste().pop();
		
	}

	
	



}
