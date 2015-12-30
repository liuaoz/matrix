package com.matrix.test.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年12月1日
 * 
 */
public class Server {

	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";

	public static final String CODE_OK = "200";
	public static final String CODE_NOT_FOUND = "404";
	public static final String CODE_SERVER_ERR = "500";

	public static final String STATUS_OK = "OK";

	private boolean isShutDown = false;

	public Server() {
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	/**
	 * default port is 9999
	 */
	public void start() {
		start(9999);
	}

	/**
	 * start a server
	 */	
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			stop();
			System.out.println("start a server exception!!!");
		}

	}

	/**
	 * receive the request from client
	 */
	private void receive() {
		try {

			while (!isShutDown) {
				Socket s = server.accept();
				System.out.println("======");
				Thread t = new Thread(new Dispatcher(s));
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
			stop();
		}

	}

	/**
	 * stop the server
	 * 
	 * @throws IOException
	 */
	public void stop() {
		isShutDown = true;
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

