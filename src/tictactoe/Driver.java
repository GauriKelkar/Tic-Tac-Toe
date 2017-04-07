package tictactoe;

import java.io.File;

import tictactoe.GameState;

public class Driver {
	
	/*Author : Gauri Kelkar
	 * This class is starting point of the game.
	 *  It coordinates with all other classes in order to play the game.
	 */
	
	
	
	public static void main(String[] args){
		Driver driver = new Driver();
		UserInterface ui = new UserInterface();
		driver.start(driver, ui);
	}
	
	public void start(Driver driver, UserInterface ui){
		ui.printMenu();
		int menuChoice = ui.chooseMenu();
		driver.followMenuChoice(menuChoice,driver, ui);
		
		
	}
	
	public void followMenuChoice(int menuChoice,Driver driver, UserInterface ui){
		GameState gamestate = new GameState();
		if(menuChoice == GameConstants.NEWGAME){
			System.out.println("You chose to Start new game!!");
			ui.chooseConfigurations(gamestate);
			gamestate.initializeGame();
			gamestate.printBoard(gamestate.getGameBoard());
			driver.startPlaying(gamestate, driver, ui);
			
		}
		if(menuChoice == GameConstants.RELOADGAME){
			System.out.println("You chose to Reload old game!!");
			GameStatePersist load = new GameStatePersist();
			File savedFile = load.getFile();
			if(savedFile.exists()){
				// load old and play
				
				 gamestate =(GameState) load.loadGame();;
    		
				// continue playing
				gamestate.printBoard(gamestate.getGameBoard());
				driver.startPlaying(gamestate, driver, ui);
			}
			else{
				System.out.println("There is no saved game... You can play a new game..");
				driver.start(driver, ui);
			}
		}
		if(menuChoice == GameConstants.EXITGAME){
			System.out.println("Exiting game..See you again!");
			System.exit(0);
		}
	}
	
	
	

	public void startPlaying(GameState gamestate, Driver driver, UserInterface ui){
		ResultChecker checkStatus = new ResultChecker();
		while(gamestate.getStatus() == GameConstants.PLAYING && gamestate.getFilledPositions()< gamestate.getTotalPositions() ){
			int status = ui.playYourMove(gamestate);
			if(status == GameConstants.EXITGAME){
				// call save 
				GameStatePersist save = new GameStatePersist();
				save.saveGame(gamestate);
				gamestate.setStatus(GameConstants.EXITGAME);
				System.exit(0);
			}
			gamestate.printBoard(gamestate.getGameBoard());
			checkStatus.checkIfWon(gamestate);
			int nextPlayer = driver.switchPlayer(gamestate.getCurrentPlayer());
			gamestate.setCurrentPlayer(nextPlayer);
			
		}
		if(gamestate.getFilledPositions() == gamestate.getTotalPositions()){
			System.out.println("Game is Draw!!");
		}
		driver.start(driver, ui);
	}
	
	// switch player after each move
	public int switchPlayer(int currentPlayer){
		int nextPlayer=0;
		if(currentPlayer == GameConstants.CROSS)
			nextPlayer = GameConstants.CIRCLE;
		else if(currentPlayer == GameConstants.CIRCLE)
			nextPlayer = GameConstants.CROSS;
		
		return nextPlayer;
	}
	
	
}
