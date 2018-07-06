package org.security.hashalgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class MDAlgorithm {
	public static String encodeMDBySun(String algorithmName) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(algorithmName);
			md.update("lotus".getBytes());
			return new String(Hex.encode(md.digest()));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encodeMDByBouncyCastle(String algorithm) {
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update("lotus".getBytes());
			return new String(Hex.encode(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encodeMDByCommonsCodec() {
		return DigestUtils.md5Hex("lotus");
	}

	public static String encodeSHA256() {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update("lotus".getBytes());
			return new String(Hex.encode(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(MDAlgorithm.encodeMDBySun("MD5"));
		System.out.println(MDAlgorithm.encodeMDByBouncyCastle("MD5"));
		System.out.println(MDAlgorithm.encodeMDByCommonsCodec());
		System.out.println(MDAlgorithm.encodeSHA256());
	}

}
