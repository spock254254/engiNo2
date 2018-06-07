package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image implements IImage {
    private int width,height;
    private int[] pixels;
    private boolean isAlpha = false;

    public Image(String path){

        BufferedImage image = null;

        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0,0,width,height,null,0,width);

        image.flush();
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
    public int[] getPixels() {
        return pixels;
    }
    @Override
    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }
    @Override
    public boolean isAlpha() {
        return isAlpha;
    }
    @Override
    public void setAlpha(boolean alpha) {
        isAlpha = alpha;
    }
}
