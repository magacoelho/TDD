import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

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
     	 assertTrue(Constantes.NUMBER_CARDS_DECK_INITIAL==startController.sizeDeck());
     }
    
    @Test 
    public void sizeWasteTest(){
      	assertTrue(Constantes.NUMBER_CARDS_INITIAL_WASTE==startController.sizeWaste());
    }
    
    @Test 
    public void getSizeFoundationsTest(){
    	int numberFoundations = startController.getNumberFoundations();
    	assertEquals(Constantes.NUMBER_FOUNDATIONS, numberFoundations);
    	ArrayList<Integer> sizeFoundations= startController.getSizeFoundations();
    	for (Integer sizeFoundation : sizeFoundations) {
			assertEquals(new Integer(Constantes.NUMBER_CARDS_INITIAL_FOUNDATIONS), sizeFoundation);
		}
     }
    
    @Test
    public void getSizeFourColoursTest(){
    	ArrayList<Integer> sizeFourColours = startController.getSizeFourColurs();
    	assertEquals(Constantes.NUMBER_ALL_FOURCOLOURS, sizeFourColours.size());
    	Integer numberCardsForFourColours= new Integer(0);
    	for(int sizeFourColor: sizeFourColours){
    		numberCardsForFourColours+=sizeFourColor;
    	}
    	assertEquals(new Integer(Constantes.NUMBER_TOTAL_INITIAL_CARDS_FOURCOLOUR), numberCardsForFourColours);
    }
    
    @Test
    public void getAllFourColorTest(){
    	ArrayList<Integer> sizeFourColours = startController.getSizeFourColurs();
        	int numberSizeFourColor=0;
     	for(int sizeFourColor: sizeFourColours){
    		assertEquals(numberSizeFourColor+1, sizeFourColor);
    		numberSizeFourColor++;
        }
 		ArrayList<Stack<Card>> allFourColors= startController.getAllFourColor();
   		for (Stack<Card> stack : allFourColors) {
				assertFalse(stack.empty());
				assertNotNull(stack.peek());
				assertTrue(!stack.peek().isCovered());
				stack.pop();
				while(!stack.isEmpty()){
					assertTrue(stack.peek().isCovered());
					stack.pop();
				}
			}
    
   }    
     
     @Test
     public void verifyNotRepetedCardsTest(){
    	 assertTrue(startController.verifyNotRepetedCards());
       }
     @Test
     public void getSizeFullDeck(){
    	 assertEquals(new Integer(Constantes.NUMBER_TOTAL_CARDS), startController.getSizeFullDeck());
    	 
     }
     
     @Test
     public void getTableau(){
     	 assertNotNull(startController.getTableau());
     }
    
     @Test
     public void getPlayer(){
    	 assertNotNull(startController.getPlayer());
    	 
     }
}
