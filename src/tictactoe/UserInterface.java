package tictactoe;

import java.util.Scanner;

public class UserInterface{
	/*
	 * Author: Gauri Kelkar
	 * This class deals with taking input from player and displaying messages to players
	 */

	public static Scanner sc = new Scanner(System.in);

	public void printMenu() {
		System.out.println("****************Welcome To Game of Tic-tac-toe**************");
		System.out.println("Menu:");
		System.out.println("Press 1 to Start New Game");
		System.out.println("Press 2 to Reload Game");
		System.out.println("Press 999 to save and exit at anytime");
		System.out.println("*********************************************************");
		System.out.println();
	}

	public int chooseMenu() {
		System.out.println("Enter choice:");
		int choice = sc.nextInt();
		return choice;
	}

	public void chooseConfigurations(GameState conf) {
		System.out.println("Enter value of N for the board configuration:");
		int n = sc.nextInt();
		int totalCells = n * n;

		conf.setBoardSize(n);
		conf.setTotalPositions(totalCells);

	}

	public int playYourMove(GameState gamestate) {

		boolean validEntry = false;
		int boardSize = gamestate.getBoardSize();
		int currentPlayer = gamestate.getCurrentPlayer();
		int[][] board = gamestate.getGameBoard();
		int filledPos = gamestate.getFilledPositions();

		if (currentPlayer == GameConstants.CROSS) {
			System.out.println("Player 1 playing with 'X'");
		} else if (currentPlayer == GameConstants.CIRCLE) {
			System.out.println("Player 2 playing with 'O'");
		}
		int x, y;
		do {
			System.out.println("To play, enter position: row <space> column (example: 2 2). To exit enter 999");
			System.out.println("Enter choice:");
			int num1 = sc.nextInt();
			if(num1== GameConstants.EXITGAME){
				System.out.println("Exiting game..");
				return GameConstants.EXITGAME;
			}
			else{
				gamestate.setStatus(GameConstants.PLAYING);
			
			int row = num1;
			int col = sc.nextInt();
			

			if (row > 0 && row <= boardSize && col > 0 && col <= boardSize) {
				x = row - 1;
				y = col - 1;
				int[] currentMove = new int[2];
				currentMove[0] = x;
				currentMove[1] = y;
				gamestate.setCurrentMove(currentMove);
				if (board[x][y] == 0) {
					if (currentPlayer == GameConstants.CROSS) {
						board[x][y] = 1;
					} else if (currentPlayer == GameConstants.CIRCLE) {
						board[x][y] = 2;
					}
					gamestate.setGameBoard(board);
					validEntry = true;
				} else {
					System.out.println("This position is already occupied!! please choose another..");
					validEntry = false;
				}
			} else {
				System.out.println("Invalid input! Please play again..");
				validEntry = false;
			}
			}
		} while (!validEntry);
		filledPos++;
		gamestate.setFilledPositions(filledPos);
		return gamestate.getStatus();

	}
	
	

}
