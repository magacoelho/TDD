package es.klodike.controllers;
import java.util.ArrayList;
import java.util.Stack;

import es.klodike.controllers.test.Foundation;
import es.klondike.model.Card;
import es.klondike.model.Board;

public class StartController {
	private Board board;
	
	public StartController() {
		super();
		this.board= new Board();
		this.board.init();
	}
	
	public int sizeWaste() {
		
		return this.board.getWaste().size();
	}
	
	public int sizeDeck() {
		return this.board.getDeck().size();
	}
	
	public int getNumberFoundations() {
		return this.board.getFoundations().size();
	}
	
	public ArrayList<Integer> getSizeFoundations() {
		ArrayList<Integer> sizeFoundations= new ArrayList<Integer>();
		for (Foundation fundation :  this.board.getFoundations()) {
			sizeFoundations.add(fundation.size());
		}
		return sizeFoundations;
	}
	
	public ArrayList<Integer> getSizeFourColurs() {
		ArrayList<Integer> sizeFourColours= new ArrayList<Integer>();

		for (Stack<Card> fourColour :this.board.getAllFourColor()) {
		  	
		  sizeFourColours.add(fourColour.size());
		}
		return sizeFourColours;
	}
	
	public Board getBoard() {
		return this.board;
	}

	public ArrayList<Stack<Card>> getAllFourColor() {
		return this.board.getAllFourColor();
	}

	public Integer getSizeFullDeck() {
		return this.board.getFullDeck().size();
	}

	public boolean verifyNotRepetedCards() {
		boolean noRepetidas= true;
	    for (Card card : this.board.getFullDeck()) {
			if( this.board.getFullDeck().lastIndexOf(card)!= this.board.getFullDeck().indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	    for (Stack<Card> stack :this.board.getAllFourColor()) {
			for (Card card : stack) {
				 for (Stack<Card> stack2 : this.board.getAllFourColor()){
					 if(stack2.lastIndexOf(card)!=stack2.indexOf(card)){
						 noRepetidas=false;
						 break;
					 }
				 }
			}
		}
	    for (Card card : this.board.getWaste())  {
	    	if(this.board.getWaste().lastIndexOf(card)!=this.board.getWaste().indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	   return noRepetidas;
	}
}
