package com.gguri.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	private Board board;
	private User user;
	private Computer com;
	private Scanner sc;
	
	public TicTacToe() {
		board = new Board();
		user = new User();
		com = new Computer();
		sc = new Scanner(System.in);
	}
	
	//실행메소드
	public void execute() {
		while(true) {
			int ch = initExec();
			switch(ch) {
			case 1:
				playGame();
				break;
			case 2:
				System.out.println("이용해주셔서 감사합니다");
				return;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
		}
			
	}
	//게임 시작 메소드
	private void playGame() {
		System.out.println("게임을 시작하겠습니다");
		board.clear();
		board.print();
		boolean isEnd = false;
		while(!isEnd) {
			user.drawBoard(board);
			System.out.println("<user>");
			board.print();
			isEnd = checkWin();
			if(isEnd) {
				break;
			}
			if(board.isFull()) {
				System.out.println();
				System.out.println("결과: 비겼습니다!");
				sc.nextLine();
				break;
			}
			System.out.println("<computer>");
			com.drawBoard(board);
			board.print();
			isEnd = checkWin();
			if(isEnd) {
				break;
			}	
		}
	}

	
	//초기화면 실행
	private int initExec() {
		initView();
		try {
			int num = getInt();
			return num;
		}catch(Exception e){
			return 0;
		}
	}
	
	//초기화면
	private void initView() {
		System.out.println("─────────────────────");
		System.out.println("      Welcome To     ");
		System.out.println("   Tic   Tac   Toe   ");
		System.out.println("─────────────────────");
		System.out.println("1. 게임시작              ");
		System.out.println("2. 나가기                ");
		System.out.println("─────────────────────");
		System.out.print("입력:");
	}
	
	
		
	//빙고된 사람이 있는지 확인
	private boolean checkWin() {
		if(board.checkBingo('O')) {
			System.out.println();
			System.out.println("결과: 당신이 이겼습니다.");
			sc.nextLine();
			return true;
		}else if(board.checkBingo('X')) {
			System.out.println();
			System.out.println("결과: 컴퓨터가 이겼습니다.");
			sc.nextLine();
			return true;
		}
		return false;
	}
	
	//숫자입력받음
	private int getInt() {
		return sc.nextInt();
	}
}
