package es.klodike.controllers.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klondike.model.Tableau;
import es.klondike.utils.Constantes;



public class MoveFromDeckToWasteControllerTest {
   private MoveFromDeckToWasteController moveFromDeckToWasteController;
   private Tableau tableau;
   
	 @Before
	 public void before(){
		 this.tableau = new Tableau();
		 this.tableau.init();
		 this.moveFromDeckToWasteController= new MoveFromDeckToWasteController(this.tableau);
	 }
	@Test
	public void moveFromDeckToWasteTest() {
		
		
		  int preSizeWaste;
	      for(int i=0;i<Constantes.NUMBER_CARDS_DECK_INITIAL;i++){
	    	  int preSizeDeck =tableau.getDeck().size();
	    	  preSizeWaste =tableau.getWaste().size();
		      moveFromDeckToWasteController.moveFromDeckToWaste();
		     
		     if(preSizeDeck >= Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE){
			    int postSizeDeck = preSizeDeck - Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE;
				assertEquals(postSizeDeck, tableau.getDeck().size());
			    int postSizeWaste = preSizeWaste + Constantes.NUMBER_MINIMUM_CARDS_MOVE_DECK_TO_WASTE;
				assertEquals(postSizeWaste, tableau.getWaste().size());
			    assertFalse(tableau.getWaste().peek().isCovered());
		   }
          }
	    	    
	       preSizeWaste =tableau.getWaste().size();
	       moveFromDeckToWasteController.moveFromDeckToWaste();
	       int postSizeDeck=preSizeWaste;
	       assertEquals(postSizeDeck, tableau.getDeck().size());
		   assertEquals(Constantes.NUMBER_EMPTY, tableau.getWaste().size());
		   for(int j=0;j<tableau.getDeck().size();j++)
		       assertTrue(tableau.getDeck().peek().isCovered());
	      }
	      


}
