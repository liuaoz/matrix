package com.matrix.test.server;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request req, Response resp) {
		
	}

	@Override
	public void doPost(Request req, Response resp) {
		resp.println("<html><head><title>register page</title></head><body>");
		resp.println(req.getParamValue("username") + ",");
		resp.println("welocme to register matrix server.</body></html>");
	}

}
