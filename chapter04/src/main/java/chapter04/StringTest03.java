package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		//String s1 = "Hello " + "World " + "Java" + 21;
//		String s1 = new StringBuilder("Hello ")
//		.append("World ")
//		.append("Java")
//		.append(21)
//		.toString();
		
		String s1 = new StringBuffer("Hello ")
				.append("World ")
				.append("Java")
				.append(21)
				.toString();
		
		System.out.println(s1);
		
		//int s = 0;
		String s2 = "";
		for(int i = 0; i<1000000; i++) {
			// s2=s2+"h";
			// 안끝남
			//s2 = new StringBuffer(s2).append("h").toString();
			//이거랑 같음
			//왜 안끝날까? 메모리 잡고 해제하고 100만번,,,
			
		}
		StringBuffer sb= new StringBuffer("");
		for(int i = 0;i<1000000; i++) {
			sb.append("h");
		}
		String s3=sb.toString();
		
		// String Methods
		
		String s4 = "abcABCabcABC";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc",7)); // 시작지점 7로 지정, 못찾으면 -1 나옴
		System.out.println(s4.substring(3,5)); // AB 3에서 5미만
		
		String s5 = "  ab  cd  ";
		String s6 = "abc,def,ghi";
		String s7 = s5.concat(s6);
		System.out.println(s5.trim()); 
		// ab	cd
		//앞뒤 공백 빼줌
		
		System.out.println(s5.replaceAll(" ", "")); 
		String[] tokens = s6.split(",");
		for(String s: tokens) {
			System.out.println(s); 
		}
		
		String[] tokens2 = s6.split(" "); //한개짜리 배열 나옴 
		for(String s:tokens2) {
			System.out.println(s); 
		}
		
		
	}

}
