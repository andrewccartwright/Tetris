package me.antoniomarroquin.tetris.mechanics;

import me.antoniomarroquin.tetris.shapes.Brick;
import me.antoniomarroquin.tetris.shapes.IShape;
import me.antoniomarroquin.tetris.shapes.LShape;
import me.antoniomarroquin.tetris.shapes.ReverseLShape;
import me.antoniomarroquin.tetris.shapes.SShape;
import me.antoniomarroquin.tetris.shapes.Shape;
import me.antoniomarroquin.tetris.shapes.SquareShape;
import me.antoniomarroquin.tetris.shapes.TShape;
import me.antoniomarroquin.tetris.shapes.ZShape;

public class PlayingField
{	
	// amount of different shapes
	public final int uniqueShapeCount = 7;
	
	// field dimensions - universal
	public static final int FIELDWIDTH = 10;
	public static final int FIELDHEIGHT = 20;
	
	public static Brick[][] bricks = new Brick[FIELDHEIGHT][FIELDWIDTH];
	public Shape currentShape;
	
	public PlayingField()
	{
		generateShape();
	}

	// create a shape of a random type and set it to be the current shape
	public void generateShape()
	{
		int startX = FIELDWIDTH / 2;
		int startY = FIELDHEIGHT - 1;
		switch ((int)(Math.random() * uniqueShapeCount)) {
		case 0: currentShape = new IShape(startX, startY); break;
		case 1: currentShape = new LShape(startX, startY); break;
		case 2: currentShape = new SShape(startX, startY); break;
		case 3: currentShape = new TShape(startX, startY); break;
		case 4: currentShape = new ZShape(startX, startY); break;
		case 5: currentShape = new ReverseLShape(startX, startY); break;
		case 6: currentShape = new SquareShape(startX, startY); break;
		default:
			System.err.println("Unique Shape Count does not match total number of Unique Shape Classes.");
		break;
		}
	}
	
	public void updateField()
	{
		for (Brick[] brick : bricks)
			for (Brick b : brick)
				if (b != null)
					System.out.print("");
					//System.out.println(this.currentShape.toString() + b.getXPos() + ", " + b.getYPos());
					// update image with new location
	}
	
	// called whenever a line of the playing field has been filled
	public void eraseLine(int indexRow) throws InterruptedException
	{
		for (int i = 0; i < FIELDWIDTH; i++)
			bricks[indexRow][i] = null;
		Thread.sleep(GameOptions.GAMETICKS);
		movePiecesDown(indexRow);
	}
	
	// called as part of the eraseLine() method. It will move all of the pieces down by a line to fill the space
	private void movePiecesDown(int indexRow)
	{
		while (indexRow < FIELDHEIGHT)
		{
			for (int i = 0; i < FIELDWIDTH; i++)
				if (bricks[indexRow][i] != null)
				{
					bricks[indexRow - 1][i] = bricks[indexRow][i];
					bricks[indexRow][i] = null;
				}
			indexRow++;
		}
	}
	
	// check the bounds of the pieces that are already placed and place the current piece on top of them
	public void placePiece()
	{
		
	}
	
	/* check if the tetrominoes have reached the top of the playing field every time a piece is placed. 
	 * If this method returns true, the endGame() method will be called, the user’s final score will be displayed, 
	 * and the user will be asked if they would like to play again.
	 */
	public boolean isFull()
	{
		if (currentShape.canMove() == false)
		{
			for (int i = 0; i < FIELDWIDTH; i++)
				for (Brick b : currentShape.getBricks())
					if (bricks[FIELDHEIGHT - 1][FIELDWIDTH].equals(b))
					{
						GameOptions.endGame();
						return true;
					}
		}
		return false;
	}
	
	// the current piece will move down every time the paint method refreshes
	public void moveDown()
	{
		currentShape.moveDown();
	}
}
