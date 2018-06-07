package com.spock254.engine.draw.order;

import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.order.IOrderDrawShape;

public class OrderDrawShape implements IOrderDrawShape {

    private IDrawingShape drawingShape;
    int offX, offY;
    int width, height;
    int color;

    public OrderDrawShape(IDrawingShape drawingShape,int offX, int offY, int width, int height, int color,int zDapth) {
        this.drawingShape = drawingShape;
        this.offX = offX;
        this.offY = offY;
        this.width = width;
        this.height = height;
        this.color = color;
        drawingShape.setZDapth(zDapth);
    }
    @Override
    public IDrawingShape getDrawingShape() {
        return drawingShape;
    }
    @Override
    public void setDrawingShape(IDrawingShape drawingShape) {
        this.drawingShape = drawingShape;
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
    public int getWidth() {
        return width;
    }
    @Override
    public void setWidth(int width) {
        this.width = width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public int getColor() {
        return color;
    }
    @Override
    public void setColor(int color) {
        this.color = color;
    }
}
