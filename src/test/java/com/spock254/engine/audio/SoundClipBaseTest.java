package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.fest.assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;


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

    @Test
    public void getVolume_setValidVolume_getValidVolume(){
        final double VOLUME = 50.0;
        soundClipBase.setVolume(VOLUME);
        Assertions.assertThat(soundClipBase.getVolume())
                .isEqualTo(VOLUME);

    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(doubles = {0,40,100})
    public void setVolume_validVolumeValues_setValidVolume(double volume){

        soundClipBase.setVolume(volume);
        Assertions.assertThat(soundClipBase.getVolume())
                .isEqualTo(volume);
    }
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(doubles = {0,-40,101})
    public void setVolume_invalidVolumeValues_getZero(double volume){
        final double DEFAULT_VOLUME = 0;

        soundClipBase.setVolume(volume);
        Assertions.assertThat(soundClipBase.getVolume())
                .isEqualTo(DEFAULT_VOLUME);
    }

    // TODO : test play method

    @Test
    public void isPlaying_callPlay_getTrue(){

        soundClipBase.play();
        Assertions.assertThat(soundClipBase.isPlaying())
                .isTrue();

    }
    @Test
    public void isPlaying_notCallPlay_getFalse(){

        Assertions.assertThat(soundClipBase.isPlaying())
                .isFalse();
    }

    @Test
    public void stop_audioClipPlaying_getTrue(){
        soundClipBase.play();
        Assertions.assertThat(soundClipBase.stop())
                .isTrue();
    }
    @Test
    public void stop_audioClipNotPlaying_getTrue(){

        Assertions.assertThat(soundClipBase.stop())
                .isFalse();
    }

}