package com.spock254.engine.draw.order;

import com.spock254.engine.interfaces.draw.order.IOrderDrawImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderImageContainer {
    //TODO : implement interface
    private ArrayList<IOrderDrawImage> images = new ArrayList<>();

    public void OrderDraw(){

    }

    public void add(IOrderDrawImage image){
        images.add(image);
    }

    public void sort(){
        Collections.sort(images, new Comparator<IOrderDrawImage>(){
            public int compare(IOrderDrawImage o1, IOrderDrawImage o2){
                if(o1.getIDrawingImage().getzDapth() == o2.getIDrawingImage().getzDapth())
                    return 0;
                return o1.getIDrawingImage().getzDapth() < o2.getIDrawingImage().getzDapth() ? -1 : 1;
            }
        });

    }

    public void draw(){
        for(IOrderDrawImage offSetDrawManager : images)
            offSetDrawManager.getIDrawingImage().drawImage(offSetDrawManager.getOffX(),offSetDrawManager.getOffY());
    }
}
