/**
 * Created by vitiok on 5/15/17.
 */
import processing.core.PApplet;

/**
 * Created by vitiok on 5/15/17.
 */
public class Ball {
    private PApplet p;
    private float x;
    private float y;
    private float vx;
    private float vy;
    private final float r;
    private float dx;
    private float dy;
    private double easing = 0.03;
    private boolean isMoving = true;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }



    Ball(PApplet p) {
        this.p = p;
        this.r = 50;
        this.x = this.p.random(0, 600);
        this.y = this.p.random(0, 600);
        this.vx = 2;
        this.vy = 2;

    };

    public float getR() {
        return r;
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

    public void draw() {
        dx = p.width/2 - x;
        dy = p.height/2 - y;
        vx = (float) (dx * easing);
        vy = (float) (dy * easing);
        p.fill(239, 124, 78);
        p.ellipse(x, y, r, r);
        if (isMoving) {
            x += vx;
            y += vy;
        }
    }
}

