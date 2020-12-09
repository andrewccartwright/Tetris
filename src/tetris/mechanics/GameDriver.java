package tetris.mechanics;

import tetris.Test;
import tetris.shapes.Brick;

public class GameDriver { 
	
	public static GameOptions options;
	public Test gui;
	
	public static void main(String[] args) throws InterruptedException
	{
		new GameDriver();
	}
	
	public GameDriver() throws InterruptedException
	{
		options = new GameOptions();
		gui = new Test();
		gui.setVisible(true);
		
		repeater();
	}
	
	// repeating method that runs the game constantly
	public void repeater() throws InterruptedException
	{
		int secondCount = 0;
		
		// constantly update no matter what
		while(true)
		{
			// pause updating a certain amount of ms depending on the GAMETICkS
			Thread.sleep(GameOptions.GAMETICKS);
			
			// Check if the game is paused or not
			if (!options.isPaused)
			{
				// check if the game has actually been created or ended
				if (GameOptions.mainGame != null)
				{
					if (!GameOptions.mainGame.currentShape.canMove())
						GameOptions.mainGame.generateShape(gui);
					if (secondCount < 1000)
						secondCount += GameOptions.GAMETICKS;
					else
					{
						secondCount = 0;
						GameOptions.mainGame.moveDown();
						for (Brick b : GameOptions.mainGame.currentShape.getBricks())
							System.out.println(b.getXPos() + ", " + b.getYPos());
						System.out.println(GameOptions.mainGame.currentShape.toString());
					}
					GameOptions.mainGame.updateField();
				}
			}
		}
	}
}
