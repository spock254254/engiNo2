package com.spock254.engine.audio;

import junit.framework.TestCase;
import org.fest.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import static junitparams.JUnitParamsRunner.$;

public class SoundClipBaseTest extends TestCase {


    @Test
    public void constructor_SetAudioPath(){
        /// Arrange
        String validPath = "/res/audio/David_Hilowitz_-_05_-_Solitude.wav";

        /// Act
        SoundClipBase  soundClipBase = new SoundClipBase(validPath);

        /// Assert
        Assertions.assertThat(soundClipBase.getPath()).isSameAs(validPath);
    }

}