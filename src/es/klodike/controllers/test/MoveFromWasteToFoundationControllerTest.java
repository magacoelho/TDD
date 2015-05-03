package es.klodike.controllers.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveFromDeckToWasteController;
import es.klodike.controllers.MoveFromWasteToFoundationController;
import es.klondike.model.Tableau;

public class MoveFromWasteToFoundationControllerTest {

	 private Tableau tableau;
	private MoveFromWasteToFoundationController moveFromWasteToFoundationController;

	@Before
	 public void before(){
		 this.tableau = new Tableau();
		 this.tableau.init();
		 this.moveFromWasteToFoundationController= new  MoveFromWasteToFoundationController(this.tableau);
	 }
   
	@Test
	public void MoveFromWasteToFoundationControllerTest(){
		//precondicion: Crata a mover la cima del waste.
		//se debe saber hacia donde se quiere mover.
		//Si la carta a mover es un as... debe haber un foundatoons vacio...
		    //-> waste.size
		
	}
}
