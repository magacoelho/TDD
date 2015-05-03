package es.klodike.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klodike.controllers.MoveFromWasteToFoundationController;
import es.klondike.model.Board;

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
		//precondicion: Carta a mover la cima del waste.
		//se debe saber hacia donde se quiere mover.
		//Si la carta a mover es un as... debe haber un foundatoons vacio...
		    //-> waste.size
		
	}
}
