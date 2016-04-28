/* NengoConvertGUI.java */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class NengoConvertGUI {
    JTextField input = null;
    JTextArea result = null;

    NengoConvertGUI() {
        JFrame frame = new JFrame("NengoConvertGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        StringBuilder sb = new StringBuilder();
        sb.append("西暦・和暦を相互変換します。<BR>");
        sb.append("「2016」、「h28」のように入力してください。");
        JEditorPane help = new JEditorPane("text/html", sb.toString());
        help.setEditable(false);
        help.setOpaque(false);

        input = new JTextField(10);
        result = new JTextArea(10, 8);

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());

        p2.add(new JLabel("西暦・和暦"), BorderLayout.WEST);
        p2.add(input, BorderLayout.CENTER);
        p1.add(help, BorderLayout.NORTH);
        p1.add(new JScrollPane(result), BorderLayout.CENTER);
        p1.add(p2, BorderLayout.SOUTH);

        frame.getContentPane().add(p1);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    new NengoConvertGUI();
                }
        });
    }

    public class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
}

