package com.spock254.engine.interfaces.ui.button;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;

public interface IUIBasic {

    public void drawBasicUI();
    public IDrawingShape getBaseShape();
    public void setBaseShape(IDrawingShape shape);
    public IDrawingShape getUpperShape();
    public void setUpperShape(IDrawingShape shape);
    public IDrawingText getText();
    public void setText(IDrawingText text);
    public Kernel getKernel();
    public void setKernel(Kernel kernel);
    public int getBaseOffX();
    public void setBaseOffX(int offx);
    public int getBaseOffY();
    public void setBaseOffY(int offy);
    public int getBaseW();
    public void setBaseW(int w);
    public int getBaseH();
    public void setBaseH(int h);
    public int getBasColor();
    public void setBaseColor(int color);
    public String getButtonText();
    public void setButtonText(String buttonText);
    public int getUpperOffX();
    public void setUpperOffX(int offx);
    public int getUpperOffY();
    public void setUpperOffY(int offy);
    public int getUpCollor();
    public void setUpColor(int color);
    public int getUpperW();
    public void setUpperW(int w);
    public int getUpperH();
    public void setUpperH(int h);
    public int getActionValue();
    public void setActionValue(int value);
}
