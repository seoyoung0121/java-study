package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		
		while(!s.empty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// 비어 있는 경우
		// s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("또치");
		System.out.println(s.pop());
		System.out.println(s.peek()); // pop 하지 않고 맨 위에 뭐있는지 살펴봄 
		System.out.println(s.pop());
		
		

	}

}
