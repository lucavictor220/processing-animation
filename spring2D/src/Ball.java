import processing.core.PApplet;

/**
 * Created by vitiok on 5/16/17.
 */
public class Ball {
    private PApplet p;
    private float x;
    private float y;
    private float r = 30;
    private boolean isMoving = true;

    private final float targetX;
    private final float targetY;
    private final double spring = 0.015;
    private final double friction = 0.95;
    private final double gravity = 2.5;

    private float dx;
    private float dy;
    private float ax;
    private float ay;
    private float vx;
    private float vy;


    Ball(PApplet p) {
        this.p = p;
        this.targetX = 300;
        this.targetY = 300;
        this.x = p.random(0, 600);
        this.y = p.random(0, 600);
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

    public void draw() {
        dx = targetX - x;
        dy = targetY - y;
        ax = (float) (dx * spring);
        ay = (float) (dy * spring);

        p.ellipse(x, y, r, r);

        vx += ax;
        vy += ay;
        vy += gravity;
        vx *= friction;
        vy *= friction;
        if (isMoving()) {
            x += vx;
            y += vy;
        }

    }

}
