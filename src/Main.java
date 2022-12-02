import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * CSC 308 Final Project: UML
 * @author Annes Huynh
 * @author Pablo
 * @version 1.0
 * An area where for a user to create class boxes, main UI
 * It initializes a JFrame, Text Area, and manages menu actions
 */

public class Main extends JFrame implements ActionListener{
    static JTextArea textArea = new JTextArea(25,15);
    private DrawArea centerPanel;

    public static void main(String[] args) {
        Main window = new Main();
        window.setSize(750, 750);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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
        file.add(open);
        file.add(save);
        file.add(quit);
        setJMenuBar(menu);

        open.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New":
                System.out.println("New Diagram");
                centerPanel.clearArea();
                textArea.setText("");
                break;
            case "Save":
                System.out.println("Saving Current Diagram");

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

    public static void addBox(String name) {
        textArea.append("class " + name + " {\n");
        textArea.append("\n");
        textArea.append("}\n");

    }
}