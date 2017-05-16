/**
 * Created by vitiok on 5/16/17.
 */

import processing.core.PApplet;

public class Sketch extends PApplet {

    private static final int Width = 600;
    private static final int Height = 600;

    Ball ball = new Ball(this);

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
        stroke(255);
        line(0, height/2, width, height/2);
        line(width/2, 0, width/2, height);
        ball.draw();
    }
}

