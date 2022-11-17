import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class DrawArea extends JPanel implements MouseListener, MouseMotionListener {

    int x,y;
    LinkedList<Box> boxLinkedList = new LinkedList<>();
    LinkedList<Object> connectionList = new LinkedList<>();
    boolean boxClicked = false;
    int boxNum = 0;
    int boxNumDrag = 0;

    DrawArea() {
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {

        g.setColor(new Color(203,205,255));
        g.fillRect(0, 0, 1000, 1000);


        for (int i = 0; i < boxLinkedList.size(); i++){
            g.setColor(Color.yellow);
            g.fillRect(boxLinkedList.get(i).getX1(),boxLinkedList.get(i).getY1(), 100,20);

            g.setColor(Color.BLACK);
            g.drawString(boxLinkedList.get(i).getName(), boxLinkedList.get(i).getX1() + 10,boxLinkedList.get(i).getY1() + 14);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (boxNum == 0) {
            for (int i = 0; i < boxLinkedList.size(); i++) {
                if (x > boxLinkedList.get(i).getX1() && x < boxLinkedList.get(i).getX1() + 100)
                    if (y > boxLinkedList.get(i).getY1() && y < boxLinkedList.get(i).getY1() + 20) {
                        System.out.println("box clicked");
                        boxClicked = true;
                        boxNum = i;
                    }
            }
        } else {
            for (int i = 0; i < boxLinkedList.size(); i++) {
                if (x > boxLinkedList.get(i).getX1() && x < boxLinkedList.get(i).getX1() + 100)
                    if (y > boxLinkedList.get(i).getY1() && y < boxLinkedList.get(i).getY1() + 20) {
                        System.out.println("box clicked");


                        boxClicked = false;
                        boxNum = 0;
                    }
            }

        }


        if (!boxClicked) {

            String name = JOptionPane.showInputDialog("Name class: ");
            boxLinkedList.add(new Box(x, y, name));

            repaint();

            Main.addBox(name);
        }


        //System.out.println(x + ", " + y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
