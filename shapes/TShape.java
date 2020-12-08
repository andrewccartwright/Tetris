//XShape class
// package tetris;

import java.awt.Color;

public class TShape extends Shape
{
    public TShape(int startX, int startY)
    {
        super(startX, startY);
        Brick[] bricks = super.getBricks();
        bricks[1] = new Brick(startX, startY-1);
        bricks[2] = new Brick(startX-1, startY-1);
        bricks[3] = new Brick(startX+1, startY-1);
        c1 = colors[2];
    }

    //  |_|
    //  |_|_|
    //  |_|
}
