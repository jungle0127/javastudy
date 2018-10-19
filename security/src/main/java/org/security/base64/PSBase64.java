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
		jdkBase64Decode();
	}
	public static void jdkBase64Decode() throws IOException {
		String cipherText = "CnkKJDBlYTY2ODdiLWY3M2MtNDg5Ni04ODJjLWY5OGYxOTcxNmIxZBABGBQgASiAuLuw4iwww5rD\r\n" + 
				"pt8sOhdDTj1kcnMsT1U9ZHJwLE89d2VzdG9uZUIkYjUwNzA3NzItMmFhMi00MTk0LTk0OTEtYWZl\r\n" + 
				"ZTQ4OTM3ZTNiEkDqk7vJwKAXxyIQqxRwMDav9aWTgpimiv7L6FKP2CzerRZburhbrpY60vxPrSbL\r\n" + 
				"omUVuTMwsPUapFey41mrVdidGq0DMIIBqTCCAUygAwIBAgIeAV2B0eh/AAA3TTBn/Tw7/Af9hfVB\r\n" + 
				"jvM/hLUjOP09MAwGCCqBHM9VAYN1BQAwWzELMAkGA1UEAwwCQ0ExCzAJBgNVBAsMAkNBMQ4wDAYD\r\n" + 
				"VQQKDAVEZWJ1ZzEQMA4GA1UEBwwHQ2hlbmdkdTEQMA4GA1UECAwHU2lDaHVhbjELMAkGA1UEBhMC\r\n" + 
				"Q04wHhcNMTcwNzI3MDIxMzIzWhcNMzcwNzI3MDIxMzIzWjAuMQwwCgYDVQQDDANkcnMxDDAKBgNV\r\n" + 
				"BAsMA2RycDEQMA4GA1UECgwHd2VzdG9uZTBZMBMGByqGSM49AgEGCCqBHM9VAYItA0IABChI1tNh\r\n" + 
				"8+t0KuZiTqh5ft59AMyQXiCMa3ZihptuKvD6g8VgeWVtBvxBcy/Q5oo3ZV9XWuUd+WJ1wGOE5GOy\r\n" + 
				"yG+jDzANMAsGA1UdDwQEAwIDyDAMBggqgRzPVQGDdQUAA0kAMEYCIQCtaDX5u4ZE7mIdSu2pOkym\r\n" + 
				"5Z85Aj5VTFBSwYDn2bZcwwIhAJy9ogloumojgFWqxbCDyZ47L9fhmH0eb0D8BKa49JyB";
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] src = decoder.decodeBuffer(cipherText);
		System.out.println(src != null);
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
		System.out.println("==============");
		System.out.println(new String(decoder.decodeBuffer("c2FhOnNlY3JldA==")));
		System.out.println("==============");
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
