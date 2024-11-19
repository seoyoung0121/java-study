package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		while(true) {
			System.out.print("수를 입력 하세요: ");
			number = scanner.nextInt();
			int sum = 0;
			if(number%2==1) {
				for(int i=0; i <= number; i++) {
					if(i%2==1) {
						sum+=i;
					}
				}
			}
			else {
				for(int i=0; i <= number; i++) {
					if(i%2==0) {
						sum+=i;
					}
				}
			}
			System.out.print("결과값: ");
			System.out.println(sum);
			
		}
	}
}
