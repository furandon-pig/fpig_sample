/* SwingDropdownList.java */

import javax.swing.JFrame;
import javax.swing.JComboBox;

public class SwingDropdownList {

    JFrame frame = null;
    JComboBox combo_box = null;

    SwingDropdownList() {
        frame = new JFrame("SwingDropdownList");

        String[] list = { "FreeBSD", "NetBSD", "OpenBSD", "Linux" };
        combo_box = new JComboBox(list);

        frame.getContentPane().add(combo_box);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        new SwingDropdownList();
    }

    public class SwingDropdownListEvent implements ActionListener {
        @override
        public void actionPerformed(ActionEvent ae) {
        }
    }

}

