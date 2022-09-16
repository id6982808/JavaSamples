import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/***
 * コレクションテスト
 * @author nayuf
 *
 */


public class CollectionTest02 {
	private static int dataCount = 20000;
	
	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		
		System.out.println("追加処理の比較");
		System.out.println(" ArrayList = " + getAddTime(arraylist));
		System.out.println(" LinkedList = " + getAddTime(linkedlist));
		System.out.println("検索処理の比較");
		System.out.println(" ArrayList(for-loop-get) = " + getGetTime(arraylist, false));
		System.out.println(" LinkedList(for-loop-get) = " + getGetTime(linkedlist, false));
		System.out.println(" ArrayList(iterator) = " + getGetTime(arraylist, true));
		System.out.println(" LinkedList(iterator) = " + getGetTime(linkedlist, true));
		System.out.println("更新処理の比較");
		System.out.println(" ArrayList(先頭要素) = " + getUpTime(arraylist, 0));
		System.out.println(" LinkedList(先頭要素) = " + getUpTime(linkedlist, 0));
		System.out.println(" ArrayList(中間要素) = " + getUpTime(arraylist, dataCount/2));
		System.out.println(" LinkedList(中間要素) = " + getUpTime(linkedlist, dataCount/2));
		System.out.println("削除処理の比較");
		System.out.println(" ArrayList = " + getDelTime(arraylist));
		System.out.println(" LinkedList = " + getDelTime(linkedlist));
	}
	
	private static String getAddTime(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < dataCount; i++) {
			list.add(i);
		}
		long endTime = System.currentTimeMillis();
		return (endTime - startTime) + " msec";
	}
	
	private static String getGetTime(List<Integer> list, boolean iteratorFlg) {
		long startTime, endTime;
		
		if (iteratorFlg) {
			startTime = System.currentTimeMillis();
			for (Iterator<Integer> iterator=list.iterator(); iterator.hasNext(); ) {
				iterator.next();
			}
			endTime = System.currentTimeMillis();
		} else {
			startTime = System.currentTimeMillis();
			for (int i = 0; i < dataCount; i++) {
				list.get(i);
			}
			endTime = System.currentTimeMillis();
		}
		return (endTime - startTime) + " msec";
	}
	
	private static String getUpTime(List<Integer> list, int index) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < dataCount; i++) {
			list.add(index, i);
		}
		long endTime = System.currentTimeMillis();
		return (endTime - startTime) + " msec";
	}
	
	private static String getDelTime(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		while (!list.isEmpty()) {
			list.remove(0);
		}
		long endTime = System.currentTimeMillis();
		return (endTime - startTime) + " msec";
	}
}
