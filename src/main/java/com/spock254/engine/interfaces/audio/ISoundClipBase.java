package com.spock254.engine.interfaces.audio;

import java.io.FileNotFoundException;

public interface ISoundClipBase {

    public void play();
    public void setVolume(double volume);
    public boolean stop();
    public boolean isPlaying();
    public double getVolume();
    public String getPath();
    public void setPath(String path);
}
