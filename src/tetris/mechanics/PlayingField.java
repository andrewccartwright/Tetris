package tetris.mechanics;

import tetris.Test;
import tetris.shapes.Brick;
import tetris.shapes.IShape;
import tetris.shapes.LShape;
import tetris.shapes.ReverseLShape;
import tetris.shapes.SShape;
import tetris.shapes.Shape;
import tetris.shapes.SquareShape;
import tetris.shapes.TShape;
import tetris.shapes.ZShape;

public class PlayingField
{	
	// amount of different shapes
	public final int uniqueShapeCount = 7;
	
	// field dimensions - universal
	public static final int FIELDWIDTH = 10;
	public static final int FIELDHEIGHT = 20;
	
	public static Brick[][] bricks = new Brick[FIELDHEIGHT][FIELDWIDTH];
	public Shape currentShape;
	public Test gui;
	
	public PlayingField(Test gui)
	{
		this.gui = gui;
		generateShape(gui);
	}

	// create a shape of a random type and set it to be the current shape
	public void generateShape(Test gui)
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
		
		gui.getGameBoard().addBricks(currentShape.getBricks());
	}
	
	private int checkForFullRows()
	{
		int full = -1;
		for (int i = 0; i < FIELDHEIGHT; i++)
		{
			for (int j = 0; j < FIELDWIDTH; j++)
			{
				if (bricks[i][j] == null)
				{
					full = -1;
					break;
				}
				else
					full = i;
			}
			if (full != -1)
				return full;
		}
		return -1;
	}
	
	public void updateField() throws InterruptedException
	{
		if (checkForFullRows() != -1)
		{
			eraseLine(checkForFullRows());
		}
		gui.getGameBoard().moveBricks();
	}
	
	// called whenever a line of the playing field has been filled
	public void eraseLine(int indexRow) throws InterruptedException
	{
		for (int i = 0; i < FIELDWIDTH; i++)
		{
			Brick temp = bricks[indexRow][i];
			temp.setXPos(-100);
			temp.setYPos(-100);
			bricks[indexRow][i] = null;
		}
		System.out.println("INDEX ROW IS: " + indexRow);
		Thread.sleep(GameOptions.GAMETICKS);
		gui.getGameBoard().deleteBricks();
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
					bricks[indexRow][i].moveDown();
					bricks[indexRow - 1][i] = bricks[indexRow][i];
					bricks[indexRow][i] = null;
				}
			indexRow++;
		}
		gui.getGameBoard().moveBricks();
		gui.getGameBoard().addScore(100);
	}
	
	// check the bounds of the pieces that are already placed and place the current piece on top of them
	public void placePiece()
	{
		
	}
	
	/* check if the tetrominoes have reached the top of the playing field every time a piece is placed. 
	 * If this method returns true, the endGame() method will be called and the user’s final score will be displayed.
	 */
	public boolean isFull()
	{
		if (currentShape.canMove() == false)
		{
			for (int i = 0; i < FIELDWIDTH; i++)
				for (Brick b : currentShape.getBricks())
					if (bricks[FIELDHEIGHT - 1][i] != null)
						if (bricks[FIELDHEIGHT - 1][i].equals(b))
							return true;
		}
		return false;
	}
	
	// the current piece will move down every time the paint method refreshes
	public void moveDown()
	{
		currentShape.moveDown(gui.getGameBoard());
	}

	public void moveDown(int i) 
	{
		moveDown();
		gui.getGameBoard().addScore(1);
	}
}
