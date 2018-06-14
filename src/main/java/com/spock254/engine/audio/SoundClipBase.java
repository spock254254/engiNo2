package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import com.spock254.engine.interfaces.audio.ISoundClipBase;
import javafx.scene.media.AudioClip;
import com.spock254.engine.interfaces.audio.ISoundClipBase;

import java.io.FileNotFoundException;

public class SoundClipBase implements ISoundClipBase {

    private AudioClip audioClip;
    private String path;


    public SoundClipBase(String path){
        if(path == null || path.isEmpty())
            throw new IllegalArgumentException("sound clip can't be null or empty");
        setPath(path);
        audioClip = new AudioClip(getClass().getResource(path).toString());
    }

    @Override
    public void play(){
        if(audioClip == null)
            throw new NullPointerException("audioClip is null");
        audioClip.play();
    }
    @Override
    public void setVolume(double volume){
        if(volume >= 0 && volume <= 100)
            audioClip.setVolume(volume);
        else
            audioClip.setVolume(0);
    }
    @Override
    public boolean stop(){
        if(audioClip == null)
            throw new NullPointerException("audioClip is null");
        if(audioClip.isPlaying()){
            audioClip.stop();
            return true;
        }
        return false;
    }
    @Override
    public boolean isPlaying(){
        if(audioClip == null)
            throw new NullPointerException("audioClip is null");
        return audioClip.isPlaying();

    }

    @Override
    public double getVolume() {
        if(audioClip == null)
            throw new NullPointerException("audioClip is null");
        return  audioClip.getVolume();
    }
    @Override
    public String getPath() {
        return path;
    }
    @Override
    public void setPath(String path) {
        if(path == null || path.isEmpty())
            throw new IllegalArgumentException("path can't be null or empty");
        else if(path.endsWith(".wav"))
            this.path = path;
        else
            throw new IllegalArgumentException("invalid path");
    }

    //TODO temp method
    public AudioClip getAudioClip(){
        return audioClip;
    }
}
