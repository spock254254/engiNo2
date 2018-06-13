package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.scene.SceneConrainer;
import com.spock254.engine.interfaces.draw.IDrawingShape;

import java.awt.event.MouseEvent;

public class Scene2 extends AbstractGame {

    IDrawingShape circle;

    @Override
    public void setUp(Kernel kernel) {
        circle =  new RectFilledDraw(kernel);
    }

    @Override
    public void update(Kernel kernel, float deltaTime) {
        if(kernel.getInput().isButtonDown(MouseEvent.BUTTON1)){
            SceneConrainer.CURRENT_SCENE = "1";
        }
    }

    @Override
    public void render(Kernel kernel, Renderer renderer) {
        circle.drawShape(70,70,30,30,0xffA4F7A6);
    }
}
