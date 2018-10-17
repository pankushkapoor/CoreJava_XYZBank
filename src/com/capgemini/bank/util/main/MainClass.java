package com.capgemini.bank.util.main;

import com.capgemini.bank.util.ConnectionProvider;

public class MainClass {

	public static void main(String[] args) {
		if(ConnectionProvider.getDBConnection()!=null) System.out.println("Connection Open!!");
		else System.out.println("Some Problem :/");
	}

}
