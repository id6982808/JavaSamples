/***
 * コレクションテスト
 * @author nayuf
 *
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionTest01 implements Comparator<String> {
	private static String[] animal = {"Cat", "Dog", "Frog", "Duck"};
	
	public static void main(String[] args) {
		testHashSet();
		testLinkedHashSet();
		testTreeSet();
	}
	
	private static void testHashSet() {
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < animal.length; i++) {
			hs.add(animal[i]);
		}
		hs.add("Cat");
		hs.add(null);
		System.out.println("HashSet:" + hs);
	}
	
	private static void testLinkedHashSet() {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		for (int i = 0; i < animal.length; i++) {
			lhs.add(animal[i]);
		}
		lhs.add("Cat");
		lhs.add(null);
		System.out.println("LinkedHashSet:" + lhs);
	}
	
	private static void testTreeSet() {
		TreeSet<String> ts1 = new TreeSet<String>();
		TreeSet<String> ts2 = new TreeSet<String>(new CollectionTest01());
		
		for (int i = 0; i < animal.length; i++) {
			ts1.add(animal[i]);
			ts2.add(animal[i]);
		}
		ts1.add("Cat");
		System.out.println("TreeSet(デフォルト):" + ts1);
		System.out.println("TreeSet(降順に変更)" + ts2);
	}
	
	public int compare(String s1, String s2) {
		return s1.compareTo(s2)*-1;
	}
}
