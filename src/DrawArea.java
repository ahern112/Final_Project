import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class DrawArea extends JPanel implements MouseListener {
    int x,y;
    LinkedList<Box> classLinkedList = new LinkedList<>();
    LinkedList<associationCon> connectionList = new LinkedList<>();
    int boxClicked = 0;
    int classNum = 100;

    public DrawArea() {
        addMouseListener(this);
    }


    public void paintComponent(Graphics g) {

        g.setColor(new Color(203,205,255));
        g.fillRect(0, 0, 1000, 1000);



        for (int i = 0; i < classLinkedList.size(); i++){
            g.setColor(Color.yellow);
            g.fillRect(classLinkedList.get(i).getX(),classLinkedList.get(i).getY(), 100,20);

            g.setColor(Color.BLACK);
            g.drawString(classLinkedList.get(i).getName(), classLinkedList.get(i).getX() + 10,classLinkedList.get(i).getY() + 14);
        }

        for (int i = 0; i < connectionList.size(); i++){
            g.drawLine(connectionList.get(i).getX1(), connectionList.get(i).getY1(), connectionList.get(i).getX2(), connectionList.get(i).getY2());
            //g.drawLine(connectionList.get(i).getX2(), connectionList.get(i).getY2(), (int)connectionList.get(i).getCx(), (int)connectionList.get(i).getCy());
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (classNum == 100) {
            for (int i = 0; i < classLinkedList.size(); i++) {
                if (x > classLinkedList.get(i).getX() && x < classLinkedList.get(i).getX() + 100)
                    if (y > classLinkedList.get(i).getY() && y < classLinkedList.get(i).getY() + 20) {
                        System.out.println("box clicked");
                        boxClicked++;
                        classNum = i;
                    }
            }
        } else {
            for (int i = 0; i < classLinkedList.size(); i++) {
                if (x > classLinkedList.get(i).getX() && x < classLinkedList.get(i).getX() + 100)
                    if (y > classLinkedList.get(i).getY() && y < classLinkedList.get(i).getY() + 20) {
                        System.out.println("box clicked2");

                        boxClicked++;
                        ButtonGroup group = new ButtonGroup();
                        JRadioButton asso = new JRadioButton("association");
                        JRadioButton inhe = new JRadioButton("inheritance");
                        JRadioButton comp = new JRadioButton("composition");
                        group.add(asso);
                        group.add(inhe);
                        group.add(comp);
                        JPanel panel = new JPanel();
                        panel.add(asso);
                        panel.add(inhe);
                        panel.add(comp);
                        JRadioButton[] buttons = {asso, inhe, comp};
                        //System.out.println(JOptionPane.showOptionDialog(panel,"Type of connection", JOptionPane.DEFAULT_OPTION));

                        String[] options = {"association", "inheritance", "composition"};

                        String conResult = (String)JOptionPane.showInputDialog(null, "What is the target Nicotine level?", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0");
                        //System.out.println(JOptionPane.showInputDialog(null, "What is the target Nicotine level?", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0"));

                        switch (conResult) {
                            case "association":
                                connectionList.add(new associationCon(classLinkedList.get(classNum).getX(),classLinkedList.get(classNum).getY(),classLinkedList.get(i).getX(),classLinkedList.get(i).getY()));
                                break;
                            case "inheritance":

                                break;
                            case "composition":

                                break;
                        }

                        classNum = 100;
                        repaint();


                    }
            }
        }


        if (boxClicked == 0) {

            String name = JOptionPane.showInputDialog("Name class: ");
            classLinkedList.add(new Box(x, y, name));

            repaint();

            Main.addBox(name);
        }

        if (boxClicked == 2) {boxClicked = 0;}
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

}
