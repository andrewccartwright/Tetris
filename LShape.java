//LShape class

import java.awt.Color;

public class LShape extends Shape
{
    public LShape(int startX, int startY)
    {
        super(startX, startY);
        bricks[1] = new Brick(startX+bricks[0].getWidth(), startY);
        bricks[2] = new Brick(startX+bricks[0].getWidth()*2, startY);
        bricks[3] = new Brick(startX+bricks[0].getWidth()*2,startY+bricks[0].getHeight());
        c1 = colors[0];
    }



}
