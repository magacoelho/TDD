import java.util.ArrayList;
import java.util.Stack;


public class StartController {

	public int sizeWaste() {
	
		return 0;
	}

	public int sizeDeck() {
		return 24;
	}

	public int getNumberFoundations() {
		return 4;
	}

	

	public ArrayList<Integer> getSizeFoundations() {
		ArrayList<Integer> sizeFoundations= new ArrayList<Integer>();
		sizeFoundations.add(new Integer(0));
		sizeFoundations.add(new Integer(0));
		sizeFoundations.add(new Integer(0));
		sizeFoundations.add(new Integer(0));
		return sizeFoundations;
	}

	public ArrayList<Integer> getSizeFourColurs() {
		ArrayList<Integer> sizeFourColours= new ArrayList<Integer>();
		for(int i=0;i<7;i++){
			sizeFourColours.add(i+1);
		}
		return sizeFourColours;
	}

	public ArrayList<Card> getCardsByFourColor(int i) {
		ArrayList<Card> cardsByFourColor = new ArrayList<Card>();
		// generar las cards...
		// rellenar el array---
		//regresarlo
		for(int j=0; j< i;j++){
			
		}
		
		return cardsByFourColor;
	}

	public Tableau getTableau() {
		
		return new Tableau();
	}

	public Player getPlayer() {
		
		return new Player();
	}

	public ArrayList<Stack<Card>> getAllFourColor() {
		    
		 ArrayList<Stack<Card>> allFourColor = new  ArrayList<Stack<Card>>();
		 
		 for(int i=0;i<7;i++  ){
			Stack<Card> stackCard= new Stack<Card>();
			for(int j=0;j<i;j++){
				Card card= new Card(j, j);//ojo aleatoria... y no repetidas.
				card.setCovered(false);
				stackCard.push(card);
				}
			
			stackCard.push(new Card(1,1));
		 }
		
		return allFourColor;
	}

}
