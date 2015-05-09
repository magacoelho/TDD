package es.klodike.controllers;

import es.klondike.model.Board;

public class KlondikeController {

	private Board board;

	public KlondikeController(Board board) {
		super();
		this.board= board;
	}

	public Board getBoard() {
		return this.board;
	}

}