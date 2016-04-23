/* TodayGUI.java */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class TodayGUI {

    TodayGUI() {
        JFrame frame = new JFrame("TodayGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Today t = new Today();
        JPanel p = new JPanel(new FlowLayout());
        p.add(new JLabel(t.toString()));

        frame.getContentPane().add(p);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    new TodayGUI();
                }
        });
    }
}

