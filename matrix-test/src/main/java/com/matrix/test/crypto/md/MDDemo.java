package com.matrix.test.crypto.md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 消息摘要算法-MD </br>
 * 
 * digest n.文摘，摘要；vt.消化，吸收；vi.消化<>
 * 
 * 实现方式：JDK,Bouncy Castle,cc
 * 
 * @author matrix
 *
 * @date 2015年11月15日
 * 
 */
public class MDDemo {

	public final static String SRC = "security md";

	public static void main(String[] args) {
		jdkMD5(SRC);
		jdkMD2(SRC);
		bcMD4(SRC);
		bcMD5(SRC);
		bcMD2(SRC);
		bcMD4JDK(SRC);
		ccMD5(SRC);
		ccMD2(SRC);
	}

	/**
	 * jdk实现md5
	 * 
	 * @param src
	 */
	public static void jdkMD5(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("JDK MD5:" + Hex.encodeHexString(md5bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * jdk实现md2
	 * 
	 * @param src
	 */
	public static void jdkMD2(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("JDK MD2:" + Hex.encodeHexString(md5bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * bouncy castle 实现md4
	 * 
	 * @param src
	 */
	public static void bcMD4(String src) {
		Digest digest = new MD4Digest();
		byte[] bytes = src.getBytes();
		digest.update(src.getBytes(), 0, bytes.length);
		byte[] md4bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4bytes, 0);
		System.out.println("BC MD4:" + Hex.encodeHexString(md4bytes));
		// 使用bc的输出
	}

	/**
	 * bouncy castle 实现md5
	 * 
	 * @param src
	 */
	public static void bcMD5(String src) {
		Digest digest = new MD5Digest();
		byte[] bytes = src.getBytes();
		digest.update(src.getBytes(), 0, bytes.length);
		byte[] md4bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4bytes, 0);
		System.out.println("BC MD5:" + Hex.encodeHexString(md4bytes));
		// 使用bc的输出

	}

	/**
	 * bouncy castle 实现md2
	 * 
	 * @param src
	 */
	public static void bcMD2(String src) {
		Digest digest = new MD2Digest();
		byte[] bytes = src.getBytes();
		digest.update(src.getBytes(), 0, bytes.length);
		byte[] md4bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4bytes, 0);
		System.out.println("BC MD2:" + Hex.encodeHexString(md4bytes));
		// 使用bc的输出
	}

	/**
	 * bouncy castle 实现md4 +jdk
	 * 
	 * @param src
	 */
	public static void bcMD4JDK(String src) {
		Security.addProvider(new BouncyCastleProvider());

		try {
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] md5bytes = md.digest(src.getBytes());
			System.out.println("BC+JDK MD4:" + Hex.encodeHexString(md5bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * cc 实现md5
	 * 
	 * @param src
	 */
	public static void ccMD5(String src) {
		String result = DigestUtils.md5Hex(src.getBytes());
		System.out.println("cc MD5:" + result);
	}

	/**
	 * cc 实现md2
	 * 
	 * @param src
	 */
	public static void ccMD2(String src) {
		String result = DigestUtils.md2Hex(src.getBytes());
		System.out.println("cc MD2:" + result);
	}

}
