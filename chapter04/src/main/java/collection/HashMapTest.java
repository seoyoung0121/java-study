package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>(); // 키 값은 불변하는 타입으로 하는게 좋음 
		
		m.put("one", 1); // auto boxing
		m.put("two", 2);
		m.put("three", 3);

		int i = m.get("one"); // auto unboxing
		int j = m.get(new String("two"));
		System.out.println(i + ":" + j ); //1:2
		
		m.put("three", 333); // 원래 값 덮음 
		
		// 순회
		Set<String> s = m.keySet();
		for(String key : s) {
			System.out.println(m.get(key));
		}	
	}

}
