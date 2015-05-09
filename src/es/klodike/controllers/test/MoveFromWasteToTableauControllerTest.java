package es.klodike.controllers.test;

import org.junit.Before;

import es.klodike.controllers.KlondikeController;
import es.klodike.controllers.MoveFromWasteToTableauController;
import es.klondike.model.Board;



public class MoveFromWasteToTableauControllerTest {
	private MoveFromWasteToTableauController moveFormWasteToTableauController;
	private Board board;


	@Before
	public void before(){
		 moveFormWasteToTableauController = new MoveFromWasteToTableauController(new Board()); 
		 this.board = moveFormWasteToTableauController.getBoard();
		 
		 
		
	}

}
