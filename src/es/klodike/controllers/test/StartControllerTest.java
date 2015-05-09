package es.klodike.controllers.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import es.klodike.controllers.StartController;
import es.klondike.model.Card;
import es.klondike.utils.Constantes;


public class StartControllerTest {
  
	private  StartController startController;
	@Before
	public void before(){
		
		startController = new StartController();
		startController.start();
	}
    @Test
    public void sizeDeckTest(){
     	 assertTrue(Constantes.NUMBER_CARDS_DECK_INITIAL==startController.getBoard().sizeDeck());
     }
    
    @Test 
    public void sizeWasteTest(){
      	assertTrue(Constantes.NUMBER_CARDS_INITIAL_WASTE==startController.getBoard().sizeWaste());
    }
    
    @Test 
    public void getSizeFoundationsTest(){
    	int numberFoundations = startController.getBoard().getNumberFoundations();
    	assertEquals(Constantes.NUMBER_FOUNDATIONS, numberFoundations);
    	ArrayList<Integer> sizeFoundations= startController.getBoard().getSizeFoundations();
    	for (Integer sizeFoundation : sizeFoundations) {
			assertEquals(new Integer(Constantes.NUMBER_CARDS_INITIAL_FOUNDATIONS), sizeFoundation);
		}
     }
    
    @Test
    public void getSizeFourColoursTest(){
    	ArrayList<Integer> sizeFourColours = startController.getBoard().getSizeTableaus();
    	assertEquals(Constantes.NUMBER_TABLEAUS, sizeFourColours.size());
    	Integer numberCardsForFourColours= new Integer(0);
    	for(int sizeFourColor: sizeFourColours){
    		numberCardsForFourColours+=sizeFourColor;
    	}
    	assertEquals(new Integer(Constantes.NUMBER_TOTAL_INITIAL_CARDS_FOURCOLOUR), numberCardsForFourColours);
    }
    
    @Test
    public void getAllFourColorTest(){
    	ArrayList<Integer> sizeFourColours = startController.getBoard().getSizeTableaus();
        	int numberSizeFourColor=0;
     	for(int sizeFourColor: sizeFourColours){
    		assertEquals(numberSizeFourColor+1, sizeFourColor);
    		numberSizeFourColor++;
        }
 		ArrayList<Stack<Card>> allFourColors= startController.getBoard().getTableaus();
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
    	 assertEquals(new Integer(Constantes.NUMBER_TOTAL_CARDS), startController.getBoard().getSizeFullDeck());
    	 
     }
     
     @Test
     public void getTableau(){
     	 assertNotNull(startController.getBoard());
     }
    
    
}
