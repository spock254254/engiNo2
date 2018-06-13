package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageRequest;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageRequest;

public class ImageRequest implements IImageRequest {

    private IImage image;
    private int zDepth;
    private int offX, offY;

    public ImageRequest(IImage image,int zDepth,int offX,int offY){

        this.image = image;
        this.zDepth = zDepth;
        this.offX = offX;
        this.offY = offY;

    }
    @Override
    public IImage getImage() {
        return image;
    }
    @Override
    public void setImage(IImage image) {
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
}
