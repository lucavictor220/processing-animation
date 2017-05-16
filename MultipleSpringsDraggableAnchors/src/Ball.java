/**
 * Created by vitiok on 5/16/17.
 */
import processing.core.PApplet;

public class Ball {
    private PApplet p;
    private float x;
    private float y;
    private float r = 30;
    private boolean isMoving = true;

    private final double spring = 0.02;
    private final double friction = 0.9;
    private final double gravity = 2;

    private float dx;
    private float dy;
    private float ax;
    private float ay;
    private float vx;
    private float vy;

    int i;


    Ball(PApplet p) {
        this.p = p;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean mouseInsideBall() {
        return (x - r/2 < p.mouseX & p.mouseX < x + r/2 & y - r/2 < p.mouseY & p.mouseY < y + r/2);
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setIsMoving(boolean moving) {
        isMoving = moving;
    }

    public void update(Handle[] handlesArray) {
        for (i = 0; i < handlesArray.length; i++) {
            dx = handlesArray[i].getX() - x;
            dy = handlesArray[i].getY() - y;
            vx += (float) (dx * handlesArray[i].getSpring());
            vy += (float) (dy * handlesArray[i].getSpring());
        }


        p.noStroke();
        p.ellipse(x, y, r, r);

        vy += gravity;
        vx *= friction;
        vy *= friction;
        if (isMoving()) {
            x += vx;
            y += vy;
        }

    }

}

