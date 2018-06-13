package com.spock254.engine.draw;

import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingImage;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.interfaces.draw.IDrawingImage;
import com.spock254.engine.interfaces.gfx.IImage;

public class ImageDraw extends Renderer implements IDrawingImage {

    private IImage image;

    public ImageDraw(Kernel gc, IImage image){
        super(gc);
        this.image = image;
    }

    @Override
    public void drawImage(int offX, int offY) {

        // don't render
        if(offX < -image.getWidth()) return;
        if(offY < -image.getHeight()) return;
        if(offX >= super.getpW()) return;
        if(offY >= super.getpH()) return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();

        if(offX < 0) newX -= offX;
        if(offY < 0) newY -= offY;
        if(newWidth + offX > super.getpW()) newWidth -= (newWidth + offX - super.getpW());// stop render out of screen x
        if(newHeight + offY > super.getpH()) newHeight -= (newHeight + offY - super.getpH());// stop render out of screen y


        for(int y = newX;y < newHeight;y++){
            for (int x = newY;x < newWidth;x++){
                setPixel(x + offX,y + offY,image.getPixels()[x + y * image.getWidth()]);
            }
        }
    }
}
