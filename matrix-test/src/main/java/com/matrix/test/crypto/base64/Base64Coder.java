package com.matrix.test.crypto.base64;

import java.io.UnsupportedEncodingException;

import org.bouncycastle.util.encoders.Base64;

/**
 * BASE64编码与解码
 * 
 * @author matrix
 * @email 576729125@qq.com
 * @date 2015年11月16日
 * 
 *       字符映射表64（26个大写、26个小写、0-9、+、/和一个=）+一个“=”作为补位符
 * 
 *       实现原理： 1、将给定的字符串以字符为单位转换为对应的字符编码（如ascii码） 2、将获得的字符编码转换为二进制码
 *       3、对获得的二进制码做分组转换操作，每3个8位二进制码为一组，转换为每4个6位二进制编码为一组（不足6位时低位补0）。这是一个分组变化的过程，
 *       3个8位二进制码和4个6位二进制码的长度都是24位（3*8=4*6）
 *       4、对获得的4个6位二进制码补位，向6位二进制码添加2位高位0，组成4个8位二进制码。 5、将获得的4个8位二进制码转换为十进制码
 *       6、将获得的十进制码转换为Base64字符表中对应的字符
 * 
 *       例子： 字符串"A"进行base64编码 字符 A ASCII码 65 二进制码 01000001 4-6位二进制码 010000
 *       010000 4-8位二进制码 00010000 00010000 十进制码 16 16 字符表映射码 Q Q = =
 * 
 *       即：编码结果为QQ==
 */
public abstract class Base64Coder {

	public final static String ENCODING = "UTF-8";

	/**
	 * Base64编码
	 * 
	 * @param src
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String src) throws UnsupportedEncodingException {
		byte[] b = Base64.encode(src.getBytes(ENCODING));
		return new String(b, ENCODING);
	}

	/**
	 * Base64解码
	 * 
	 * @param src
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String src) throws UnsupportedEncodingException {
		byte[] b = Base64.decode(src.getBytes(ENCODING));
		return new String(b, ENCODING);
	}

}
