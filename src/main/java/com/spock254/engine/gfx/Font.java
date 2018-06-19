package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IFont;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Font  implements IFont {

    public static com.spock254.engine.gfx.Font STANDART = new Font("/res/standart.png");

    private String fontPath;

    private Image fontImage;
    private int[] offsets;
    private int[] widths;

    public Font(String path)  {

        if(path == null || path.isEmpty())
            throw new IllegalArgumentException("font file not found");

        fontPath = path;
        try {
            fontImage = new Image(path);
        } catch (Exception e) {
            fontImage = STANDART.fontImage;
        }

        offsets = new int[59];
        widths = new int[59];

        int unicode = 0;

        for (int i = 0;i < fontImage.getWidth();i++){
            if(fontImage.getPixels()[i] == 0xff0000ff){
                offsets[unicode] = i;
            }
            if(fontImage.getPixels()[i] == 0xffffff00){
                widths[unicode] = i - offsets[unicode];
                //System.out.println(widths[unicode]);
                unicode++;
            }
        }

    }
    @Override
    public int getTextPixelWeight(String str){
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("invalid word");
        int size = 0;
        str = str.toUpperCase();
        for(int i = 0; i < str.length();i ++){
            size += widths[str.codePointAt(i) - 32];
        }
        return size;
    }

    @Override
    public int getTextPixelHeight(String str) {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException("invalid word");
        return fontImage.getHeight();
    }

    @Override
    public String getFontPath() {
        return fontPath;
    }

    public static Font getSTANDART() {
        return STANDART;
    }
    @Override
    public Image getFontImage() {
        return fontImage;
    }
    @Override
    public void setFontImage(Image fontImage) {
        this.fontImage = fontImage;
    }
    @Override
    public int[] getOffsets() {
        return offsets;
    }
    @Override
    public void setOffsets(int[] offsets) {
        this.offsets = offsets;
    }
    @Override
    public int[] getWidths() {
        return widths;
    }
    @Override
    public void setWidths(int[] widths) {
        this.widths = widths;
    }
}
