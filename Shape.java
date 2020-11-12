import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.util.ArrayList;

public class Shape extends Component
{
    Brick[] bricks = new Brick[4];
    Color[] colors = {Color.cyan, Color.green, Color.yellow, Color.red, Color.orange, Color.magenta, Color.pink};
    Color c1;
    boolean canMove = true;
    boolean canRotate = true;

    ArrayList<Shape> settled = new ArrayList<Shape>();


    public Shape(int startX, int startY)
    {
        bricks[0] = new Brick(startX,startY);

    }

    public boolean canMove()
    {
        return canMove;
    }

    public int getMinX()
    {
        int min = bricks[0].getXPos();

        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getXPos() < min)
            {
                min = bricks[i].getXPos();
            }
        }

        return min;
    }

    public int getMinY()
    {
        int min = bricks[0].getYPos();

        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getYPos() < min)
            {
                min = bricks[i].getYPos();
            }
        }

        return min;
    }

    public int getMaxX()
    {
        int max = bricks[0].getXPos();

        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getXPos() + bricks[i].getWidth() > max)
            {
                max = bricks[i].getXPos() + bricks[i].getWidth();
            }
        }

        return max;
    }

    public int getMaxY()
    {
        int max = bricks[0].getYPos();

        for(int i = 0; i < 4; i++)
        {
            if(bricks[i].getYPos() + bricks[i].getHeight() > max)
            {
                max = bricks[i].getYPos() + bricks[i].getHeight();
            }
        }

        return max;
    }

    public void moveLeft()
    {
        for(int i = 0; i < 4; i++)
        {
            bricks[i].moveLeft();
        }
    }

    public void moveRight()
    {
        for(int i = 0; i < 4; i++)
        {
            bricks[i].moveRight();
        }
    }

    public void moveDown()
    {
        if(getMaxY() < 600 && !checkBelow())
        {
            for(int i = 0; i < 4; i++)
            {
                bricks[i].moveDown();
            }
        }
        else
        {
            canMove = false;
        }
    }

    public boolean isSettled(Shape s1)
    {
        if(!canMove)
        {
            settled.add(s1);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkBelow()
    {
        boolean filled = false;
        for(int i = 0; i < settled.size(); i++)
        {
            
        }
        return filled;
    }

    public void rotateLeft()
    {
        int tempX = 0;
        int tempY = 0;
        int temp = 0;

        for(int i = 0; i < 4; i++)
        {
            if(getMaxX() < 800 && getMaxY() < 600 && getMinX() > 0 && getMinY() > 0)
            {
                canRotate = true;

                tempX = bricks[i].getXPos() - bricks[0].getXPos();
                tempY = bricks[i].getYPos() - bricks[0].getYPos();

                temp = tempX;
                tempX = -tempY;
                tempY = temp;


                bricks[i].setXPos(bricks[0].getXPos() - tempX);
                bricks[i].setYPos(bricks[0].getYPos() - tempY);
            }
            else
            {
                canRotate = false;
                break;
            }

        }


    }

    public void rotateRight()
    {
        int tempX = 0;
        int tempY = 0;
        int temp = 0;

        for(int i = 0; i < 4; i++)
        {
            if(getMaxX() < 800 && getMaxY() < 600 && getMinX() > 0 && getMinY() > 0)
            {
                canRotate = true;

                tempX = bricks[i].getXPos() - bricks[0].getXPos();
                tempY = bricks[i].getYPos() - bricks[0].getYPos();

                temp = tempX;
                tempX = -tempY;
                tempY = temp;


                bricks[i].setXPos(bricks[0].getXPos() + tempX);
                bricks[i].setYPos(bricks[0].getYPos() + tempY);
            }
            else
            {
                canRotate = false;
                break;
            }
        }
    }

    public void drawImage(Graphics g)
    {
        super.paint(g);

        g.setColor(c1);

        bricks[0].drawImage(g);
        bricks[1].drawImage(g);
        bricks[2].drawImage(g);
        bricks[3].drawImage(g);
    }
}
