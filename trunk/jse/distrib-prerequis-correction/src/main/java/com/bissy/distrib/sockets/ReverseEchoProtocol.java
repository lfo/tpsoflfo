package com.bissy.distrib.sockets;

public class ReverseEchoProtocol {

	
	 public String processInput(String line) {
	        System.out.println("Ask for an echo of : "+line);
	        String answer = new StringBuffer(line).reverse().toString();
	        System.out.println(answer);
	        return answer;
	    }

}
