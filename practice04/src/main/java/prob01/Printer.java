package prob01;

public class Printer {
//	public void println(Object object) {
//		System.out.println(object);
//	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t + " ");
		}
		System.out.println("\n");
	}

	public int sum(Integer... nums) {
		int s= 0;
		for(Integer n : nums) {
			s += n;
		}
		return s;
	}
}
