package es.klondike.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import es.klondike.utils.Constantes;


public class Board {

	private ArrayList<Stack<Card>> tableaus;
	private ArrayList<Foundation> foundations;
	private Stack<Card> deck;
	private Stack<Card> waste;
	private List<Card> fullDeck;
	private List<Card> fullDeckNotRepartida;

	public Board() {
		super();
		this.tableaus= new  ArrayList<Stack<Card>>();
		this.foundations= new ArrayList<Foundation>();
		this.deck= new Stack<Card>();
		this.waste= new Stack<Card>();
		this.fullDeck= new ArrayList<Card>();
		this.fullDeckNotRepartida= new ArrayList<Card>();
        this.init();
	}

// getters adn setters
	public int sizeWaste() {	
		return this.getWaste().size();
	}
	
	public int sizeDeck() {
		return this.getDeck().size();
	}
	
	public int getNumberFoundations() {
		return this.getFoundations().size();
	}
	
	public ArrayList<Integer> getSizeFoundations() {
		ArrayList<Integer> sizeFoundations= new ArrayList<Integer>();
		for (Foundation fundation :  this.getFoundations()) {
			sizeFoundations.add(fundation.size());
		}
		return sizeFoundations;
	}
	
	public ArrayList<Integer> getSizeTableaus() {
		ArrayList<Integer> sizeFourColours= new ArrayList<Integer>();
		for (Stack<Card> fourColour :this.getTableaus()) {
			sizeFourColours.add(fourColour.size());
		}
		return sizeFourColours;
	}
	
	public Integer getSizeFullDeck() {
		return this.getFullDeck().size();
	}
	
	public Stack<Card> getTableau(int tableauTargetIndex) {
		return this.getTableaus().get(tableauTargetIndex);
	}
	public boolean isEmptyWaste() {
		return this.getWaste().size()==0;
	}
	
	public boolean isEmptyFoundation(Foundation foundation) {
		return foundation.size()==0;
	}
	
	public Foundation getFoundation(int i) {
		return this.getFoundations().get(i);
	}

	public ArrayList<Stack<Card>> getTableaus() {
		return tableaus;
	}
	public void setTableaus(ArrayList<Stack<Card>> tableaus) {
		this.tableaus = tableaus;
	}
	public ArrayList<Foundation> getFoundations() {
		return foundations;
	}
	public void setFoundations(ArrayList<Foundation> foundations) {
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

	// metodos neescraios para crear un tablero VACÍO
	public void init(){
		this.initFullDeck();
		this.initFoundations();
		this.initTableaus();
	}

	public void initFoundations(){
	 for(int i=0; i<Constantes.NUMBER_FOUNDATIONS;i++){
	  this.foundations.add(new Foundation(new Stack<Card>()));
	 }
	}
	public void initFullDeck(){
		Suite[] suites= Suite.values();
		for(int i=0;i<Constantes.ORDINAL_MAXIMUN_CARD;i++){
			for(Suite suite:suites){
				Card card = new Card(suite,i+1,Constantes.COVERED_CARD);
				switch(suite){
				case CLUB:
				case SPADE: card.setColour(Colour.BLACK);
		                     break; 
				case HEART:
				case DIAMOND:card.setColour(Colour.RED);
					        break;
				}
				this.fullDeck.add(card);
				fullDeckNotRepartida.add(card);
			}
		}		
	  
	}
	
	public void initTableaus(){
	for(int i=0;i<Constantes.NUMBER_TABLEAUS;i++  ){
			Stack<Card> stackCard= new Stack<Card>();
			tableaus.add(stackCard);
		}
	}
}
