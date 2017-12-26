package com.kara.datagen;

import java.net.*;
import java.io.*;

public class DataFeedOutChannel {
	int portNumber=9087;
	PrintWriter pw;
	ServerSocket soc;
	Socket clientSocket;
	
	public DataFeedOutChannel(int portNumber){
		this.portNumber=portNumber;
		pw=this.getServerStream("localhost", this.portNumber);
	}
	

	public PrintWriter getServerStream(String hostname,int portNumber){
		try {
			System.out.println("Defining new Socket");
			soc = new ServerSocket(portNumber);
			System.out.println("Waiting for Incoming Connection at : "+portNumber);
			clientSocket = soc.accept();

			System.out.println("Connection Received");
			OutputStream outputStream = clientSocket.getOutputStream();
			// Keep Reading the data in a Infinite loop and send it //over to
			// the Socket.
			PrintWriter out = new PrintWriter(outputStream, true);
			return out;
			//clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void conclude(){
		try{
			soc.close();
			clientSocket.close();
			pw.close();
			System.out.println("DataFeedOutChannel concluded by closing sockets and streams");
		}catch(IOException io){
			System.out.println("Exception "+io);
		}
	}

}
