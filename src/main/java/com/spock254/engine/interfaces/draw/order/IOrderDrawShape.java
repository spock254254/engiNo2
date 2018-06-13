package com.spock254.engine.interfaces.draw.order;

import com.spock254.engine.interfaces.draw.IDrawingShape;

public interface IOrderDrawShape {

    public IDrawingShape getDrawingShape();
    public void setDrawingShape(IDrawingShape drawingShape);
    public int getOffX();
    public void setOffX(int offX);
    public int getOffY();
    public void setOffY(int offY);
    public int getWidth();
    public void setWidth(int width);
    public int getHeight();
    public void setHeight(int height);
    public int getColor();
    public void setColor(int color);
}
