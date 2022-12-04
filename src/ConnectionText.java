import java.io.Serializable;

/**
 * ConnectionText class
 * @author Annes Huynh
 * @version 1.0
 * Keeps track of connections that each class has
 * for the text area
 */

public class ConnectionText implements Serializable {
    private String type;    // assoc, comp, or inheritance
    private String var_or_method_name;    // assoc, comp, or inheritance
    private Box box;

    /**
     * Class constructor.
     * @param type
     * @param box
     */
    public ConnectionText(String type, Box box) {
        this.type = type;
        this.box = box;
    }

    public ConnectionText(String type, String var_method_name) {
        this.type = type;
        this.var_or_method_name = var_method_name;
    }

    public String getType() {
        return type;
    }

    public Box getBox() {
        return box;
    }

}
