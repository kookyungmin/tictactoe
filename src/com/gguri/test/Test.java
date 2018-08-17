package com.gguri.test;

import com.gguri.tictactoe.Board;
import com.gguri.tictactoe.User;

public class Test {

	public static void main(String[] args) {
		Board b = new Board();
		User u = new User();
		b.setBoard(0, 0, 'O');
		u.drawBoard(b);
		b.print();

	}

}
