package com.spock254.engine;

import com.spock254.engine.gfx.Font;
import com.spock254.engine.interfaces.Rendering;

import java.awt.image.DataBufferInt;

public class Renderer implements Rendering {

    private final int MAX_ALPHA = 255;
    private Font font = Font.STANDART;

    private int pH,pW;
    private int[] p;
    private int[] zb;
    private  int zDapth = 0;


    public Renderer(Kernel gc){
        pH = gc.getHeight();
        pW = gc.getWidth();
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
        zb = new int[p.length];
    }
    @Override
    public void clear(){
        for (int i = 0;i < p.length;i++){
            p[i] = 0;
            zb[i] = 0;
        }

    }

    @Override
    public void setPixel(int x,int y,int value){

        int alpha = ((value >> 24) & 0xff);

        if((x < 0 || x >= pW || y < 0 || y >= pH) || alpha == 0)
            return;
        if(zb[x + y * pW] > zDapth)
            return;


        if(alpha == MAX_ALPHA){
            p[x + y * pW] = value; //set pix from two dem to one dem
        }else {

            int pixelColor = p[x + y * pW];

            int newRed = ((pixelColor >> 16) & 0xff) - (int)((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
            int newGreen = ((pixelColor >> 8) & 0xff) - (int)((((pixelColor >> 8) & 0xff) - ((value >> 8) & 0xff)) * (alpha / 255f));
            int newBlue = (pixelColor & 0xff) - (int)(((pixelColor & 0xff) - (value & 0xff)) * (alpha / 255f));

            p[x + y * pW] = (255 << 24 | newRed << 16 | newGreen << 8 | newBlue);
        }

    }


    @Override
    public int getpH() {
        return pH;
    }
    @Override
    public void setpH(int pH) {
        this.pH = pH;
    }
    @Override
    public int getpW() {
        return pW;
    }
    @Override
    public void setpW(int pW) {
        this.pW = pW;
    }
    @Override
    public int[] getP() {
        return p;
    }
    @Override
    public void setP(int[] p) {
        this.p = p;
    }
    @Override
    public int getzDapth() {
        return zDapth;
    }
    @Override
    public void setzDapth(int zDapth) {
        this.zDapth = zDapth;
    }


    }


