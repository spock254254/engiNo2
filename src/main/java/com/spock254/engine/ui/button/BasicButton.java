package com.spock254.engine.ui.button;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.button.IUIBasic;
import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.button.IUIBasic;

public class BasicButton implements IUIBasic {

    private IDrawingShape shape;
    private IDrawingText text;
    private Kernel kernel;
    private int buttonOffX;
    private int buttonOffY;
    private int buttonW;
    private int buttonH;
    private int buttonColor;
    private String buttonText;
    private int textOffX,textOffY;
    private int textColor;


    public BasicButton(Kernel gc, IDrawingShape shape, IDrawingText text,
                       int buttonOffX, int buttonOffY, int buttonW, int buttonH, int buttonColor,
                       String buttonText, int textOffX, int textOffY, int textColor) {
        this.kernel = gc;
        this.shape = shape;
        this.text = text;
        this.buttonOffX = buttonOffX;
        this.buttonOffY = buttonOffY;
        this.buttonW = buttonW;
        this.buttonH = buttonH;
        this.buttonColor = buttonColor;
        this.buttonText = buttonText;
        this.textOffX = textOffX;
        this.textOffY = textOffY;
        this.textColor = textColor;
    }
    public BasicButton(Kernel gc, IDrawingShape shape, IDrawingText text,
                       int buttonOffX, int buttonOffY, int buttonW, int buttonH, int buttonColor,
                       String buttonText, int textColor) {
        this.kernel = gc;
        this.shape = shape;
        this.text = text;
        this.buttonOffX = buttonOffX;
        this.buttonOffY = buttonOffY;
        this.buttonW = buttonW;
        this.buttonH = buttonH;
        this.buttonColor = buttonColor;
        this.buttonText = buttonText;
        this.textOffX = ((buttonW - text.getFont().getTextPixelWeight(buttonText)) / 2) + buttonOffX;
        this.textOffY = ((buttonH / 2) - (text.getFont().getTextPixelHeight(buttonText)) / 2) + buttonOffY; // TODO
        this.textColor = textColor;
    }

    @Override
    public void drawBasicUI(){

        shape.drawShape(buttonOffX,buttonOffY,buttonW,buttonH,buttonColor);
        text.drawText(buttonText,textOffX,textOffY,textColor);
    }

    @Override
    public IDrawingShape getBaseShape() {
        return shape;
    }
    @Override
    public void setBaseShape(IDrawingShape shape) {
        this.shape = shape;
    }

    @Override
    public IDrawingShape getUpperShape() {
        System.out.println("NOT NEED INIT FOR THIS OBJ");
        return null;
    }

    @Override
    public void setUpperShape(IDrawingShape shape) {
        System.out.println("NOT NEED INIT FOR THIS OBJ");
    }

    @Override
    public IDrawingText getText() {
        return text;
    }
    @Override
    public void setText(IDrawingText text) {
        this.text = text;
    }
    @Override
    public Kernel getKernel() {
        return kernel;
    }
    @Override
    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }
    @Override
    public int getBaseOffX() {
        return buttonOffX;
    }
    @Override
    public void setBaseOffX(int offx) {
        this.buttonOffX = offx;
    }
    @Override
    public int getBaseOffY() {
        return buttonOffY;
    }
    @Override
    public void setBaseOffY(int offy) {
        this.buttonOffY = offy;
    }
    @Override
    public int getBaseW() {
        return buttonW;
    }
    @Override
    public void setBaseW(int w) {
        this.buttonW = w;
    }
    @Override
    public int getBaseH() {
        return buttonH;
    }
    @Override
    public void setBaseH(int h) {
        this.buttonH = h;
    }
    @Override
    public int getBasColor() {
        return buttonColor;
    }
    @Override
    public void setBaseColor(int color) {
        this.buttonColor = color;
    }
    @Override
    public String getButtonText() {
        return buttonText;
    }
    @Override
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
    @Override
    public int getUpperOffX() {
        return textOffX;
    }
    @Override
    public void setUpperOffX(int offx) {
        this.textOffX = offx;
    }
    @Override
    public int getUpperOffY() {
        return textOffY;
    }
    @Override
    public void setUpperOffY(int offy) {
        this.textOffY = offy;
    }
    @Override
    public int getUpCollor() {
        return textColor;
    }
    @Override
    public void setUpColor(int color) {
        this.textColor = color;
    }

    @Override
    public int getUpperW() {
        return text.getFont().getTextPixelHeight(buttonText);
    }

    @Override
    public void setUpperW(int w) {
        // TODO : throw exception
    }

    @Override
    public int getUpperH() {
        return text.getFont().getTextPixelWeight(buttonText);
    }

    @Override
    public void setUpperH(int h) {
        // TODO : throw exception
    }

    @Override
    public int getActionValue() {
        return 0;// TODO : fix base behavior
    }

    @Override
    public void setActionValue(int value) {
        // TODO : fix base behavior
    }
}
