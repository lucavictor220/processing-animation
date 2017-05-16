import processing.core.PApplet;

/**
 * Created by vitiok on 5/16/17.
 */
public class Ball {
    private PApplet p;
    private float x;
    private float y;

    private final float targetX;
    private final float targetY;
    private final double spring = 0.01;

    private float dx;
    private float ax;
    private float vx;

    Ball(PApplet p) {
        this.p = p;
        this.targetX = 300;
        this.targetY = 300;
        this.x = 0;
        this.y = 300;
    }

    public void draw() {
        dx = targetX - x;
        ax = (float) (dx * spring);
        p.ellipse(x, y, 30, 30);
        vx += ax;
        x += vx;
    }

}
