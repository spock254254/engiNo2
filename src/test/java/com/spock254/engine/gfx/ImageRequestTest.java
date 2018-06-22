package com.spock254.engine.gfx;

import com.spock254.engine.interfaces.gfx.IImage;
import com.spock254.engine.interfaces.gfx.IImageRequest;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.fest.assertions.Assertions;

class ImageRequestTest {

    private static IImage mockedImage;
    private IImageRequest imageRequest;
    private int zDepth = 0;
    private int offX = 10;
    private int offY = 10;

    @BeforeAll
    static void init(){
        mockedImage = Mockito.mock(IImage.class);
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
}