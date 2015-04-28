import java.util.ArrayList;
import java.util.Stack;


public class StartController {

	private ArrayList<Stack<Card>> allFourColor;
	private ArrayList<Stack<Card>> foundations;
	private ArrayList<Stack<Card>> deck;
	
	private void init(){
		this.initFoundations();
		this.initAllFourColours();
		
	}
	
	public void initFoundations(){
		//foundations vacios
		for(int i=0; i<4;i++){
			this.foundations.add(new Stack<Card>());
		}
		
	}
	
	public void initAllFourColours(){
		for(int i=0;i<7;i++  ){
			Stack<Card> stackCard= new Stack<Card>();
			for(int j=0;j<i;j++){
				Card card= new Card(new Colour(), j,true);//ojo aleatoria... y no repetidas.
				card.setCovered(true);
				stackCard.push(card);
			}
			
			stackCard.push(new Card(new Colour(),1,false));
		}
		
		
	}
	
	public StartController() {
		super();
		this.allFourColor= new  ArrayList<Stack<Card>>();
		this.foundations= new ArrayList<Stack<Card>>();
		this.init();
	}

	public int sizeWaste() {
		return 0;
	}

	public int sizeDeck() {
		return 24;
	}

	public int getNumberFoundations() {
		return this.foundations.size();
	}

	public ArrayList<Integer> getSizeFoundations() {
		ArrayList<Integer> sizeFoundations= new ArrayList<Integer>();
		for (Stack<Card> fundation : this.foundations) {
			sizeFoundations.add(fundation.size());
		}
		return sizeFoundations;
	}

	public ArrayList<Integer> getSizeFourColurs() {
		ArrayList<Integer> sizeFourColours= new ArrayList<Integer>();
		for(int i=0;i<7;i++){
			sizeFourColours.add(i+1);
		}
		return sizeFourColours;
	}

	public Tableau getTableau() {
		
		return new Tableau();
	}

	
	public Player getPlayer() {
		return new Player();
	}

	public ArrayList<Stack<Card>> getAllFourColor() {
		return allFourColor;
	}

	public Integer getSizeFullDeck() {
		return 52;
	}

	public boolean verifyNotRepetedCards() {
		return true;
	}

}
