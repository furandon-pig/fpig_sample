/* LinkURL.java */

import java.io.*;
import java.awt.*;
import java.awt.Event;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;

public class LinkURL {

	JFrame frame;
	JEditorPane edit;
	JLabel label;

	LinkURL() throws IOException {
		JPanel p;
		Container c;

		frame = new JFrame("LinkURL");
		c = frame.getContentPane();

		String text = new String(
			"hello <a href='http://www.yahoo.co.jp/'>yahoo</a> world.");

		edit = new JEditorPane("text/html", text);
		edit.setEditable(false);
		edit.setOpaque(false);
		edit.addHyperlinkListener(new HyperlinkHandler());

		label = new JLabel(" ");

		p = new JPanel(new BorderLayout());
		p.add(edit, BorderLayout.CENTER);
		p.add(label, BorderLayout.SOUTH);

		c.add(p);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String [] args) {
		try {
			new LinkURL();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	class HyperlinkHandler implements HyperlinkListener {
		@Override
		public void hyperlinkUpdate(HyperlinkEvent he) {
			HyperlinkEvent.EventType et;
			et = he.getEventType();

			if (et == HyperlinkEvent.EventType.ACTIVATED) {
				openURLwithBrowser(he.getURL());
			} else if (et == HyperlinkEvent.EventType.ENTERED) {
				label.setText(he.getURL().toString());
			} else if (et == HyperlinkEvent.EventType.EXITED) {
				label.setText(" ");
			}
		}
		public void openURLwithBrowser(URL url) {
			Desktop dp = Desktop.getDesktop();	
			try {
				dp.browse(url.toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
