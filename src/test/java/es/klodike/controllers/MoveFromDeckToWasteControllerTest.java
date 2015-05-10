package es.klodike.controllers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klodike.controllers.StartController;
import es.klondike.model.Board;
import es.klondike.utils.Constantes;



public class MoveFromDeckToWasteControllerTest {
   private MoveFromDeckToWasteController moveFromDeckToWasteController;
   private Board board;
   
	 @Before
	 public void before(){
		 StartController start = new StartController();
		 start.start();
		 this.moveFromDeckToWasteController= new MoveFromDeckToWasteController(start.getBoard());
		 this.board= moveFromDeckToWasteController.getBoard();
	 }
	@Test
	public void moveFromDeckToWasteTest() {
		  int preSizeWaste;
	      for(int i=0;i<Constantes.NUMBER_CARDS_DECK_INITIAL;i++){
	    	  int preSizeDeck =board.getDeck().size();
	    	  preSizeWaste =board.getWaste().size();
		      moveFromDeckToWasteController.moveFromDeckToWaste();
	 	     if(preSizeDeck >= Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE){
			    int postSizeDeck = preSizeDeck - Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE;
				assertEquals(postSizeDeck, board.getDeck().size());
			    int postSizeWaste = preSizeWaste + Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE;
				assertEquals(postSizeWaste, board.getWaste().size());
			    assertFalse(board.getWaste().peek().isCovered());
		     }
          }
	    	    
	       preSizeWaste =board.getWaste().size();
	       moveFromDeckToWasteController.moveFromDeckToWaste();
	       int postSizeDeck=preSizeWaste;
	       assertEquals(postSizeDeck, board.getDeck().size());
		   assertEquals(Constantes.NUMBER_EMPTY, board.getWaste().size());
		   for(int j=0;j<board.getDeck().size();j++)
		       assertTrue(board.getDeck().peek().isCovered());
	   }
}
