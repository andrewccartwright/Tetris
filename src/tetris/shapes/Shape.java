//Shape class
// package tetris;
package tetris.shapes;

import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import tetris.GameBoard;
import tetris.Test;
import tetris.mechanics.PlayingField;

public class Shape extends Component
{
    protected Brick[] bricks = new Brick[4];
    protected ImageIcon[] colors = {GameBoard.CYAN, GameBoard.GREEN, GameBoard.YELLOW, GameBoard.RED, GameBoard.ORANGE, GameBoard.PURPLE, GameBoard.PINK};
    protected ImageIcon c1;
    protected boolean canMove = true;
    private boolean isReversed = false;
    protected int currentRotation = 0;

    //default constructor
    public Shape(int startX, int startY)
    {
        bricks[0] = new Brick(startX,startY);
        
        
        if(Test.colorChoice != null)
        {
        	switch(Test.colorChoice)
            {
            	case "Classic":
            		colors = GameBoard.classic;
            		break;
            	case "BerryBlast":
            		colors = GameBoard.berryBlast;
            		break;
            	case "ColorShift":
            		colors = GameBoard.colorShift;
            		break;
            	case "Cuppacino":
            		colors = GameBoard.cuppacino;
            		break;
            	case "Pastel":
            		colors = GameBoard.pastel;
            		break;
            	case "Winter":
            		colors = GameBoard.winter;
            		break;
            	default:
            		colors = GameBoard.classic;
            }
        }
        
        	
    }

    //setters
    public void setColor(ImageIcon c1){this.c1 = c1;}
    public void setColors(ImageIcon[] colors) {this.colors = colors;}
    public void setBricks(Brick[] bricks){this.bricks = bricks;}
    

    //getters
    public Brick[] getBricks(){return bricks;}
    public ImageIcon[] getColors(){return colors;}
    public ImageIcon getColor(){return c1;}

    //tests if the piece can move down without hitting another piece or going out of bounds
    public boolean canMove()
    {
        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getXPos() < 0 | bricks[i].getXPos() > PlayingField.FIELDWIDTH - 1)
            {
                break;
            }
            if(bricks[i].getYPos()-1 >= 0)
            {
                if(PlayingField.bricks[bricks[i].getYPos()-1][bricks[i].getXPos()] == null)
                {
                    canMove = true;
                }
                else
                {
                    canMove = false;
                    break;
                }
            }
            else
            {
                canMove = false;
                break;
            }

        }
        return canMove;
    }

    //moves each brick to the left
    public void moveLeft()
    {
        boolean canMoveLeft = true;
        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getXPos() > 0)
            {
            	if(PlayingField.bricks[bricks[i].getYPos()][bricks[i].getXPos()-1] == null)
            		canMoveLeft = true;
            	else
            	{
            		canMoveLeft = false;
            		break;
            	}
            }
            else
            {
                canMoveLeft = false;
                break;
            }
        }

        if(canMoveLeft)
        {
            for(Brick b : bricks)
            {
                b.moveLeft();
            }
        }
    }

    //moves each brick to the right
    public void moveRight()
    {
        boolean canMoveRight = true;
        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getXPos() < PlayingField.FIELDWIDTH -1)
            {
            	if(PlayingField.bricks[bricks[i].getYPos()][bricks[i].getXPos()+1] == null)
            		canMoveRight = true;
            	else
            	{
            		canMoveRight = false;
            		break;
            	}
            }
            else
            {
                canMoveRight = false;
                break;
            }
        }

        if(canMoveRight)
        {
            for(Brick b : bricks)
            {
                b.moveRight();
            }
        }
    }

    //moves down one gridspace
    public void moveDown(GameBoard gameBoard)
    {
        if(canMove())
        {
            for(int i = 0; i < 4; i++)
            {
                bricks[i].moveDown();
            }
        }
        else
        {
            placePiece();
        }
    }

    //places the current piece when there is another piece below it or it reaches the bottom of the playing field
    public void placePiece()
    {
        for(int i = 0; i < 4; i++)
        {
            PlayingField.bricks[bricks[i].getYPos()][bricks[i].getXPos()] = bricks[i];
        }
    }

  //checks that the piece can rotate without going out of bounds or hitting another piece
    public boolean testLeftRotation(Brick[] bricks)
    {
        int tempX = 0;
        int tempY = 0;
        int temp = 0;
        boolean r = true;

        for(int i = 0; i < 4; i++)
        {
            tempX = bricks[i].getXPos() - bricks[0].getXPos();
            tempY = bricks[i].getYPos() - bricks[0].getYPos();

            temp = tempX;
            tempX = -tempY;
            tempY = temp;

            if(bricks[i].getXPos() - tempX < PlayingField.FIELDWIDTH & bricks[i].getYPos()+tempY < PlayingField.FIELDHEIGHT & bricks[i].getXPos() - tempX > 0 & bricks[i].getYPos()+tempY > 0)
            {
                if(PlayingField.bricks[bricks[i].getYPos()+tempY][bricks[i].getXPos() - tempX] == null)
                    r = true;
                else
                {
                    r = false;
                    break;
                }
            }
            else
            {
                r = false;
                break;
            }
        }

        return r;
    }

    public boolean testRightRotation(Brick[] bricks)
    {
        int tempX = 0;
        int tempY = 0;
        int temp = 0;
        boolean r = true;

        for(int i = 0; i < 4; i++)
        {
            tempX = bricks[i].getXPos() - bricks[0].getXPos();
            tempY = bricks[i].getYPos() - bricks[0].getYPos();

            temp = tempX;
            tempX = -tempY;
            tempY = temp;

            if(bricks[i].getXPos() + tempX < PlayingField.FIELDWIDTH & bricks[i].getYPos()-tempY < PlayingField.FIELDHEIGHT & bricks[i].getXPos() + tempX > 0 & bricks[i].getYPos() - tempY > 0)
            {
                if(PlayingField.bricks[bricks[i].getYPos()-tempY][bricks[i].getXPos()+tempX] == null)
                    r = true;
                else
                {
                    r = false;
                    break;
                }
            }
            else
            {
                r = false;
                break;
            }
        }

        return r;
    }

    //rotates piece 90 degrees to the left
    public void rotateLeft()
    {
        int tempX = 0;
        int tempY = 0;
        int temp = 0;

        if (!isReversed)
        {
	        for(int i = 0; i < 4; i++)
	        {
	
	            tempX = bricks[i].getXPos() - bricks[0].getXPos();
	            tempY = bricks[i].getYPos() - bricks[0].getYPos();
	
	            temp = tempX;
	            tempX = -tempY;
	            tempY = temp;
	
	            //Piece only rotates if testRotation returns true
	            if(testLeftRotation(bricks))
	            {
	                bricks[i].setXPos(bricks[0].getXPos() - tempX);
	                bricks[i].setYPos(bricks[0].getYPos() + tempY);
	            }
	        }
	        isReversed = !isReversed;
        }
        else
        {
        	for(int i = 0; i < 4; i++)
            {

                tempX = bricks[i].getXPos() - bricks[0].getXPos();
                tempY = bricks[i].getYPos() - bricks[0].getYPos();

                temp = tempX;
                tempX = -tempY;
                tempY = temp;

                //Piece only rotates if testRotation returns true
                if(testRightRotation(bricks))
                {
                    bricks[i].setXPos(bricks[0].getXPos() + tempX);
                    bricks[i].setYPos(bricks[0].getYPos() - tempY);
                }
            }
        	isReversed = !isReversed;
        }
    }

    //rotates piece 90 degrees to the right
    public void rotateRight()
    {
        int tempX = 0;
        int tempY = 0;
        int temp = 0;

        if (!isReversed)
        {
	        for(int i = 0; i < 4; i++)
	        {
	
	            tempX = bricks[i].getXPos() - bricks[0].getXPos();
	            tempY = bricks[i].getYPos() - bricks[0].getYPos();
	
	            temp = tempX;
	            tempX = -tempY;
	            tempY = temp;
	
	            //Piece only rotates if testRotation returns true
	            if(testRightRotation(bricks))
	            {
	                bricks[i].setXPos(bricks[0].getXPos() + tempX);
	                bricks[i].setYPos(bricks[0].getYPos() - tempY);
	            }
	            
	        }
	        isReversed = !isReversed;
        }
        else
        {
        	for(int i = 0; i < 4; i++)
	        {
	
	            tempX = bricks[i].getXPos() - bricks[0].getXPos();
	            tempY = bricks[i].getYPos() - bricks[0].getYPos();
	
	            temp = tempX;
	            tempX = -tempY;
	            tempY = temp;
	
	            //Piece only rotates if testRotation returns true
	            if(testLeftRotation(bricks))
	            {
	                bricks[i].setXPos(bricks[0].getXPos() - tempX);
	                bricks[i].setYPos(bricks[0].getYPos() + tempY);
	            }
	        }
        	isReversed = !isReversed;
        }
    }
}
