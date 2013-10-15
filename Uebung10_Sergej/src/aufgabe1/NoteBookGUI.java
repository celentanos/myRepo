package aufgabe1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class NoteBookGUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel p;
	
	JLabel nameLabel = new JLabel ("Wochentag: ");
	JLabel name1Label = new JLabel ("Termine: ");
	JComboBox name = new JComboBox (new Object[] {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"});
	
	//STRING-Definieren
	
	JTextArea termine = new JTextArea();
	JButton saveButton = new JButton("Speichern");
	JButton showButton = new JButton("Anzeigen");
	JButton closeButton = new JButton("Beenden");
	JButton clearButton = new JButton("Clear");
	
	Map<String,String> notes = new HashMap<String,String>();
	
	public void initGUI()
	
	{
		p= (JPanel)this.getContentPane();
		p.setLayout(null);
		
		nameLabel.setBounds(20,5,110,30);
		p.add(nameLabel);
		
		name1Label.setBounds(160,5,110,30);
		p.add(name1Label);
		
		name.setBounds(20,30,110,30);
		p.add(name);
		
		termine.setBounds(160,30,200,180);
		p.add(termine);
		
		saveButton.setBounds(20,100,110,20);
		p.add(saveButton);
		
		showButton.setBounds(20,130,110,20);
		p.add(showButton);
		
		clearButton.setBounds(20,160,110,20);
		p.add(clearButton);
		
		closeButton.setBounds(20,190,110,20);
		p.add(closeButton);
		
		saveButton.addActionListener(this);
		showButton.addActionListener(this);
		closeButton.addActionListener(this);
		clearButton.addActionListener(this);
		
	}
	
	public NoteBookGUI()
	{
		this.setTitle("GUI_NoteBook");
		this.setSize(400, 300);
		initGUI();	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		String key,value;
		Object source = event.getSource();
		
		if (source==saveButton) //SPEICHERUNG
		{
			
			key = name.getSelectedItem().toString();
			value = termine.getText();
			notes.put(key,value);
			System.out.println ();	
		
		}
		
		if(source==showButton) //ANZEIGEN
		{
			
			key = name.getSelectedItem().toString();
			value = notes.get(key);
			
			if (value == null || value.equals(""))
			{
				termine.setText("Keine Termine");
			}
			
			else 
				termine.setText(value);
			
		}
		
		if(source==clearButton) //Loeschen
		{
			termine.setText("");
		}
		
		if (event.getActionCommand().equals("Beenden"))
		{
			System.exit(0);
		}
	}

}

