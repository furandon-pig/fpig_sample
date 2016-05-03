/* Counter.java */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;;
import javax.swing.JButton;;

public class Counter {

    int count = 0;

    JFrame frame = null;

    JMenuBar menubar = null;

    JMenu menu1 = null;
    JMenu menu2 = null;

    JMenuItem item1_1 = null;
    JMenuItem item2_1 = null;

    JLabel result = null;
    JButton button = null;

    Counter() {
        frame = new JFrame("Counter");

        menubar = new JMenuBar();

        menu1 = new JMenu("File");
        menu2 = new JMenu("Menu");

        menubar.add(menu1);
        menubar.add(menu2);

        item1_1 = new JMenuItem("Quit");
        menu1.add(item1_1);

        item2_1 = new JMenuItem("Reset");
        menu2.add(item2_1);

        MyMenuEvent mme = new MyMenuEvent();
        item1_1.addActionListener(mme);
        item2_1.addActionListener(mme);

        frame.setJMenuBar(menubar);

        JPanel p = new JPanel(new BorderLayout());
        result = new JLabel(Integer.toString(count));
        result.setText(Integer.toString(count));

        button = new JButton("count");
        button.addActionListener(mme);

        p.add(result, BorderLayout.CENTER);
        p.add(button, BorderLayout.SOUTH);

        reset();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(p);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void reset() {
        count = 0;
        result.setText(Integer.toString(count));
    }

    public static void main(String... args) {
        new Counter();
    }

    public class MyMenuEvent implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == item1_1) {
                frame.dispose();
                System.exit(0);
            }
            if (ae.getSource() == item2_1) {
                reset();
            }
            if (ae.getSource() == button) {
                count++;
                result.setText(Integer.toString(count));
            }
        }
    }
}

