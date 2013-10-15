package kw56;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KW56 extends JFrame{
	
	public KW56(){
		super("Layaouts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		final Container cp = getContentPane();
		
		setLayout(new BorderLayout(0, 10));
		cp.add(new JLabel("Hallo;"), BorderLayout.NORTH);
		cp.add(new JTextArea("Das ist nur ein Test!"), BorderLayout.CENTER);
		cp.add(new TreeButtons(), BorderLayout.SOUTH);
		
		/*final LayoutManager layout = new GridLayout(1, 2, 20, 10);
		setLayout(layout);
		
		cp.add(getRightSide());
		cp.add(getLefttSide());*/
			
		
		/*final Container cp = getContentPane();
		cp.add(new JButton("Knopf oben"));
		cp.add(new JButton("Knopf links"));
		cp.add(new JButton("Knopf rechts"));
		cp.add(new JButton("Knopf unten"));
		cp.add(new JButton("Knopf mitte"), 0);
		cp.add(new JTextField(20));
		setSize(300, 300);
		//pack();
		/*for (int i = 0; i < 50; i++)
			cp.add(new JButton("Knopf" + (i + 1)));*/
		setSize(400, 400);
	}

	private Component getLefttSide() {
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(10, 10));
		panel.add(new JButton("Knopf 1"), BorderLayout.NORTH);
		panel.add(new JButton("Knopf 2"), BorderLayout.SOUTH);
		
		return panel;
	}

	private Component getRightSide() {
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(new JLabel("Label"));
		panel.add(new TextField(20));
		
		return panel;
	}
	
}
