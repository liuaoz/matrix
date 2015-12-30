package com.matrix.test.server;

/**
 *
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年12月2日
 * 
 */
public abstract class Servlet {

	public void service(Request req, Response resp) throws Exception {
		this.doGet(req, resp);
		this.doPost(req, resp);
	}

	public abstract void doGet(Request req, Response resp) throws Exception;

	public abstract void doPost(Request req, Response resp) throws Exception;

}
