package kw57;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KW57_4_GUI extends JFrame implements ActionListener {

	JPanel p = new JPanel();
	JButton ein = new JButton("Einzahlung");

	public KW57_4_GUI() {
		initGUI();
		pack();
	}

	private void initGUI() {
		p = (JPanel) this.getContentPane();
		ein.addActionListener(this);
		p.setLayout(new GridLayout());
		p.add(ein);

	}

	public void actionPerformed(ActionEvent erreignis) {
		System.out.println("Hallo!");
	}
}
