package kw53;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Uebung8_2b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordCout();
	}
	public static void wordCout(){
		final Map<String, Integer> wordMap = new TreeMap<String, Integer>();
		
		Reader r = null;
		
		try {
			//Lies die Datei
			r = new FileReader("src/kw53_2012_01_05/Uebung8_2b.java");
		} catch(FileNotFoundException e){
			//z.B.: Datei nicht gefunden
			System.err.println("Datei nicht gefunden!");
			e.printStackTrace();
		}
		
		//Zerpfl�ckt den Text
		StreamTokenizer st = new StreamTokenizer(r);
		try{
			//Lies die Datei
			while(StreamTokenizer.TT_EOF != st.nextToken()){
				//Aktueller Token ist ein Word
				if (st.ttype == StreamTokenizer.TT_WORD){
					//Aktuelles Wort aus der Datei
					final String word = st.sval;
					
					if (wordMap.containsKey(word)){
						//�berschreibe alten Wert (erh�hen um 1)
						wordMap.put(word, wordMap.get(word)+ 1);
					}
					else{
						//F�ge neues Wort ein
						wordMap.put(word, 1);
					}
				}
			}
		}catch (IOException e){
			//z.B.: keine Leserechte
			e.printStackTrace();
		}
		
		System.out.println("Anzahl der verschiedenen W�rter: " + wordMap.size());
		
		Set<Entry<String, Integer>> entrySet = wordMap.entrySet();
		
		for (Entry<String, Integer> entry : entrySet){
			//z.B.: "3 x static"
//			System.out.println(entry.getValue() + " x " + entry.getKey());
		}
		
		List<String>keyList = new LinkedList<String>(wordMap.keySet());
		Collections.sort(keyList);
		
		for (String key : keyList)
			System.out.println(wordMap.get(key) + " x " + key);
	}

}
