package com.spock254.engine.interfaces.anim;

public interface IAnimation {
    public void startAnim(int frames);
    public void reset();
    public void stop();
    public boolean isRunning();

}
