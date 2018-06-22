package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image implements IImage {
    private int width, height;
    private int[] pixels;
    private boolean isAlpha = false;

    public Image(String path) throws IOException {
        if (path == null)
            throw new IllegalArgumentException("image path is null");
        if (path.isEmpty())
            throw new IllegalArgumentException("image path is empty");
        BufferedImage image = null;


        image = ImageIO.read(Image.class.getResourceAsStream(path));


        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);

        image.flush();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        if (width < 0)
            throw new IllegalArgumentException("width less then 0");
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        if (height < 0)
            throw new IllegalArgumentException("height less then 0");
        this.height = height;
    }

    @Override
    public int[] getPixels() {
        return pixels;
    }

    @Override
    public void setPixels(int[] pixels) {
        if (pixels == null)
            throw new IllegalArgumentException("pixels array is null");
            if (pixels.length == 0)
                throw new IllegalArgumentException("pixels are empty");


            this.pixels = pixels;

    }
        @Override
        public boolean isAlpha () {
            return isAlpha;
        }
        @Override
        public void setAlpha ( boolean alpha){
            isAlpha = alpha;
        }
    }

