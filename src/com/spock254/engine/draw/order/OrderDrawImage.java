package com.spock254.engine.draw.order;

import com.spock254.engine.interfaces.draw.IDrawingImage;
import com.spock254.engine.interfaces.draw.order.IOrderDrawImage;

public class OrderDrawImage implements IOrderDrawImage {

    private int offX,offY;
    private IDrawingImage IDrawingImage;


    public OrderDrawImage(IDrawingImage IDrawingImage, int offX, int offY, int zDapth){
        this.IDrawingImage = IDrawingImage;
        this.offX = offX;
        this.offY = offY;
        this.IDrawingImage.setzDapth(zDapth);
    }
    @Override
    public int getOffX() {
        return offX;
    }
    @Override
    public void setOffX(int offX) {
        this.offX = offX;
    }
    @Override
    public int getOffY() {
        return offY;
    }
    @Override
    public void setOffY(int offY) {
        this.offY = offY;
    }
    @Override
    public IDrawingImage getIDrawingImage() {
        return IDrawingImage;
    }
    @Override
    public void setIDrawingImage(IDrawingImage IDrawingImage) {
        this.IDrawingImage = IDrawingImage;
    }
}
