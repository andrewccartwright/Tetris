//IShape class
package tetris.shapes;

import java.awt.Color;

public class IShape extends Shape
{
    public IShape(int startX, int startY)
    {
        super(startX, startY);
        c1 = colors[1];
        bricks[0].setColor(c1);
        bricks[1] = new Brick(startX+1, startY, getColor());
        bricks[2] = new Brick(startX+2, startY, getColor());
        bricks[3] = new Brick(startX+3, startY, getColor());
    }

    //  |_|
    //  |_|
    //  |_|
    //  |_|

}
