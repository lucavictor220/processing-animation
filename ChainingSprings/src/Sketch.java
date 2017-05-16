/**
 * Created by vitiok on 5/16/17.
 */

import processing.core.PApplet;

public class Sketch extends PApplet {

    private static final int Width = 600;
    private static final int Height = 600;
    private int chainLength = 5;
    private Ball[] ballChain = new Ball[chainLength];

    private Ball ball;


    public void settings(){
        size(Width, Height);
        init();
    }


    public void init() {
        for (int i = 0; i < chainLength; i++) {
            ballChain[i] = new Ball(this);
        }
    }

    public void draw() {
        background(0);
        for (int i = 0; i < chainLength; i++) {
            if (i == 0) {
                ballChain[i].update(mouseX, mouseY);
                continue;
            }
            ballChain[i].update(ballChain[i-1].getX(), ballChain[i-1].getY());
        }
    }
}

