package com.spock254.engine;



import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class Window {

    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    int width = 0;
    int height = 0;

    public Window(Kernel gc){
        image = new BufferedImage(gc.getWidth(),gc.getHeight(),BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension dimension = new Dimension((int)(gc.getWidth() * gc.getScale()),
                (int)(gc.getHeight() * gc.getScale()));
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);

        frame = new JFrame(gc.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas,BorderLayout.CENTER);
        frame.pack(); // size to canvas
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        width = canvas.getWidth();
        height = canvas.getHeight();

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();


    }

    public void update(){

        g.drawImage(image,0,0,width,height,null);
        bs.show();
    }

    public BufferedImage getImage() {
        return image;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
