package com.spock254.engine.interfaces.audio;

public interface ISoundClipBase {

    public void play();
    public void setVolume(double volume);
    public void stop();
    public boolean isPlaying();
    public double getVolume();

}
