import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

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


    public DrawArea() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    public void paintComponent(Graphics g) {

        g.setColor(new Color(203,205,255));
        g.fillRect(0, 0, 1000, 1000);



        for (int i = 0; i < boxLinkedList.size(); i++){
            g.setColor(Color.yellow);
            g.fillRect(boxLinkedList.get(i).getX(), boxLinkedList.get(i).getY(), 100,20);

            g.setColor(Color.BLACK);
            g.drawString(boxLinkedList.get(i).getName(), boxLinkedList.get(i).getX() + 10, boxLinkedList.get(i).getY() + 14);
        }

        for (int i = 0; i < associationLinkedList.size(); i++){
            g.drawLine(associationLinkedList.get(i).getX1(), associationLinkedList.get(i).getY1(), associationLinkedList.get(i).getX2(), associationLinkedList.get(i).getY2());
            //System.out.println(connectionList.get(i).getAngle1());

            g.drawLine(associationLinkedList.get(i).getX2(), associationLinkedList.get(i).getY2(), (int) associationLinkedList.get(i).getCx(), (int) associationLinkedList.get(i).getCy());

            g.drawLine(associationLinkedList.get(i).getX2(), associationLinkedList.get(i).getY2(), (int) associationLinkedList.get(i).getBx(), (int) associationLinkedList.get(i).getBy());
            System.out.println(associationLinkedList.get(i).getCx() + ", " + associationLinkedList.get(i).getCy());
            System.out.println(associationLinkedList.get(i).getBx() + ", " + associationLinkedList.get(i).getBy());
            System.out.println(associationLinkedList.get(i).getAngle1());
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

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (classNum == 100) {
            for (int i = 0; i < boxLinkedList.size(); i++) {
                if (x > boxLinkedList.get(i).getX() && x < boxLinkedList.get(i).getX() + 100)
                    if (y > boxLinkedList.get(i).getY() && y < boxLinkedList.get(i).getY() + 20) {
                        System.out.println("box clicked");
                        boxClicked++;
                        classNum = i;
                    }
            }
        } else {
            for (int i = 0; i < boxLinkedList.size(); i++) {
                if (x > boxLinkedList.get(i).getX() && x < boxLinkedList.get(i).getX() + 100)
                    if (y > boxLinkedList.get(i).getY() && y < boxLinkedList.get(i).getY() + 20) {
                        System.out.println("box clicked2");

                        boxClicked++;

                        String[] options = {"association", "inheritance", "composition"};

                        String conResult = (String)JOptionPane.showInputDialog(null, "Choose the type of connection", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0");


                        switch (conResult) {
                            case "association":
                                associationLinkedList.add(new associationCon(boxLinkedList.get(classNum).getX(), boxLinkedList.get(classNum).getY(), boxLinkedList.get(i).getX(), boxLinkedList.get(i).getY()));
                                break;
                            case "inheritance":
                                inheritanceLinkedList.add(new inheritanceCon(boxLinkedList.get(classNum).getX(), boxLinkedList.get(classNum).getY(), boxLinkedList.get(i).getX(), boxLinkedList.get(i).getY()));
                                break;
                            case "composition":
                                compositionLinkedList.add(new compositionCon(boxLinkedList.get(classNum).getX(), boxLinkedList.get(classNum).getY(), boxLinkedList.get(i).getX(), boxLinkedList.get(i).getY()));
                                break;
                        }

                        classNum = 100;
                        repaint();


                    }
            }
        }


        if (boxClicked == 0) {

            String name = JOptionPane.showInputDialog("Name class: ");
            boxLinkedList.add(new Box(x, y, name));

            repaint();

            Main.addBox(name);
        }

        if (boxClicked == 2) {boxClicked = 0;}
        //System.out.println(x + ", " + y);

    }


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
                isBoxBeingDragged = true;
                boxBeingDragged = boxLinkedList.get(i);
                System.out.println("THIS WAS A BOX");
                break;
            }
            System.out.println(boxLinkedList.get(i).getX() + ", " + boxLinkedList.get(i).getY());

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragged");
        if(isBoxBeingDragged) {
            int x1 = e.getX();
            int y1 = e.getY();
            boxBeingDragged.setX(x1);
            boxBeingDragged.setY(y1);
            repaint();
            System.out.println(x1 + ", " + y1);
        }


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Mouse MOved");
    }
}
