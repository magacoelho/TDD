package es.klodike.controllers.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klondike.model.Card;
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
		
	      for(int i=0;i<Constantes.NUMBER_CARDS_DECK_INITIAL;i++){
	    	  int sizeDeck =tableau.getDeck().size();
		      int sizeWaste =tableau.getWaste().size();
	
		      moveFromDeckToWasteController.moveFromDeckToWaste();
		     if(sizeDeck>= 1){
		     	// si hay cartas suficientes
			    assertEquals(sizeDeck-1, tableau.getDeck().size());
			    assertEquals(sizeWaste+1, tableau.getWaste().size());
			    assertFalse(tableau.getWaste().peek().isCovered());
			// comprobara que deck tiene menos 1 cartas
		    // comprobar que waste tiene mas 1 cartas. (y q cambió  de cubiertas=true a cubiertas=false
		   }
          }
	 
	      // verificar que en el Deck están las cartas del Waste
	      int sizeDeck =tableau.getDeck().size();
	      int sizeWaste =tableau.getWaste().size();
	       moveFromDeckToWasteController.moveFromDeckToWaste();
	       assertEquals(sizeWaste, tableau.getDeck().size());
		   assertEquals(0, tableau.getWaste().size());
		   for(int j=0;j<tableau.getDeck().size();j++)
		       assertTrue(tableau.getDeck().peek().isCovered());
		     //comprobar que deck tiene el mismo nuemro de cartas
		     //comprobar que waste tiene el mismo numero de cartas
		  
	      }
	      


}
