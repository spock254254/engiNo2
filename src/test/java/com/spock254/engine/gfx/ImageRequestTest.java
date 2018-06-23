package com.spock254.engine.gfx;

import com.spock254.engine.helper.ScreenSize;
import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageRequest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.fest.assertions.Assertions;

import java.awt.*;

class ImageRequestTest {

    private static IImage mockedImage;
    private IImageRequest imageRequest;
    private int zDepth = 0;
    private int offX = 10;
    private int offY = 10;
    private static Dimension screenSize;

    @BeforeAll
    static void init(){
        mockedImage = Mockito.mock(IImage.class);
        screenSize = ScreenSize.getSizeScreen();
    }
    @AfterAll
    static void deinit(){
        mockedImage = null;
    }

    @BeforeEach
    void setUp() {
        imageRequest = new ImageRequest(mockedImage,zDepth,offX,offY);
    }

    @AfterEach
    void tearDown() {
        imageRequest = null;
    }
    @Test
    public void constructor_validInit_getValidFields(){
        IImageRequest validImageRequest = new ImageRequest(mockedImage,zDepth,offX,offY);
        Assertions.assertThat(validImageRequest.getImage())
                .isNotNull()
                .isSameAs(mockedImage);
        Assertions.assertThat(validImageRequest.getOffX())
                .isEqualTo(offX);
        Assertions.assertThat(validImageRequest.getOffY())
                .isEqualTo(offY);
        Assertions.assertThat(validImageRequest.getzDepth())
                .isEqualTo(zDepth);
    }
    @Test
    public void constructor_nullImage_throwIllegalArgumentException(){
        try{
            IImageRequest invalidImageRequest = new ImageRequest(null,zDepth,offX,offY);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("image is null");
        }
    }
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(ints = {10,50,100})
    public void setOffX_validOffsets_getOffset(int offset){
        imageRequest.setOffX(offset);
        Assertions.assertThat(imageRequest.getOffX())
                .isEqualTo(offset);
    }
    @Test
    public void setOffX_negativeOffsets_throwNumberFormatException(){
        int negativeOffSetX = -20;
        try{
            imageRequest.setOffX(negativeOffSetX);
        }catch (NumberFormatException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("offX less then 0");
        }
    }

    @Test
    public void setOffX_moreThenScreenSizeOffset_throwNumberFormatException(){
        int moreThenScreenSizeOffset = screenSize.width + 100;
        try{
            imageRequest.setOffX(moreThenScreenSizeOffset);
        }catch (NumberFormatException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("offX more then screen size");
        }
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(ints = {10,50,100})
    public void setOffY_validOffsets_getOffset(int offset){
        imageRequest.setOffY(offset);
        Assertions.assertThat(imageRequest.getOffY())
                .isEqualTo(offset);
    }
    @Test
    public void setOffY_negativeOffsets_throwNumberFormatException(){
        int negativeOffSetY = -20;
        try{
            imageRequest.setOffY(negativeOffSetY);
        }catch (NumberFormatException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("offY less then 0");
        }
    }
    @Test
    public void setOffY_moreThenScreenSizeOffset_throwNumberFormatException(){
        int moreThenScreenSizeOffset = screenSize.height + 100;
        try{
            imageRequest.setOffY(moreThenScreenSizeOffset);
        }catch (NumberFormatException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("offY more then screen size");
        }
    }
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(ints = {10,50,100})
    public void setzDepth_validOffsets_getValidzDepth(int depth){
        imageRequest.setzDepth(depth);
        Assertions.assertThat(imageRequest.getzDepth())
                .isEqualTo(depth);
    }
    @Test
    public void setzDepth_afterInit_getValidzDepth(){

        Assertions.assertThat(imageRequest.getzDepth())
                .isEqualTo(zDepth);
    }
    @Test
    public void getzDepth_afterInit_getValidzDepth(){

        Assertions.assertThat(imageRequest.getzDepth())
                .isEqualTo(zDepth);
    }
    @Test
    public void getzDepth_afterSet_getValidzDepth(){
        int result = 5;
        imageRequest.setzDepth(result);
        Assertions.assertThat(imageRequest.getzDepth())
                .isEqualTo(result);
    }
    @Test
    public void getOffX_afterInit_getValidOffX(){

        Assertions.assertThat(imageRequest.getOffX())
                .isEqualTo(offX);
    }
    @Test
    public void getOffX_afterSet_getValidOffX(){
        int result = 5;
        imageRequest.setOffX(result);
        Assertions.assertThat(imageRequest.getOffX())
                .isEqualTo(result);
    }
    @Test
    public void getOffY_afterInit_getValidOffY(){

        Assertions.assertThat(imageRequest.getOffY())
                .isEqualTo(offY);
    }
    @Test
    public void getOffY_afterSet_getValidOffY(){
        int result = 5;
        imageRequest.setOffY(result);
        Assertions.assertThat(imageRequest.getOffY())
                .isEqualTo(result);
    }
    @Test
    public void setImage_setValidImg_getValidImg(){
        imageRequest.setImage(mockedImage);
        Assertions.assertThat(imageRequest.getImage())
                .isSameAs(mockedImage);
    }
    @Test
    public void setImage_setNull_throwIllegalArgumentException(){
        try{
            imageRequest.setImage(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("image is null");
        }
    }
    @Test
    public void getImage_afterInit_getValidImage(){
        Assertions.assertThat(imageRequest.getImage())
                .isSameAs(mockedImage);
    }
    @Test
    public void getImage_afterSet_getValidImage(){

        imageRequest.setImage(mockedImage);
        Assertions.assertThat(imageRequest.getImage())
                .isSameAs(mockedImage);
    }
}