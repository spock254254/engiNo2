package com.spock254.engine.interfaces.draw;

import com.spock254.engine.interfaces.gfx.IFont;

public interface IDrawingText {
    public void drawText(String text,int offX,int offY,int color);
    public IFont getFont();
    public void setFont(IFont font);
   // public int getTextPixelSize(String text);
}
