package u2013_04_11;

import java.awt.*;
import javax.swing.*;

public class Composite {
	public static void main(String[] args) {
		JFrame f = new JFrame("Composite");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = new JPanel(new BorderLayout());
		c.add(new JButton("foo"), BorderLayout.CENTER);
		f.getContentPane().add(c);
		f.pack();
		f.setVisible(true);
	}
}