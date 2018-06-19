package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IFont;
import com.spock254.engine.interfaces.gfx.IImage;
import org.fest.assertions.Assert;
import org.fest.assertions.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FontTest {

    private static final String validPath = "/res/standart.png";
    private static final String invalidPath = "invalidPath";
    private IFont font;
    private static IImage image;

    @BeforeAll
    static void init() throws IOException {
        image = new Image(validPath);
    }
    @AfterAll
    static void deinit(){
        image = null;
    }

    @BeforeEach
    void setUp() throws IOException{
        font = new Font(validPath);

    }

    @AfterEach
    void tearDown() {
        font = null;
    }

    @Test
    public void constructor_validPath_getImageAndPath(){



        Assertions.assertThat(font.getFontImage().getWidth())
                .isEqualTo(image.getWidth());
        Assertions.assertThat(font.getFontImage().getHeight())
                .isEqualTo(image.getHeight());
        Assertions.assertThat(font.getFontImage().getPixels())
                .contains(image.getPixels());
        Assertions.assertThat(font.getFontPath())
                .isSameAs(validPath);

    }
    @Test
    public void constructor_nullPath_throwIllegalArgumentException(){

        try{
            new Font(null);
        }catch (Exception ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("font file not found");
        }

    }
    @Test
    public void constructor_emptyPath_throwIllegalArgumentException(){

        try{
            new Font("");
        }catch (Exception ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("font file not found");
        }

    }
    @Test
    public void constructor_invalidPath_getStandartFont() {

            IFont invalidFont = new Font(invalidPath);
            Assertions.assertThat(invalidFont.getFontImage())
                    .isSameAs(Font.getSTANDART().getFontImage());

    }
    @Test
    public void getTextPixelWeight_validWord_getValidSize(){
        String testWord = "this is test word";
        testWord = testWord.toUpperCase();
        int[] widths = font.getWidths();
        int size = 0;
        for(char c : testWord.toCharArray()){
            size += widths[((int)c) - 32];
        }
        Assertions.assertThat(size)
                .isEqualTo(font.getTextPixelWeight(testWord));
    }
    @Test
    public void getTextPixelWeight_nullWord_throwIllegalArgumentException(){

        try{
            font.getTextPixelWeight(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("invalid word");
        }
    }
    @Test
    public void getTextPixelWeight_emptyWord_throwIllegalArgumentException(){

        try{
            font.getTextPixelWeight("");
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("invalid word");
        }
    }
    @Test
    public void getTextPixelHeigh_nullWord_throwIllegalArgumentException(){

        try{
            font.getTextPixelHeight(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("invalid word");
        }
    }
    @Test
    public void getTextPixelHeigh_emptyWord_throwIllegalArgumentException(){

        try{
            font.getTextPixelHeight("");
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("invalid word");
        }
    }
}