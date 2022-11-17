/*
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
/**
 *
 * Drawing Application - CSC 308
 * @author Abraham Hernandez
 * @version 1.0
 *
 *//*


*/
/**
 * Draw Application
 *//*

public class Main extends JFrame implements ActionListener {
    private String currentShape = "Rectangle";
    private String currentColor = "Black";
    DrawArea drawArea = new DrawArea();
    */
/**
     * Main App Class to create a window selection
     * @param args
     *//*

    public static void main(String[] args) {
        Main main = new Main();
        main.setSize(500,500);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
        System.out.println("Hello world!");
    }
    */
/**
     * Main App Class to create selection options as well as drawarea
     *//*

    public Main() {
        super("My Paint App");
        JPanel southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        southPanel.setBackground(Color.lightGray);
        JButton b1 = new JButton("Undo");
        JButton b2 = new JButton("Erase");
        southPanel.add(b1);
        southPanel.add(b2);

        JPanel westPanel = new JPanel();
        westPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        westPanel.setBackground(Color.lightGray);
        String[] colors = { "Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink" };
        JComboBox list = new JComboBox(colors);
        JRadioButton rectangle = new JRadioButton("Rectangle");
        JRadioButton circle = new JRadioButton("Circle");
        JRadioButton arc = new JRadioButton("Arc");
        rectangle.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(rectangle);
        group.add(circle);
        group.add(arc);
        GridLayout grid = new GridLayout(7,1);
        westPanel.setLayout(grid);
        westPanel.add(list);
        westPanel.add(rectangle);
        westPanel.add(circle);
        westPanel.add(arc);

        JPanel centerPanel = drawArea;
        centerPanel.setBackground(Color.CYAN);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(southPanel, BorderLayout.SOUTH);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        list.addActionListener(this);
        rectangle.addActionListener(this);
        circle.addActionListener(this);
        arc.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    */
/**
     * actionPerformed method - commands for objects
     * @param e the event to be processed
     *//*

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Arc":
                currentShape = "Arc";
                drawArea.setValues(currentColor, currentShape);
                break;
            case "Circle":
                currentShape = "Circle";
                drawArea.setValues(currentColor, currentShape);
                break;
            case "Rectangle":
                currentShape = "Rectangle";
                drawArea.setValues(currentColor, currentShape);
                break;
            case "comboBoxChanged":
                JComboBox tmp = (JComboBox) e.getSource();
                currentColor = tmp.getSelectedItem().toString();
                drawArea.setValues(currentColor, currentShape);
                break;
            case "Undo":
                drawArea.undo();
                break;
            case "Erase":
                drawArea.erase();
                break;

        }
    }


}*/
/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Stack;

public class DrawArea extends JPanel implements MouseListener, MouseMotionListener {
    int x1, y1, x2, y2;
    private Color color;
    private String shape;
    HashMap<String, Color> map = new  HashMap<String, Color>();
    Stack<Shape> stk = new Stack<>();
    *//**
     * DrawArea Class to create color selection and create the shapes
     *//*
    public DrawArea() {
        addMouseListener(this);
        addMouseMotionListener(this);
        map.put("Red", Color.RED);
        map.put("Green", Color.GREEN);
        map.put("Black", Color.BLACK);
        map.put("Blue", Color.BLUE);
        map.put("Yellow", Color.YELLOW);
        map.put("Orange", Color.ORANGE);
        map.put("Pink", Color.PINK);
        color = Color.black;
        shape = "Rectangle";
    }
    *//**
     * paintComponent method - to draw the stack of shapes created
     * @param g to draw objects
     *//*
    public void paintComponent (Graphics g) {
        for (Shape eachShape:stk) {
            g.setColor(eachShape.color);
            int firstX = eachShape.x1;
            int secondX = eachShape.x2;
            if(firstX > secondX){
                firstX = secondX;
                secondX = eachShape.x1;
            }

            int firstY = eachShape.y1;
            int secondY = eachShape.y2;
            if(firstY>secondY){
                firstY = secondY;
                secondY = eachShape.y1;
            }

            switch (eachShape.shape){
                case "Rectangle":
                    g.fillRect(firstX,firstY,Math.abs(secondX-firstX),Math.abs(secondY-firstY));
                    break;
                case "Arc":
                    double anglelnRadians = Math.atan2(secondY, secondX);
                    double length = Math.toDegrees(anglelnRadians);
                    g.fillArc(firstX,firstY,Math.abs(secondX-firstX), Math.abs(secondY-firstY),0, (int)length);
                    break;
                case "Circle":
                    g.fillOval(firstX,firstY,Math.abs(secondX-firstX),Math.abs(secondY-firstY));
                    break;
            }
        }
    }
    *//**
     * undo method - get rid of the top of stack
     *//*
    public void undo() {
        if(stk.size() > 0) {
            stk.pop();
            repaint();
        }
    }
    *//**
     * erase method - erase the board
     *//*
    public void erase() {
        stk.clear();
        repaint();
    }

    public void setValues(String color, String shape) {
        this.color = map.get(color);
        this.shape = shape;
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }
    *//**
     * mouseReleased method - once mouse is released creates new shape
     * @param e to capture a mouse event
     *//*
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        stk.push(new Shape(x1,y1,x2,y2,shape, color));
        repaint();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}*/
/*

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
/**
 * @author Sing Tai, Pablo Gonzalez, Abraham Hernandez, Annes Huynh, John Angkahan
 * @version Lab2
 *//*

public class App extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4;
    public static void main(String[] args) {
        App window = new App();
        window.setSize(500, 500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public App() {
        super("Title");
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu about = new JMenu("About");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");

        file.add(open);
        file.add(save);
        file.add(quit);

        menu.add(file);
        menu.add(about);

        setJMenuBar(menu);
        open.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);

        GridLayout grid = new GridLayout(2,2);
        JPanel box = new JPanel();
        JTabbedPane pane = new JTabbedPane();
        pane.add(box, "Hola");
        box.setLayout(grid);

        JPanel calculator = new JPanel();
        GridLayout grid2 = new GridLayout(4,3);
        calculator.setLayout(grid2);
        JButton oneB = new JButton("1");
        JButton twoB = new JButton("2");
        JButton threeB = new JButton("3");
        JButton fourB = new JButton("4");
        JButton fiveB = new JButton("5");
        JButton sixB = new JButton("6");
        JButton sevenB = new JButton("7");
        JButton eightB = new JButton("8");
        JButton nineB = new JButton("9");
        JButton zeroB = new JButton("0");
        t4 = new JTextField("");


        calculator.add(zeroB);
        zeroB.addActionListener(this);
        calculator.add(oneB);
        oneB.addActionListener(this);
        calculator.add(twoB);
        twoB.addActionListener(this);
        calculator.add(threeB);
        threeB.addActionListener(this);
        calculator.add(fourB);
        fourB.addActionListener(this);
        calculator.add(fiveB);
        fiveB.addActionListener(this);
        calculator.add(sixB);
        sixB.addActionListener(this);
        calculator.add(sevenB);
        sevenB.addActionListener(this);
        calculator.add(eightB);
        eightB.addActionListener(this);
        calculator.add(nineB);
        nineB.addActionListener(this);
        calculator.add(t4);
        pane.add(calculator, "Calculator");

        JButton b1 = new JButton("Click Here");
        b1.addActionListener(this);
        t1 = new JTextField("I can write here");
        t2 = new JTextField("And Here...");
        t3 = new JTextField("Or Here");
        box.add(t1);
        box.add(t2);
        box.add(b1);
        box.add(t3);

        JLabel three = new JLabel(":)");
        three.setOpaque(true);
        three.setBackground(Color.CYAN);
        JLabel four = new JLabel(":(");
        four.setOpaque(true);
        four.setBackground(Color.YELLOW);
        pane.add(three, "Three");
        pane.add(four, "Four");
        add(pane);
    }
    */
/**
     *
     * @param e the event to be processed
     *//*

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Quit")) {
            this.dispose();
        } else if (e.getActionCommand().equals("Click Here")) {
            JOptionPane.showMessageDialog(this, t1.getText());
            t3.setText(t1.getText() + ", " + t2.getText());
        } else if (e.getActionCommand().equals("Open") || e.getActionCommand().equals("Save")) {
            JOptionPane.showMessageDialog(this, e.getActionCommand());
        } else {
            */
/*Integer adding = Integer.parseInt(e.getActionCommand()) + Integer.parseInt(t4.getText());
            String ad = adding.toString();*//*

            t4.setText(t4.getText() + e.getActionCommand());
        }
    }
}*/
