package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// 내 컴터 ip address 찾아보자
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostIPAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName); // Appleui-MacBook.local
			System.out.println(hostIPAddress);
			
			byte[] IPAddresses = inetAddress.getAddress();
			for (byte IPAddress : IPAddresses) {
				//System.out.println(IPAddress); //unsign으로 넣었는데 sign으로 출력해서 이상하게 나옴
				System.out.println(IPAddress & 0x000000ff); 
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
