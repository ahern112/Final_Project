
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Main extends JFrame implements ActionListener{


    public static void main(String[] args) {
        Main window = new Main();
        window.setSize(800, 700);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    Main() {
        super("Final Project");
        /*BorderLayout b1 = new BorderLayout();
        setLayout(b1);*/

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");


        JMenuItem newI = new JMenuItem("New");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");

        file.add(open);
        file.add(save);
        file.add(newI);

        open.addActionListener(this);
        save.addActionListener(this);
        newI.addActionListener(this);



        menu.add(file);
        menu.add(help);

        setJMenuBar(menu);



        JPanel westPanel = new JPanel();
        westPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        westPanel.setBackground(Color.lightGray);
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
}