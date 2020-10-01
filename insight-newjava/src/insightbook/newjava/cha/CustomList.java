package insightbook.newjava.cha;

import java.util.ArrayList;
import java.util.List;

public class CustomList {
	private List list = new ArrayList();
	
	public void add(Object element) {
		list.add(element);
	}
	
	public Object get(int index) {
		return list.get(index);
	}
}