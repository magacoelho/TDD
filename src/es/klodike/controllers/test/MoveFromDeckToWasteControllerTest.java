package es.klodike.controllers.test;
import org.junit.Before;
import org.junit.Test;
import es.klodike.controllers.MoveFromDeckToWasteController;
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
	
		  // si hay cartas suficientes
			// comprobara que deck tiene menos 1 cartas
		    // comprobar que waste tiene mas 1 cartas. (y q cambió  de cubiertas=true a cubiertas=false
		  // else
		     //comprobar que deck tiene el mismo nuemro de cartas
		     //comprobar que waste tiene el mismo numero de cartas
	
	
	}

}
