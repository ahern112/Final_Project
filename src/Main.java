import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CSC 308 Final Project: UML
 * @author Annes Huynh
 * @author Pablo Gonzalez
 * @version 1.0
 * An area where for a user to create class boxes, main UI
 * It initializes a JFrame, Text Area, and manages menu actions
 */

public class Main extends JFrame implements ActionListener{
    static JTextArea textArea = new JTextArea(25,15);
    private DrawArea centerPanel;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Main window = new Main();
        window.setSize(750, 750);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Class Constructor
     */
    Main() {
        super("Final Project");

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu about = new JMenu("About");
        menu.add(file);
        menu.add(about);
        JMenuItem open = new JMenuItem("New");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem load = new JMenuItem("Load");
        file.add(open);
        file.add(load);
        file.add(save);
        file.add(quit);
        setJMenuBar(menu);

        open.addActionListener(this);
        load.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);

        // west
        JPanel westPanel = new JPanel();
        westPanel.setBackground(new Color(243,243,243));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        westPanel.add(scrollPane);

        // center
        centerPanel = new DrawArea();
        centerPanel.setBackground(new Color(203,205,255));

        // frame
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New":
                System.out.println("New Diagram");
                centerPanel.clearArea();
                textArea.setText("");
                break;
            case "Load":
                System.out.println("Loading Stored Diagram");
                try {
                    FileInputStream fileIn = new FileInputStream("myUML.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    ArrayList<Object> loadData = (ArrayList<Object>) in.readObject();
                    centerPanel.boxLinkedList = (LinkedList<Box>) loadData.get(0);
                    centerPanel.associationLinkedList = (LinkedList<associationCon>) loadData.get(1);
                    centerPanel.inheritanceLinkedList = (LinkedList<inheritanceCon>) loadData.get(2);
                    centerPanel.compositionLinkedList = (LinkedList<compositionCon>) loadData.get(3);
                    in.close();
                    fileIn.close();
                    repaint();
                    centerPanel.updateTextArea();
                } catch (IOException | ClassNotFoundException i) {
                    i.printStackTrace();
                }

                break;
            case "Save":
                System.out.println("Saving Current Diagram");
                ArrayList<Object> data = centerPanel.getData();
                try {
                    FileOutputStream fileOut = new FileOutputStream("myUML.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(data);
                    out.flush();
                    out.close();
                    JOptionPane.showMessageDialog(null, "UML diagram successfully saved to myUML.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }
                break;
            case "Quit":
                System.out.println("Exiting Program");
                System.exit(0);
                break;
            case "About":
                System.out.println("CSC 308 Group Final Project");
                break;
            default:
                System.out.println("No Action Selected");
                break;

        }
    }

    /**
     *
     * @param name the name of the box to be added to the text area
     */
    public static void addBox(String name) {
        textArea.append("class " + name + " {\n");
        textArea.append("\n");
        textArea.append("}\n");

        System.out.println("Sing hello");

    }
}