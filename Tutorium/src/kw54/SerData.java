package kw54;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class SerData implements Serializable{
	private final GregorianCalendar cal;
	
	public SerData(int day, int month, int year){
		cal = new GregorianCalendar(year, month, day);
	}
	
	public String toString(){
		return cal.get(GregorianCalendar.DAY_OF_MONTH) + "." + cal.get(GregorianCalendar.MONTH) + "." + cal.get(GregorianCalendar.YEAR);
		
	}
}
