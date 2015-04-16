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
	public void test() {
	  	fail("Not yet implemented");
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
    public void getFoundationsTest(){
    	int numberFoundations = startController.getNumberFoundations();
    	assertEquals(4, numberFoundations);
    	
    	ArrayList<Card> foundations= startController.getFoundations();
    	
    	
    }
}
