package javase.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SimpleServer implements Runnable {
	@Override
	public void run() {

		ServerSocket serverSocket = null;
		try {

			serverSocket = new ServerSocket(3333);

			serverSocket.setSoTimeout(6000);

			while (true) {

				Socket clientSocket = serverSocket.accept();

				BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				System.out.println("Client said :" + inputReader.readLine());
			}

		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
