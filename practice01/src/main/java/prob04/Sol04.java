package prob04;

import java.util.Scanner;

public class Sol04 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열을 입력하세요: ");
		String str = scanner.nextLine();
		String totalString = "";
		for (int i = 0; i < str.length(); i++) {
			totalString += str.charAt(i);
			System.out.println(totalString);
		}
		scanner.close();
	}
}