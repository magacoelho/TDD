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
	 	int tableauTargetIndex=0;
		board.getTableaus().get(tableauTargetIndex).clear();
		Card cardToMove =new Card(Suite.CLUB, Constantes.ORDINAL_MAXIMUN_CARD, Constantes.UNCOVERED_CARD, Colour.BLACK);
		board.getWaste().push(cardToMove);
		assertTrue(board.getTableau(tableauTargetIndex).size()==0);
       	moveFromWasteToTableauController.move(tableauTargetIndex);
		assertEquals(cardToMove, this.board.getTableaus().get(tableauTargetIndex).peek());
		assertEquals(1,this.board.getTableaus().get(tableauTargetIndex).size());
		
		tableauTargetIndex=0;
		board.getTableau(tableauTargetIndex).clear();
		cardToMove =new Card(Suite.CLUB, 12, Constantes.UNCOVERED_CARD,Colour.BLACK);
		board.getWaste().push(cardToMove);
		assertFalse(moveFromWasteToTableauController.isEmptyWaste());
		assertNotEquals(Constantes.ORDINAL_MAXIMUN_CARD, board.getWaste().peek().getNumber());
		assertTrue(board.getTableau(tableauTargetIndex).size()==0);
       	moveFromWasteToTableauController.move(tableauTargetIndex);
		assertEquals(0,this.board.getTableau(tableauTargetIndex).size());
		}
	
	@Test
	public void moveFromWasteToNotEmptyTableau(){
		this.board.init();
		int tableauTargetIndex=0;
		Card cardToMove =new Card(Suite.HEART, 3, Constantes.UNCOVERED_CARD, Colour.RED);
		Card cardTopTableauTarget = new Card(Suite.SPADE, 2, Constantes.UNCOVERED_CARD, Colour.BLACK);
		board.getWaste().push(cardToMove);
		board.getTableaus().get(tableauTargetIndex).push(cardTopTableauTarget);
		assertFalse(moveFromWasteToTableauController.isEmptyWaste());
		Card cardTopTableauTargetOld = this.board.getTableau(tableauTargetIndex).peek();
		moveFromWasteToTableauController.move(tableauTargetIndex);
		Card cardTopTableauTargetNew = this.board.getTableau(tableauTargetIndex).peek();
		assertEquals(cardToMove, cardTopTableauTargetNew);
		assertTrue(cardTopTableauTargetNew.isConsecutiveNumber(cardTopTableauTargetOld));
		assertEquals(3,this.board.getTableaus().get(tableauTargetIndex).size());
	}
        
}
