package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액:");
		int amount = scanner.nextInt();
		int money;
		int count;

		for (int i = 0; i < MONEYS.length; i++) {
			money = MONEYS[i];
			count = amount / money;
			amount = amount % money;

			System.out.print(money);
			System.out.print("원 : ");
			System.out.print(count);
			System.out.println("개");
		}

		scanner.close();
	}
}