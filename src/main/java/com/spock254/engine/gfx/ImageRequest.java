package com.spock254.engine.gfx;

import com.spock254.engine.helper.ScreenSize;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageRequest;

public class ImageRequest implements IImageRequest {

    private IImage image;
    private int zDepth;
    private int offX, offY;

    public ImageRequest(IImage image,int zDepth,int offX,int offY){
        if(image == null)
            throw new IllegalArgumentException("image is null");
        setImage(image);
        setzDepth(zDepth);
        setOffX(offX);
        setOffY(offY);

    }
    @Override
    public IImage getImage() {
        return image;
    }
    @Override
    public void setImage(IImage image) {
        if(image == null)
            throw new IllegalArgumentException("image is null");
        this.image = image;
    }
    @Override
    public int getzDepth() {
        return zDepth;
    }
    @Override
    public void setzDepth(int zDepth) {
        this.zDepth = zDepth;
    }
    @Override
    public int getOffX() {
        return offX;
    }
    @Override
    public void setOffX(int offX) {
        if(offX < 0)
            throw new NumberFormatException("offX less then 0");
        if(offX > ScreenSize.getSizeScreen().width)
            throw new NumberFormatException("offX more then screen size");
        this.offX = offX;
    }
    @Override
    public int getOffY() {
        return offY;
    }
    @Override
    public void setOffY(int offY) {
        if(offY < 0)
            throw new NumberFormatException("offY less then 0");
        if(offY > ScreenSize.getSizeScreen().height)
            throw new NumberFormatException("offY more then screen size");
        this.offY = offY;
    }
}
