package es.klodike.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		 this.board.init();
	}
	
	@Test 
	public void moveFromWasteToEmptyTableau(){
		assertFalse(moveFormWasteToTableauController.isEmptyWaste());
		
	}

}
