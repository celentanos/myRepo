package kw55;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GgtGui extends JFrame implements ActionListener{
	final JTextField f1;
	final JTextField f2;
	final JLabel res;
	final JButton calc;
	
	public GgtGui(){
		super("ggt");
		
		final Container cp = getContentPane();
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	//echtes Schliessen (Kreuz)!
		addWindowListener(new MyWindowCloser());
		
		f1 = new JTextField(12);
		f2 = new JTextField(12);
		calc = new JButton("Berechne");
		res = new JLabel("0");
		
		calc.addActionListener(this);
		
		cp.add(f1);
		cp.add(f2);
		cp.add(calc);
		cp.add(res);
		
		//setSize(200, 200);
		pack();
		
		//Dialog zentrieren!
		final Dimension d = this.getToolkit().getScreenSize();
		setLocation(((d.width - this.getWidth()) / 2),
					((d.height - this.getHeight()) / 2));
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hallo :)");
		long x1 = 0, x2 = 0;
		
		//Text -> Zahl, mit Fehlerbehandlung
		try{
		x1 = Long.parseLong(f1.getText());
		x2 = Long.parseLong(f2.getText());
		}
		catch (NumberFormatException err){
			JOptionPane.showMessageDialog(this, "Eingegebener Wert ist keine Zahl!", "Fehler!", JOptionPane.ERROR_MESSAGE);
			System.err.println("Keine Zahl");
			return;
		}
		//GGT - Algorithmus
		long n, m, r;
		
		n = x1; m = x2;
		r = n % m;
		while (r!=0){
			n = m;
			m = r;
			r = n % m;
		}
		//Ausgabe
		res.setText(String.valueOf(m));
		System.out.println( "Der ggT von "+ x1 +" und "+ x2 +" ist "+ m);
		
		//Dialoggroesse anpassen!
		pack();
		
	}
}
