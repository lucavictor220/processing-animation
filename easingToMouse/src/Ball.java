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

    Ball(PApplet p) {
        this.p = p;
        this.r = 50;
        this.x = this.p.random(0, 600);
        this.y = this.p.random(0, 600);
        this.vx = 2;
        this.vy = 2;

    };

    public void draw() {
        dx = p.mouseX - x;
        dy = p.mouseY - y;
        vx = (float) (dx * easing);
        vy = (float) (dy * easing);
        p.fill(142, 124, 200);
        p.ellipse(x, y, r, r);
        x += vx;
        y += vy;
    }
}

