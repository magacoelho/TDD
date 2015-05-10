package es.klodike.controllers;


import java.util.Random;
import java.util.Stack;

import es.klondike.model.Card;
import es.klondike.model.Board;
import es.klondike.model.Colour;
import es.klondike.model.Foundation;
import es.klondike.model.Suite;
import es.klondike.utils.Constantes;


public class StartController  extends KlondikeController{
	public StartController() {
		super(new Board());
		
	}
	    public void start(){
	    	this.initDeck();
	        this.initTableaus();
	    	
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
		
		public void initDeck() {
			for(int i=0; i<Constantes.NUMBER_CARDS_DECK_INITIAL;i++){
				Card card=this.getRandomCard();
				this.getBoard().getDeck().push(card);
			}
			}
		

		private Card getRandomCard() {
			Random r = new Random();
			int ordinalFulDeck=0;
			if(this.getBoard().getFullDeckNotRepartida().size()>1)
				ordinalFulDeck= r.nextInt(this.getBoard().getFullDeckNotRepartida().size()-1);
			Card card= this.getBoard().getFullDeckNotRepartida().get(ordinalFulDeck);
			this.getBoard().getFullDeckNotRepartida().remove(ordinalFulDeck);
			return card;
		}

		public void initFoundations(){
			
				for(int i=0; i<Constantes.NUMBER_FOUNDATIONS;i++){
					this.getBoard().getFoundation(i).getStackCard().clear();
				
			}
			
		}
				
		public void initTableaus(){
		for(int i=0;i<Constantes.NUMBER_TABLEAUS;i++  ){
				Stack<Card> stackCard= this.getBoard().getTableaus().get(i);
				for(int j=0;j<i;j++){
					Card card= this.getRandomCard();
					card.setCovered(Constantes.COVERED_CARD);
					stackCard.push(card);
				}
				Card card = this.getRandomCard();
				card.setCovered(Constantes.UNCOVERED_CARD);
				stackCard.push(card);
				this.getBoard().getTableaus().set(i, stackCard);	
		 }
		}
	

}
