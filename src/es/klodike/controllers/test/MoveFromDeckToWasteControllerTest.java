package es.klodike.controllers.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klondike.model.Card;
import es.klondike.model.Tableau;



public class MoveFromDeckToWasteControllerTest {
   private MoveFromDeckToWasteController moveFromDeckToWasteController;
   private Tableau tableau;
   
	 @Before
	 public void before(){
		 moveFromDeckToWasteController= new MoveFromDeckToWasteController();
		 tableau = new Tableau();
	 }
	@Test
	public void moveFromDeckToWasteTest() {
	      // si está vacia.... el deck tendrá todo el waste entero pero volteadas
		   int sizeDeck =tableau.getDeck().size();
		   int sizeWaste =tableau.getWaste().size();
		   Card card = tableau.getDeck().peek();
		   if(sizeDeck>= 1){
		  // si hay cartas suficientes
			    moveFromDeckToWasteController.moveFromDeckToWaste();
			    assertEquals(sizeDeck-1, tableau.getDeck().size());
			    assertEquals(sizeWaste+1, tableau.getWaste().size());
			    assertFalse(card.isCovered()==tableau.getWaste().peek().isCovered());
			// comprobara que deck tiene menos 1 cartas
		    // comprobar que waste tiene mas 1 cartas. (y q cambió  de cubiertas=true a cubiertas=false
		   }
		   else{
		     //comprobar que deck tiene el mismo nuemro de cartas
		     //comprobar que waste tiene el mismo numero de cartas
		   }
	
	
	}

}
