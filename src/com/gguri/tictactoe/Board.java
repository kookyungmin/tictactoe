package com.gguri.tictactoe;

public class Board {
	private char[][] board;
	private static final int SIZE = 3;
	public Board() {
		board = new char[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j< SIZE; j++) {
				board[i][j] = ' ';
			}
		}
	}
	//문자 삽입 메소드 
	public boolean setBoard(int x, int y, char character) {
		try {
			if(board[x][y] == ' ') {
				board[x][y] = character;
			}else {
				Exception e = new Exception();
				System.out.print("이미 채워져있는 자리입니다! ");
				throw e;
			}
			
		}catch(Exception e) {
			System.out.println("잘못입력하셨습니다.");
			return false;
		}
		return true;
	}
	//문자가 가득 찼는지 확인하는 메소드
	public boolean isFull() {
		boolean result = true;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(board[i][j]==' ') {
					result = false;
				}
			}
		}
		return result;
	}
	
	//빙고 되었는지 확인
	public boolean checkBingo(char ch) {
		boolean result = false;
				
			
			
		return result;
	}
	//화면 출력 메소드
	public void print() {
		System.out.println("┌─────┬─────┬─────┐");
		System.out.println("│  "+board[0][0]+"  │  "+board[0][1]+"  │  "+board[0][2]+"  │");
		System.out.println("├─────┼─────┼─────┤");
		System.out.println("│  "+board[1][0]+"  │  "+board[1][1]+"  │  "+board[1][2]+"  │");
		System.out.println("├─────┼─────┼─────┤");
		System.out.println("│  "+board[2][0]+"  │  "+board[2][1]+"  │  "+board[2][2]+"  │");
		System.out.println("└─────┴─────┴─────┘");
		
	}
	
	public int getSize() {
		return SIZE;
	}
	public char[][] getBoard(){
		return board;
	}
	

}
