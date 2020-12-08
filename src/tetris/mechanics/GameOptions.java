package tetris.mechanics;

import javax.swing.JPanel;

public class GameOptions
{
	
	public static PlayingField mainGame;
	public boolean isPaused = false;
	
	// update 20 times per second
	public static final int GAMETICKS = 1000 / 50;
	
	public void singlePlayer(JPanel game)
	{
		mainGame = new PlayingField();
	}
	
	// optional if we have time
	public void multiplayer()
	{
		
	}
	
	public static void endGame()
	{
		mainGame = null;
		displayScore();
	}
	
	public static void displayScore()
	{
		// display score window
	}
	
	public void pauseAndUnpauseGame()
	{
		isPaused = !isPaused;
	}
}
