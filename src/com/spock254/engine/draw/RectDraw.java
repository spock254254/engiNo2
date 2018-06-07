package com.spock254.engine.draw;

import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingShape;

public class RectDraw extends Renderer implements IDrawingShape {

    public RectDraw(Kernel gc) {
        super(gc);
    }


    @Override
    public void drawShape(int offX, int offY, int width, int height, int color) {
        for (int y = 0;y <= height;y++){

            super.setPixel(offX,y + offY,color);
            super.setPixel(offX + width,y + offY,color);
        }
        for (int x = 0;x <= width;x++){
            super.setPixel(x + offX,offY,color);
            super.setPixel(x + offX,offY + height,color);
        }
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
