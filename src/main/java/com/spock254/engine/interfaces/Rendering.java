package com.spock254.engine.interfaces;

import com.spock254.engine.Renderer;
import com.spock254.engine.gfx.Image;
import com.spock254.engine.gfx.ImageTile;

public interface Rendering {

    public void clear();
    public void setPixel(int x,int y,int value);
   // public void process(); //TODO : have to deal with it...=(
    //public boolean isDapth(Renderer renderer);

    public int getpH();
    public void setpH(int pH);
    public int getpW();
    public void setpW(int pW);
    public int[] getP();
    public void setP(int[] p);
    public int getzDapth();
    public void setzDapth(int zDapth);
}
