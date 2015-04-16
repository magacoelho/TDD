import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class StartControllerTest {
    private  StartController startController;
	@Before
	public void before(){
		
		startController = new StartController();
	}
    
        
    @Test
    public void sizeDeckTest(){
     	 assertTrue(24==startController.sizeDeck());
     }
    
    @Test 
    public void sizeWasteTest(){
      	assertTrue(0==startController.sizeWaste());
    }
    
    @Test 
    public void getSizeFoundationsTest(){
    	int numberFoundations = startController.getNumberFoundations();
    	assertEquals(4, numberFoundations);
    	ArrayList<Integer> sizeFoundations= startController.getSizeFoundations();
    	for (Integer sizeFoundation : sizeFoundations) {
			assertEquals(new Integer(0), sizeFoundation);
		}
     }
    
}
