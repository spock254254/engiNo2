package com.spock254.engine.interfaces.ui;

import com.spock254.engine.interfaces.ui.button.IUIBasic;
import com.spock254.engine.ui.UIColor;

public interface IUIObject extends IUIBasic {
    public void action();
    public void draw();
    public boolean isHover();
    public void setButtonUIObjectFunction(UIObjectFunction uiObjectFunction);
    public UIObjectFunction getButtonUIObjectFunction();

    public UIColor getBaseColor();
    public void setBaseColor(UIColor color);
    public UIColor getUpperColor();
    public void setUpperColor(UIColor color);
}
