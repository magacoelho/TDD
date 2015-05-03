package es.klodike.controllers;

import es.klondike.model.Tableau;

public class MoveFromDeckToWasteController {

	private Tableau tableau;

	public MoveFromDeckToWasteController(Tableau tableau) {
		this.tableau= tableau;
	}

	public void moveFromDeckToWaste() {
		
		tableau.getWaste().push(tableau.getDeck().pop());
		tableau.getWaste().peek().setCovered(false);
		
	}

}
