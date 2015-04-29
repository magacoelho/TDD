import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class StartController {

	private static final int NUMBER_ALL_FOURCOLOURS = 7;
	private static final int NUMBER_FOUNDATIONS = 4;
	private static final int NUMBER_COLOUR_CARD = 13;
	private static final int NUMBER_CARDS_DECK_INITIAL = 24;
	private ArrayList<Stack<Card>> allFourColor;
	private ArrayList<Stack<Card>> foundations;
	private Stack<Card> deck;
	private Stack<Card> waste;
	private List<Card> fullDeck;
	private List<Card> fullDeckNotRepartida;
	
	private void init(){
		this.initFullDeck();
		this.initFoundations();
		this.initAllFourColours();
		this.initDeck();
		
	}
	
	public void initDeck() {
		for(int i=0; i<NUMBER_CARDS_DECK_INITIAL;i++){
			Card card=this.getRandomCard();
			this.deck.push(card);
		}
	}

	private Card getRandomCard() {
		Random r = new Random();
		int ordinalFulDeck=0;
		if(fullDeckNotRepartida.size()>1) r.nextInt(fullDeckNotRepartida.size()-1);
		Card card= fullDeckNotRepartida.get(ordinalFulDeck);
		fullDeckNotRepartida.remove(ordinalFulDeck);
		return card;
	}

	public void initFoundations(){
			for(int i=0; i<NUMBER_FOUNDATIONS;i++){
			this.foundations.add(new Stack<Card>());
		}
		
	}
	public void initFullDeck(){
		Colour[] colours= Colour.values();
	
		for(int i=0;i<NUMBER_COLOUR_CARD;i++){
			for(Colour colour:colours){
				Card card = new Card(colour,i+1,true);
				fullDeck.add(card);
				fullDeckNotRepartida.add(card);
			}
		}		
	 
	}
	
	public void initAllFourColours(){
	for(int i=0;i<NUMBER_ALL_FOURCOLOURS;i++  ){
			Stack<Card> stackCard= new Stack<Card>();
			for(int j=0;j<i;j++){
				Card card= this.getRandomCard();//ojo aleatoria... y no repetidas.
				card.setCovered(true);
				stackCard.push(card);
			}
			Card card = this.getRandomCard();
			card.setCovered(false);
			stackCard.push(card);
			allFourColor.add(stackCard);
		}
	}
	
	public StartController() {
		super();
		this.allFourColor= new  ArrayList<Stack<Card>>();
		this.foundations= new ArrayList<Stack<Card>>();
		this.deck= new Stack<Card>();
		this.waste= new Stack<Card>();
		this.fullDeck= new ArrayList<Card>();
		this.fullDeckNotRepartida= new ArrayList<Card>();
		this.init();
	}

	public int sizeWaste() {
		return this.waste.size();
	}

	public int sizeDeck() {
		return deck.size();
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

		for (Stack<Card> fourColour :this.allFourColor) {
		  	
		  sizeFourColours.add(fourColour.size());
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
		return fullDeck.size();
	}

	public boolean verifyNotRepetedCards() {
		boolean noRepetidas= true;
	    for (Card card : fullDeck) {
			if(fullDeck.lastIndexOf(card)!=fullDeck.indexOf(card)){
				noRepetidas=false;
				break;
			}
		}
	   return noRepetidas;
	}

}
