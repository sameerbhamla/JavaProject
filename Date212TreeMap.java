import java.util.TreeMap;

public class Date212TreeMap 
{
	 TreeMap<Date212, String> dtm = new TreeMap(new Date212Comparator()); //date tree map

	 public void add(Date212 date) 
	 {
	     dtm.put(date, null);
	 }
	  
	 public String toString() 
	 {
	     String s = "";
	     Date212 d = dtm.firstKey();
	     while(d != null)
	     {
	    	 s += d.toString();
	    	 s += "\n";
	    	 d = dtm.higherKey(d);
	     }
	     
	     return s;
	 }
}