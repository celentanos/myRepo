package aufgabe_D;

import java.io.*;

public class D {

	public static void main(String[] args) {
		float val = 12000000000000000000000000f;
		String descr = "abba";

		// a.i: Speichern - Stream
		try {
			OutputStream outputstream = new FileOutputStream("FileOMG.txt");
			OutputStreamWriter output = new OutputStreamWriter(outputstream);
			PrintWriter writer = new PrintWriter(output);
			writer.print(" I r g e n d e t w a s " + val + descr);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// a.ii: Speichern - Objekt
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream("FileDat.txt"));
			output.writeObject(val + descr);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// b.i: Lesen - Stream
		try {
			InputStream istream = new FileInputStream("FileOMG.txt");
			InputStreamReader inp = new InputStreamReader(istream);
			BufferedReader reader = new BufferedReader(inp);
			String zeile = reader.readLine();
			while (zeile != null) {
				System.out.println(zeile);
				zeile = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Lesefehler");
		}
		
		// b.ii: Lesen - Objekt
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("FileDat.txt"));
			System.out.println(input.readObject());
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}