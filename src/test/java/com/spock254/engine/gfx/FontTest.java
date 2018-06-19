package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IFont;
import com.spock254.engine.interfaces.gfx.IImage;
import org.fest.assertions.Assertions;
import org.junit.jupiter.api.*;
import java.io.IOException;

class FontTest {

    private static final String validPath = "/res/standart.png";
    private static final String invalidPath = "invalidPath";
    private static final String TEST_WORD = "this is test word";
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
    void setUp(){
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
        String upperCaseTestWord = TEST_WORD.toUpperCase();
        int[] widths = font.getWidths();
        int size = 0;
        for(char c : upperCaseTestWord.toCharArray()){
            size += widths[((int)c) - 32];
        }
        Assertions.assertThat(size)
                .isEqualTo(font.getTextPixelWeight(upperCaseTestWord));
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
    public void getTextPixelHeigh_validWord_getValidSize(){
        String upperCaseTestWord = TEST_WORD.toUpperCase();
        Assertions.assertThat(font.getTextPixelHeight(upperCaseTestWord))
                .isEqualTo(font.getFontImage().getHeight());
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
    @Test
    public void getFontPath_validInit_getPath(){
        Assertions.assertThat(font.getFontPath())
                .isSameAs(validPath);
    }
    @Test
    public void getFontPath_invalidInit_getStandartPath(){
        Assertions.assertThat(font.getFontPath())
                .isSameAs(Font.getSTANDART().getFontPath());
    }
    @Test
    public void getFontImage_validInit_getImage(){
        Assertions.assertThat(font.getFontImage())
                .isNotNull();
    }
    @Test
    public void getFontImage_invalidInit_getStandartImage(){
        IFont invalidFont = new Font(invalidPath);
        Assertions.assertThat(invalidFont.getFontImage())
                .isSameAs(Font.getSTANDART().getFontImage());
    }
    @Test
    public void setFontImage_validImage_getImage() throws IOException{
        Image validImage = new Image(validPath);
        font.setFontImage(validImage);

        Assertions.assertThat(font.getFontImage())
                .isSameAs(validImage);

    }
    @Test
    public void setFontImage_nullImage_throwIllegalArgumentException() throws IOException{

        try{
            font.setFontImage(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("image can't be null");
        }
    }
    @Test
    public void getOffsets_setValidOffsets_getOffsets(){
        int[] testOffset = {1,2,3,4,5};
        font.setOffsets(testOffset);

        Assertions.assertThat(font.getOffsets())
                .isNotEmpty();
        Assertions.assertThat(font.getOffsets().length)
                .isEqualTo(testOffset.length);
        Assertions.assertThat(font.getOffsets())
                .isIn(testOffset);
    }
    @Test
    public void setOffsets_setValidOffsets_getOffsets(){
        int[] testOffset = {1,2,3,4,5};
        font.setOffsets(testOffset);

        Assertions.assertThat(font.getOffsets())
                .isNotEmpty();
        Assertions.assertThat(font.getOffsets().length)
                .isEqualTo(testOffset.length);
        Assertions.assertThat(font.getOffsets())
                .isIn(testOffset);
    }
    @Test
    public void setOffsets_setNull_throwIllegalArgumentException(){

        try{
            font.setOffsets(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("offsets can't be null");
        }
    }
    @Test
    public void setOffsets_setEmptyArray_throwIllegalArgumentException(){
        int[] emptyArray = {};
        try{
            font.setOffsets(emptyArray);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("offsets can't empty");
        }
    }
    @Test
    public void getWidths_setValidWidths_getWidths(){
        int[] testWidths = {1,2,3,4,5};
        font.setWidths(testWidths);

        Assertions.assertThat(font.getWidths())
                .isNotEmpty();
        Assertions.assertThat(font.getWidths().length)
                .isEqualTo(testWidths.length);
        Assertions.assertThat(font.getWidths())
                .isIn(testWidths);
    }
    @Test
    public void setWidths_setValidWidths_getWidths(){
        int[] testWidths = {1,2,3,4,5};
        font.setWidths(testWidths);

        Assertions.assertThat(font.getOffsets())
                .isNotEmpty();
        Assertions.assertThat(font.getWidths().length)
                .isEqualTo(testWidths.length);
        Assertions.assertThat(font.getWidths())
                .isIn(testWidths);
    }
    @Test
    public void setWidths_setNull_throwIllegalArgumentException(){

        try{
            font.setWidths(null);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("widths can't be null");
        }
    }
    @Test
    public void setWidths_setEmptyArray_throwIllegalArgumentException(){
        int[] emptyArray = {};
        try{
            font.setWidths(emptyArray);
        }catch (IllegalArgumentException ex){
            Assertions.assertThat(ex.getMessage())
                    .isSameAs("widths can't empty");
        }
    }

}