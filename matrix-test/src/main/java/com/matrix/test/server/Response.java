package com.matrix.test.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * assemble response message
 * 
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年12月1日
 * 
 */
public class Response {

	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";

	private StringBuilder content;

	private StringBuilder headInfo;

	private BufferedWriter bw;

	private int len;

	public Response() {
		headInfo = new StringBuilder();
		content = new StringBuilder();
		len = 0;
	}

	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}

	public Response(Socket s) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch (IOException e) {
			headInfo = null;
		}
	}

	/**
	 * build content
	 * 
	 * @param info
	 * @return
	 */
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;
	}

	/**
	 * build content and \r\n
	 * 
	 * @param info
	 * @return
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info + CRLF).getBytes().length;
		return this;
	}

	private void createHeadInfo(int code) {
		if (headInfo == null) {
			code = 500;
		}
		// response
		// 1.HTTP protocol version,status code, description
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch (code) {
		case 200:
			headInfo.append("OK");
			break;
		case 500:
			headInfo.append("MATRIX'S SERVER ERROR");
			break;
		case 404:
			headInfo.append("NOT FOUND");
			break;
		default:
		}
		// append("OK")
		headInfo.append(CRLF);

		// 2.response head
		headInfo.append("Server:matrix server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);

		// 3.content length
		headInfo.append("Content-length:").append(len).append(CRLF);

		// 4.middle between head and body
		headInfo.append(CRLF);

	}

	public void pushToClient(int code) throws IOException {
		createHeadInfo(code);
		bw.append(headInfo);
		bw.append(content);
		bw.flush();
	}

	public void close() throws IOException {
		bw.close();
	}

}
