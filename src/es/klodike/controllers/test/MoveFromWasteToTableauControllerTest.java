package es.klodike.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



import es.klodike.controllers.MoveFromWasteToTableauController;
import es.klondike.model.Board;
import es.klondike.model.Card;
import es.klondike.model.Suite;
import es.klondike.utils.Colour;
import es.klondike.utils.Constantes;



public class MoveFromWasteToTableauControllerTest {
	private MoveFromWasteToTableauController moveFromWasteToTableauController;
	private Board board;


	@Before
	public void before(){
		 moveFromWasteToTableauController = new MoveFromWasteToTableauController(new Board()); 
		 this.board = moveFromWasteToTableauController.getBoard();
		 this.board.init();
		
	}
	
	@Test 
	public void moveFromWasteToEmptyTableau(){
	 	int tableauTarget=0;
		board.getTableaus().get(tableauTarget).clear();
		Card cardToMove =new Card(Suite.CLUB, 13, Constantes.UNCOVERED_CARD, Colour.BLACK);
		board.getWaste().push(cardToMove);
		assertFalse(moveFromWasteToTableauController.isEmptyWaste());
		assertEquals(13, board.getWaste().peek().getNumber());
		assertTrue(board.getTableaus().get(tableauTarget).size()==0);
       	moveFromWasteToTableauController.move(tableauTarget);
		assertEquals(cardToMove, this.board.getTableaus().get(tableauTarget).peek());
		assertEquals(1,this.board.getTableaus().get(tableauTarget).size());
		
		tableauTarget=0;
		board.getTableaus().get(tableauTarget).clear();
		cardToMove =new Card(Suite.CLUB, 12, Constantes.UNCOVERED_CARD,Colour.BLACK);
		board.getWaste().push(cardToMove);
		assertFalse(moveFromWasteToTableauController.isEmptyWaste());
		assertNotEquals(13, board.getWaste().peek().getNumber());
		assertTrue(board.getTableaus().get(tableauTarget).size()==0);
       	moveFromWasteToTableauController.move(tableauTarget);
		assertEquals(0,this.board.getTableaus().get(tableauTarget).size());
		}
	
	@Test
	public void moveFromWasteToNotEmptyTableau(){
		this.board.init();
		int tableauTarget=0;
		Card cardToMove =new Card(Suite.HEART, 3, Constantes.UNCOVERED_CARD, Colour.RED);
		Card cardTopTableauTarget = new Card(Suite.SPADE, 2, Constantes.UNCOVERED_CARD, Colour.BLACK);
		board.getWaste().push(cardToMove);
		board.getTableaus().get(tableauTarget).push(cardTopTableauTarget);
		assertFalse(moveFromWasteToTableauController.isEmptyWaste());
		moveFromWasteToTableauController.move(tableauTarget);
		cardTopTableauTarget = this.board.getTableaus().get(tableauTarget).peek();
		assertEquals(cardToMove, cardTopTableauTarget);
		assertEquals(3,this.board.getTableaus().get(tableauTarget).size());
	}
        
}
