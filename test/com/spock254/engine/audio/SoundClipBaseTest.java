package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class SoundClipBaseTest {


    public Object[] getvalidVolume() { return $(0,34,100); }

    private String validPath = "/res/audio/David_Hilowitz_-_05_-_Solitude.wav";
    private String invalidPath = "invalidAudioClipPath";
    ISoundClipBase soundClipBase;

    //@Before
    @BeforeEach
    public void setUp(){
        soundClipBase = new SoundClipBase(validPath);
    }

    @Test
    public void constructor_SetValidAudioPath(){
        /// Arrange

        /// Act
        ISoundClipBase soundClipBaseCtr = new SoundClipBase(validPath);

        /// Assert
        Assertions.assertThat(soundClipBaseCtr.getPath()).isSameAs(validPath);
    }

    @Test
    public void constructor_SetNullAudioPath_ThrowIllegalArgumentException(){
        /// Arrange

        /// Act
        try{
            ISoundClipBase soundClipBaseCtr = new SoundClipBase(null);
        }catch (IllegalArgumentException ex){
        /// Assert
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("sound clip can't be null or empty");
        }
    }
    @Test
    public void constructor_SetEmptyAudioPath_ThrowIllegalArgumentException(){
        /// Arrange

        /// Act
        try{
            ISoundClipBase soundClipBaseCtr = new SoundClipBase("");
        }catch (IllegalArgumentException ex){
            /// Assert
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("sound clip can't be null or empty");
        }
    }
    @Test
    public void setPath_SetInvalidAudioPath_ThrowIllegalArgumentException(){
        /// Arrange

        /// Act
        try{
            soundClipBase.setPath(invalidPath);
        }catch (IllegalArgumentException ex){

        /// Assert
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("illegal sound clip path");
        }

    }
    @Test
    @Parameters(method = "getvalidVolume")
    public void setVolume_SetValidVolume_GetSameValue(int soundValue){
        /// Arrange

        /// Act
        soundClipBase.setVolume(soundValue);

        /// Assert
        Assertions.assertThat(soundClipBase.getVolume())
                .isEqualTo(soundValue);
    }

    @Test
    public void getPath_SetValidAudioClip_GetSameValue(){
        /// Arrange
        String path;

        /// Act
        path = soundClipBase.getPath();

        /// Assert
        Assertions.assertThat(path)
                .isSameAs(validPath);

    }

}