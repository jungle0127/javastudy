package org.security.hashalgorithm.mac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class SunMacCoder {
	private String algorithm;
	public SunMacCoder(String algorithm) {
		this.algorithm = algorithm;
	}
	private SecretKey initHmacKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey;
	}
	public byte[] encodeHmac(String data) throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKey secretKey = this.initHmacKey();
		Mac mac = Mac.getInstance(algorithm);
		System.out.println(mac.getProvider().getName());
		mac.init(secretKey);
		byte[] encodedData = mac.doFinal(data.getBytes());
		return encodedData;
	}
}
