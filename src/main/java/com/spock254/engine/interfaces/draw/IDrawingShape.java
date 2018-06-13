package com.spock254.engine.interfaces.draw;

import javax.swing.*;

public interface IDrawingShape {
    public void drawShape(int offX,int offY,int width,int height,int color);
    public int getZDapth();
    public void setZDapth(int zDapth);
}
