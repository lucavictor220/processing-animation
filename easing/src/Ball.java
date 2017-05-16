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
    private float targetX = 300;
    private float targetY = 300;
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
        this.dx = this.targetX - this.x;
        this.dy = this.targetY - this.y;
    };

    public void draw() {
        dx = targetX - x;
        dy = targetY - y;
        vx = (float) (dx * easing);
        vy = (float) (dy * easing);
        p.ellipse(x, y, r, r);
        x += vx;
        y += vy;
        if ((295 > x | x < 305) & (y > 295 | y < 305)) {
            System.out.println("Stop");
            p.noLoop();
        }
    }
}
