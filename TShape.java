//XShape class

import java.awt.Color;

public class TShape extends Shape
{
    public TShape(int startX, int startY)
    {
        super(startX, startY);
        bricks[1] = new Brick(startX, startY+bricks[0].getHeight());
        bricks[2] = new Brick(startX-bricks[0].getWidth(), startY+bricks[0].getHeight());
        bricks[3] = new Brick(startX+bricks[0].getWidth(),startY+bricks[0].getHeight());
        c1 = colors[2];
    }


}
