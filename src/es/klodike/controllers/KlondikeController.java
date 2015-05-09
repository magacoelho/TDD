package es.klodike.controllers;

import es.klondike.model.Board;
import es.klondike.model.Foundation;

public class KlondikeController {

	private Board board;

	public KlondikeController(Board board) {
		super();
		this.board= board;
	}

	public boolean isEmptyWaste() {
		return board.getWaste().size()==0;
	}

	public boolean isEmptyFoundation(Foundation foundation) {
		return foundation.size()==0;
	}

	public Foundation getFoundation(int i) {
		return board.getFoundations().get(i);
	}

	public Board getBoard() {
		return this.board;
	}

}