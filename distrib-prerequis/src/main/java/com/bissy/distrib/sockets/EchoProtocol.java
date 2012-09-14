package com.bissy.distrib.sockets;

public class EchoProtocol {

    public String processInput(String line) {
        System.out.println("Ask for an echo of : "+line);
        String answer = String.format("EchoServer answer : %s %s",line, line);
        System.out.println(answer);
        return answer;
    }

}
