package com.matrix.test.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Base64;

/**
 * MD5摘要工具类
 * 
 * @author xiaoding
 *
 */
public class Md5Utils {
	private Md5Utils() {
	}

	public static String md5ToBas64(String data) {
		MessageDigest md = null;
		String str = null;
		try {
			md = MessageDigest.getInstance("MD5");
			str = new String(Base64.encode(md.digest(data.getBytes("UTF-8"))),
					"UTF-8");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String md5ToHexStr(String data) {
		MessageDigest md = null;
		String str = null;
		try {
			md = MessageDigest.getInstance("MD5");
			// str = Hex.toHexString(md.digest(data.getBytes("UTF-8")));
			str = bytesToHexString(md.digest(data.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * Convert byte[] to hex
	 * string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
	 * 
	 * @param src
	 *            byte[] data
	 * @return hex string
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
