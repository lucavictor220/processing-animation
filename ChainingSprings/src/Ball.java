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

    private final double spring = 0.02;
    private final double friction = 0.9;
    private final double gravity = 2;

    private float dx;
    private float dy;
    private float ax;
    private float ay;
    private float vx;
    private float vy;


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

    public void update(float targetX, float targetY) {
        dx = targetX - x;
        dy = targetY - y;
        ax = (float) (dx * spring);
        ay = (float) (dy * spring);

        p.stroke(255);
        p.fill(84, 152, 211);
        p.line(targetX, targetY, x, y);
        p.noStroke();
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
