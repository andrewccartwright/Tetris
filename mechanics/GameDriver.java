package me.antoniomarroquin.tetris;

import me.antoniomarroquin.tetris.gui.TetrisUserInterface;
import me.antoniomarroquin.tetris.mechanics.GameOptions;
import me.antoniomarroquin.tetris.shapes.Brick;

public class GameDriver { 
	
	public static void main(String[] args) throws InterruptedException
	{
		GameOptions options = new GameOptions();
		TetrisUserInterface gui = new TetrisUserInterface();
		gui.setVisible(true);
		options.singlePlayer(null);
		
		int secondCount = 0;
		while(!options.isPaused)
		{
			Thread.sleep(GameOptions.GAMETICKS);
			if (GameOptions.mainGame != null)
			{
				if (!GameOptions.mainGame.currentShape.canMove())
					GameOptions.mainGame.generateShape();
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
