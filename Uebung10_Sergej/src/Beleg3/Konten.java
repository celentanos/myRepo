package Beleg3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Beleg3.Konto;


public class Konten extends JFrame implements ActionListener{
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	JPanel p;
	JLabel nameLabel = new JLabel (" Kontonummer: ");
	JLabel name1Label = new JLabel (" Kontostand: ");
	JLabel name2Label = new JLabel ("     Betrag: ");
	JComboBox kto = new JComboBox ();
	JTextArea betrag = new JTextArea ();
	
	//STRING-Definieren
	
	JLabel kontostand = new JLabel();
	JButton showButton = new JButton("Anzeigen");
	JButton closeButton = new JButton("Beenden");
	JButton einzahlen = new JButton("Einzahlen");
	JButton auszahlen = new JButton("Auszahlen");
	JTextArea betr = new JTextArea ();
	Map<Integer,Konto> konten = new HashMap<Integer,Konto>();
	
	public void initGUI()
	
	{
		p= (JPanel)this.getContentPane();
		p.setLayout(null);
		
		nameLabel.setBounds(20,5,110,30);
		p.add(nameLabel);
		
		name1Label.setBounds(20,40,110,30);
		p.add(name1Label);
		
		name2Label.setBounds(20,75,110,30);
		p.add(name2Label);
		
		kto.setBounds(120,10,110,20);
		p.add(kto);
		
		betr.setBounds(120,75,110,20);
		p.add(betr);
		
		kontostand.setBounds(120,40,200,20);
		p.add(kontostand);
		
		showButton.setBounds(20,160,110,20);
		p.add(showButton);
		
		auszahlen.setBounds(140,160,110,20);
		p.add(auszahlen);
		
		einzahlen.setBounds(260,160,110,20);
		p.add(einzahlen);
		
		closeButton.setBounds(20,220,350,20);
		p.add(closeButton);
		
		showButton.addActionListener(this);
		closeButton.addActionListener(this);
		einzahlen.addActionListener(this);
		auszahlen.addActionListener(this);
		
		
		
		readkonten();
		Collection<Konto> alleKonten = konten.values();
		for (Konto k : alleKonten) {
			kto.addItem(k.getKontonummer());
		}
	} 
	private void readkonten(){//===Aus einer Datei lesen!=============
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("konten.dat"));
			konten = (Map<Integer, Konto>) input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Die Datei wurde nicht gefunden!", "Fehler!", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	public Konten()
	{
		this.setTitle("Kontenmanagement");
		this.setSize(400, 300);
		initGUI();	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		String key,value;
		Konto konto;
		Object source = event.getSource();
		
		if (source==einzahlen) //Einzahlen-Button
		{
			key = kto.getSelectedItem().toString();
			konto = konten.get(Integer.parseInt(key));
			
			konto.setBetrag(konto.getBetrag() + Integer.parseInt(betr.getText()));
			writekonten();
			readkonten();
			
			key = kto.getSelectedItem().toString();
			value = Integer.toString(konten.get(Integer.parseInt(key)).getBetrag());
			kontostand.setText(value);
		}
		if (source==auszahlen) //Auszahlen-Button
		{
			
			key = kto.getSelectedItem().toString();
			konto = konten.get(Integer.parseInt(key));
			
			if( konto.getBetrag() - Integer.parseInt(betr.getText()) > konto.getDispolimit() * -1) {
				konto.setBetrag(konto.getBetrag() - Integer.parseInt(betr.getText()));
				writekonten();
				readkonten();
				
			} else {
				JOptionPane.showMessageDialog(this, "Dispolimit kann nich �berzogen werden! Auszahlung nicht m�glich!");
			} 
			
			key = kto.getSelectedItem().toString();
			value = Integer.toString(konten.get(Integer.parseInt(key)).getBetrag());
			kontostand.setText(value);
			
		}
		
		if(source==showButton) //Anzeigen-Button
		{
			key = kto.getSelectedItem().toString();
			value = Integer.toString(konten.get(Integer.parseInt(key)).getBetrag());
			kontostand.setText(value);
		}
		
		if (event.getActionCommand().equals("Beenden"))
		{
			System.exit(0);
		}
	}
	//in konten.dat schreiben
	private void writekonten() {
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream("konten.dat"));
			output.writeObject(konten);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

