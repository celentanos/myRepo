package aufgabe_C;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener{
	JPanel p = new JPanel();
	JButton b1 = new JButton("Druecken 1");
	JButton b2 = new JButton("Druecken 2");
	JLabel l = new JLabel("Anzeige");
	
	public GUI(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		b1.addActionListener(this);//gibt eine Möglichkeit beim Drücken auf die Taste eine Aktion ausführen
		b2.addActionListener(this);//gibt eine Möglichkeit beim Drücken auf die Taste eine Aktion ausführen
		p = (JPanel) this.getContentPane();//!!!!!!
		p.setLayout(new FlowLayout());//zadajot Layout na Panel
		p.add(b1);
		p.add(b2);
		p.add(l);
		pack();	//methode grupperierung	
	}

	public void actionPerformed(ActionEvent e) {
		Object eingabe = e.getSource();
		if(eingabe == b1){
			l.setText("Hallo!");
		}
		if(eingabe == b2){
			l.setText("Prived!");
		}
	}
}
