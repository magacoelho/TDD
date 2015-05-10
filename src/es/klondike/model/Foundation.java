package es.klondike.model;

import java.util.Stack;

public class Foundation {

	private Stack<Card> stackCard;
	private Suite suite;

	public Foundation(Stack<Card> stackCard, Suite suite) {
		this.stackCard= stackCard;
		this.suite=suite;
	}

	public Foundation(Stack<Card> stackCard) {
		this.stackCard= stackCard;
	}

	public Integer size() {
			return this.stackCard.size();
	}

	public Suite getSuite() {
		return this.suite;
	}

	public Stack<Card> getStackCard() {
		return this.stackCard;
	}

	public void setSuite(Suite suite) {
		this.suite=suite;
	}
	
	public Card getTopCard(){
		return this.stackCard.peek();
	}
}
