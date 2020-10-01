package insightbook.newjava.cha;

import java.util.ArrayList;
import java.util.List;

public class GenericCustomList<E> {
	private List<E> list = new ArrayList<E>();
	
	public void add(E element) {
		list.add(element);
	}
	
	public E get(int index) {
		return list.get(index);
	}
}