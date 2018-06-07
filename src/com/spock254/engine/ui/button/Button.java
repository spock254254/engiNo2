package com.spock254.engine.ui.button;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.UIObjectFunction;
import com.spock254.engine.interfaces.ui.IUIObject;
import com.spock254.engine.ui.UIColor;

import java.awt.event.MouseEvent;

public class Button extends BasicButton implements IUIObject {


    private UIColor textColor;
    private UIColor btnColor;
    private int initBtnColor;
    private int initTextColor;

    private UIObjectFunction buttonUIObjectFunction;
    private int actionValue;

    public Button(Kernel gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, String buttonText, int textOffX, int textOffY,
                  UIColor textColor, UIColor btnColor, UIObjectFunction buttonUIObjectFunction) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, btnColor.getBaseColor(), buttonText, textOffX, textOffY, textColor.getBaseColor());
        this.textColor = textColor;
        this.btnColor = btnColor;
        initBtnColor = btnColor.getBaseColor();
        initTextColor = textColor.getBaseColor();
        this.buttonUIObjectFunction = buttonUIObjectFunction;
        actionValue = 0;
    }

    public Button(Kernel gc, IDrawingShape shape, IDrawingText text, int buttonOffX, int buttonOffY, int buttonW, int buttonH, String buttonText,
                  UIColor textColor, UIColor btnColor, UIObjectFunction buttonUIObjectFunction) {
        super(gc, shape, text, buttonOffX, buttonOffY, buttonW, buttonH, btnColor.getBaseColor(), buttonText, textColor.getBaseColor());
        this.textColor = textColor;
        this.btnColor = btnColor;
        initBtnColor = btnColor.getBaseColor();
        initTextColor = textColor.getBaseColor();
        this.buttonUIObjectFunction = buttonUIObjectFunction;
        actionValue = 0;
    }
    @Override
    public void setButtonUIObjectFunction(UIObjectFunction uiObjectFunction) {
        this.buttonUIObjectFunction = uiObjectFunction;
    }
    @Override
    public UIObjectFunction getButtonUIObjectFunction() {
        return buttonUIObjectFunction;
    }

    @Override
    public void action(){
        if(isHover() && getKernel().getInput().isButtonUp(MouseEvent.BUTTON1)){
            buttonUIObjectFunction.click();
            setActionValue(1);
        }else
            setActionValue(-1);

    }

    @Override
    public void draw() {
        super.drawBasicUI();

        if(this.isHover()){
            super.setBaseColor(this.btnColor.getHoverColor());
            super.setUpColor(this.textColor.getHoverColor());
            if(isBtnCliced(MouseEvent.BUTTON1)){
                super.setBaseColor(this.btnColor.getActiveColor());
                super.setUpColor(this.textColor.getActiveColor());
            }
        }else {
            super.setBaseColor(initBtnColor);
            super.setUpColor(initTextColor);
        }
    }


    @Override
    public boolean isHover(){
        return (super.getBaseOffX() <= super.getKernel().getInput().getMouseX()
                && (super.getBaseOffX()+super.getBaseW()) >= super.getKernel().getInput().getMouseX()
                && super.getBaseOffY() <= super.getKernel().getInput().getMouseY()
                && (super.getBaseOffY() + super.getBaseH() >= super.getKernel().getInput().getMouseY()));
    }

    private boolean isBtnCliced(int code){
        return (super.getKernel().getInput().isButton(code));
    }
    @Override
    public UIColor getBaseColor(){
        return this.btnColor;
    }
    @Override
    public void setBaseColor(UIColor color){
        this.btnColor = color;
    }
    @Override
    public UIColor getUpperColor(){
        return this.textColor;
    }
    @Override
    public void setUpperColor(UIColor color){
        this.textColor = color;
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
