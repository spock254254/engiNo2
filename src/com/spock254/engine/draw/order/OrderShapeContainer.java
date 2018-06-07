package com.spock254.engine.draw.order;

import com.spock254.engine.interfaces.draw.order.IOrderDrawImage;
import com.spock254.engine.interfaces.draw.order.IOrderDrawShape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderShapeContainer {

    private ArrayList<IOrderDrawShape> shapes = new ArrayList<>();

    public void OrderDraw(){

    }

    public void add(IOrderDrawShape image){
        shapes.add(image);
    }

    public void sort(){
        Collections.sort(shapes, new Comparator<IOrderDrawShape>(){
            public int compare(IOrderDrawShape o1, IOrderDrawShape o2){
                if(o1.getDrawingShape().getZDapth() == o2.getDrawingShape().getZDapth())
                    return 0;
                return o1.getDrawingShape().getZDapth() < o2.getDrawingShape().getZDapth() ? -1 : 1;
            }
        });

    }

    public void draw(){
        for(IOrderDrawShape orderDrawShape : shapes)
            orderDrawShape.getDrawingShape().drawShape(orderDrawShape.getOffX()
                                                        ,orderDrawShape.getOffY()
                                                        ,orderDrawShape.getWidth()
                                                        ,orderDrawShape.getHeight()
                                                        ,orderDrawShape.getColor());
    }

}
