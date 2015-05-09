package es.klodike.controllers;

import java.util.Stack;

import es.klondike.model.Board;
import es.klondike.model.Card;

public class MoveFromWasteToTableauController  extends KlondikeController{

	public MoveFromWasteToTableauController(Board board) {
		super(board);
	}

	public void move(int tableauTargetIndex) {
		if(this.getBoard().getWaste().size()>0){
			Stack<Card> tableauTarget =  this.getBoard().getTableaus().get(tableauTargetIndex);
			Card cardTopWaste =this.getBoard().getWaste().peek();
			if((cardTopWaste.getNumber()==13&&tableauTarget.size()==0)
					||
					  (tableauTarget.size()!=0&& 
					   (cardTopWaste.getNumber()==tableauTarget.peek().getNumber() +1)
					    &&cardTopWaste.getColour()!= tableauTarget.peek().getColour())){
				
					 tableauTarget.push(cardTopWaste);
				     this.getBoard().getWaste().pop();
			
			 }
						
			}
		}
	}

