import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DrawArea Class
 * @author John Angkahan
 * @author Annes Huynh
 * @author Abraham Hernandez
 * @author Sing Tai
 * @author Pablo Gonzalez
 * @version 1.0
 *
 */


public class DrawArea extends JPanel implements MouseListener, MouseMotionListener {
    int x,y;
    LinkedList<Box> boxLinkedList = new LinkedList<>();
    LinkedList<associationCon> associationLinkedList = new LinkedList<>();
    LinkedList<inheritanceCon> inheritanceLinkedList = new LinkedList<>();
    LinkedList<compositionCon> compositionLinkedList = new LinkedList<>();
    int boxClicked = 0;
    int classNum = 100;

    Box boxBeingDragged;
    boolean isBoxBeingDragged;
    boolean wasBoxPressed;


    //variables for handling Box click and showing selection( add method, variables OR 3 of the relationship arrows)
    boolean isBoxClicked;

    /**
     * Class constructor.
     */
    public DrawArea() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * @return all the necessary data to recreate the UML diagram after deserialization
     */
    public ArrayList<Object> getData() {
        ArrayList<Object> data = new ArrayList<>();
        data.add(boxLinkedList);
        data.add(associationLinkedList);
        data.add(inheritanceLinkedList);
        data.add(compositionLinkedList);
        return data;
    }

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {

        g.setColor(new Color(203,205,255));
        g.fillRect(0, 0, 1000, 1000);



        for (int i = 0; i < boxLinkedList.size(); i++){
            g.setColor(Color.yellow);
            g.fillRect(boxLinkedList.get(i).getX(), boxLinkedList.get(i).getY(), 100,20);

            g.setColor(Color.BLACK);
            g.drawString(boxLinkedList.get(i).getName(), boxLinkedList.get(i).getX() + 10, boxLinkedList.get(i).getY() + 14);
            //if method selected is true, then redesign this part
        }

        for (int i = 0; i < associationLinkedList.size(); i++){
            g.drawLine(associationLinkedList.get(i).getX1(), associationLinkedList.get(i).getY1(), associationLinkedList.get(i).getX2(), associationLinkedList.get(i).getY2());
            //System.out.println(connectionList.get(i).getAngle1());

            g.drawLine(associationLinkedList.get(i).getX2(), associationLinkedList.get(i).getY2(), (int) associationLinkedList.get(i).getCx(), (int) associationLinkedList.get(i).getCy());

            g.drawLine(associationLinkedList.get(i).getX2(), associationLinkedList.get(i).getY2(), (int) associationLinkedList.get(i).getBx(), (int) associationLinkedList.get(i).getBy());
            System.out.println(associationLinkedList.get(i).getCx() + ", " + associationLinkedList.get(i).getCy());
            System.out.println(associationLinkedList.get(i).getBx() + ", " + associationLinkedList.get(i).getBy());
            //System.out.println(associationLinkedList.get(i).getAngle1());
        }

        for (int i = 0; i < inheritanceLinkedList.size(); i++){
            g.drawLine(inheritanceLinkedList.get(i).getX1(), inheritanceLinkedList.get(i).getY1(), inheritanceLinkedList.get(i).getX2(), inheritanceLinkedList.get(i).getY2());
            //System.out.println(connectionList.get(i).getAngle1());

            //g.drawLine(inheritanceLinkedList.get(i).getX2(), inheritanceLinkedList.get(i).getY2(), (int) inheritanceLinkedList.get(i).getCx(), (int) inheritanceLinkedList.get(i).getCy());

            //g.drawLine(inheritanceLinkedList.get(i).getX2(), inheritanceLinkedList.get(i).getY2(), (int) inheritanceLinkedList.get(i).getBx(), (int) inheritanceLinkedList.get(i).getBy());
            g.setColor(Color.WHITE);
            g.fillPolygon(inheritanceLinkedList.get(i).getXcoords(),inheritanceLinkedList.get(i).getYcoords(),3);
            g.setColor(Color.BLACK);
        }

        for (int i = 0; i < compositionLinkedList.size(); i++) {
            g.drawLine(compositionLinkedList.get(i).getX1(), compositionLinkedList.get(i).getY1(), compositionLinkedList.get(i).getX2(), compositionLinkedList.get(i).getY2());

            g.setColor(Color.BLACK);
            g.fillPolygon(compositionLinkedList.get(i).getXcoords(), compositionLinkedList.get(i).getYcoords(), 4);



        }
    }

    /**
     *
     * @param x
     * @param y
     * @return true if mouse clicked on existing box
     */
    public boolean checkForBox(int x, int y) {
        for (int i = 0; i < boxLinkedList.size(); i++) {
            System.out.println(boxLinkedList.get(i).getName() + ": " + boxLinkedList.get(i).getX() + ", " + boxLinkedList.get(i).getY());
            System.out.println(x + " " + y);

            if (x > boxLinkedList.get(i).getX() && x < boxLinkedList.get(i).getX() + 100)
                if (y > boxLinkedList.get(i).getY() && y < boxLinkedList.get(i).getY() + 20) {
                    System.out.println("box clicked");
                    return true;
                }
        }
        return false;
    }

    /**
     *
     * @param x
     * @param y
     * @return Box object that was clicked on
     */
    public Box returnBox(int x, int y) {
        for (int i = 0; i < boxLinkedList.size(); i++) {
            //System.out.println(boxLinkedList.get(i).getX() + ", dis " + boxLinkedList.get(i).getY() + " " + x + ", " + y);
            if (x > boxLinkedList.get(i).getX() && x < boxLinkedList.get(i).getX() + 100)
                if (y > boxLinkedList.get(i).getY() && y < boxLinkedList.get(i).getY() + 20) {
                    System.out.println("box clicked");
                    return boxLinkedList.get(i);
                }
        }
        return null;
    }

    /**
     *
     * @param className
     * @return name of Box object that was clicked on
     */
    public Box returnBoxByName(String className) {
        for (int i = 0; i < boxLinkedList.size(); i++) {
            if(boxLinkedList.get(i).getName().equals(className)) {
                return boxLinkedList.get(i);
            }
        }
        return null;
    }

    /**
     * clearArea method
     * Clears all linked lists so that the canvas is cleared
     */
    public void clearArea() {
        boxLinkedList.clear();
        associationLinkedList.clear();
        compositionLinkedList.clear();
        inheritanceLinkedList.clear();
        boxClicked = 0;
        repaint();
    }

    /**
     * updateTextArea method
     * Clears text area and repaints with new connections
     */
    public void updateTextArea() {
        Main.textArea.setText("");  // refresh
        // for every class in box linked list > create class > check for connections
        for (int i = 0; i < boxLinkedList.size(); i++) {
            Main.textArea.append("class " + boxLinkedList.get(i).getName());
            // class has connections
            //System.out.println("Print Connections: " + boxLinkedList.get(i).getConnections());
            if(!boxLinkedList.get(i).getConnections().isEmpty()) {
                List<ConnectionText> currConnections = boxLinkedList.get(i).getConnections();
                for (int j = 0; j < currConnections.size(); j++) {
                    //System.out.println(boxLinkedList.get(i).getName() + ": " + currConnections.get(j).getType());
                    System.out.println(currConnections.get(j).getType().equals("inheritance"));
                    if (currConnections.get(j).getType().equals("inheritance")) {
                        System.out.println("Class has inheritance");
                        Main.textArea.append("\nextends " + currConnections.get(j).getBox().getName());
                    }
                }
                Main.textArea.append(" {\n");
                for (int j = 0; j < currConnections.size(); j++) {
                    //System.out.println("2nd loop");
                    if (currConnections.get(j).getType().equals("composition")) {
                        Main.textArea.append("  " + currConnections.get(j).getBox().getName() + "\n");
                    }
                }
                for (int j = 0; j < currConnections.size(); j++) {
                    //System.out.println("3rd loop");
                    if (currConnections.get(j).getType().equals("association")) {
                        Main.textArea.append("  method() {\n    "
                                + currConnections.get(j).getBox().getName()
                                + "\n  }\n");
                    }
                }

            } else {
                Main.textArea.append(" {\n");
            }
            Main.textArea.append("}\n\n");
        }
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
        x = e.getX();
        y = e.getY();

        isBoxClicked = checkForBox(x,y);

        // first check if they are clicking on a box

        if (isBoxClicked) {
            //once we know its clicked then we have to prompt them to ask whether they want to add a method or a link
            Box boxBeingChanged = returnBox(x, y);
            String[] op1 = {"UML", "Method"};
            String result1 = (String)JOptionPane.showInputDialog(null, "What do you want to create:", "Selection", JOptionPane.DEFAULT_OPTION, null, op1, "0");
            switch (result1) {
                case "Method":
                    //boxLinkedList.
                    String[] option = {"Add a variable", "Add a method"};
                    String attribute_or_method = (String)JOptionPane.showInputDialog(null, "Add a Method or Variable?", "Selection", JOptionPane.DEFAULT_OPTION, null, option, "0");
                    switch (attribute_or_method){
                        case "Add a variable":
                            System.out.println("added a variable");
                            break;
                        case "Add a method":
                            System.out.println();
                            break;
                    }


                case "UML":

                    String[] options = {"association", "inheritance", "composition"};
                    // takes user input
                    String conResult = (String)JOptionPane.showInputDialog(null, "Choose the type of connection", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0");

                    String s2 = JOptionPane.showInputDialog("Name class to connect: ");
                    Box secondBox = returnBoxByName(s2);

                    switch (conResult) {
                        case "association":
                            associationLinkedList.add(new associationCon(boxBeingChanged, secondBox));
                            //associationLinkedList.add(new associationCon(boxBeingChanged.getX(), boxBeingChanged.getY(), secondBox.getX(), secondBox.getY()));
                            boxBeingChanged.addConnection("association", secondBox);
                            repaint();
                            break;
                        case "inheritance":
                            inheritanceLinkedList.add(new inheritanceCon(boxBeingChanged, secondBox));
                            boxBeingChanged.addConnection("inheritance", secondBox);
                            repaint();
                            break;
                        case "composition":
                            compositionLinkedList.add(new compositionCon(boxBeingChanged, secondBox));
                            boxBeingChanged.addConnection("composition", secondBox);
                            repaint();
                            break;
                    }
                    updateTextArea();
                    repaint();
                    break;
                default:
                    break;
            }
        } else {
            // if no box is clicked then we have to create a class
            String name = JOptionPane.showInputDialog("Name class: ");
            boxLinkedList.add(new Box(x, y, name));
            System.out.println(x + ", " + y);
            repaint();

            updateTextArea();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        int x1 = e.getX();
        int y1 = e.getY();
        // loop through to see if the pressed had a box on it based off coordinates
        for (int i = 0; i < boxLinkedList.size(); i++){
            // g.fillRect(boxLinkedList.get(i).getX(), boxLinkedList.get(i).getY(), 100,20);
            if((boxLinkedList.get(i).getX() + 100 >= x1) && (boxLinkedList.get(i).getY() + 20 >= y1)){
                // set box dragging
                //isBoxBeingDragged = true;
                boxBeingDragged = boxLinkedList.get(i);
                System.out.println("THIS WAS A BOX");
                break;
            }
            System.out.println(boxLinkedList.get(i).getX() + ", " + boxLinkedList.get(i).getY());

        }

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragged");
        // this works and moves the box
        isBoxBeingDragged = true;
        int x1 = e.getX();
        int y1 = e.getY();
        boxBeingDragged.setX(x1);
        boxBeingDragged.setY(y1);

        //now check if the box moving is connected to any of the link


        repaint();
        System.out.println(x1 + ", " + y1);

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Being released");
        if(isBoxBeingDragged){
            int x1 = e.getX();
            int y1 = e.getY();
            boxBeingDragged.setX(x1);
            boxBeingDragged.setY(y1);
            isBoxBeingDragged = false;
            boxBeingDragged = null;
            repaint();
        }
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Mouse MOved");
    }
}
