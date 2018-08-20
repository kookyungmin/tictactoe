package com.gguri.tictactoe;

import java.util.Scanner;

public class User implements Player{
	//사용자 돌을 놓는 메소드
	@Override
	public void drawBoard(Board board) {
		boolean check = false;
		while(!check) {
			try {
				int x = getInt('X');
				int y = getInt('Y');
				check = board.setBoard(x, y, 'O');
			}catch(Exception e) {
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}
	//좌표 입력 받는 메소드
	private int getInt(char ch) throws Exception{
		System.out.println("───────────────────────");
		System.out.println(ch+"좌표를 입력해 주세요! (0~2)");
		System.out.println("───────────────────────");
		System.out.print("입력:");
		return getInt();
	}
	//숫자 입력 받는 메소드
	private int getInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
