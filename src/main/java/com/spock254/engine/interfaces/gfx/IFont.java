package com.spock254.engine.interfaces.gfx;

import com.spock254.engine.gfx.Font;
import com.spock254.engine.gfx.Image;

public interface IFont {

    public Image getFontImage();
    public void setFontImage(Image fontImage);
    public int[] getOffsets();
    public void setOffsets(int[] offsets);
    public int[] getWidths();
    public void setWidths(int[] widths);
    public int getTextPixelWeight(String str);
    public int getTextPixelHeight(String str);
    public String getFontPath();

}
