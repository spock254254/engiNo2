package com.spock254.game;

import com.spock254.engine.AbstractGame;
import com.spock254.engine.Kernel;
import com.spock254.engine.interfaces.scene.ISceneConrainer;
import com.spock254.engine.scene.SceneConrainer;
import java.util.HashMap;
import java.util.Map;

public class GameManager  {


    public static void main(String[] args){

        Map<String,AbstractGame> abstractGameDictionary = new HashMap<>();
        abstractGameDictionary.put("1",new Scene1());
        abstractGameDictionary.put("2",new Scene2());
        SceneConrainer.CURRENT_SCENE = "1";


        ISceneConrainer sceneConrainer = new SceneConrainer(abstractGameDictionary);

        Kernel gc = new Kernel(sceneConrainer);
        gc.start();
    }
}
