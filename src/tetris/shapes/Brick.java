//Brick class of Tetris project
package tetris.shapes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import tetris.mechanics.PlayingField;

public class Brick extends Component
{
    private int xPos;
    private int yPos;
    private int height;
    private int width;
    private ImageIcon c1;


    //Default constructor
    public Brick()
    {
        xPos = 0;
        yPos = 0;
        height = 25;
        width = 25;
    }

    //2-argument constructor
    public Brick(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;

        //Checks that entered values are valid
        if(xPos < 0)
        {
            xPos = 0;
        }
        else if(xPos > PlayingField.FIELDWIDTH)
        {
            xPos = PlayingField.FIELDWIDTH;
        }
        if(yPos < 0)
        {
            yPos = 0;
        }
        else if(yPos > PlayingField.FIELDHEIGHT)
        {
            yPos = PlayingField.FIELDHEIGHT;
        }
        height = 25;
        width = 25;
    }
    
  //3-argument constructor
    public Brick(int xPos, int yPos, ImageIcon color)
    {
        this.xPos = xPos;
        this.yPos = yPos;

        //Checks that entered values are valid
        if(xPos < 0)
        {
            xPos = 0;
        }
        else if(xPos > PlayingField.FIELDWIDTH)
        {
            xPos = PlayingField.FIELDWIDTH;
        }
        if(yPos < 0)
        {
            yPos = 0;
        }
        else if(yPos > PlayingField.FIELDHEIGHT)
        {
            yPos = PlayingField.FIELDHEIGHT;
        }
        height = 25;
        width = 25;
        
        c1 = color;
        
        System.out.println(c1.getIconHeight());
    }

    public Brick(int xPos, int yPos, int height, int width)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    }

    //setters
    public void setXPos(int xPos){this.xPos = xPos;}

    public void setYPos(int yPos){this.yPos = yPos;}
    
    public void setColor(ImageIcon color) {this.c1 = color;}

    //getters
    public int getXPos(){return xPos;}

    public int getYPos(){return yPos;}

    public int getHeight(){return height;}

    public int getWidth(){return width;}
    
    public ImageIcon getColor() {return c1;}


    //moves brick down by one gridspace
    public void moveDown()
    {
        if(yPos > 0)
            yPos --;
    }

    //moves brick one gridspace to the left
    public void moveLeft()
    {
        xPos --;
    }

    //moves brick one gridspace to the right
    public void moveRight()
    {
        xPos ++;
    }

    //draws the brick
    public void drawImage(Graphics g)
    {
        super.paint(g);

        g.fillRect(xPos, yPos, width, height);
    }
}
