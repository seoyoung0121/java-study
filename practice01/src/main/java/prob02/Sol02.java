package prob02;

public class Sol02 {
	public static void main(String[] args) {

		String str = "";

		for (int i = 1; i < 19; i++) {
			str += String.valueOf(i);
			if (i >= 10) {
				System.out.println(str);
			}
		}

	}
}