package com.spock254.engine.audio;

import com.spock254.engine.interfaces.audio.ISoundClipBase;
import junit.framework.TestCase;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.fest.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;


import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class SoundClipBaseTest extends TestCase {


    private String validPath = "/res/audio/David_Hilowitz_-_05_-_Solitude.wav";
    private String invalidPath = "invalidAudioClipPath";

    @Test
    public void constructor_SetValidAudioPath(){
        /// Arrange

        /// Act
        ISoundClipBase soundClipBase = new SoundClipBase(validPath);

        /// Assert
        Assertions.assertThat(soundClipBase.getPath()).isSameAs(validPath);
    }

    @Test
    public void constructor_SetNullAudioPath_ThrowIllegalArgumentException(){
        /// Arrange

        /// Act
        try{
            ISoundClipBase soundClipBase = new SoundClipBase(null);
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
            ISoundClipBase soundClipBase = new SoundClipBase("");
        }catch (IllegalArgumentException ex){
            /// Assert
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("sound clip can't be null or empty");
        }
    }
    @Test
    public void setPath_SetInvalidAudioPath_ThrowIllegalArgumentException(){
        /// Arrange
        ISoundClipBase soundClipBase = new SoundClipBase(validPath);


        /// Act
        try{
            soundClipBase.setPath(invalidPath);
        }catch (IllegalArgumentException ex){

        /// Assert
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("illegal sound clip path");
        }

    }

}