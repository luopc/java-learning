package com.luopc.base;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByAddress(new byte[] {127,0,0,1});
			System.out.println(ip.isReachable(2000));
			
			InetAddress baduIp = InetAddress.getByName("www.baidu.com");
			System.out.println(ip.isReachable(2000));
			System.out.println(baduIp.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
