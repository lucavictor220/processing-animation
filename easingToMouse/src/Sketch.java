/**
 * Created by vitiok on 5/15/17.
 */

import processing.core.PApplet;

public class Sketch extends PApplet {

    private static final int Width = 600;
    private static final int Height = 600;

    private Ball ball = new Ball(this);

    public void settings(){
        size(Width, Height);
    }

    public void keyPressed() {
    }

    public void mousePressed() {
    }

    public void mouseDragged() {
    }

    public void draw(){
        background(0);
        ball.draw();
    }
}


