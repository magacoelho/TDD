package es.klodike.controllers.test;

import java.util.Stack;

import es.klondike.model.Card;
import es.klondike.model.Suite;

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

	

}
