package es.klodike.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromWasteToFoundationController;
import es.klodike.controllers.StartController;
import es.klondike.model.Board;
import es.klondike.model.Card;
import es.klondike.model.Foundation;
import es.klondike.model.Suite;
import es.klondike.utils.Constantes;

public class MoveFromWasteToFoundationControllerTest {

	private Board board;
	private MoveFromWasteToFoundationController moveFromWasteToFoundationController;

	@Before
	 public void before(){
		 StartController start = new StartController();
		 start.start();
		 this.moveFromWasteToFoundationController= new  MoveFromWasteToFoundationController(start.getBoard());
		 this.board= moveFromWasteToFoundationController.getBoard();
	 }
   
	@Test
	public void MoveFromWasteToFoundationEmptyControllerTest(){
		int foundationIndex=0;
		for(Suite suite: Suite.values()){
			Card card = board.getWaste().push(new Card(suite, 1, Constantes.UNCOVERED_CARD));
			Foundation targetFoundation = board.getFoundation(foundationIndex);
			assertEquals(new Integer(0),targetFoundation.size());
			assertNull(targetFoundation.getSuite());
			moveFromWasteToFoundationController.moveCardFromWasteToFoundation(card, foundationIndex);
			assertEquals(suite, targetFoundation.getSuite());
			assertEquals(card,targetFoundation.getTopCard());
			assertTrue(targetFoundation.size()==1);
			foundationIndex++;
		}   
			
	}
	@Test
	public void MoveFromWasteToFoundationNotEmptyControllerTest(){
		 int targetFoundationIndex= 0;
		 Card card;
		 Card cardNew;
		 Foundation targetFoundation = null;
		 int ordinal;
		 for(Suite suite: Suite.values()){
			 ordinal=Constantes.ORDINAL_MINIMUN_CARD;
			 cardNew = board.getWaste().push(new Card(suite, ordinal, Constantes.UNCOVERED_CARD));
			 assertFalse(board.isEmptyWaste());
			 moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
			 targetFoundation =board.getFoundation(targetFoundationIndex);
			do{
			   	ordinal++;
			   	card=moveFromWasteToFoundationController.getTopCardFoundation(targetFoundation);
			   	cardNew = board.getWaste().push(new Card(suite, ordinal, Constantes.UNCOVERED_CARD));
			    moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
			    assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber()-1);
			    assertEquals(cardNew,targetFoundation.getStackCard().peek());
			    assertEquals(suite, targetFoundation.getSuite());
				}
			while(ordinal<=Constantes.ORDINAL_MINIMUN_CARD + 2);
			targetFoundationIndex++;
		 }
		 //misma suit ... no consecutivo --> no se debe mover
		targetFoundationIndex=0;
		targetFoundation =board.getFoundation(targetFoundationIndex); 
		card=  moveFromWasteToFoundationController.getTopCardFoundation(targetFoundation);
		cardNew = board.getWaste().push(new Card(Suite.SPADE,6, Constantes.UNCOVERED_CARD));
		assertFalse(board.isEmptyWaste());
		assertNotEquals(card.getNumber()+1, cardNew.getNumber());
		moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
		assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber());
		assertEquals(card, targetFoundation.getStackCard().peek());
		assertEquals(Suite.SPADE, targetFoundation.getSuite());
		
		
		targetFoundationIndex=1;
		targetFoundation = board.getFoundation(targetFoundationIndex); 
		card=  moveFromWasteToFoundationController.getTopCardFoundation(targetFoundation);
		cardNew = board.getWaste().push(new Card(Suite.CLUB,6, Constantes.UNCOVERED_CARD));
		assertFalse(board.isEmptyWaste());
		assertNotEquals(card.getNumber()+1, cardNew.getNumber());
		moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
		assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber());
		assertEquals(card, targetFoundation.getStackCard().peek());
		assertEquals(Suite.CLUB, targetFoundation.getSuite());
		
		
		targetFoundationIndex=0;
		targetFoundation = board.getFoundation(targetFoundationIndex); 
		card=   moveFromWasteToFoundationController.getTopCardFoundation(targetFoundation);
		cardNew = board.getWaste().push(new Card(Suite.HEART,5, Constantes.UNCOVERED_CARD));
		assertFalse(board.isEmptyWaste());
		assertNotEquals(Suite.HEART, targetFoundation.getSuite());
		moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew,targetFoundationIndex);
		assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber());
		
		targetFoundationIndex=1;
		targetFoundation = board.getFoundation(targetFoundationIndex); 
		card=   moveFromWasteToFoundationController.getTopCardFoundation(targetFoundation);
		cardNew = board.getWaste().push(new Card(Suite.HEART,5, Constantes.UNCOVERED_CARD));
		assertFalse(board.isEmptyWaste());
		assertNotEquals(Suite.HEART, targetFoundation.getSuite());
		moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew,targetFoundationIndex);
		assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber());
		
	}
}
