package insightbook.newjava.cha;

import java.util.HashMap;
import java.util.Map;

public class GenericCustomMap<K, V> {
	private Map<K, V> map = new HashMap<K, V>();
	
	public void put(K key, V value) {
		map.put(key, value);
	}
	
	public V get(K key) {
		return map.get(key);
	}
}