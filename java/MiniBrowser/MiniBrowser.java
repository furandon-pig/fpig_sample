/*
 * MiniBrowser.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MiniBrowser {

	JFrame frame;
	JButton btn_go;
    JTextField text_url;
    JEditorPane editor;
    JLabel lbl_status;

	MiniBrowser() {
		initGUI();
	}

	private void initGUI() {
		Container c;
		JPanel p1;
        JPanel p2;
		ButtonEvent be;

		frame = new JFrame("MiniBrowser");

		c = frame.getContentPane();
		p1 = new JPanel(new BorderLayout());
        p2 = new JPanel(new BorderLayout());

        editor = new JEditorPane();
        editor.setContentType("text/html");

        text_url = new JTextField(20);
        lbl_status = new JLabel(" ");

		btn_go = new JButton("go");
		btn_go.addActionListener(new ButtonEvent());

        p1.add(new JLabel("URL"), BorderLayout.WEST);
        p1.add(text_url, BorderLayout.CENTER);
        p1.add(btn_go, BorderLayout.EAST);

        p2.add(p1, BorderLayout.NORTH);
        p2.add(new JScrollPane(editor), BorderLayout.CENTER);
        p2.add(lbl_status, BorderLayout.SOUTH);
		c.add(p2);

		initLookFeel();
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void initLookFeel() {
		try {
			/*
			UIManager.setLookAndFeel(
				UIManager.getSystemLookAndFeelClassName());
			*/

			// Setup the "Metal" look and feel.
			MetalLookAndFeel.setCurrentTheme(
				new DefaultMetalTheme());
			UIManager.setLookAndFeel(
				"javax.swing.plaf.metal.MetalLookAndFeel");

			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) {
		new MiniBrowser();
	}


	public class ButtonEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == btn_go) {
				try {
				    lbl_status.setText("loading...");
				    editor.setPage(text_url.getText());
				    lbl_status.setText("done.");
				} catch (Exception e) {
				    e.printStackTrace();
				    lbl_status.setText("error.");
				}
			}
		}
	}
}
