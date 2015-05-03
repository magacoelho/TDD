package es.klondike.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import es.klondike.utils.Constantes;


public class Tableau {

	private ArrayList<Stack<Card>> allFourColor;
	private ArrayList<Stack<Card>> foundations;
	private Stack<Card> deck;
	private Stack<Card> waste;
	private List<Card> fullDeck;
	private List<Card> fullDeckNotRepartida;

	
	public Tableau() {
		super();
		this.allFourColor= new  ArrayList<Stack<Card>>();
		this.foundations= new ArrayList<Stack<Card>>();
		this.deck= new Stack<Card>();
		this.waste= new Stack<Card>();
		this.fullDeck= new ArrayList<Card>();
		this.fullDeckNotRepartida= new ArrayList<Card>();

		
	
	}
	public ArrayList<Stack<Card>> getAllFourColor() {
		return allFourColor;
	}
	public void setAllFourColor(ArrayList<Stack<Card>> allFourColor) {
		this.allFourColor = allFourColor;
	}
	public ArrayList<Stack<Card>> getFoundations() {
		return foundations;
	}
	public void setFoundations(ArrayList<Stack<Card>> foundations) {
		this.foundations = foundations;
	}
	public Stack<Card> getDeck() {
		return deck;
	}
	public void setDeck(Stack<Card> deck) {
		this.deck = deck;
	}
	public Stack<Card> getWaste() {
		return waste;
	}
	public void setWaste(Stack<Card> waste) {
		this.waste = waste;
	}
	public List<Card> getFullDeck() {
		return fullDeck;
	}
	public void setFullDeck(List<Card> fullDeck) {
		this.fullDeck = fullDeck;
	}
	public List<Card> getFullDeckNotRepartida() {
		return fullDeckNotRepartida;
	}
	public void setFullDeckNotRepartida(List<Card> fullDeckNotRepartida) {
		this.fullDeckNotRepartida = fullDeckNotRepartida;
	}


   // metodos neescraios ara crear un tablero
	

	public void init(){
		this.initFullDeck();
		this.initFoundations();
		this.initAllFourColours();
		this.initDeck();
		
	}
	public void initDeck() {
		for(int i=0; i<Constantes.NUMBER_CARDS_DECK_INITIAL;i++){
			Card card=this.getRandomCard();
			this.deck.push(card);
		}
		}

	private Card getRandomCard() {
		Random r = new Random();
		int ordinalFulDeck=0;
		if(this.fullDeckNotRepartida.size()>1) r.nextInt(this.fullDeckNotRepartida.size()-1);
		Card card= this.fullDeckNotRepartida.get(ordinalFulDeck);
		this.fullDeckNotRepartida.remove(ordinalFulDeck);
		return card;
	}

	public void initFoundations(){
			for(int i=0; i<Constantes.NUMBER_FOUNDATIONS;i++){
			this.foundations.add(new Stack<Card>());
		}
		
	}
	public void initFullDeck(){
		Colour[] colours= Colour.values();
	
		for(int i=0;i<Constantes.NUMBER_COLOUR_CARD;i++){
			for(Colour colour:colours){
				Card card = new Card(colour,i+1,Constantes.COVERED_CARD);
				this.fullDeck.add(card);
				fullDeckNotRepartida.add(card);
			}
		}		
	  
	}
	
	public void initAllFourColours(){
	for(int i=0;i<Constantes.NUMBER_ALL_FOURCOLOURS;i++  ){
			Stack<Card> stackCard= new Stack<Card>();
			for(int j=0;j<i;j++){
				Card card= this.getRandomCard();//ojo aleatoria... y no repetidas.
				card.setCovered(Constantes.COVERED_CARD);
				stackCard.push(card);
			}
			Card card = this.getRandomCard();
			card.setCovered(Constantes.UNCOVERED_CARD);
			stackCard.push(card);
			allFourColor.add(stackCard);
		}
	}
	
	 
}
