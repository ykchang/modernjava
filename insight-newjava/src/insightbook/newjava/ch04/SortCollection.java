package insightbook.newjava.ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCollection {

	public static void main(String[] args) {
//		List<BaseballPlayer> list = new ArrayList<BaseballPlayer>();
//		list.sort(new Comparator<BaseballPlayer>() {
//			@Override
//			public int compare(BaseballPlayer object1, BaseballPlayer object2) {
//				return object1.getPlayerName().compareTo(object2.getPlayerName());
//			}
//		});

		List<BaseballPlayer> list = new ArrayList<BaseballPlayer>();
		list.sort(
			(BaseballPlayer object1, BaseballPlayer object2) 
			-> object1.getPlayerName().compareTo(object2.getPlayerName())
		);
	}
}
