package es.klodike.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klodike.controllers.MoveFromWasteToFoundationController;
import es.klondike.model.Board;
import es.klondike.model.Card;

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
	public void MoveFromWasteToFoundationControllerTest(){
		Card cardToMove = board.getWaste().peek();
		assertNotNull(card);
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
