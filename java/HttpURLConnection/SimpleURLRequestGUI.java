/* SimpleURLRequestGUI.java */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class SimpleURLRequestGUI {

    SimpleURLRequest sur;

	JFrame frame;
	JButton button1;
	JTextArea text;
	JTextField url_text;

	SimpleURLRequestGUI() {
		initGUI();
		sur = new SimpleURLRequest();
	}

	private void initGUI() {
		Container c;
		JPanel p;
		JPanel pp;
		ButtonEvent be;

		frame = new JFrame("SimpleURLRequestGUI");

		c = frame.getContentPane();
		p = new JPanel(new BorderLayout());
		pp = new JPanel(new BorderLayout());

		be = new ButtonEvent();
		button1 = new JButton("get");
		button1.addActionListener(be);
		url_text = new JTextField(24);

		text = new JTextArea(24, 20);

		p.add(new JLabel("url "), BorderLayout.WEST);
		p.add(url_text, BorderLayout.CENTER);
		p.add(button1, BorderLayout.EAST);

		pp.add(p, BorderLayout.NORTH);
		pp.add(new JScrollPane(text), BorderLayout.CENTER);
		c.add(pp);

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
		new SimpleURLRequestGUI();
	}

	public class ButtonEvent implements ActionListener {
		//@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == button1) {
				text.setText(sur.getData(url_text.getText()));
			}
		}
	}
}
