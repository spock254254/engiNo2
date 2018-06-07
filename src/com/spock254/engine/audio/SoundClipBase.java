package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import javafx.scene.media.AudioClip;

public class SoundClipBase implements ISoundClipBase {

    AudioClip audioClip;

    public SoundClipBase(String path){

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

    //TODO temp method
    public AudioClip getAudioClip(){
        return audioClip;
    }
}
