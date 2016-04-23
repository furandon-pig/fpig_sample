/* CheckBox.java */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class CheckBox {
    JCheckBox check = null;
    JLabel label = null;

    CheckBox() {
        JFrame frame = new JFrame("CheckBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        check = new JCheckBox("checkbox");
        label = new JLabel();
        if (check.isSelected() == true) {
            label.setText("CHECKED");
        } else {
            label.setText("NOT checked");
        }

        ButtonEvent be = new ButtonEvent();
        check.addActionListener(be);

        JPanel p = new JPanel(new BorderLayout());
        p.add(check, BorderLayout.NORTH);
        p.add(label, BorderLayout.SOUTH);

        frame.getContentPane().add(p);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    new CheckBox();
                }
        });
    }

    public class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == check) {
                if (check.isSelected() == true) {
                    label.setText("CHECKED");
                } else {
                    label.setText("NOT checked");
                }
            }
        }
    }
}

