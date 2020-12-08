//ZShape class
package tetris.shapes;

import java.awt.Color;

public class ZShape extends Shape
{
    public ZShape(int startX, int startY)
    {
        super(startX, startY);
        Brick[] bricks = super.getBricks();
        bricks[1] = new Brick(startX, startY-1);
        bricks[2] = new Brick(startX-1, startY-1);
        bricks[3] = new Brick(startX-1,startY-2);
        c1 = colors[3];
    }

    //    |_|
    //  |_|_|
    //  |_|
}
