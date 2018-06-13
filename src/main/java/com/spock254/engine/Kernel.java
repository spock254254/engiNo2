package com.spock254.engine;

import com.spock254.engine.interfaces.scene.ISceneConrainer;
import com.spock254.engine.save.SavingSystem;
import com.spock254.engine.scene.SceneConrainer;


import java.util.Set;

public class Kernel implements Runnable{

    private Thread tread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame abstractGame;
    private boolean isRunning = false;
    private final double UPDATE_CAP = 1.0/60.0;
    private int width = 320;
    private int height = 240;
    private float scale = 2f;
    private String title = "engineNo";
    private int fps;
    private ISceneConrainer sceneConrainer;
    private SavingSystem savingSystem;

    public Kernel(){

    }

    public Kernel(AbstractGame abstractGame) {

        this.abstractGame = abstractGame;
    }
    public Kernel(ISceneConrainer sceneConrainer){

        this.sceneConrainer = sceneConrainer;

    }

    public void start(){

        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        savingSystem = new SavingSystem();

        if(sceneConrainer != null){ // init all scenes in game

            Set<String> keys = sceneConrainer.getScenes().keySet();

            for (String key : keys)
              sceneConrainer.getScene(key).setUp(this);

        }
        else
            abstractGame.setUp(this); // if just one scene in game


        tread = new Thread(this);
        tread.run();
    }

    public void stop(){

    }

    @Override
    public void run() {

        isRunning = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        fps = 0;

        while (isRunning){
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP){

                unprocessedTime -= UPDATE_CAP;
                render = true;

                if(sceneConrainer != null)
                    sceneConrainer.getScene(SceneConrainer.CURRENT_SCENE).update(this,(float)UPDATE_CAP); //TODO :
                else
                abstractGame.update(this,(float)UPDATE_CAP);

                input.update();



                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    //System.out.println("FPS : "+fps);
                }
            }
            if(render)
            {
                renderer.clear();


                if(sceneConrainer != null)
                    sceneConrainer.getScene(SceneConrainer.CURRENT_SCENE).render(this,renderer);
                else
                    abstractGame.render(this,renderer);

                window.update();
                frames++;
            }else {
                try{
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose(){
        System.out.println("dispose");
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }

    public int getFps(){ return fps; }

    public boolean isRunning() { return isRunning; }

    public void setRunning(boolean running) { isRunning = running; }

    public SavingSystem getSavingSystem() {
        return savingSystem;
    }
}
