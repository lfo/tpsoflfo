package com.bissy.distrib.sockets;

public class ReverseEchoProtocol {

	
	 public String processInput(String line) {
	        return new StringBuilder(line).reverse().toString();
	    }

}
