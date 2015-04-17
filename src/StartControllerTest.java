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
     	int ordinalFourColor=0;
    	for(int sizeFourColor: sizeFourColours){
    		ArrayList<Card> cardsByFourColor= startController.getCardsByFourColor(ordinalFourColor);
    		assertTrue(cardsByFourColor.size()>0);
    		int sizeByFourColor =cardsByFourColor.size();
    		for(int j=0;j<sizeByFourColor;j++){  
    		  	if(j==sizeByFourColor-1){
    		  		assertTrue(cardsByFourColor.get(j).isUncovered());
    		  	}
    		  	assertTrue(cardsByFourColor.get(j).isCovered());
    	  	}
    		ordinalFourColor++;
    	}
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
