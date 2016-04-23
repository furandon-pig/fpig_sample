/* ResourceBandle.java */

import java.awt.*;
import java.awt.Event;
import javax.swing.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBandle extends JFrame {

    protected static final String RESOURCE =
        "ResourceBandleMessages";

    protected static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle(RESOURCE, Locale.getDefault());
    }

    ResourceBandle() {
        super(bundle.getString("Frame.title"));
        getContentPane().add(new JButton(bundle.getString("Button.text")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String [] args) {
        new ResourceBandle();
    }
}
