/* HelloGUI.java */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class HelloGUI {
    JButton btn1 = null;
    JButton btn2 = null;

    HelloGUI() {
        JFrame frame = new JFrame("HelloGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn1 = new JButton("Hello");
        btn2 = new JButton("World");

        ButtonEvent be = new ButtonEvent();
        btn1.addActionListener(be);
        btn2.addActionListener(be);

        JPanel p = new JPanel(new FlowLayout());
        p.add(btn1);
        p.add(btn2);

        frame.getContentPane().add(p);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    new HelloGUI();
                }
        });
    }

    public class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btn1) {
                System.out.println("Hello");
            } else if (ae.getSource() == btn2) {
                System.out.println("World");
            }
        }
    }
}

