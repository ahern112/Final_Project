import java.awt.*;

public class Box {
    private int x1, y1;
    private String name;

    public Box(int x1, int y1, String name) {
        this.x1 = x1;
        this.y1 = y1;
        this.name = name;
    }
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public String getName() {
        return name;
    }

    public void setX(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
}
