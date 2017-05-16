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

    public void mousePressed() {
        if (ball.mouseInsideBall()) {
            ball.setIsMoving(false);
        }
    }

    public void mouseReleased() {
        ball.setIsMoving(true);
    }

    public void mouseDragged() {
        if (!ball.isMoving()) {
            ball.setX(mouseX);
            ball.setY(mouseY);
        }
    }

    public void draw(){
        background(0);
        stroke(255);
        line(300, 300, ball.getX(), ball.getY());
        ball.draw();
    }
}

