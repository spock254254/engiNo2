package com.spock254.engine.interfaces.gfx;

public interface IImage {
    public int getWidth();
    public void setWidth(int width);
    public int getHeight();
    public void setHeight(int height);
    public int[] getPixels();
    public void setPixels(int[] pixels);
    public boolean isAlpha();
    public void setAlpha(boolean alpha);
}
