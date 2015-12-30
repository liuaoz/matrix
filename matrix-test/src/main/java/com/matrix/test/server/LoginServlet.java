package com.matrix.test.server;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request req, Response resp) {
		resp.println("<html><head><title>login page</title></head><body>");
		resp.println(req.getParamValue("username") + ",");
		resp.println("welocme to login matrix server.</body></html>");
	}

	@Override
	public void doPost(Request req, Response resp) {
		// TODO Auto-generated method stub

	}

}
