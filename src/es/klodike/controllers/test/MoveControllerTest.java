package es.klodike.controllers.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.MoveController;
import es.klondike.model.Card;
import es.klondike.model.Deck;
import es.klondike.model.Waste;


public class MoveControllerTest {
   private MoveController moveController;
	 @Before
	 public void before(){
		 moveController= new MoveController();
	 }
	//@Test
	public void moveFromDeckToWasteTest() {
		// Card card = new Card(0, 3);
		 Waste waste = new Waste(new ArrayList<Card>());
		 Deck deck = new Deck(new ArrayList<Card>());
	     
		// assertTrue(moveController.moveFromDeckToWaste());
		 
		
		
	}

}
