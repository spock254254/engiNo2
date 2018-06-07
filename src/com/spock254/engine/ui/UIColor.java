package com.spock254.engine.ui;

import com.spock254.engine.interfaces.ui.IUIColor;

public class UIColor implements IUIColor {
    private int baseColor;
    private int hoverColor;
    private int activeColor;
    private int disableColor;

    public UIColor(int baseColor, int hoverColor, int activeColor, int disableColor) {
        this.baseColor = baseColor;
        this.hoverColor = hoverColor;
        this.activeColor = activeColor;
        this.disableColor = disableColor;
    }

    public UIColor(int baseColor, int hoverColor, int activeColor) {
        this.baseColor = baseColor;
        this.hoverColor = hoverColor;
        this.activeColor = activeColor;
    }

    public UIColor(int baseColor, int hoverColor) {
        this.baseColor = baseColor;
        this.hoverColor = hoverColor;
    }

    public UIColor(int baseColor) {
        this.baseColor = baseColor;
    }
    @Override
    public int getBaseColor() {
        return baseColor;
    }
    @Override
    public void setBaseColor(int baseColor) {
        this.baseColor = baseColor;
    }
    @Override
    public int getHoverColor() {
        return hoverColor;
    }
    @Override
    public void setHoverColor(int hoverColor) {
        this.hoverColor = hoverColor;
    }
    @Override
    public int getActiveColor() {
        return activeColor;
    }
    @Override
    public void setActiveColor(int activeColor) {
        this.activeColor = activeColor;
    }
    @Override
    public int getDisableColor() {
        return disableColor;
    }
    @Override
    public void setDisableColor(int disableColor) {
        this.disableColor = disableColor;
    }
}
