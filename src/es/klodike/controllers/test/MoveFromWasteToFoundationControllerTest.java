package es.klodike.controllers.test;

import static org.junit.Assert.*;

import java.util.Stack;

import javax.management.remote.TargetedNotification;

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
		int foundationIndex=0;
		for(Suite suite: Suite.values()){
			Card card = board.getWaste().push(new Card(suite, 1, Constantes.UNCOVERED_CARD));
			Foundation targetFoundation = this.board.getFoundations().get(foundationIndex);
			assertEquals(0,targetFoundation.getStackCard().size());
			moveFromWasteToFoundationController.moveCardFromWasteToFoundation(card, foundationIndex);
			assertEquals(suite, targetFoundation.getSuite());
			assertEquals(card,targetFoundation.getStackCard().peek());
			assertTrue(targetFoundation.getStackCard().size()==1);
			foundationIndex++;
		}   
			
	}
	@Test
	public void MoveFromWasteToFoundationControllerTest(){
		 int targetFoundationIndex= 0;
		 Card card;
		 Card cardNew;
		 Foundation targetFoundation = null;
		 int ordinal;
		 for(Suite suite: Suite.values()){
			 ordinal=Constantes.ORDINAL_MINIMUN_CARD;
			 cardNew = board.getWaste().push(new Card(suite, ordinal, Constantes.UNCOVERED_CARD));
			 moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
			 targetFoundation = this.board.getFoundations().get(targetFoundationIndex);
			do{
			   	ordinal++;
			   	card=board.getFoundations().get(targetFoundationIndex).getStackCard().peek();
			   	cardNew = board.getWaste().push(new Card(suite, ordinal, Constantes.UNCOVERED_CARD));
			    moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
			    assertTrue(card.getNumber()==board.getFoundations().get(targetFoundationIndex).getStackCard().peek().getNumber()-1);
			    assertEquals(cardNew,targetFoundation.getStackCard().peek());
			    assertEquals(suite, targetFoundation.getSuite());
				}
			while(ordinal<=Constantes.ORDINAL_MINIMUN_CARD + 2);
			targetFoundationIndex++;
		 }
		 //misma suit ... no consecutivo --> no se debe mover
		targetFoundationIndex=0;
		targetFoundation = moveFromWasteToFoundationController.getFoundation(targetFoundationIndex); 
		card=  targetFoundation.getStackCard().peek();
		cardNew = board.getWaste().push(new Card(Suite.SPADE,6, Constantes.UNCOVERED_CARD));
		assertNotEquals(card.getNumber()+1, cardNew.getNumber());
		moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew, targetFoundationIndex);
		assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber());
		assertEquals(card, targetFoundation.getStackCard().peek());
		assertEquals(Suite.SPADE, targetFoundation.getSuite());
		
		//consucutivo pero diferente Suit-> no se debe mover
		targetFoundationIndex=0;
		targetFoundation = moveFromWasteToFoundationController.getFoundation(targetFoundationIndex); 
		card=  targetFoundation.getStackCard().peek();
		cardNew = board.getWaste().push(new Card(Suite.HEART,5, Constantes.UNCOVERED_CARD));
		assertNotEquals(Suite.HEART, targetFoundation.getSuite());
		moveFromWasteToFoundationController.moveCardFromWasteToFoundation(cardNew,targetFoundationIndex);
		assertTrue(card.getNumber()==targetFoundation.getStackCard().peek().getNumber());
		assertEquals(card, targetFoundation.getStackCard().peek());
		
	}
}
