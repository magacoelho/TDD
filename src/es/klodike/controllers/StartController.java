package es.klodike.controllers;

import java.util.Stack;

import es.klondike.model.Card;
import es.klondike.model.Board;

public class StartController  extends KlondikeController{
	public StartController() {
		super(new Board());
		
	}
	    public void start(){
	    	this.getBoard().init();	
	    }
	    
	    
	    
	    
		public boolean verifyNotRepetedCards() {
		boolean noRepetidas= true;
	    for (Card card : this.getBoard().getFullDeck()) {
			if( this.getBoard().getFullDeck().lastIndexOf(card)!= this.getBoard().getFullDeck().indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	    for (Stack<Card> stack :this.getBoard().getTableaus()) {
			for (Card card : stack) {
				 for (Stack<Card> stack2 : this.getBoard().getTableaus()){
					 if(stack2.lastIndexOf(card)!=stack2.indexOf(card)){
						 noRepetidas=false;
						 break;
					 }
				 }
			}
		}
	    for (Card card : this.getBoard().getWaste())  {
	    	if(this.getBoard().getWaste().lastIndexOf(card)!=this.getBoard().getWaste().indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	   return noRepetidas;
	}
}
