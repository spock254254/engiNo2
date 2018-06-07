package com.spock254.engine.interfaces.scene;

import com.spock254.engine.AbstractGame;

import java.util.Map;

public interface ISceneConrainer {

    public AbstractGame getScene(String scene);
    public void addScene(String scene,AbstractGame abstractGame);
    public void removeScene(String scene);
    public Map<String, AbstractGame> getScenes();
}
