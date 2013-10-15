package aufgabe1;


public class Warteschlange {
	
	private int currentSize;
	
	private Object [] ws;
	
	public Warteschlange (int n) {
		currentSize = 0;
		ws = new Object [n];
	}
	
	public boolean append(Object x) {
		
		if (currentSize < ws.length) {
			ws[currentSize] = x;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty(){
		if (currentSize == 0){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public Object remove() {
		
		if (isEmpty()) {
			
			return null;
		}
		
		else{
			
			for (int i = 0; i < ws.length; i++){
				ws[i] = ws[i+1];
				currentSize = currentSize - (i + 1);
			}
			
			return ws[0];
		}
				
	}
	
	public String toString() {
		String ausgabe = null;
		for (int i = 0; i == ws.length; i++){
			ausgabe = ausgabe + ws[i];
		}
		return ausgabe;
	}
	
	
			
}
