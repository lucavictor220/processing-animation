/**
 * Created by vitiok on 5/16/17.
 */


import processing.core.PApplet;

public class Sketch extends PApplet {

    private static final int Width = 600;
    private static final int Height = 600;
    private int nrOfHandles = 5;
    private Handle[] handlesArray = new Handle[nrOfHandles];

    private Ball ball;
    int i;


    public void settings(){
        size(Width, Height);
        init();
    }

    public void mousePressed() {
        if (ball.mouseInsideBall()) {
            ball.setIsMoving(false);
        }
        for (i = 0; i < handlesArray.length; i++) {
            if (handlesArray[i].mouseInsideHandle()) {
                handlesArray[i].setMoved(true);
            }
        }
    }

    public void mouseReleased() {
        ball.setIsMoving(true);
        for (i = 0; i < handlesArray.length; i++) {
            handlesArray[i].setMoved(false);
        }
    }

    public void mouseDragged() {
        if (!ball.isMoving()) {
            ball.setX(mouseX);
            ball.setY(mouseY);
        }
        for (i = 0; i < handlesArray.length; i++) {
            if (handlesArray[i].isMoved()) {
                handlesArray[i].setX(mouseX);
                handlesArray[i].setY(mouseY);
            }
        }

    }


    private void init() {
        for (int i = 0; i < nrOfHandles; i++) {
            handlesArray[i] = new Handle(this);
        }
        ball = new Ball(this);
    }

    public void draw() {
        background(0);
        for (i = 0; i < nrOfHandles; i++) {
            handlesArray[i].draw(ball.getX(), ball.getY());
        }
        ball.update(handlesArray);
    }
}


