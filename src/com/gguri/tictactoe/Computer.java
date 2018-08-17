package com.gguri.tictactoe;

public class Computer implements Player{

	@Override
	public void drawBoard(Board board) {
		board.setBoard(0, 0, 'X');
	}
	
}
