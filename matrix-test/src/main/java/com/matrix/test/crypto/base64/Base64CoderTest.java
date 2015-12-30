package com.matrix.test.crypto.base64;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class Base64CoderTest {

	@Test
	public void test() throws UnsupportedEncodingException {
		String inputStr = "Java加密与解密的艺术";
		System.err.println("原文：\t" + inputStr);

		String code = Base64Coder.encode(inputStr);

		System.err.println("编码后：\t" + code);

		String outputStr = Base64Coder.decode(code);

		System.err.println("解码后：\t" + outputStr);

		junit.framework.Assert.assertEquals(inputStr, outputStr);

	}

}
