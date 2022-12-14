
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Box Class
 * @author Annes Huynh
 * @author John Angkahan
 * @version 1.0
 * Has box properties
 */

public class Box implements Serializable {
    private int x, y;
    private String name;
    private String var_or_method_name;
    List<ConnectionText> connections = new ArrayList<>();

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

    public List<ConnectionText> getConnections() {
        return connections;
    }

    public void addConnection(String string, Box connect) {
        ConnectionText newConnect = new ConnectionText(string, connect);
        connections.add(newConnect);
    }

    public void addConnection(String string, String var_or_method_name) {
        ConnectionText newConnect = new ConnectionText(string, var_or_method_name);
        connections.add(newConnect);
    }
}

