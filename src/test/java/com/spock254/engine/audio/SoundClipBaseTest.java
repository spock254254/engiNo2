package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.fest.assertions.*;


class SoundClipBaseTest {

    private ISoundClipBase soundClipBase;
    private final String validPath = "/res/audio/standart.wav";
    private final String invalidPath = "invalidPath";

    @BeforeEach
    void setUp() {
        soundClipBase = new SoundClipBase(validPath);
    }

    @AfterEach
    void tearDown() {
        soundClipBase = null;
    }
    @Test
    public void constructor_validPath_getPath(){

        ISoundClipBase soundClipBaseValid = new SoundClipBase(validPath);
        Assertions.assertThat(soundClipBaseValid.getPath())
                .isSameAs(validPath);
    }
    @Test
    public void constructor_invalidPath_throwIllegalArgumentException(){


        try{
            ISoundClipBase soundClipBaseInvalid = new SoundClipBase(invalidPath);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("invalid path");
        }
    }
    @Test
    public void constructor_invalidPathWithWavExtension_throwIllegalArgumentException(){
        String invalidPathWithExt = invalidPath + ".wav";

        try{
            ISoundClipBase soundClipBaseInvalid = new SoundClipBase(invalidPathWithExt);
        }catch (NullPointerException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs(null);
        }
    }
    @Test
    public void constructor_nullAndEmptyPath_throwIllegalArgumentException(){

        try{
            ISoundClipBase soundClipBaseInvalid = new SoundClipBase(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("sound clip can't be null or empty");
        }
        try{
            ISoundClipBase soundClipBaseInvalid = new SoundClipBase("");
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("sound clip can't be null or empty");
        }
    }
    @Test
    public void setPath_validPath_getPath(){
        String newValidPath = "validPath.wav";
        soundClipBase.setPath(newValidPath);
        Assertions.assertThat(newValidPath)
                .isSameAs(soundClipBase.getPath());
    }
    @Test
    public void setPath_nullAndEmptyPath_throwIllegalArgumentException(){
        try{
            soundClipBase.setPath(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("path can't be null or empty");
        }
        try{
            soundClipBase.setPath("");
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("path can't be null or empty");
        }
    }
    @Test
    public void getPath_validObject_getValidPath(){
        Assertions.assertThat(validPath)
                .isSameAs(soundClipBase.getPath());
    }
    //TODO :  expected same instance but found:<50.0> and:<50.0>
    @Test
    public void getVolume_setValidVolume_getValidVolume(){
        final double VOLUME = 50;
        soundClipBase.setVolume(VOLUME);
        Assertions.assertThat(VOLUME)
                .isSameAs(soundClipBase.getVolume());
    }

}