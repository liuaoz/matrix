package com.matrix.test.crypto.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;

/**
 * 消息摘要算法-SHA (MD4-->SHA1) </br> secure hash algorithm 安全散列算法
 * 
 * SHA-1 160 JDK SHA-224 224 Bouncy Castle SHA-256 256 JDK SHA-384 384 JDK
 * SHA-512 512 JDK
 * 
 * @author matrix
 *
 * @date 2015年11月15日
 * 
 */
public class SHADemo {

	public final static String SRC = "sha crypto";

	public static void main(String[] args) {
		jdkSHA1(SRC);
		bcSHA1(SRC);
	}

	/**
	 * JDK 对 SHA1的实现
	 * 备注：jdk中，sha即为sha1
	 * @param src
	 */
	public static void jdkSHA1(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
//			byte[] bytes = md.digest(src.getBytes());
//			System.out.println("JDK SHA1:" + Hex.encodeHexString(bytes)
			md.update(src.getBytes());
			System.out.println("JDK SHA1:"+ Hex.encodeHexString(md.digest()));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用bc 实现sha1
	 * 
	 * @param src
	 */
	public static void bcSHA1(String src){
		Digest digest = new SHA1Digest();
		
		digest.update(src.getBytes(),0,src.length());
		
		byte[] bytes = new byte[digest.getDigestSize()];
		
		digest.doFinal(bytes, 0);
		
		System.out.println("BC SHA1:"+Hex.encodeHexString(bytes));
		
	}
}
