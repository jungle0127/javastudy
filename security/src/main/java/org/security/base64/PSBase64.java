package org.security.base64;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 应用场景：
 * email, 密钥，证书文件
 * @author PS
 * 
 * RFC 2045
 * 衍生： base 16, base32, url base64
 * 替换方式算法
 *
 */
public class PSBase64 {
	private static String plainText = "ps base64 text";
	public static void main(String[] args) throws IOException {
		jdkBase64();
		commonsCodesBase64();
		bouncyCastleBase64();
	}
	/**
	 * JDK
	 * @throws IOException
	 */
	public static void jdkBase64() throws IOException {
		BASE64Encoder encoder = new BASE64Encoder();
		String cipherText = encoder.encode(plainText.getBytes());
		System.out.println("JDK encode:" + cipherText);
		
		BASE64Decoder decoder = new BASE64Decoder();
		System.out.println(new String(decoder.decodeBuffer(cipherText)));
	}
	/**
	 * Commons codec
	 */
	public static void commonsCodesBase64() {
		byte[] encodedBytes = Base64.encodeBase64(plainText.getBytes());
		System.out.println(new String(encodedBytes));
		byte[] decodeBytes = Base64.decodeBase64(encodedBytes);
		System.out.println(new String(decodeBytes));
	}
	/**
	 * Bouncy Castle
	 */
	public static void bouncyCastleBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(plainText.getBytes());
		System.out.println(new String(encodeBytes));
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println(new String(decodeBytes));
	}
}
