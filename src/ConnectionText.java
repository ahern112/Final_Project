/**
 * ConnectionText class
 * @author Annes Huynh
 * @version 1.0
 * Keeps track of connections that each class has
 * for the text area
 */

public class ConnectionText {
    private String type;    // assoc, comp, or inheritance
    private Box box;

    public ConnectionText(String type, Box box) {
        this.type = type;
        this.box = box;
    }

    public String getType() {
        return type;
    }

    public Box getBox() {
        return box;
    }

}
 