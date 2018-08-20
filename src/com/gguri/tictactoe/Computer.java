package com.gguri.tictactoe;


public class Computer implements Player{
	private boolean init = true;
	//컴퓨터 돌을 놓는 메소드
	@Override
	public void drawBoard(Board board) {
		if(init) {
			initDrawBoard(board);
			init = false;
		}else {
			defenseBoard(board);
		}
		
		
	}
	//랜덤 메소드
		private void randomBoard(Board board) {
			int x , y;
			do {
				x = (int)(Math.random()*3);
				y = (int)(Math.random()*3);
			}while(!board.isEmptyBoard(x, y));
			board.setBoard(x, y, 'X');
			
		}
		
	//처음 놓는 메소드
	private void initDrawBoard(Board board) {
		//가운데에 아무것도 없다면 가운데에 놓는다.
		if(board.isEmptyBoard(1, 1)) {
			board.setBoard(1, 1, 'X');
		}else { //아니면 아무데나 놓는다.
			randomBoard(board);
		}
	}
	//공격 메소드
	private void attackBoard(Board board) {
		int size = board.getSize();
		for(int i = 0 ; i < size; i++) {
			for(int j = 0; j < size; j++) {
				//비워 있는 곳에 놔보고
				if(board.isEmptyBoard(i, j)) {
					board.setBoard(i, j, 'X');
					//빙고가 된다면 거기에 놓는다
					if (board.checkBingo('X')) {
						return;
					}
					//빙고가 아니면 다시 원래대로 돌려놓는다.
					board.changeBoard(i, j, ' ');
				}
			}
		}
		//공격할 때 없으면 아무데나 둔다.
		randomBoard(board);
	}
	//디펜스 메소드
	private void defenseBoard(Board board) {
		int size = board.getSize();
		//상대가 빙고만들만한 곳이 있으면 그곳에 놓는다.
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				//비워 있는 곳에 상대의 돌을 놔보고
				if(board.isEmptyBoard(i, j)) {
					board.setBoard(i, j, 'O');
					//빙고가 된다면 막는다
					if (board.checkBingo('O')) {
						board.changeBoard(i, j, 'X');
						return;
					}
					//아니면 돌려놓는다.
					board.changeBoard(i, j, ' ');
				}
			}
		}
		
		//상대가 빙고 될만한 곳이 없으면 공격 한다.
		attackBoard(board);
	}
}
