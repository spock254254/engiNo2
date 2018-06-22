package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IImage;
import org.junit.jupiter.api.*;
import org.fest.assertions.Assertions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class ImageTest {

    private static final String validPath = "/res/standart.png";
    private static final String invalidPath = "invalidPath";
    private IImage image;
    private static BufferedImage buffImage;

    @BeforeAll
    static void init() throws IOException{
        buffImage = ImageIO.read(Image.class.getResourceAsStream(validPath));
    }
    @AfterAll
    static void deinit(){
        buffImage = null;
    }
    @BeforeEach
    void setUp() throws IOException{
        image = new Image(validPath);
    }

    @AfterEach
    void tearDown() {
        image = null;
    }
    @Test
    public void constructor_validPath_fillPixelsWidthAndHeight() throws IOException{
        IImage validImage = new Image(validPath);

        Assertions.assertThat(validImage.getHeight())
                .isPositive();
        Assertions.assertThat(validImage.getWidth())
                .isPositive();
        Assertions.assertThat(validImage.getPixels())
                .isNotNull()
                .isNotEmpty();
    }
    @Test
    public void constructor_invalidPath_IllegalArgumentException(){

        Throwable t = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class
                ,() -> new Image(invalidPath));
        Assertions.assertThat(t.getMessage())
                .isSameAs("input == null!");

    }
    @Test
    public void constructor_nullPath_throwIllegalArgumentException(){

        Throwable t = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class
                ,() -> new Image(null));
        Assertions.assertThat(t.getMessage())
                .isSameAs("image path is null");

    }
    @Test
    public void constructor_emptyPath_throwIllegalArgumentException(){

        Throwable t = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class
                ,() -> new Image(""));
        Assertions.assertThat(t.getMessage())
                .isSameAs("image path is empty");

    }

    @Test
    public void getWidth_setPositiveWidth_getWidth(){
        int positiveWidth = 15;
        image.setWidth(positiveWidth);
        Assertions.assertThat(image.getWidth())
                .isEqualTo(positiveWidth);
    }

    @Test
    public void getWidth_validInit_getWidth(){


        Assertions.assertThat(image.getWidth())
                .isEqualTo(buffImage.getWidth());
    }


    @Test
    public void setWidth_setPositiveWidth_getWidth(){
        int positiveWidth = 15;
        image.setWidth(positiveWidth);
        Assertions.assertThat(image.getWidth())
                .isEqualTo(positiveWidth);
    }
    @Test
    public void setWidth_setNegativeWidth_throwIllegalArgumentException(){
        int negativeWidth = -15;
        try{
            image.setWidth(negativeWidth);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("width less then 0");
        }


    }
    @Test
    public void getHeight_setPositiveWidth_getWidth(){
        int positiveWidth = 15;
        image.setHeight(positiveWidth);
        Assertions.assertThat(image.getHeight())
                .isEqualTo(positiveWidth);
    }
    @Test
    public void getHeight_setNegativeWidth_throwIllegalArgumentException(){
        int negativeWidth = -15;
        try{
            image.setHeight(negativeWidth);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("height less then 0");
        }
    }
    @Test
    public void getHeight_validInit_getHeight(){

        Assertions.assertThat(image.getHeight())
                .isEqualTo(buffImage.getHeight());
    }
    @Test
    public void getPixels_validInit_getPixelsArray(){
        int [] validPixels = buffImage.getRGB(0,0,buffImage.getWidth()
                ,buffImage.getHeight(),null,0,buffImage.getWidth());
        Assertions.assertThat(image.getPixels().length)
                .isEqualTo(validPixels.length);
        Assertions.assertThat(image.getPixels())
                .contains(image.getPixels());
    }
    @Test
    public void getPixels_setValidPixels_getPixelArray(){
        int[] pixels = {1,2,3,4,5,6,7};
        image.setPixels(pixels);
        Assertions.assertThat(image.getPixels().length)
                .isEqualTo(pixels.length);
        Assertions.assertThat(image.getPixels())
                .contains(pixels);
    }
    @Test
    public void getPixels_setEmptyPixelsArray_throwIllegalArgumentException(){
        int[] emptyPixels = {};
        try{
            image.setPixels(emptyPixels);
            int [] result = image.getPixels();
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("pixels are empty");
        }
    }
    @Test
    public void getPixels_setNull_throwIllegalArgumentException(){
        try{
            image.setPixels(null);
            int [] result = image.getPixels();
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("pixels array is null");
        }
    }
    @Test
    public void setPixels_validInit_getPixelsArray(){
        int [] validPixels = buffImage.getRGB(0,0,buffImage.getWidth()
                ,buffImage.getHeight(),null,0,buffImage.getWidth());
        image.setPixels(validPixels);
        Assertions.assertThat(image.getPixels().length)
                .isEqualTo(validPixels.length);
        Assertions.assertThat(image.getPixels())
                .contains(validPixels);
    }

    @Test
    public void setPixels_validSet_getPixelsArray(){
        int[] pixels = {1,2,3,4,5,6,7};
        image.setPixels(pixels);
        Assertions.assertThat(image.getPixels().length)
                .isEqualTo(pixels.length);
        Assertions.assertThat(image.getPixels())
                .contains(pixels);
    }
    @Test
    public void setPixels_setEmptyPixelsArray_throwIllegalArgumentException(){
        int[] emptyPixels = {};
        try{
            image.setPixels(emptyPixels);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("pixels are empty");
        }
    }
    @Test
    public void setPixels_setNull_throwIllegalArgumentException(){
        try{
            image.setPixels(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("pixels array is null");
        }
    }
    @Test
    public void isAlpha_validInit_getFalse(){
        Assertions.assertThat(image.isAlpha())
                .isFalse();
    }
    @Test
    public void isAlpha_setTrue_getTrue(){
        image.setAlpha(true);
        Assertions.assertThat(image.isAlpha())
                .isTrue();
    }
    @Test
    public void isAlpha_setFalse_getFalse(){
        image.setAlpha(false);
        Assertions.assertThat(image.isAlpha())
                .isFalse();
    }
    @Test
    public void setAlpha_setTrue_getTrue(){
        image.setAlpha(true);
        Assertions.assertThat(image.isAlpha())
                .isTrue();
    }
    @Test
    public void setAlpha_setFalse_getFalse(){
        image.setAlpha(false);
        Assertions.assertThat(image.isAlpha())
                .isFalse();
    }
}