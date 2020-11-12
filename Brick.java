//Brick class of Tetris project

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Brick extends Component
{
    private int xPos;
    private int yPos;
    private int height;
    private int width;
    private Color c1;

    public Brick()
    {
        xPos = 300;
        yPos = 0;
        height = 25;
        width = 25;

    }

    public Brick(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        height = 25;
        width = 25;

    }

    public Brick(int xPos, int yPos, int height, int width)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;

    }

    public void setXPos(int xPos){this.xPos = xPos;}

    public void setYPos(int yPos){this.yPos = yPos;}

    public int getXPos(){return xPos;}

    public int getYPos(){return yPos;}

    public int getHeight(){return height;}

    public int getWidth(){return width;}

    public void moveDown()
    {
        yPos += 25;
    }

    public void moveLeft()
    {
        xPos -= width;
    }

    public void moveRight()
    {
        xPos += width;
    }

    public void drawImage(Graphics g)
    {
        super.paint(g);

        g.fillRect(xPos, yPos, width, height);
    }
}
