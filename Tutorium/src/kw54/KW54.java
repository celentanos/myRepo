package kw54;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

public class KW54 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//auf2und3();
		
		auf4();
	}
	
	private static void auf4(){
		SerData myDate = new SerData(12, 11, 2012);
		System.out.println(myDate);
		
		try {
			writeDate(myDate);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			readDate();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void readDate() throws FileNotFoundException, ClassNotFoundException,	IOException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("date.ser"));
		SerData mydaData = (SerData) in.readObject();
		System.out.println("Gelesen: " + mydaData);
	}
	
	private static void writeDate(SerData myData) throws FileNotFoundException, ClassNotFoundException,	IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("date.ser"));
		out.writeObject(myData);
		
	}
	
	private static void auf2und3(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("collatz.txt", true));
			//on´hne 'true' wird immer wieder neue Datei angelegt...
			for (long i = 1; i < 1000; ++i)
			collatz(i, writer);
			//Wichtig!
			writer.close();
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NumberTooLargeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void collatz(long n, BufferedWriter writer) throws ArithmeticException, NumberTooLargeException, IOException {
		if (n < 1)
			throw new ArithmeticException("n < 1");
		
		if (n > 1000)
			throw new NumberTooLargeException();
		
		
		writer.write("####" + n + "#####");
		writer.newLine();
		
		while (n > 1){
			if (n % 2 == 0)
				n /= 2;
			else
				n = 3 * n + 1;
			System.out.println(n);
			writer.write("\t" + n);
			writer.newLine();
		}

	}
}
