package com.matrix.test.crypto.mac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * 消息摘要算法-mac（Message Authentication Code）</br>
 * HmacMD2,HmacMD4，HmacMD5</br>
 * Hmac (Keyed-Hash Message Authentication code)  消息认证码算法
 * 含有秘钥的散列函数算法
 * HmacSHA1,HmacSHA224,HmacSHA256,HmacSHA384,HmacSHA512
 *
 * @author matrix
 *
 * @date 2015年11月15日
 * 
 */
public class MACDemo {

	public final static String SRC="mac crypto";
	
	public static void main(String[] args) {
		jdkHmacMD5(SRC);
		bcHMACMD5(SRC);
	}
	
	/**
	 * 使用jdk实现hmacmd5
	 * 备注：在产生密钥时候，耗时很多
	 * @param src
	 */
	public static void jdkHmacMD5(String src){
		try {
			System.out.println("***1***");
			//初始化KeyGenerator
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
			System.out.println("***2***");
			//产生秘钥(备注：该步骤很耗时间)
			SecretKey secretKey= keyGenerator.generateKey();
			System.out.println("***3***");
			//获得密钥
			byte [] key = secretKey.getEncoded();
			key = Hex.decodeHex(new char[]{'a','a','a','a','a','a'});
			System.out.println("***4***");
			//还原密钥
			SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");
			System.out.println("***5***");
			//实例化mac
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			
			mac.init(restoreSecretKey);
			byte [] macbytes = mac.doFinal(src.getBytes());
			System.out.println("JDK HMACMD5:"+Hex.encodeHexString(macbytes));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * bc 实现hmacmd5
	 * @param src
	 */
	public static void bcHMACMD5(String src){
		HMac hmac = new HMac(new MD5Digest());
		
		hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaa")));
		hmac.update(src.getBytes(),0,src.getBytes().length);
		
		byte [] bytes = new byte[hmac.getMacSize()];
		
		hmac.doFinal(bytes, 0);
		
		System.out.println("bc hmacMD5:"+Hex.encodeHexString(bytes));
	}
}
