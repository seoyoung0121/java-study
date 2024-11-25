package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p1;

		// == : 두 객체의 동일성
		System.out.println(p1 == p2); // false
		System.out.println(p1 == p3); // true

		// equals : 두 객체의 동질성
		System.out.println(p1.equals(p2)); // 처음엔 false: 기본 구현은 동일성 비교, 우리가 오버라이딩 해줘야함
		System.out.println(p1.equals(p3)); // true
	}

}
