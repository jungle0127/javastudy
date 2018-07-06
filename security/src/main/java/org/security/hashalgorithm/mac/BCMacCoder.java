package org.security.hashalgorithm.mac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BCMacCoder {
	private String algorithm;
	public BCMacCoder(String algorithm) {
		this.algorithm = algorithm;
	}
	private static SecretKey initHmacKey() throws NoSuchAlgorithmException {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();
		System.out.println(keyGenerator.getProvider().getName());
		return secretKey;
	}
	public static byte[] encodeHmac(String data) throws NoSuchAlgorithmException, InvalidKeyException {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey secretKey = initHmacKey();
		Mac mac = Mac.getInstance("HmacMD5");
		System.out.println(mac.getProvider().getName());
		mac.init(secretKey);
		byte[] encodedData = mac.doFinal(data.getBytes());
		return encodedData;
	}
}
