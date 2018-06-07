package com.spock254.engine.ui.slider;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.ui.UIObjectFunction;
import com.spock254.engine.interfaces.ui.IUIObject;
import com.spock254.engine.ui.UIColor;
import java.awt.event.MouseEvent;

public class Sliedr extends BasicSlider implements IUIObject {


    private UIObjectFunction uiObjectFunction;
    private int actionValue;

    private final double RANGE_COEFFICIENT;

    public Sliedr(Kernel kernel, IDrawingShape sliderLine, IDrawingShape sliderButton,
                  int offXline, int offYline, int offXButton, int offYButton,
                  int lineW, int lineH, int buttonW, int buttonH,
                  UIColor sliderLineColor, UIColor sliderButtonColor,
                  UIObjectFunction uiObjectFunction) {

        super(kernel, sliderLine, sliderButton, offXline, offYline,
                offXButton, offYButton, lineW, lineH, buttonW,
                buttonH, sliderLineColor, sliderButtonColor);

        this.uiObjectFunction = uiObjectFunction;
        RANGE_COEFFICIENT = 100 / super.getBaseW();

    }

    public Sliedr(Kernel kernel, IDrawingShape sliderLine, IDrawingShape sliderButton,
                  int offXline, int offYline, int lineW,
                  UIColor sliderLineColor, UIColor sliderButtonColor,
                  UIObjectFunction uiObjectFunction) {
        super(kernel, sliderLine, sliderButton, offXline,
                offYline, lineW, sliderLineColor, sliderButtonColor);

        this.uiObjectFunction = uiObjectFunction;
        RANGE_COEFFICIENT = 100 / super.getBaseW();
    }


    @Override
    public void action() {
        if(isHover() && super.getKernel().getInput().isButton(MouseEvent.BUTTON1)){

            int valueInRange = (super.getUpperOffX() - super.getBaseOffX()) * (int) RANGE_COEFFICIENT;
            if(valueInRange == (int) RANGE_COEFFICIENT)
                valueInRange = 0;

            super.setUpperOffX(super.getKernel().getInput().getMouseX());
            this.setActionValue(valueInRange);
            if(this.uiObjectFunction != null)
                this.uiObjectFunction.click();
        }

    }

    @Override
    public void draw() {
        super.drawBasicUI();

    }

    @Override
    public boolean isHover() {
        return (super.getBaseOffX() <= super.getKernel().getInput().getMouseX()
                && (super.getBaseOffX()+super.getBaseW()) >= super.getKernel().getInput().getMouseX()
                && super.getBaseOffY() <= super.getKernel().getInput().getMouseY()
                && (super.getBaseOffY() + super.getBaseH() >= super.getKernel().getInput().getMouseY()));
    }

    @Override
    public void setButtonUIObjectFunction(UIObjectFunction uiObjectFunction) {
        this.uiObjectFunction = uiObjectFunction;
    }

    @Override
    public UIObjectFunction getButtonUIObjectFunction() {
        return this.uiObjectFunction;
    }

    @Override
    public UIColor getBaseColor() {
        return super.getSliderLineColor();
    }

    @Override
    public void setBaseColor(UIColor color) {
        super.setSliderLineColor(color);
    }

    @Override
    public UIColor getUpperColor() {
        return super.getSliderButtonColor();
    }

    @Override
    public void setUpperColor(UIColor color) {
        super.setSliderButtonColor(color);
    }

    @Override
    public int getActionValue() {
        return actionValue;
    }

    @Override
    public void setActionValue(int actionValue) {
        this.actionValue = actionValue;
    }
}
