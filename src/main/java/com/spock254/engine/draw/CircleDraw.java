package com.spock254.engine.draw;

import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingShape;

public class CircleDraw extends Renderer implements IDrawingShape {

    private  double area;

    public CircleDraw(Kernel gc) {
        super(gc);
    }

    @Override
    public void drawShape(int offX, int offY, int width, int height, int color) {

        int d = (5 - (width / 2) * 4)/4;
        int x = 0;
        int y = width / 2;


        do {
            setPixel(offX + x, offY + y, color);
            setPixel(offX + x, offY - y, color);
            setPixel(offX - x, offY + y, color);
            setPixel(offX - x, offY - y, color);
            setPixel(offX + y, offY + x, color);
            setPixel(offX + y, offY - x, color);
            setPixel(offX - y, offY + x, color);
            setPixel(offX - y, offY - x, color);
            if (d < 0) {
                d += 2 * x + 1;
            } else {
                d += 2 * (x - y) + 1;
                y--;
            }
            x++;
        } while (x <= y);
    }


    @Override
    public int getZDapth() {
        return super.getzDapth();
    }

    @Override
    public void setZDapth(int zDapth) {
        super.setzDapth(zDapth);
    }
}
