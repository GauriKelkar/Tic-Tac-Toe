package tictactoe;

import java.io.Serializable;

public class GameState implements Serializable {
	
	/*author : Gauri Kelkar
	 * This class represents the state of the game.
	 */
	
	private static final long serialVersionUID = 1L;
	
	int[][] gameBoard;
	int[] currentMove = new int[2];
	int filledPositions;
	int currentPlayer;
	int status;
	int boardSize;
	int totalPositions;
	
	
	public int[][] getGameBoard() {
		return gameBoard;
	}
	public void setGameBoard(int[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
	public int[] getCurrentMove() {
		return currentMove;
	}
	public void setCurrentMove(int[] currentMove) {
		this.currentMove = currentMove;
	}
	public int getFilledPositions() {
		return filledPositions;
	}
	public void setFilledPositions(int filledPositions) {
		this.filledPositions = filledPositions;
	}
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getTotalPositions() {
		return totalPositions;
	}
	public void setTotalPositions(int totalPositions) {
		this.totalPositions = totalPositions;
	}
	public int getBoardSize() {
		return boardSize;
	}
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	
	
	public void initializeGame(){
		int boardSize = this.getBoardSize();
		gameBoard = new int[boardSize][boardSize];
		
		for(int i=0; i< boardSize; i++){
			for(int j=0; j<boardSize; j++){
				gameBoard[i][j] = GameConstants.INITIAL;
			}
		}
		filledPositions = 0;
		currentPlayer = GameConstants.CROSS;
		status = GameConstants.PLAYING;
	}

	public void printBoard(int[][] board){
		int boardSize = this.getBoardSize();
		for(int i=0; i< boardSize; i++){
			for(int j=0; j<boardSize; j++){
				
				if(board[i][j] == GameConstants.CROSS){
					System.out.print(" X " );
				}
				else if(board[i][j] == GameConstants.CIRCLE){
					System.out.print(" O " );
				}
				else{
					System.out.print("   " );
				}
				if(j != boardSize-1 ){
					System.out.print("|" );
				}
			}
			System.out.println();
			if(i!= boardSize -1)
				for(int k = 0; k< boardSize; k++){
					System.out.print("----");
				}
			System.out.println();    
		}
	}

}
