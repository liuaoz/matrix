package com.matrix.test.server;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable {
	private Socket s;
	private Request req;
	private Response resp;
	private int code = 200;

	public Dispatcher(Socket s) {
		this.setS(s);
		try {
			this.req = new Request(s.getInputStream());
			this.resp = new Response(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			code = 500;
			return;
		}
	}

	@Override
	public void run() {
		try {
			Servlet servlet = WebApp.getServlet(req.getUrl());
			if (servlet == null) {
				this.code = 404;
			} else {
				servlet.service(req, resp);
			}
			resp.pushToClient(code);
		} catch (Exception e) {
			try {
				resp.pushToClient(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

}
