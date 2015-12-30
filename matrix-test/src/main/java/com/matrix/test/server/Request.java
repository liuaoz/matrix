package com.matrix.test.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * assemble request
 * 
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年12月2日
 * 
 */
public class Request {

	/**
	 * request method
	 */
	private String method;

	/**
	 * request url
	 */
	private String url;

	/**
	 * params of request
	 */
	private Map<String, List<String>> parameterMapValue;

	public static final String CRLF = "\r\n";

	private InputStream is;

	private String requestInfo;

	public Request() {
		method = "";
		url = "";
		parameterMapValue = new HashMap<String, List<String>>();
		requestInfo = "";
	}

	public Request(InputStream is) {
		this();
		this.is = is;
		byte[] data = new byte[20480];
		int len = 0;
		try {
			len = is.read(data);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		requestInfo = new String(data, 0, len);//TODO
		System.out.println("请求数据流为：");
		System.out.println(requestInfo);
		parseRequestInfo();
	}

	/**
	 * parse request info
	 * 
	 * @param requestInfo
	 */
	private void parseRequestInfo() {
		if (requestInfo == null || (requestInfo = requestInfo.trim()).equals("")) {
			return;
		}

		String paramsString = "";

		// 1.method
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int idx = firstLine.indexOf("/");

		this.method = firstLine.substring(0, idx).trim();
		String urlStr = requestInfo.substring(idx, requestInfo.indexOf("HTTP/")).trim();
		if (this.method.equalsIgnoreCase("get")) {
			if (urlStr.contains("?")) {
				String[] arr = urlStr.split("\\?");
				this.url = arr[0];
				paramsString = arr[1];
			} else {
				this.url = urlStr;
			}

		} else if (this.method.equalsIgnoreCase("post")) {
			this.url = urlStr;
			paramsString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		} else {
			System.out.println("Don't support the method of request:" + this.method);
			return;
		}

		if (paramsString.equals("")) {
			return;
		}
		parseParams(paramsString);
	}

	/**
	 * parse params
	 * @param paramsString
	 */
	private void parseParams(String paramsString) {
		String[] params = paramsString.split("&");
		for (int i = 0; i < params.length; i++) {
			String[] keyValue = params[i].split("=");
			
			if(keyValue.length==1){
				keyValue = Arrays.copyOf(keyValue, 2);
				keyValue[1]=null;
			}
			String key = params[i].substring(0, params[i].indexOf("="));
			String value = decode(params[i].substring(params[i].indexOf("=") + 1),"gbk");
			if(this.parameterMapValue.containsKey(key)){
				this.parameterMapValue.get(key).add(value);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(value);
				this.parameterMapValue.put(key, list);
			}
		}

	}
	
	/**
	 * get params value by key
	 * @param name
	 * @return
	 */
	public String[] getParamValues(String name){
		List<String> values = null;
		if((values = parameterMapValue.get(name))==null){
			return null;
		}else{
			return values.toArray(new String[0]);
		}
	}
	
	/**get single value by key
	 * @param name
	 * @return
	 */
	public String getParamValue(String name){
		String[] values = getParamValues(name);
		if(values ==null){
			return null;
		}else{
			return values[0];
		}
	}
	
	private String decode(String value,String code){
		try {
			return java.net.URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}

	public Map<String, List<String>> getParameterMapValue() {
		return parameterMapValue;
	}

	public void setParameterMapValue(Map<String, List<String>> parameterMapValue) {
		this.parameterMapValue = parameterMapValue;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
}
