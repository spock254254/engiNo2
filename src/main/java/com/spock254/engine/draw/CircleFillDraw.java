package com.spock254.engine.draw;

import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingShape;

public class CircleFillDraw extends Renderer implements IDrawingShape {

    public CircleFillDraw(Kernel gc) {
        super(gc);
    }

    @Override
    public void drawShape(int offX, int offY, int width, int height, int color) {

        int radius = width / 2;

        for(int y=-radius; y<=radius; y++)
            for(int x=-radius; x<=radius; x++)
                if(x*x+y*y <= radius*radius)
                    super.setPixel(offX+x, offY+y,color);
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
