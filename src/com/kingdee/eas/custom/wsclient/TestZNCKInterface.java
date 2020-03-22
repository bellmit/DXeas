package com.kingdee.eas.custom.wsclient;

import java.rmi.RemoteException;

public class TestZNCKInterface {
	
	
	
	
	/**
	 * ²âÊÔ½Ó¿Ú
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException{
		
		Ctr_LedSoapProxy proxy = new Ctr_LedSoapProxy();
		
		
		String lightStr = proxy.lighten("COM2", "9600", 10);
		
		
		System.out.println("lighten result:"+lightStr);
		
		
		String ext = proxy.extinguish("COM2", "9600", 15);
		
		System.out.println("ext result:"+lightStr);
		
		
		String allout = proxy.allOut("COM2", "9600");
		
		
		System.out.println("lighten result:"+lightStr);
		
	}
}
