import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/***
 * コレクションテスト
 * @author nayuf
 *
 */
public class CollectionTest03 {
	public static void main(String[] args) {
		String[] array = {"ねこ", "いぬ", "かえる", "あひる"};
		HashMap<String, String> hashmap = new HashMap<String, String>();
		LinkedHashMap<String, String> linkedhashmap = new LinkedHashMap<String, String>();
		TreeMap<String, String> treemap = new TreeMap<String, String>();
		
		for (int i = array.length; i > 0; i--) {
			hashmap.put(String.valueOf(i), array[i-1]);
			linkedhashmap.put(String.valueOf(i), array[i-1]);
			treemap.put(String.valueOf(i), array[i-1]);
		}
		
		System.out.println("HashMap : " + hashmap.toString());
		System.out.println("LinkedHashMap : " + linkedhashmap.toString());
		System.out.println("TreeMap : " + treemap.toString());
	}
}
