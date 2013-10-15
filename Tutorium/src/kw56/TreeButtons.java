package kw56;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class TreeButtons extends JComponent implements ActionListener{
	private final JButton but1 = new JButton("Knopf 1");
	private final JButton but2 = new JButton("Knopf 2");
	private final JButton but3 = new JButton("Knopf 3");
	public TreeButtons(){
		setLayout(new GridLayout(1,3,5,0));
		add(but1);
		add(but2);
		add(but3);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == but1)
			System.out.println("Der erste tolle Knopf wurde ausgelöst!");
		else if(e.getSource() == but2)
			System.out.println("Der zweite nicht so tolle Knopf!");
		else if(e.getSource() == but3)
			System.out.println("");
		else{
			//...
		}
		
	}
}
