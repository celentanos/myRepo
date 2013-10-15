package programm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class ProgrammGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -2654122148608276635L;
	JPanel p;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
//===Die ganzen Knoepfe und so...==================================================================
	JLabel kontonummerlbl = new JLabel("KontoNr.:");
	JTextField kontonummertxt = new JTextField();
	JLabel betraglbl = new JLabel("Betrag:");
	JTextField betragtxt = new JTextField();
	JLabel dispolimitlbl = new JLabel("Dispolimit:");
	JTextField dispolimittxt = new JTextField();
	JButton ein = new JButton("Einzahlung");
	JButton aus = new JButton("Auszahlung");
	JButton addkonto = new JButton("add Konto");
	JButton delkonto = new JButton("del Konto");
	JMenuBar menu = new JMenuBar();

	JLabel tablbl1 = new JLabel("Konto");
	JLabel tablbl2 = new JLabel("Betrag");
	JLabel tablbl3 = new JLabel("Dispolimit");

	JTextArea kontolistetxtar = new JTextArea();
//===Tabelle==================================================================================
	String[][] inhalt;
	JTable tabelle;
//===Menu=====================================================================================
	JMenu menu1 = new JMenu("Datei");
	JMenuItem beendenItem = new JMenuItem("Beenden");
//===Map======================================================================================
	Map<Integer, Konto> konten = new TreeMap<Integer, Konto>();

//=== Konstruktor=============================================================================
	public ProgrammGUI() {
		readkonten();
		AbstractTableModel atm = new AbstractTableModel() {
			private static final long serialVersionUID = -4406771747484807059L;
			public String getColumnName(int col) {
				return null; // todo
			}
			public int getRowCount() {
				return inhalt.length;
			}
			public int getColumnCount() {
				return 3;
			}
			public Object getValueAt(int row, int col) {
				return inhalt[row][col];
			}
			public boolean isCellEditable(int row, int col) {
				return false;
			}
			public void setValueAt(Object value, int row, int col) {
				fireTableCellUpdated(row, col);
			}
		};
		
		map2array();
		tabelle = new JTable(atm);
		this.setTitle("Kontenverwaltung");
		initGUI();
	}

	public void initGUI() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // echtes Schliessen (mit d. Kreuz)!
		// addWindowListener(new MyWindowCloser()); //Schliessen mit Bestaetigung...

		addkonto.addActionListener(this);
		delkonto.addActionListener(this);
		ein.addActionListener(this);
		aus.addActionListener(this);
		beendenItem.addActionListener(this);

		tabelle.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				// Klick auf einen Tabelleneintrag
				if (e.getClickCount() == 1) {
					int i = tabelle.getSelectedRow();
					Konto k = konten.get(Integer.parseInt(inhalt[i][0]));
					kontonummertxt.setText(k.getKontonummerS());
					betragtxt.setText(k.getBetragS());
					dispolimittxt.setText(k.getDispolimitS());
				}
			}
		});
		
		initMenu();
		this.setJMenuBar(menu);
		initP1();
		initP2();
		initP3();
		p = (JPanel) this.getContentPane();
		p.setLayout(new BorderLayout());
		p.add(p1, BorderLayout.SOUTH);
		p.add(p2, BorderLayout.CENTER);
		this.pack();
	}

	private void initP3() {
		p3.setLayout(new GridLayout(1, 3));
		p3.add(tablbl1);
		p3.add(tablbl2);
		p3.add(tablbl3);
	}

	private void initP2() {
		p2.setPreferredSize(new Dimension(0, 200));
		p2.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		p2.setLayout(new BorderLayout());
		p2.add(p3, BorderLayout.NORTH);
		p2.add(tabelle, BorderLayout.CENTER);
	}

	private void initP1() {
		p1.setLayout(new GridLayout(5, 2));
		p1.add(kontonummerlbl);
		p1.add(kontonummertxt);
		p1.add(betraglbl);
		p1.add(betragtxt);
		p1.add(dispolimitlbl);
		p1.add(dispolimittxt);
		p1.add(ein);
		p1.add(aus);
		p1.add(addkonto);
		p1.add(delkonto);
	}

	private void initMenu() {
		menu.add(menu1);
		menu1.add(beendenItem);
	}
//===Map in Array umwandeln===================================================================
	private void map2array() {
		Collection<Konto> alleKonten = konten.values();
		inhalt = new String[konten.size()][3];

		int i = 0;
		for (Konto k : alleKonten) {
			inhalt[i][0] = k.getKontonummerS();
			inhalt[i][1] = k.getBetragS();
			inhalt[i][2] = k.getDispolimitS();
			i++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent ereignis) {
		final int ERROR = -1;
		Object source = ereignis.getSource();

		int kontonummer, betrag, dispolimit;

		try {
			kontonummer = Integer.parseInt(kontonummertxt.getText());
			betrag = Integer.parseInt(betragtxt.getText());
			dispolimit = Integer.parseInt(dispolimittxt.getText());
			
		} catch (NumberFormatException e) {
			kontonummer = ERROR;
			betrag = ERROR;
			dispolimit = ERROR;
		}

		if (source == addkonto && kontonummer != ERROR && betrag != ERROR && dispolimit != ERROR) {
			if (kontonummer < 1 || betrag < 1 ||  dispolimit < 0) {
				JOptionPane.showMessageDialog(this, "Bitte geben Sie positive Zahl ein!", "Fehler!", JOptionPane.ERROR_MESSAGE);
			}

			else {
				Konto konto = new Konto(kontonummer, betrag, dispolimit);
				konten.put(kontonummer, konto);
			}
		}

		if (source == delkonto && kontonummer != ERROR && betrag != ERROR && dispolimit != ERROR) {
			
			if (kontonummer < 1 || betrag < 1 ||  dispolimit < 0) {
				JOptionPane.showMessageDialog(this, "Bitte geben Sie positive Zahl ein!", "Fehler!", JOptionPane.ERROR_MESSAGE);
			}

			else {
			konten.remove(kontonummer);
			}
		}

		if (source == ein && kontonummer != ERROR && betrag != ERROR && dispolimit != ERROR) {

			if (kontonummer < 1 || betrag < 1 || dispolimit < 0) {
				JOptionPane.showMessageDialog(this, "Bitte geben Sie positive Zahl ein!", "Fehler!", JOptionPane.ERROR_MESSAGE);
			}

			else {
				Konto k = konten.get(kontonummer);
				if (k == null) {
					JOptionPane.showMessageDialog(this, "Konto wurde nicht gefunden!", "Fehler!", JOptionPane.ERROR_MESSAGE);
				} 
				
				else {
					int neuerbetrag = betrag + k.getBetrag();
					k.betrag = neuerbetrag;
				}
			}
		}

		if (source == aus && kontonummer != ERROR && betrag != ERROR && dispolimit != ERROR) {

			if (kontonummer < 1 || betrag < 1) {
				JOptionPane.showMessageDialog(this, "Bitte geben Sie positive Zahl ein!", "Fehler!", JOptionPane.ERROR_MESSAGE);
			}

			else {
				Konto k = konten.get(kontonummer);
				if (k == null) {
					JOptionPane.showMessageDialog(this, "Konto wurde nicht gefunden!", "Fehler!", JOptionPane.ERROR_MESSAGE);
				} else {
					int neuerbetrag = k.getBetrag() - betrag;
					if (neuerbetrag < -dispolimit) {
						JOptionPane.showMessageDialog(this, "Sie habet d. Limit erreicht!", "Fehler!", JOptionPane.ERROR_MESSAGE);
					} else {
						k.betrag = neuerbetrag;
					}
				}
			}
		}
		
		if (kontonummer == ERROR && source != beendenItem || betrag == ERROR && source != beendenItem || dispolimit == ERROR && source != beendenItem){
			JOptionPane.showMessageDialog(this, "Falsche Eingabe!", "Fehler!", JOptionPane.ERROR_MESSAGE);
		}
		
		if (source == beendenItem) {
			writekonten();
			System.exit(0);
		}
		
		map2array();
		tabelle.repaint();
		writekonten();
	}

	@SuppressWarnings("unchecked")
	private void readkonten() {// ===Aus einer Datei lesen!=====================================================
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("konten.dat"));
			konten = (Map<Integer, Konto>) input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Die Datei wurde nicht gefunden!", "Fehler!", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void writekonten() {// ===In eine Datei schreiben!!!===================================================
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