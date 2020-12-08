//LShape class
package tetris.shapes;

import java.awt.Color;

public class LShape extends Shape
{
    public LShape(int startX, int startY)
    {
        super(startX, startY);
        bricks[1] = new Brick(startX, startY-1);
        bricks[2] = new Brick(startX, startY-2);
        bricks[3] = new Brick(startX-1,startY-2);
        c1 = colors[0];
    }

    //  |_|
    //  |_|
    //  |_|_|

}
