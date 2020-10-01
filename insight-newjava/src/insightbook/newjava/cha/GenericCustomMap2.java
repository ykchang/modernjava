package insightbook.newjava.cha;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericCustomMap2<K, V> {
	private Map<K, V> map = new HashMap<K, V>();
	
	public void put(K key, V value) {
		map.put(key, value);
	}
	
	public V get(K key) {
		return map.get(key);
	}
	
	public static <K, V> Map<K, V> sorting(Map<K, V> map) {
		return map;
	}
	
	public static void addNumbers(List<? super Integer> list) {
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	}
}