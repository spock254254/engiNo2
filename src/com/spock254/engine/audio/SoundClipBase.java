package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import javafx.scene.media.AudioClip;

public class SoundClipBase implements ISoundClipBase {

    AudioClip audioClip;
    String path;


    public SoundClipBase(String path){
        setPath(path);
        audioClip = new AudioClip(getClass().getResource(path).toString());

    }
    @Override
    public void play(){
        audioClip.play();
    }
    @Override
    public void setVolume(double volume){

        audioClip.setVolume(volume);
    }
    @Override
    public void stop(){
        audioClip.stop();
    }
    @Override
    public boolean isPlaying(){
        return audioClip.isPlaying();
    }

    @Override
    public double getVolume() {
        return  audioClip.getVolume();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //TODO temp method
    public AudioClip getAudioClip(){
        return audioClip;
    }
}
