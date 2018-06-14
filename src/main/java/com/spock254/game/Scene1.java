package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.Kernel;
import com.spock254.engine.Renderer;
import com.spock254.engine.audio.SoundClipBase;
import com.spock254.engine.draw.RectFilledDraw;
import com.spock254.engine.draw.CircleFillDraw;
import com.spock254.engine.helper.Math;
import com.spock254.engine.interfaces.draw.IDrawingShape;
import com.spock254.engine.interfaces.ui.IUIObject;
import com.spock254.engine.ui.ColorTable;
import com.spock254.engine.ui.UIColor;
import com.spock254.engine.ui.slider.Sliedr;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Scene1 extends AbstractGame {

    IUIObject slider;
    IDrawingShape line;
    IDrawingShape button;

    SoundClipBase soundClipBase;

    @Override
    public void setUp(Kernel kernel) {

        line = new RectFilledDraw(kernel);
        button = new CircleFillDraw(kernel);

        slider = new Sliedr(kernel,line,button,50,50,50,
                new UIColor(ColorTable.darkred),new UIColor(ColorTable.firebrick),null);
        System.out.print(Math.normalize(4,66,0,100,50));

            soundClipBase = new SoundClipBase("res/audio/standart.wav");

        soundClipBase.play();

    }

    @Override
    public void update(Kernel kernel, float deltaTime) {
        slider.action();
        soundClipBase.setVolume((double) slider.getActionValue()/100);
        if(kernel.getInput().isKeyDown(KeyEvent.VK_A)){
            soundClipBase.getAudioClip().stop();
            soundClipBase.play();
        }


    }

    @Override
    public void render(Kernel kernel, Renderer renderer) {
        slider.draw();
    }
}
