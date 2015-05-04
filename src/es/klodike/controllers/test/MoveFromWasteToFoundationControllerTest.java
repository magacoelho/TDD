package es.klodike.controllers.test;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klodike.controllers.MoveFromWasteToFoundationController;
import es.klondike.model.Board;
import es.klondike.model.Card;
import es.klondike.model.Suite;
import es.klondike.utils.Constantes;

public class MoveFromWasteToFoundationControllerTest {

	private Board board;
	private MoveFromWasteToFoundationController moveFromWasteToFoundationController;

	@Before
	 public void before(){
		 this.board = new Board();
		 this.board.init();
		 this.moveFromWasteToFoundationController= new  MoveFromWasteToFoundationController(this.board);
	 }
   
	@Test
	public void MoveFromWasteToFoundationEmptyControllerTest(){
		// mover un as cuando está desocupada la Foundation
		for(Suite suite: Suite.values()){
			Card card = board.getWaste().push(new Card(suite, 1, Constantes.UNCOVERED_CARD));
			Foundation foundation = new Foundation(new Stack<Card>(), suite);
		}   
		 
		for(Suite suite: Suite.values()){
			for(Suite suiteFoundation: Suite.values()){
				Card cardToMove= board.getWaste().peek();
				Suite targetSuite= suiteFoundation;
				moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardToMove, targetSuite);
				} 
			   
		}
		  	
		
		//elementos Carta a mover la cima del waste.
		 // El foundation debe corresponder a la misma Suit
		// si la carta a mover es un as...debe settearse el foundation como de este Suit
		// y verificar q se ha agergado
		 // la cima del foundation debe ser un ordinal menor que la carta a mover 
		// y verificar q se ha agregado
		  
		
		//se debe saber hacia donde se quiere mover.
		//Si la carta a mover es un as... debe haber un foundatoons vacio...
		    //-> waste.size
		
	}
}
