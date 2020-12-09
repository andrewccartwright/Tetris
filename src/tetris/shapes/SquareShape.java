//SquareShape class
package tetris.shapes;

import java.awt.Color;

public class SquareShape extends Shape
{
    public SquareShape(int startX, int startY)
    {
        super(startX, startY);
        c1 = colors[4];
        bricks[0].setColor(c1);
        bricks[1] = new Brick(startX+1, startY, getColor());
        bricks[2] = new Brick(startX, startY-1, getColor());
        bricks[3] = new Brick(startX+1,startY-1, getColor());
    }

    //  |_|_|
    //  |_|_|

}
