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
    
    @Test
    public void getSizeFourColoursTest(){
    	ArrayList<Integer> sizeFourColours = startController.getSizeFourColurs();
    	// hay 7 ...
    	assertEquals(7, sizeFourColours.size());
    	
    	Integer numberCardsForFourColours= new Integer(0);
    	for(int sizeFourColor: sizeFourColours){
    		numberCardsForFourColours+=sizeFourColor;
    	}
    	assertEquals(new Integer(28), numberCardsForFourColours);
    	
    	
    	  
    	//OJO... no repetidas..
    	//OJO en orden aleatorio
    }
    
    @Test
    public void getAllFourColorTest(){
    	ArrayList<Integer> sizeFourColours = startController.getSizeFourColurs();
    	// el tamaño va aumentando.
    	int numberSizeFourColor=0;
     	for(int sizeFourColor: sizeFourColours){
    		assertEquals(numberSizeFourColor+1, sizeFourColor);
    		numberSizeFourColor++;
        }
    	
     	
//    	//el de la cima de la pila está destapado (total-1)!=0 están tapados
     
    	for(int sizeFourColor: sizeFourColours){
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
    	
    }    
    
     @Test
     private void verifyNotRepetedCardsTest(){
    	 
    	 
     }
     @Test
     private void getSizeBaraja(){
    	 assertTrue(52, startController.getSizeBaraja());
    	 
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
