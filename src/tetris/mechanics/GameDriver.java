package tetris.mechanics;

import tetris.Test;
import tetris.shapes.Brick;

public class GameDriver { 
	
	public static void main(String[] args) throws InterruptedException
	{
		GameOptions options = new GameOptions();
		Test gui = new Test();
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
