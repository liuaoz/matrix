package com.matrix.util.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Consts;

import com.matrix.util.httpclient.SendAuthReqUtil;

/**
 * 功能：http请求工具类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月1日
 */
public class HttpUtil {

	/**
	 * 使用Get方式获取数据
	 * 
	 * @param url
	 *            URL包括参数，http://HOST/XX?XX=XX&XXX=XXX
	 * @param charset
	 *            编码方式
	 * @return
	 */
	public static String sendGet(String url, String charset) {

		String result = "";
		BufferedReader in = null;

		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * POST请求，字符串形式数据
	 * 
	 * @param url
	 *            请求地址
	 * @param param
	 *            请求数据
	 * @param charset
	 *            编码方式
	 * @return
	 */
	public static String sendPost(String url, String param, String charset) {

		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * POST请求，Map形式数据
	 * 
	 * @param url
	 *            请求地址
	 * @param param
	 *            请求数据
	 * @param charset
	 *            编码方式
	 */
	@SuppressWarnings("deprecation")
	public static String sendPost(String url, Map<String, String> param, String charset) {

		StringBuffer buffer = new StringBuffer();
		if (param != null && !param.isEmpty()) {
			for (Map.Entry<String, String> entry : param.entrySet()) {
				buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue())).append("&");

			}
		}
		buffer.deleteCharAt(buffer.length() - 1);

		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(buffer);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {

		String name = "马富";
		String cid = "132623195510113015";
		String manz_url = "http://139.196.195.95:8080/api/authenInfoApi.htm";
		String manz_userId = "100272";
		String manz_mkey = "Y55153lL5x1T55593x7NG5l13171597d";
		String manz_des = "9t79Q7p79UF39L7t99IAY1xsr577xbA1";
		
		SendAuthReqUtil.strDefaultKey = manz_des;
		String nameDes = SendAuthReqUtil.Encode(name);
		String cidDes = SendAuthReqUtil.Encode(cid);

		String ts = String.valueOf(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		

		String md5Str = null;
		try {
			md5Str = Md5Util
					.md5Sign("userId" + manz_userId + "auName" + name + "auId" + cid + "ts" + ts + manz_mkey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		

		Map<String, String> params = new HashMap<String, String>();

		params.put("userId", manz_userId);
		params.put("auName", nameDes);
		params.put("auId", cidDes);
		params.put("reqDate", sdf.format(new Date()));
		params.put("ts", ts);
		params.put("sign", md5Str);
		params.put("authType", "01");// 01：实名认证，02：人证合一，03：银行卡认证
		params.put("resType", "Json"); // Json/xml

		String result = HttpUtil.sendPost(manz_url, params, Consts.UTF_8.toString());
		System.out.println(result);

	}

	@SuppressWarnings("deprecation")
	public static void test(String[] args) {

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		String str = "";

		try {
			fis = new FileInputStream("E:\\yixun.txt");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);

			while ((str = br.readLine()) != null) {
				String[] arr = str.split("\t");
				String cid = arr[1];
				String name = arr[0];

				name = java.net.URLEncoder.encode(name);
				String url = "http://192.168.1.60:8080/ucf-webapp/api/ew_identity_photo_check/" + name + "/" + cid
						+ "/btof/a12345678/";
				// String url =
				// "http://192.168.1.60:8080/ucf-webapp/api/ylz_cid_queryWageGrade_api/"
				// + cid
				// + "/btof/a12345678/";
				// System.out.println(url);

				String output = sendGet(url, "utf-8");

				// System.out.println(output);

				String aline = "cid-" + cid + ",name-" + arr[0] + "==" + output + "\n";

				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\yixun_result.txt", true)));
				System.out.println(aline);
				bw.write(aline);
				bw.flush();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
