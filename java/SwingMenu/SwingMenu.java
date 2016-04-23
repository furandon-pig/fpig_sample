/* SwingMenu.java */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SwingMenu {

    JFrame frame = null;

    JMenuBar menubar = null;

    JMenu menu1 = null;
    JMenu menu2 = null;

    JMenuItem item1_1 = null;
    JMenuItem item1_2 = null;
    JMenuItem item1_3 = null;

    JMenuItem item2_1 = null;
    JMenuItem item2_2 = null;
    JMenuItem item2_3 = null;

    SwingMenu() {
        frame = new JFrame("SwingMenu");

        menubar = new JMenuBar();

        menu1 = new JMenu("File");
        menu2 = new JMenu("Menu");

        menubar.add(menu1);
        menubar.add(menu2);

        item1_1 = new JMenuItem("New");
        item1_2 = new JMenuItem("Open");
        item1_3 = new JMenuItem("Close");
        menu1.add(item1_1);
        menu1.add(item1_2);
        menu1.add(item1_3);

        item2_1 = new JMenuItem("Cut");
        item2_2 = new JMenuItem("Copy");
        item2_3 = new JMenuItem("Paste");
        menu2.add(item2_1);
        menu2.add(item2_2);
        menu2.add(item2_3);

        MyMenuEvent mme = new MyMenuEvent();
        item1_1.addActionListener(mme);

        frame.setJMenuBar(menubar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(320, 160);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        new SwingMenu();
    }

    public class MyMenuEvent implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == item1_1) {
                System.out.println(item1_1.getText());
            }
        }
    }
}

