package tictactoe;


public class ResultChecker{
     /*
      * Author: Gauri Kelkar
      * This class has logic to check if a player has won after each move.
      */

	public void checkIfWon(GameState gamestate){
		int x = gamestate.getCurrentMove()[0];
		int y= gamestate.getCurrentMove()[1];
		int currentPlayer = gamestate.getCurrentPlayer();
		int boardSize = gamestate.getBoardSize();
		int[][] board = gamestate.getGameBoard();
		//check row
		int col = 0;
		while(col<boardSize){
			if(board[x][col]== currentPlayer)
			    col++;
			else
				break;
			if(col == boardSize-1 && board[x][col]== currentPlayer){
					declareWinner(currentPlayer);
					gamestate.setStatus(GameConstants.WIN);
					
			}
		}
			
		// check column
		int row = 0;
		while(row<boardSize){
			if(board[row][y]== currentPlayer)
				row++;
			else
				break;
			if(row == boardSize-1 && board[row][y]== currentPlayer){
				
				declareWinner(currentPlayer);
				gamestate.setStatus(GameConstants.WIN);
				
			}
		}
		//check diagonal 1
		
		for(int p1= 0,p2=0; p1<boardSize && p2<boardSize; ){
			if(board[p1][p2]== currentPlayer){
				p1++;p2++;
			}
			else{
				break;
			}
			if(p1 == boardSize-1 && p2 == boardSize-1 && board[p1][p2]== currentPlayer){
				
				declareWinner(currentPlayer);
				gamestate.setStatus(GameConstants.WIN);
				
			}
		}
		
		//check diagonal 2
		
		for(int p1= 0,p2=boardSize-1; p1<boardSize && p2>0; ){
			if(board[p1][p2]== currentPlayer){
				p1++;p2--;
			}
			else{
				break;
			}
			if(p1 == boardSize-1 && p2 == 0 && board[p1][p2]== currentPlayer){
				
				declareWinner(currentPlayer);
				gamestate.setStatus(GameConstants.WIN);
				
			}
		}

       	
	}


public void declareWinner(int currentPlayer){
	if (currentPlayer == GameConstants.CROSS) {
		System.out.println("Congratulations Player 1! You Won!!!");
		
	} else if (currentPlayer == GameConstants.CIRCLE) {
		System.out.println("Congratulations Player 2! You Won!!!");
	}
	
}

}
