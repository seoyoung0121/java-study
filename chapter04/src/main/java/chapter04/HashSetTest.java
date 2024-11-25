package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>();
		
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		Rect r3 = new Rect(4, 50);
		
		set.add(r1);
		set.add(r2);
		set.add(r3);
		
		for(Rect r:set) {
			System.out.println(r); //hashcode, equals 오버라이드 하면 값이 같기에 r1, r2 중 하나만 출력
		}

	}

}
