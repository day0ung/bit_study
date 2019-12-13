package main;

import java.net.Socket;

import net.ReadThread;
import view.ClientFrame;

public class mainClass {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.2.22", 9000);
			System.out.println("Connection Success!");
			
			ClientFrame cf = new ClientFrame(socket);
			
			new ReadThread(socket, cf).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}