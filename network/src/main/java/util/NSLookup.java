package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
			
			Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.print("> ");
				String s = scanner.nextLine();
				if("exit".equals(s)) {
					break;
				}
				InetAddress[] inetAddresses = InetAddress.getAllByName(s); // 하나의 도메인에 여러 IP 매핑될 수 있음
				for(InetAddress inetAddress: inetAddresses) {
					System.out.print(s + " : ");
					System.out.println(inetAddress.getHostAddress());
				}
					
			} 
		} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		

	}

}
