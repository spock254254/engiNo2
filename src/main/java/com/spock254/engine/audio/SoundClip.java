package com.spock254.engine.audio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SoundClip {

    private Clip clip = null;
    private FloatControl gainControl;



    public SoundClip(String path){


        //TODO : invalid format

        try {
            InputStream audioSrc = SoundClip.class.getResourceAsStream(path);
            InputStream bufferedin = new BufferedInputStream(audioSrc);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedin);
            AudioFormat baseFormat = audioInputStream.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                                                      baseFormat.getSampleRate(),
                                                      16,
                                                      baseFormat.getChannels(),
                                                      baseFormat.getChannels() * 2,
                                                      baseFormat.getSampleRate(),
                                                      false);
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,audioInputStream);

            clip = AudioSystem.getClip();
            clip.open(dais);

            gainControl = (FloatControl)clip.getControl(FloatControl.Type.VOLUME);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }



    public void play(){

        if(clip == null)
            return;

        stop();
        clip.setFramePosition(0);
        while (!clip.isRunning())
        {
            clip.start();
        }
    }
    public void stop(){

        if(clip.isRunning())
            clip.stop();
    }
    public void close(){
        stop();
        clip.drain();
        clip.close();
    }
    public void loop(){

        clip.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }
    public void setVolum(float value){

        gainControl.setValue(value);
    }
    public boolean isRunning(){

        return clip.isRunning();
    }
}
