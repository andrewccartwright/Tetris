//SquareShape class
package tetris.shapes;

import java.awt.Color;

public class SquareShape extends Shape
{
    public SquareShape(int startX, int startY)
    {
        super(startX, startY);
        bricks[1] = new Brick(startX+1, startY);
        bricks[2] = new Brick(startX, startY-1);
        bricks[3] = new Brick(startX+1,startY-1);
        c1 = colors[4];
    }

    //  |_|_|
    //  |_|_|

}
