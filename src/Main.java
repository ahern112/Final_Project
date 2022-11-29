
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Main extends JFrame implements ActionListener{
    static JTextArea textArea = new JTextArea(25,15);

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
        JPanel centerPanel = new DrawArea();
        centerPanel.setBackground(new Color(203,205,255));

        // bottom
        JPanel bottomPanel = new JPanel();

        // frame
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Open":
                System.out.println("OPEN ME ");
                break;
            case "New":
                System.out.println("NEW ME");
                break;
            case "Save":
                System.out.println("SAVE ME");
                break;
            case "Help":
                System.out.println("HELP ME");
                break;
            default:
                System.out.println("NO IDEA BROTHER");
                break;

        }
    }

    public static void addBox(String name) {
        textArea.append("class " + name + " {\n");
        textArea.append("\n");
        textArea.append("}\n");

        System.out.println("Sing hello");

    }
}