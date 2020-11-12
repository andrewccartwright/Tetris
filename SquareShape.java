//SquareShape class

import java.awt.Color;

public class SquareShape extends Shape
{
    public SquareShape(int startX, int startY)
    {
        super(startX, startY);
        bricks[1] = new Brick(startX+bricks[0].getWidth(), startY);
        bricks[2] = new Brick(startX, startY+bricks[0].getHeight());
        bricks[3] = new Brick(startX+bricks[0].getWidth(),startY+bricks[0].getHeight());
        c1 = colors[4];
    }

}
