package com.spock254.engine;

import java.awt.event.*;

public class Input implements KeyListener,MouseListener,MouseMotionListener,MouseWheelListener {

    private Kernel kernel;

    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

    public Input(Kernel kernel)
    {
        this.kernel = kernel;
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        kernel.getWindow().getCanvas().addKeyListener(this);
        kernel.getWindow().getCanvas().addMouseListener(this);
        kernel.getWindow().getCanvas().addMouseMotionListener(this);
        kernel.getWindow().getCanvas().addMouseWheelListener(this);
    }
    public void update(){

        scroll = 0;

        for(int i = 0;i < NUM_KEYS;i++){
            keysLast[i] = keys[i];
        }
        for(int i = 0;i < NUM_BUTTONS;i++){
            buttonsLast[i] = buttons[i];
        }
    }
    // key INPUT
    public boolean isKey(int keyCode){
        return keys[keyCode];
    }
    public boolean isKeyUp(int keyCode){
        return !keys[keyCode] && keysLast[keyCode];
    }
    public boolean isKeyDown(int keyCode){
        return keys[keyCode] && !keysLast[keyCode];
    }

    //buttons INPUT
    public boolean isButton(int keyCode){
        return buttons[keyCode];
    }
    public boolean isButtonUp(int keyCode){
        return !buttons[keyCode] && buttonsLast[keyCode];
    }
    public boolean isButtonDown(int keyCode){
        return buttons[keyCode] && !buttonsLast[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

        keys[keyEvent.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

        buttons[mouseEvent.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        buttons[mouseEvent.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

        mouseX = (int) (mouseEvent.getX() / kernel.getScale());
        mouseY = (int) (mouseEvent.getY() / kernel.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        mouseX = (int) (mouseEvent.getX() / kernel.getScale());
        mouseY = (int) (mouseEvent.getY() / kernel.getScale());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        scroll = mouseWheelEvent.getWheelRotation();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getScroll() {
        return scroll;
    }
}
