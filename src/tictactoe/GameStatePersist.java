package tictactoe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameStatePersist {
	
	/*author: Gauri Kelkar
	 * This class contains functions to save the state of the game and reload it again. 
	 */
			
	
	public File file = new File(GameConstants.SAVEGAMEFILEPATH);

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void saveGame(GameState gamestate){
		try {   
			
			File theDir = new File(GameConstants.SAVEGAMEDIRPATH);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
			    try{
			        theDir.mkdir();
			    } 
			    catch(SecurityException se){
			      System.out.println("Error in creating directory... Please create "+ GameConstants.SAVEGAMEDIRPATH +" and run again");
			    }        
			   
			}
	        FileOutputStream fileStream = new FileOutputStream(file);   
	        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   

	        objectStream.writeObject(gamestate);
	       
	        objectStream.close();   
	        fileStream.close();   

	        System.out.println("Game saved. To resume saved game, select Reload option from Menu.");
	    } catch (Exception e) {   
	       System.out.println("Saving failed.. You will not be able to Reload this game");
	       e.printStackTrace();
	    }   
		
	}
	
    public GameState loadGame(){
    	GameState game = null;
    	 try{

    		    FileInputStream fileStream = new FileInputStream(file);   
    		    ObjectInputStream objectStream = new ObjectInputStream(fileStream);   
    		    
    		    game = (GameState) objectStream.readObject();
    		   
    		   
    		    objectStream.close();   
    	        fileStream.close();   
    		    System.out.println("Your game is Loaded..enjoy playing.......");
    		    System.out.println();
    		   
    		   }
    	 catch (Exception e) {   
  	       System.out.println("loading failed.. ");
  	       e.printStackTrace();
  	    }   
    	 return  game;
	}

}
