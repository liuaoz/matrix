package com.matrix.test.server;

import java.util.Map;

public class WebApp {

	private static ServletContext servletContext;

	static {
		servletContext = new ServletContext();

		Map<String, String> mapping = servletContext.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");

		Map<String, String> servlet = servletContext.getServlet();
		servlet.put("login", "com.matrix.test.server.LoginServlet");
		servlet.put("register", "com.matrix.test.server.RegisterServlet");

	}

	public WebApp() {

	}

	public static Servlet getServlet(String url) {
		if (url == null || url.equals("")) {
			return null;
		} else {
			Class<?> c;
			Object obj = null;
			try {
				c = Class.forName(servletContext.getServlet().get(servletContext.getMapping().get(url)));
				obj = c.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

			return (Servlet) obj;
		}
	}

}
