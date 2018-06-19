package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageTile;
import com.spock254.engine.interfaces.gfx.IImageTile;

import java.io.IOException;

public class ImageTile extends Image implements IImageTile {

    int tileW, tileH;

    public ImageTile(String path,int tileW,int tileH) throws IOException {
        super(path);
        this.tileH = tileH;
        this.tileW = tileW;
    }
    @Override
    public int getTileW() {
        return tileW;
    }
    @Override
    public void setTileW(int tileW) {
        this.tileW = tileW;
    }
    @Override
    public int getTileH() {
        return tileH;
    }
    @Override
    public void setTileH(int tileH) {
        this.tileH = tileH;
    }
}
