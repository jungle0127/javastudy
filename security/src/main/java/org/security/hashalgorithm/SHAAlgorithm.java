package org.security.hashalgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class SHAAlgorithm {
	public static String encodeSHABySun(String algorithm) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance(algorithm);				
		md.update("lotus".getBytes());
		return Hex.toHexString(md.digest()); 
	}
	public static String encodeSHAByBouncyCastle(String algorithm) throws NoSuchAlgorithmException {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance(algorithm);
		return Hex.toHexString(md.digest("lotus".getBytes()));
	}
	public static String encodeSHAByCommonsCodec() {
		return DigestUtils.sha256Hex("lotus");
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(SHAAlgorithm.encodeSHABySun("SHA-1"));
		System.out.println(SHAAlgorithm.encodeSHABySun("SHA-256"));
		System.out.println(SHAAlgorithm.encodeSHABySun("SHA-384"));
		System.out.println(SHAAlgorithm.encodeSHABySun("SHA-512"));
		System.out.println(SHAAlgorithm.encodeSHAByBouncyCastle("SHA-224"));
		System.out.println(encodeSHAByCommonsCodec());
		
	}

}
