import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class MoveControllerTest {
   private MoveController moveController;
	 @Before
	 public void before(){
		 moveController= new MoveController();
	 }
	@Test
	public void moveFromDeckToWasteTest() {
		 Card card = new Card(0, 3);
		 Waste waste = new Waste(new ArrayList<Card>());
		 Deck deck = new Deck();
	     assertTrue(moveController.moveFromDeckToWaste(card,deck, waste));
		
		
	}

}
