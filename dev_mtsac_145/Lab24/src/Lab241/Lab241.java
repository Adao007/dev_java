package Lab241;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lab241 {
	static public void main(String[ ] args)
	{
		HashMap<String, String> map = new HashMap<>();
		map.put("david", "1347");
		map.put("cindy", "9999");
		map.put("alice", "1234");
		map.put("paul", "5757");
		map.put("mary", "3719"); 
		
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		System.out.println("----------------------------");
		
		for(Map.Entry<String, String> e : map.entrySet() ) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + " : " + value);
			
		}
		
		System.out.println("----------------------------------");
		String val = (String)map.get("alice");
		System.out.println("Value for key alice is: " + val); 
	}
}
