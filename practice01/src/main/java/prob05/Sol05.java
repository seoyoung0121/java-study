package prob05;

public class Sol05 {
	public static void main(String[] args) {
		String number="";
		int count=0;
		for(int i = 1; i <= 100; i++) {
			number=String.valueOf(i);
			count=0;
			for(int j=0 ; j < number.length(); j++) {
				if (number.charAt(j)=='3' || number.charAt(j)=='6' || number.charAt(j)=='9') {
					count+=1;
				}
			}
			if(count>0) {
				System.out.print(i);
				System.out.print(" ");
				System.out.print("짝".repeat(count));
				System.out.print("\n");
			}
		}

	}
}
