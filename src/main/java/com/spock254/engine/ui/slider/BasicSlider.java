package com.spock254.engine.ui.slider;

import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.button.IUIBasic;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.draw.IDrawingText;
import com.spock254.engine.interfaces.ui.button.IUIBasic;
import com.spock254.engine.ui.UIColor;

public class BasicSlider implements IUIBasic {

    private Kernel kernel;
    private IDrawingShape sliderLine;
    private IDrawingShape sliderButton;
    private int offXline;
    private int offYline;
    private int offXButton;
    private int offYButton;
    private int lineW;
    private int lineH;
    private int buttonW;
    private int buttonH;
    private UIColor sliderLineColor;
    private UIColor sliderButtonColor;


    public BasicSlider(Kernel kernel, IDrawingShape sliderLine, IDrawingShape sliderButton,
                       int offXline, int offYline, int offXButton, int offYButton,
                       int lineW, int lineH, int buttonW, int buttonH,
                       UIColor sliderLineColor, UIColor sliderButtonColor) {
        this.kernel = kernel;
        this.sliderLine = sliderLine;
        this.sliderButton = sliderButton;
        this.offXline = offXline;
        this.offYline = offYline;
        this.offXButton = offXButton;
        this.offYButton = offYButton;
        this.lineW = lineW;
        this.lineH = lineH;
        this.buttonW = buttonW;
        this.buttonH = buttonH;
        this.sliderLineColor = sliderLineColor;
        this.sliderButtonColor = sliderButtonColor;
    }

    public BasicSlider(Kernel kernel, IDrawingShape sliderLine, IDrawingShape sliderButton,
                       int offXline, int offYline, int lineW,
                       UIColor sliderLineColor, UIColor sliderButtonColor) {
        this.sliderLineColor = sliderLineColor;
        this.sliderButtonColor = sliderButtonColor;
        this.lineW = lineW;
        this.kernel = kernel;
        this.sliderLine = sliderLine;
        this.sliderButton = sliderButton;
        this.offXline = offXline;
        this.offYline = offYline;
        this.offXButton = offXline + (lineW / 2);
        this.lineH = (int)(lineW / 10);
        this.buttonW = lineH * 2;
        this.buttonH = lineH * 2;
        this.offYButton = offYline + (lineH / 2);


    }
    @Override
    public void drawBasicUI(){
        sliderLine.drawShape(offXline,offYline,lineW,lineH,sliderLineColor.getBaseColor());
        sliderButton.drawShape(offXButton,offYButton,buttonW,buttonH,sliderButtonColor.getBaseColor());
    }

    @Override
    public IDrawingShape getBaseShape() {
        return this.sliderLine;
    }

    @Override
    public void setBaseShape(IDrawingShape shape) {
        this.sliderLine = shape;
    }

    @Override
    public IDrawingShape getUpperShape() {
        return this.sliderButton;
    }

    @Override
    public void setUpperShape(IDrawingShape shape) {
        this.sliderButton = shape;
    }

    @Override
    public IDrawingText getText() {
        return null; // not need// TODO : throw exception
    }

    @Override
    public void setText(IDrawingText text) {
                    // not need// TODO : throw exception
    }

    @Override
    public Kernel getKernel() {
        return this.kernel;
    }

    @Override
    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public int getBaseOffX() {
        return this.offXline;
    }

    @Override
    public void setBaseOffX(int offx) {
        this.offXline = offx;
    }

    @Override
    public int getBaseOffY() {
        return this.offYline;
    }

    @Override
    public void setBaseOffY(int offy) {
        this.offYline = offy;
    }

    @Override
    public int getBaseW() {
        return this.lineW;
    }

    @Override
    public void setBaseW(int w) {
        this.lineW = w;
    }

    @Override
    public int getBaseH() {
        return this.lineH;
    }

    @Override
    public void setBaseH(int h) {
        this.lineH = h;
    }

    @Override
    public int getBasColor() {
        return this.sliderLineColor.getBaseColor();
    }

    @Override
    public void setBaseColor(int color) {
        this.sliderLineColor.setBaseColor(color);
    }

    @Override
    public String getButtonText() {
        return null; // TODO : throw exception
    }

    @Override
    public void setButtonText(String buttonText) {
        // TODO : throw exception
    }

    @Override
    public int getUpperOffX() {
        return this.offXButton;
    }

    @Override
    public void setUpperOffX(int offx) {
        this.offXButton = offx;
    }

    @Override
    public int getUpperOffY() {
        return this.offYButton;
    }

    @Override
    public void setUpperOffY(int offy) {
        this.offYButton = offy;
    }

    @Override
    public int getUpCollor() {
        return this.sliderButtonColor.getBaseColor();
    }

    @Override
    public void setUpColor(int color) {
        this.sliderButtonColor.setBaseColor(color);
    }

    @Override
    public int getUpperW() {
        return this.buttonW;
    }

    @Override
    public void setUpperW(int w) {
        this.buttonW = buttonW;
    }

    @Override
    public int getUpperH() {
        return this.buttonH;
    }

    @Override
    public void setUpperH(int h) {
        this.buttonH = h;
    }

    @Override
    public int getActionValue() {
        return 0;// TODO : fix base behavior
    }

    @Override
    public void setActionValue(int value) {
        // TODO : fix base behavior
    }

    protected UIColor getSliderLineColor() {
        return sliderLineColor;
    }

    protected void setSliderLineColor(UIColor sliderLineColor) {
        this.sliderLineColor = sliderLineColor;
    }

    protected UIColor getSliderButtonColor() {
        return sliderButtonColor;
    }

    protected void setSliderButtonColor(UIColor sliderButtonColor) {
        this.sliderButtonColor = sliderButtonColor;
    }
}
