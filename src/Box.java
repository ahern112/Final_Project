/**
 * Box Class
 * @author Annes Huynh
 * @author John Angkahan
 * @version 1.0
 * Has box properties
 */

public class Box {
    private int x,y;
    private String name;

    public Box(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

