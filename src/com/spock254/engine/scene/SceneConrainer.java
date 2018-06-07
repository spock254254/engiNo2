package com.spock254.engine.scene;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.interfaces.scene.ISceneConrainer;

import java.util.Map;

public class SceneConrainer implements ISceneConrainer {

    public static String CURRENT_SCENE = "1";
    private Map<String,AbstractGame> scenes;

    public SceneConrainer(Map<String,AbstractGame> scenes){
        this.scenes = scenes;
    }

    @Override
    public AbstractGame getScene(String scene){
        return scenes.get(scene);
    }
    @Override
    public void addScene(String scene,AbstractGame abstractGame){
        scenes.put(scene,abstractGame);
    }
    @Override
    public void removeScene(String scene){
        scenes.remove(scene);
    }
    @Override
    public Map<String, AbstractGame> getScenes() {
        return scenes;
    }
}
