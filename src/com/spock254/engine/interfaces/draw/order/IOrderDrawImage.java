package com.spock254.engine.interfaces.draw.order;

import com.spock254.engine.interfaces.draw.IDrawingImage;

public interface IOrderDrawImage {

    public int getOffX();
    public void setOffX(int offX);
    public int getOffY();
    public void setOffY(int offY);
    public IDrawingImage getIDrawingImage();
    public void setIDrawingImage(IDrawingImage IDrawingImage);
}
