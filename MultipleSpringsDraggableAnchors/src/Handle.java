import processing.core.PApplet;

/**
 * Created by vitiok on 5/16/17.
 */
public class Handle {
    private PApplet p;
    private float x;
    private float y;
    private final double spring = 0.02;
    private int width = 20;
    private int height = 20;

    public double getSpring() {
        return spring;
    }

    Handle(PApplet p) {
        this.p = p;
        this.x = p.random(0, p.width);
        this.y = p.random(0, p.height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean mouseInsideHandle() {
        return (x < p.mouseX & p.mouseX < width & y < p.mouseY & p.mouseY < height);
    }

    void draw(float targetX, float targetY) {
        p.stroke(255);
        p.line(x, y, targetX, targetY);

        p.rect(x, y, 25, 25);
    }
}
