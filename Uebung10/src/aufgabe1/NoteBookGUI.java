package aufgabe1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class NoteBookGUI extends JFrame implements ActionListener{
	JPanel cp;
	
	JLabel nameLabel = new JLabel("Wochentag:");
	JLabel terminLabel = new JLabel("Termin:");
	JComboBox name = new JComboBox(new Object[] {"Mo","Di","Mi","Do","Fr","Sa","So"});
	JTextArea termine = new JTextArea();
	JButton saveButton = new JButton("Speichern");
	JButton showButton = new JButton("Anzeigen");
	JButton clearButton = new JButton("Clear");
	JButton beendenButton = new JButton("Beenden");
	
	Map<String,String> notes = new HashMap<String,String>();
	
	ActionListener a = null;
	public void initGUI(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		saveButton.addActionListener(this);
		showButton.addActionListener(this);
		beendenButton.addActionListener(this);
		clearButton.addActionListener(this);
		name.addActionListener(a);
		
		JPanel p = (JPanel)this.getContentPane();
		p.setLayout(null);
		nameLabel.setBounds(20,5,110,30);
		p.add(nameLabel);
		terminLabel.setBounds(160,5,110,30);
		p.add(terminLabel);
		name.setBounds(20,30,110,30);
		p.add(name);
		termine.setBounds(160,30,200,160);
		p.add(termine);
		showButton.setBounds(20,80,110,20);
		p.add(showButton);
		saveButton.setBounds(20,110,110,20);
		p.add(saveButton);
		clearButton.setBounds(20,140,110,20);
		p.add(clearButton);
		beendenButton.setBounds(20,170,110,20);
		p.add(beendenButton);
	}
//===Konstruktor=====================================================
	public NoteBookGUI(){
		this.setTitle("GUI-NoteBook");
		this.setSize(400,250);
		initGUI();
		notes = readnotes();
	}
//===Aus der Datei lesen=============================================
	@SuppressWarnings("unchecked")
	private Map<String, String> readnotes() {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("notizen.dat"));
			notes = (Map<String,String>) input.readObject();
			input.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notes;
	}

	@Override
	public void actionPerformed(ActionEvent ereignis) {
		String key,value;
		Object source = ereignis.getSource();
//===Ereignis:Speichern=========================================
		if (source == saveButton){
//===Speicherung von Notizen====================================
			key = name.getSelectedItem().toString();
			value = termine.getText();
			notes.put(key, value);
			System.out.println(notes);
			writenotes();
		}
		
		if (source == showButton){
//===Selektiere den Tex zum ausgew�hltem Wochentag===============
//===->Anzeige im TextArea=======================================
			key = name.getSelectedItem().toString();
			value = notes.get(key);
			
			if (value == null || value.equals("")){
				termine.setText("keine Termine");
			}
			else {
				termine.setText(value);
			}
		}
		
		if (source == clearButton){
			termine.setText("");
		}
		
		if (source == beendenButton){
			writenotes();
			System.exit(0);
		}
		
	}
//===In eine Datei schreiben!!!=======================================
	private void writenotes() {
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream("notizen.dat"));
			output.writeObject(notes);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}