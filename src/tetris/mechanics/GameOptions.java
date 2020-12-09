package tetris.mechanics;

import javax.swing.JPanel;

import tetris.Test;

public class GameOptions
{
	
	public static PlayingField mainGame;
	public boolean isPaused = false;
	
	// update 20 times per second
	public static final int GAMETICKS = 1000 / 50;
	
	public void singlePlayer(Test game)
	{
		mainGame = new PlayingField(game);
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
